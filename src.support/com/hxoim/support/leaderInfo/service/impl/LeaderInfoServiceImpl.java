package com.hxoim.support.leaderInfo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hxoim.person.markedcadre.mapper.McMarkedcadreMapper;
import com.hxoim.support.inforesource.entity.DataTableCol;
import com.hxoim.support.leaderInfo.mapper.A01Mapper;
import com.hxoim.support.leaderInfo.service.LeaderInfoService;
import com.hxoim.support.leaderInfo.util.LowerKeyMap;
import com.hxoim.support.sysdict.service.SysDictItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class LeaderInfoServiceImpl implements LeaderInfoService {

    @Autowired
    private A01Mapper a01Mapper;

    @Autowired
    private McMarkedcadreMapper mcMarkedcadreMapper;

    @Autowired
    private SysDictItemService sysDictItemService;

    //根据id查询返回数据
    @Override
    public Map<String,Object> selectBasicInfo(Integer pageNum, Integer pageSize, String orgId) {

        //结果map
        Map<String, Object> resultMap = new LinkedHashMap<>();

        //查询动态表头信息
        List<DataTableCol> dataTableColList = mcMarkedcadreMapper.selectDynamicColumn();
        resultMap.put("dataCol", dataTableColList);

        //查询列相关字典
        Map<String, Object> dicCodeItemMap = new LinkedHashMap<>();
        for (DataTableCol dataTableCol : dataTableColList) {
            String controlType = dataTableCol.getControlType();
            if ("2".equals(controlType) || "14".equals(controlType)) {
                if (!dicCodeItemMap.containsKey(dataTableCol.getDicCode())) {
                    List<Map<String, Object>> dicCodeItems = sysDictItemService.getDictInfoByDictCode(dataTableCol.getDicCode(), null);
                    dicCodeItemMap.put(dataTableCol.getDicCode(), dicCodeItems);
                }
            }
        }
        resultMap.put("dicCodeItems", dicCodeItemMap);

        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        PageHelper.startPage(pageNum, pageSize);
        if(orgId == null){
            List<LinkedHashMap<String, Object>> list1 = a01Mapper.selectAllInfo();
            PageInfo info1 = new PageInfo(list1);
            resultMap.put("info",info1);
            return resultMap;
        }else {
            List<LinkedHashMap<String, Object>> list2 = a01Mapper.selectByOrgId(orgId);
            PageInfo info2 = new PageInfo(list2);
            resultMap.put("info",info2);
            return resultMap;
        }
    }

    //查询数据信息集
    @Override
    public List<Map<String,Object>> selectLeaderInfoData(String tablecode, String id) {

        Map<String, Object> resultMap = new LinkedHashMap<>();

        if("Data_table".equalsIgnoreCase(tablecode)){
            List<Map<String, Object>> infoLine = a01Mapper.selectInfoLine();
            return infoLine;
        }

        List<Map<String, Object>> tableCol = a01Mapper.selectTableCol(tablecode);
        List<Map<String, Object>> tableInfo = a01Mapper.selectTableInfo(tablecode);

        //查询列相关字典
        Map<String, Object> dicCodeItemMap = new LinkedHashMap<>();
        for (Map<String, Object> map : tableCol) {
            String controlType = (String) map.get("CONTROL_TYPE");
            if (map.get("DIC_CODE") != null && map.get("DIC_CODE") != ""){
                if ("2".equals(controlType) || "14".equals(controlType)) {
                    if (!dicCodeItemMap.containsKey(map.get("DIC_CODE"))) {
                        List<Map<String, Object>> dicCodeItems = sysDictItemService.getDictInfoByDictCode((String) map.get("DIC_CODE"), null);
                        dicCodeItemMap.put((String) map.get("DIC_CODE"), dicCodeItems);
                    }
                    resultMap.put("dicCodeItems", dicCodeItemMap);
                }
            }
        }

        resultMap.put("tableCol",tableCol);
        resultMap.put("tableInfo",tableInfo);

        /*if("A36".equalsIgnoreCase(tablecode)){
            List<Map<String, Object>> tableData = a01Mapper.selectFamilyMember(id);
            resultMap.put("tableData",tableData);
            return Collections.singletonList(resultMap);
        }*/

        List<LowerKeyMap<String, Object>> tableData = a01Mapper.selectLeaderInfoData(tablecode, id);
        resultMap.put("tableData",tableData);
        return Collections.singletonList(resultMap);
    }
}
