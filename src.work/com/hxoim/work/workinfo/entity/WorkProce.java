package com.hxoim.work.workinfo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 工作安排-结果审查
 * 
 * @author gaozhenyuan
 * @date 2019/12/25 15:45
 */
@TableAnnotation(TableName = "work_proce", TableDescription="结果审查")
public class WorkProce {
    /**
     * 主键
     */
    @ColumnAnnotation(FieldName = "id",  FieldDescription="主键")
    private String id;

    /**
     * 工作责任表主键
     */
    @ColumnAnnotation(FieldName = "work_responsible_id",  FieldDescription="工作责任表主键")
    private String workResponsibleId;

    /**
     * 处理事项
     */
    @ColumnAnnotation(FieldName = "proce",  FieldDescription="审查事项")
    private String proce;

    /**
     * 处理结果
     */
    @ColumnAnnotation(FieldName = "proce_reason",  FieldDescription="审查结果")
    private String proceReason;

    /**
     * 审查人
     */
    @ColumnAnnotation(FieldName = "user_id",  FieldDescription="审查人")
    private String userId;

    /**
     * 审查人
     */
    @ColumnAnnotation(FieldName = "user_name",  FieldDescription="审查人")
    private String userName;


    /**
     * 审查时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ColumnAnnotation(FieldName = "proce_time",  FieldDescription="审查时间")
    private Date proceTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWorkResponsibleId() {
        return workResponsibleId;
    }

    public void setWorkResponsibleId(String workResponsibleId) {
        this.workResponsibleId = workResponsibleId;
    }

    public String getProce() {
        return proce;
    }

    public void setProce(String proce) {
        this.proce = proce;
    }

    public String getProceReason() {
        return proceReason;
    }

    public void setProceReason(String proceReason) {
        this.proceReason = proceReason;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getProceTime() {
        return proceTime;
    }

    public void setProceTime(Date proceTime) {
        this.proceTime = proceTime;
    }
}