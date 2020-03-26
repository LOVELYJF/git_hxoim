package com.hxoim.support.DataChangedLog.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.IdAnnotation;
import com.hxoim.common.hxannotation.IgnoreLogAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * cf_datachangedlog
 */
public class CfDatachangedlog {
    /**
     * Id
     */
    @IdAnnotation
    @ColumnAnnotation(FieldName = "id",  FieldDescription="Id")
    private String id;

    /**
     * 操作员Id
     */
    @ColumnAnnotation(FieldName = "operator_id",  FieldDescription="操作员Id")
    private String operatorId;

    /**
     * 操作员姓名
     */
    @ColumnAnnotation(FieldName = "operator_name",  FieldDescription="操作员姓名")
    private String operatorName;

    /**
     * 操作日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ColumnAnnotation(FieldName = "operate_date",  FieldDescription="操作日期")
    private Date operateDate;

    /**
     * 操作类型
     */
    @ColumnAnnotation(FieldName = "operate_type",  FieldDescription="操作类型")
    private Integer operateType;

    /**
     * 修改表
     */
    @ColumnAnnotation(FieldName = "table_name",  FieldDescription="修改表")
    private String tableName;

    /**
     * 表中文名
     */
    @ColumnAnnotation(FieldName = "table_desc",  FieldDescription="表中文名")
    private String tableDesc;

    /**
     * 计算机IP
     */
    @ColumnAnnotation(FieldName = "ip",  FieldDescription="计算机IP")
    private String ip;

    /**
     * 执行SQL
     */
    @ColumnAnnotation(FieldName = "executed_sql",  FieldDescription="执行SQL")
    private String executedSql;

    /**
     * 参数
     */
    @ColumnAnnotation(FieldName = "parameters",  FieldDescription="参数")
    private String parameters;

    /**
     * 变化的数据
     */
    @IgnoreLogAnnotation
    @ColumnAnnotation(FieldName = "changed_data",  FieldDescription="变化的数据")
    private String changedData;

    public CfDatachangedlog(String id, String operatorId, String operatorName, Date operateDate, Integer operateType, String tableName, String tableDesc, String ip, String executedSql, String parameters) {
        this.id = id;
        this.operatorId = operatorId;
        this.operatorName = operatorName;
        this.operateDate = operateDate;
        this.operateType = operateType;
        this.tableName = tableName;
        this.tableDesc = tableDesc;
        this.ip = ip;
        this.executedSql = executedSql;
        this.parameters = parameters;
    }

    public CfDatachangedlog(String id, String operatorId, String operatorName, Date operateDate, Integer operateType, String tableName, String tableDesc, String ip, String executedSql, String parameters, String changedData) {
        this.id = id;
        this.operatorId = operatorId;
        this.operatorName = operatorName;
        this.operateDate = operateDate;
        this.operateType = operateType;
        this.tableName = tableName;
        this.tableDesc = tableDesc;
        this.ip = ip;
        this.executedSql = executedSql;
        this.parameters = parameters;
        this.changedData = changedData;
    }

    public CfDatachangedlog() {
        super();
    }

    /**
     * Id
     * @return id Id
     */
    public String getId() {
        return id;
    }

    /**
     * Id
     * @param id Id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 操作员Id
     * @return operator_id 操作员Id
     */
    public String getOperatorId() {
        return operatorId;
    }

    /**
     * 操作员Id
     * @param operatorId 操作员Id
     */
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId == null ? null : operatorId.trim();
    }

    /**
     * 操作员姓名
     * @return operator_name 操作员姓名
     */
    public String getOperatorName() {
        return operatorName;
    }

    /**
     * 操作员姓名
     * @param operatorName 操作员姓名
     */
    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName == null ? null : operatorName.trim();
    }

    /**
     * 操作日期
     * @return operate_date 操作日期
     */
    public Date getOperateDate() {
        return operateDate;
    }

    /**
     * 操作日期
     * @param operateDate 操作日期
     */
    public void setOperateDate(Date operateDate) {
        this.operateDate = operateDate;
    }

    /**
     * 操作类型
     * @return operate_type 操作类型
     */
    public Integer getOperateType() {
        return operateType;
    }

    /**
     * 操作类型
     * @param operateType 操作类型
     */
    public void setOperateType(Integer operateType) {
        this.operateType = operateType;
    }

    /**
     * 修改表
     * @return table_name 修改表
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * 修改表
     * @param tableName 修改表
     */
    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    /**
     * 表中文名
     * @return table_desc 表中文名
     */
    public String getTableDesc() {
        return tableDesc;
    }

    /**
     * 表中文名
     * @param tableDesc 表中文名
     */
    public void setTableDesc(String tableDesc) {
        this.tableDesc = tableDesc == null ? null : tableDesc.trim();
    }

    /**
     * 计算机IP
     * @return ip 计算机IP
     */
    public String getIp() {
        return ip;
    }

    /**
     * 计算机IP
     * @param ip 计算机IP
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * 执行SQL
     * @return executed_sql 执行SQL
     */
    public String getExecutedSql() {
        return executedSql;
    }

    /**
     * 执行SQL
     * @param executedSql 执行SQL
     */
    public void setExecutedSql(String executedSql) {
        this.executedSql = executedSql == null ? null : executedSql.trim();
    }

    /**
     * 参数
     * @return parameters 参数
     */
    public String getParameters() {
        return parameters;
    }

    /**
     * 参数
     * @param parameters 参数
     */
    public void setParameters(String parameters) {
        this.parameters = parameters == null ? null : parameters.trim();
    }

    /**
     * 变化的数据
     * @return changed_data 变化的数据
     */
    public String getChangedData() {
        return changedData;
    }

    /**
     * 变化的数据
     * @param changedData 变化的数据
     */
    public void setChangedData(String changedData) {
        this.changedData = changedData == null ? null : changedData.trim();
    }
}