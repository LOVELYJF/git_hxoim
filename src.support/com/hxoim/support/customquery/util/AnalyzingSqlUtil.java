package com.hxoim.support.customquery.util;

import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.common.utils.SpringUtil;
import com.hxoim.support.customquery.entity.custom.ConditionEntity;
import com.hxoim.support.customquery.entity.custom.OrderEntity;
import com.hxoim.support.inforesource.entity.DataTable;
import com.hxoim.support.inforesource.entity.DataTableCol;
import com.hxoim.support.inforesource.mapper.DataTableColMapper;
import com.hxoim.support.inforesource.mapper.DataTableMapper;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @desc: 将对象解析为sql
 * @author: lijing
 * @date: 2019/8/2
 */
public class AnalyzingSqlUtil {
    private static DataTableMapper dataTableMapper = SpringUtil.getBean(DataTableMapper.class);
    private static DataTableColMapper dataTableColMapper = SpringUtil.getBean(DataTableColMapper.class);

    /**
     * 排序对象解析为sql
     *
     * @param orderEntities
     * @return sql
     */
    public static String getOrderSql(List<OrderEntity> orderEntities) {
        StringBuffer orderSql = new StringBuffer();
        if (orderEntities != null && orderEntities.size() > 0) {
            for (OrderEntity orderEntity : orderEntities) {
                //排序字段为空默认升序
                if (StringUtils.isEmpty(orderEntity.getSortOrder())) {
                    orderEntity.setSortOrder("asc");
                }
                orderSql.append(orderEntity.getFieldName() + " " + orderEntity.getSortOrder() + ",");
            }
        }
        //去除最后的逗号返回
        return orderSql.toString().length() > 0 ? orderSql.toString().substring(0, orderSql.toString().length() - 1) : "";
    }

    /**
     * 条件对象转换为sql
     *
     * @param conditionEntities
     * @return
     */
    public static String getWhereSql(List<ConditionEntity> conditionEntities) {
        StringBuffer wheresql = new StringBuffer();
        if (conditionEntities != null && conditionEntities.size() > 0) {
            for (ConditionEntity conditionEntity : conditionEntities) {
                String value = conditionEntity.getValue().trim();
                String operator = conditionEntity.getOperator().trim().toUpperCase();
                String fieldName = conditionEntity.getFieldName();
                String expressionPrefix = StringUtils.isEmpty(conditionEntity.getExpressionPrefix()) ? "" : conditionEntity.getExpressionPrefix().trim();
                //封装sql
                wheresql.append(" " + conditionEntity.getConnector().trim())
                        .append(" " +  expressionPrefix)
                        .append(" " + fieldName)
                        .append(" " + operator);
                //特殊处理
                if ("NULL".equalsIgnoreCase(value) && operator.contains("IS")) {
                    wheresql.append(" null");
                } else if (StringUtils.isEmpty(value) && !operator.contains("IS")) {
                    wheresql.append(" ''");
                } else {
                    if (operator.contains("IN") || operator.contains("EXISTS")) {
                        if (value.startsWith("(") && value.endsWith(")")) {
                            wheresql.append(" " + value + " ");
                        } else {
                            wheresql.append(" (" + value + ") ");
                        }
                    } else {
                        //字段类型判断
                        if (StringUtils.isEmpty(conditionEntity.getFieldType())){
                            wheresql.append(" '" + value + "' ");
                        }else if (conditionEntity.getFieldType().toUpperCase().contains("INT")) {
                            wheresql.append(" " + value + " ");
                        } else {
                            wheresql.append(" '" + value + "' ");
                        }
                    }
                }
                String expressionSuffix = StringUtils.isEmpty(conditionEntity.getExpressionSuffix()) ? "" : conditionEntity.getExpressionSuffix().trim();
                wheresql.append(expressionSuffix);
            }
        }
        return wheresql.toString();
    }

