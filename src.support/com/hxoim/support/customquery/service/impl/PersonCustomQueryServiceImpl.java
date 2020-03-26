package com.hxoim.support.customquery.service.impl;

import com.hxoim.general.select.mapper.SelectMapper;
import com.hxoim.general.select.entity.SqlVo;
import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.common.utils.ExcelUtil;
import com.hxoim.common.utils.UserInfo;
import com.hxoim.common.utils.UserInfoUtil;
import com.hxoim.support.customquery.entity.custom.ConditionEntity;
import com.hxoim.support.customquery.entity.custom.OrderEntity;
import com.hxoim.support.customquery.entity.paramentity.CustomQueryParam;
import com.hxoim.support.customquery.mapper.QueryPlanMapper;
import com.hxoim.support.customquery.service.PersonCustomQueryService;
import com.hxoim.support.customquery.util.AnalyzingSqlUtil;
import com.hxoim.support.inforesource.entity.DataTableCol;
import com.hxoim.support.sysdict.service.SysDictItemService;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @desc: 自定义查询
 * @author: lijing
 * @date: 2019/8/7
 */
@Service
public class PersonCustomQueryServiceImpl implements PersonCustomQueryService {

    @Autowired
    private SelectMapper selectMapper ;
    @Autowired
    private SysDictItemService sysDictItemService;
//    @Autowired
//    private QueryPlanMapper selectMapper;


    @Override
    public Map<String, Object> customQuery(CustomQueryParam customQueryParam) {
        //结果map
        Map<String, Object> resultMap = new HashMap<>();

        UserInfo userInfo = UserInfoUtil.getUserInfo();
        if (userInfo == null) {
            throw new ParameterNullException("请先登录");
        }
        List<ConditionEntity> conditionEntities = customQueryParam.getConditionEntities();
        List<OrderEntity> orderEntities = customQueryParam.getOrderEntities();
        List<String> fields = customQueryParam.getFileds();
        String b0111 = customQueryParam.getB0111();

        if (fields == null || fields.size() < 1) {
            throw new ParameterNullException("参数异常");
        }

        String baseTableName = AnalyzingSqlUtil.getBaseTable(conditionEntities, fields, orderEntities);

        //解析sql
        String orderSql = AnalyzingSqlUtil.getOrderSql(orderEntities);
        String whereSql = AnalyzingSqlUtil.getWhereSql(conditionEntities);
        Map<String, String> conditionSql = AnalyzingSqlUtil.getJoinCondition(conditionEntities, fields, orderEntities, b0111, baseTableName);

        whereSql = whereSql + conditionSql.get("whereSql");
        String joinSql = conditionSql.get("joinSql");
        //列属性
        List<DataTableCol> dataTableColList = AnalyzingSqlUtil.getDataTableCol(fields);

        //查询sql
        StringBuffer querySql = new StringBuffer();
        //结果集sql
        querySql.append("select distinct " + StringUtils.join(fields, ","))
                .append(" ," + baseTableName + ".A01000")
                .append(" from " + joinSql)
                .append(" where 1=1 " + whereSql);
        if (!StringUtils.isEmpty(orderSql)) {
            querySql.append(" order by " + orderSql);
        }
        if (customQueryParam.getIsPage()) {
            int page = (customQueryParam.getPageNum() - 1) * customQueryParam.getPageSize();
            querySql.append(" limit " + page + "," + customQueryParam.getPageSize());
            //总数
            StringBuffer countSql = new StringBuffer();
            countSql.append("select count(distinct " + baseTableName + ".A01000) as count")
                    .append(" from " + joinSql)
                    .append(" where 1=1 " + whereSql);
            if (!StringUtils.isEmpty(orderSql)) {
                countSql.append(" order by " + orderSql);
            }
            List<LinkedHashMap<String, Object>> count = selectMapper.select(SqlVo.getInstance(countSql.toString()));
            resultMap.put("total", count.get(0).get("count"));
        }
        List<LinkedHashMap<String, Object>> dataList = selectMapper.select(SqlVo.getInstance(querySql.toString()));

        //查询列相关字典
        Map<String, Object> dicCodeItemMap = new HashMap<>();
        for (DataTableCol dataTableCol : dataTableColList) {
            String controlType = dataTableCol.getControlType();
            if ("2".equals(controlType) || "14".equals(controlType)) {
                if (!dicCodeItemMap.containsKey(dataTableCol.getDicCode())) {
                    List<Map<String, Object>> dicCodeItems = sysDictItemService.getDictInfoByDictCode(dataTableCol.getDicCode(), null);
                    dicCodeItemMap.put(dataTableCol.getDicCode(), dicCodeItems);
                }
            }
        }

        //结果集封装
        resultMap.put("data", dataList);
        resultMap.put("pageIndex", customQueryParam.getPageNum());
        resultMap.put("pageSize", customQueryParam.getPageSize());
        resultMap.put("dataCol", dataTableColList);
        resultMap.put("dicCodeItems", dicCodeItemMap);

        return resultMap;
    }

