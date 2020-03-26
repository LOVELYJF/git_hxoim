package com.hxoim.support.customquery.entity;

import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.IgnoreLogAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;

import java.util.Date;

/**
 * q_query_plan
 */
@TableAnnotation(TableName = "q_query_plan", TableDescription="")
public class QueryPlanWithBLOBs extends QueryPlan {
    /**
     * 查询条件的json数组
     */
    @IgnoreLogAnnotation
    @ColumnAnnotation(FieldName = "sql_where_json",  FieldDescription="查询条件的json数组")
    private String sqlWhereJson;

    /**
     * 中文描述
     */
    @IgnoreLogAnnotation
    @ColumnAnnotation(FieldName = "remark",  FieldDescription="中文描述")
    private String remark;

    public QueryPlanWithBLOBs(String id, String planName, String isDelete, String createUserid, Date createTime, Long orderIndex, Date modifyTime, String modifyUser, String sqlWhereJson, String remark) {
        super(id, planName, isDelete, createUserid, createTime, orderIndex, modifyTime, modifyUser);
        this.sqlWhereJson = sqlWhereJson;
        this.remark = remark;
    }

    public QueryPlanWithBLOBs() {
        super();
    }

    /**
     * 查询条件的json数组
     * @return sql_where_json 查询条件的json数组
     */
    public String getSqlWhereJson() {
        return sqlWhereJson;
    }

    /**
     * 查询条件的json数组
     * @param sqlWhereJson 查询条件的json数组
     */
    public void setSqlWhereJson(String sqlWhereJson) {
        this.sqlWhereJson = sqlWhereJson;
    }

    /**
     * 中文描述
     * @return remark 中文描述
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 中文描述
     * @param remark 中文描述
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}