    /**
     * 获取连接sql
     *
     * @param conditionEntities 条件列表
     * @param fileds            展示列集合
     * @param orderEntities     排序列表
     * @param a0201b            机构id 逗号分隔
     * @param baseTable         连接基础表
     * @return
     */
    public static Map<String, String> getJoinCondition(List<ConditionEntity> conditionEntities, List<String> fileds, List<OrderEntity> orderEntities, String a0201b, String baseTable) {
        StringBuffer joinConditionSql = new StringBuffer();
        StringBuffer whereSql = new StringBuffer();
        //A02表名
        String a02Name = "";
        //B01表名
        String b01Name = "";
        //表名集合
        Map<String, DataTable> tableNameMap = getTableNames(conditionEntities, fileds, orderEntities);
        //基础表加入
        joinConditionSql.append(baseTable);
        for (Map.Entry<String, DataTable> entity : tableNameMap.entrySet()) {
            String tableName = entity.getKey().toUpperCase();
            DataTable dataTable = entity.getValue();
            if (dataTable == null) {
                throw new ParameterNullException("参数异常");
            }
            if (!tableName.equalsIgnoreCase(baseTable)) {
                //如果选择机构则加入机构条件
                if (tableName.contains("A02")) {
                    a02Name = tableName;
                } else if (tableName.contains("B01")) {
                    b01Name = tableName;
                } else if (StringUtils.isEmpty(dataTable.getTableSameSql())) {
                    joinConditionSql.append(" left join (" + dataTable.getTableSameSql() + ") " + tableName + " on")
                            .append(" " + baseTable + ".A01000 = " + tableName + ".A01000");
                    whereSql.append(" and " + tableName + ".is_deleted = 0 ");
                } else {
                    joinConditionSql.append(" left join " + tableName + " on")
                            .append(" " + baseTable + ".A01000 = " + tableName + ".A01000");
                    whereSql.append(" and " + tableName + ".is_deleted = 0 ");
                }
            }
        }
        //a02不存在，则加入b02
        if (StringUtils.isEmpty(a02Name)) {
            String[] names = baseTable.split("_");
            String suffix = "";
            if (names.length == 2) {
                suffix = names[1];
            }
            a02Name = "A02" + suffix;
        }
        //连接a02
        if (!a02Name.equalsIgnoreCase(baseTable)){
            joinConditionSql.append(" left join " + a02Name + " on")
                    .append(" " + baseTable + ".A01000 = " + a02Name + ".A01000");
            whereSql.append(" and " + a02Name + ".is_deleted = 0");
        }
        if (!StringUtils.isEmpty(a0201b)) {
            whereSql.append(" and " + a02Name + ".A0201B in ('" + a0201b.replaceAll(",", "','") + "')");
        }
        whereSql.append(" and " + baseTable + ".is_deleted = 0");
        //b01存在则加入b01
        if (!StringUtils.isEmpty(b01Name)) {
            joinConditionSql.append(" left join " + b01Name + " on")
                    .append(" " + a02Name + ".A0201B = " + b01Name + ".B0111");
            whereSql.append(" and " + a02Name + ".is_deleted = 0");
            if (!StringUtils.isEmpty(a0201b)) {
                whereSql.append(" and " + b01Name + ".B0111 in ('" + a0201b.replaceAll(",", "','") + "')");
            }
        }

        //返回join和部分where条件
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("whereSql", whereSql.toString());
        resultMap.put("joinSql", joinConditionSql.toString());
        return resultMap;
    }

    /**
     * 获取查询列
     *
     * @param fileds 查询列
     * @return
     */
    public static List<DataTableCol> getDataTableCol(List<String> fileds) {
        List<DataTableCol> dataTableColList = new ArrayList<>();
        for (String filed : fileds) {
            String[] tablename = filed.split("\\.");
            if (tablename.length != 2) {
                throw new ParameterNullException("参数异常");
            }
            Map<String, String> param = new HashMap<>();
            param.put("tabCode", tablename[0]);
            param.put("code", tablename[1]);
            DataTableCol dataTableCol = dataTableColMapper.selectDataByCodeAndTabCode(param);
            if (dataTableCol != null) {
                dataTableColList.add(dataTableCol);
            }
        }
        return dataTableColList;
    }