    @Override
    public HSSFWorkbook exportExcel(CustomQueryParam customQueryParam) {
        //设置不分页
        customQueryParam.setIsPage(false);
        Map<String, Object> resultMap = customQuery(customQueryParam);
        //excel头部
        List<String> headers = new ArrayList<>();
        List<DataTableCol> dataTableColList = (List<DataTableCol>) resultMap.get("dataCol");
        for (DataTableCol item : dataTableColList) {
            headers.add(item.getColName());
        }
        //excel内容
        List<List<String>> content = new ArrayList<>();
        //数据
        List<LinkedHashMap<String, Object>> dataList = (List<LinkedHashMap<String, Object>>) resultMap.get("data");
        //列相关字典
        Map<String, Object> dicCodeItemMap = (Map<String, Object>) resultMap.get("dicCodeItems");

        for (LinkedHashMap<String, Object> item : dataList) {
            List<String> contentItem = new ArrayList<>();
            for (DataTableCol dataTableCol : dataTableColList) {
                //是否是字典
                String controlType = dataTableCol.getControlType();
                if ("2".equals(controlType) || "14".equals(controlType)) {
                    List<Map<String, Object>> dicCodeItemList = (List<Map<String, Object>>) dicCodeItemMap.get(dataTableCol.getDicCode());
                    for (Map<String, Object> mapItem : dicCodeItemList) {
                        if (item.get(dataTableCol.getColCode()).equals(mapItem.get("id"))) {
                            contentItem.add((String) mapItem.get("name"));
                            break;
                        }
                    }
                } else if ("3".equals(controlType)) {
                    String val = item.get(dataTableCol.getColCode()).toString();
                    String value = "";
                    //时间
                    if (dataTableCol.getDataType().toUpperCase().contains("DATE") || dataTableCol.getDataType().toUpperCase().contains("TIME")) {
                        String formateVal;
                        if ("1".equals(dataTableCol.getShowFormat())) {
                            formateVal = "yyyy.mm";
                        } else if ("2".equals(dataTableCol.getShowFormat())) {
                            formateVal = "yyyy.mm.dd";
                        } else {
                            formateVal = "yyyy";
                        }
                        SimpleDateFormat formatter = new SimpleDateFormat(formateVal);
                        value = formatter.format(item.get(dataTableCol.getColCode()));
                    } else {
                        if ("1".equals(dataTableCol.getShowFormat())) {
                            value = val.substring(0, 4) + "." + val.substring(4);
                        } else if ("2".equals(dataTableCol.getShowFormat())) {
                            value = val.substring(0, 4) + "." + val.substring(4, 6) + "." + val.substring(6);
                        } else {
                            value = val;
                        }
                    }
                    contentItem.add(value);
                } else {
                    contentItem.add((String) item.get(dataTableCol.getColCode()));
                }
            }
            content.add(contentItem);
        }
        //导出
        //sheet名
        String sheetName = "人员信息表";
        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, headers, content, null);
        return wb;
    }
}
