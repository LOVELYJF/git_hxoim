package com.hxoim.support.customquery.entity.custom;

/**
 * @desc: sql排序实体类
 * @author: lijing
 * @date: 2019/8/2
 */
public class OrderEntity {
    /**
     * 排序字段，带表名
     */
    private String fieldName;
    /**
     * 升序/降序，asc/desc
     */
    private String sortOrder;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }
}