    /**
     * 获取相关表名
     *
     * @param conditionEntities 条件列表
     * @param fileds            展示列集合
     * @param orderEntities     排序列表
     * @return
     */
    public static Map<String, DataTable> getTableNames(List<ConditionEntity> conditionEntities, List<String> fileds, List<OrderEntity> orderEntities) {
        Map<String, DataTable> tableNameMap = new HashMap<>();
        //条件列表
        for (ConditionEntity conditionEntity : conditionEntities) {
            if (conditionEntity.getFieldName().contains("date_format")){
                String tableName = conditionEntity.getFieldName().split("\\.")[0].split("\\(\\'")[1];
                if (!tableNameMap.containsKey(tableName.toUpperCase())) {
                    DataTable dataTable = dataTableMapper.selectByCode(tableName.toUpperCase());
                    tableNameMap.put(tableName.toUpperCase(), dataTable);
                }
            }else{
                String[] tablename = conditionEntity.getFieldName().split("\\.");
                if (tablename.length != 2) {
                    throw new ParameterNullException("参数异常");
                }
                if (!tableNameMap.containsKey(tablename[0].toUpperCase())) {
                    DataTable dataTable = dataTableMapper.selectByCode(tablename[0].toUpperCase());
                    tableNameMap.put(tablename[0].toUpperCase(), dataTable);
                }
            }
        }
        //排序列表
        for (OrderEntity orderEntity : orderEntities) {
            String[] tablename = orderEntity.getFieldName().split("\\.");
            if (tablename.length != 2) {
                throw new ParameterNullException("参数异常");
            }
            if (!tableNameMap.containsKey(tablename[0].toUpperCase())) {
                DataTable dataTable = dataTableMapper.selectByCode(tablename[0].toUpperCase());
                tableNameMap.put(tablename[0].toUpperCase(), dataTable);
            }
        }
        //展示列集合
        for (String filed : fileds) {
            String[] tablename = filed.split("\\.");
            if (tablename.length != 2) {
                throw new ParameterNullException("参数异常");
            }
            if (!tableNameMap.containsKey(tablename[0].toUpperCase())) {
                DataTable dataTable = dataTableMapper.selectByCode(tablename[0].toUpperCase());
                tableNameMap.put(tablename[0].toUpperCase(), dataTable);
            }
        }
        return tableNameMap;
    }

    /**
     * 获取基础表
     *
     * @param conditionEntities
     * @param fileds
     * @param orderEntities
     * @return
     */
    public static String getBaseTable(List<ConditionEntity> conditionEntities, List<String> fileds, List<OrderEntity> orderEntities) {
        String baseTable = "";
        for (String filed : fileds) {
            String[] tablename = filed.split("\\.");
            if (tablename.length != 2) {
                throw new ParameterNullException("参数异常");
            }
            if (tablename[0].toUpperCase().contains("A01")) {
                baseTable = tablename[0];
                break;
            }
        }
        if (StringUtils.isEmpty(baseTable)) {
            for (ConditionEntity conditionEntity : conditionEntities) {
                if (conditionEntity.getFieldName().contains("date_format")){
                    String tableName = conditionEntity.getFieldName().split("\\.")[0].split("\\(")[1];
                    if (tableName.toUpperCase().contains("A01")) {
                        baseTable = tableName;
                        break;
                    }
                }else{
                    String[] tablename = conditionEntity.getFieldName().split("\\.");
                    if (tablename.length != 2) {
                        throw new ParameterNullException("参数异常");
                    }
                    if (tablename[0].toUpperCase().contains("A01")) {
                        baseTable = tablename[0];
                        break;
                    }
                }
            }
        }
        if (StringUtils.isEmpty(baseTable)) {
            for (OrderEntity orderEntity : orderEntities) {
                String[] tablename = orderEntity.getFieldName().split("\\.");
                if (tablename.length != 2) {
                    throw new ParameterNullException("参数异常");
                }
                if (tablename[0].toUpperCase().contains("A01")) {
                    baseTable = tablename[0];
                    break;
                }
            }
        }
        if (StringUtils.isEmpty(baseTable)){
            baseTable = fileds.get(0).split("\\.")[0];
        }
        return baseTable;
    }
}
