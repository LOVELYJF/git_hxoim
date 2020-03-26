package com.hxoim.support.operateLog.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.IdAnnotation;
import com.hxoim.common.hxannotation.IgnoreLogAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * cf_operatelog
 */
@TableAnnotation(TableName = "cf_operatelog", TableDescription="")
public class CfOperatelog {
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
     * 操作模块
     */
    @ColumnAnnotation(FieldName = "operate_model",  FieldDescription="操作模块")
    private String operateModel;

    /**
     * 计算机IP
     */
    @ColumnAnnotation(FieldName = "ip",  FieldDescription="计算机IP")
    private String ip;

    /**
     * 操作地址
     */
    @ColumnAnnotation(FieldName = "url",  FieldDescription="操作地址")
    private String url;

    public CfOperatelog(String id, String operatorId, String operatorName, Date operateDate, Integer operateType, String operateModel, String ip, String url) {
        this.id = id;
        this.operatorId = operatorId;
        this.operatorName = operatorName;
        this.operateDate = operateDate;
        this.operateType = operateType;
        this.operateModel = operateModel;
        this.ip = ip;
        this.url = url;
    }

    public CfOperatelog() {
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
     * 操作模块
     * @return operate_model 操作模块
     */
    public String getOperateModel() {
        return operateModel;
    }

    /**
     * 操作模块
     * @param operateModel 操作模块
     */
    public void setOperateModel(String operateModel) {
        this.operateModel = operateModel == null ? null : operateModel.trim();
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
     * 操作地址
     * @return url 操作地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 操作地址
     * @param url 操作地址
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}