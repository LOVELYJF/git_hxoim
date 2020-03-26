package com.hxoim.full.search.entity;

/**
 * 全文检索设置实体类
 *
 * @author sunqian
 * @date 2019/11/5 14:38
 */
public class FullSearchSetting {

    /**主键*/
    private String id;

    /**表编码*/
    private String tableCode;

    /**列编码*/
    private String columnCode;

    /**列中文描述*/
    private String columnName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTableCode() {
        return tableCode;
    }

    public void setTableCode(String tableCode) {
        this.tableCode = tableCode;
    }

    public String getColumnCode() {
        return columnCode;
    }

    public void setColumnCode(String columnCode) {
        this.columnCode = columnCode;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
}