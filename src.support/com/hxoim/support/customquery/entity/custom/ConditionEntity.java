package com.hxoim.support.customquery.entity.custom;

/**
 * @desc: sql条件实体
 * @author: lijing
 * @date: 2019/8/2
 */
public class ConditionEntity {
    /**
     * 条件连接关系 and/or
     */
    private String connector;
    /**
     * 表达式前缀，为空或者为'('
     */
    private String expressionPrefix;
    /**
     * 字段名，格式：表名.字段名
     */
    private String fieldName;
    /**
     * 操作符 :>=<=
     */
    private String operator;
    /**
     * 字段值
     */
    private String value;
    /**
     * 表达式后缀，为空或者为')'
     */
    private String expressionSuffix;
    /**
     * 字段类型
     */
    private String fieldType;

    public String getConnector() {
        return connector;
    }

    public void setConnector(String connector) {
        this.connector = connector;
    }

    public String getExpressionPrefix() {
        return expressionPrefix;
    }

    public void setExpressionPrefix(String expressionPrefix) {
        this.expressionPrefix = expressionPrefix;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getExpressionSuffix() {
        return expressionSuffix;
    }

    public void setExpressionSuffix(String expressionSuffix) {
        this.expressionSuffix = expressionSuffix;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }
}
