package com.hxoim.support.combinedQuery.entity;

import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.IdAnnotation;
import com.hxoim.common.hxannotation.IgnoreLogAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;

/**
 * 组合查询
 * 
 * @author sunqian
 * @date 2019/8/26 17:04
 */
@TableAnnotation(TableName = "combined_query", TableDescription = "组合查询")
public class CombinedQuery {
    /**
     * 主键
     */
    @IdAnnotation
    @ColumnAnnotation(FieldName = "id", FieldDescription = "主键")
    private String id;

    /**
     * 条件类型
     */
    @ColumnAnnotation(FieldName = "condition_type", FieldDescription = "条件类型")
    private String conditionType;

    /**
     * 条件名称
     */
    @ColumnAnnotation(FieldName = "condition_name", FieldDescription = "条件名称")
    private String conditionName;

    /**
     * 表编码
     */
    @ColumnAnnotation(FieldName = "table_Code", FieldDescription = "表编码")
    private String tableCode;

    /**
     * 列编码
     */
    @ColumnAnnotation(FieldName = "column_code", FieldDescription = "列编码")
    private String columnCode;

    /**
     * 排序
     */
    @ColumnAnnotation(FieldName = "order_index", FieldDescription = "排序")
    private Integer orderIndex;

    /**
     * 条件模版
     */
    @IgnoreLogAnnotation
    @ColumnAnnotation(FieldName = "templet", FieldDescription = "条件模版")
    private String templet;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConditionType() {
        return conditionType;
    }

    public void setConditionType(String conditionType) {
        this.conditionType = conditionType;
    }

    public String getConditionName() {
        return conditionName;
    }

    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
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

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }

    public String getTemplet() {
        return templet;
    }

    public void setTemplet(String templet) {
        this.templet = templet;
    }
}