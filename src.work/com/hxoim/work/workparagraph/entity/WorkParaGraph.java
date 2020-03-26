package com.hxoim.work.workparagraph.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hxoim.common.hxannotation.ColumnAnnotation;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class WorkParaGraph {
    /**
     * 主键
     */
    @ColumnAnnotation(FieldName = "id",  FieldDescription="主键")
    private String id;

    /**
     * 修改人
     */
    @ColumnAnnotation(FieldName = "modify_user",  FieldDescription="修改人")
    private String modifyUser;

    /**
     * 修改时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ColumnAnnotation(FieldName = "modify_time",  FieldDescription="修改时间")
    private Date modifyTime;

    /**
     * 父级id
     */
    @ColumnAnnotation(FieldName = "p_id",  FieldDescription="父级id")
    private String pId;

    /**
     * 工作标题
     */
    @ColumnAnnotation(FieldName = "work_title",  FieldDescription="机构名称")
    private String workTitle;

    /**
     * 工作内容
     */
    @ColumnAnnotation(FieldName = "work_content",  FieldDescription="工作内容")
    private String workContent;

    /**
     * 发起人
     */
    @ColumnAnnotation(FieldName = "user_id",  FieldDescription="发起人")
    private String userId;

    /**
     * 工作状态(0:待分配;1:进行中;2:已完成;3:已确认)
     */
    @ColumnAnnotation(FieldName = "status",  FieldDescription="工作状态(0:待分配;1:进行中;2:已完成;3:已确认)")
    private String status;

    /**
     * 发起时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ColumnAnnotation(FieldName = "start_time",  FieldDescription="发起时间")
    private Date startTime;

    /**
     * 计划完成时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ColumnAnnotation(FieldName = "plan_finished_time",  FieldDescription="计划完成时间")
    private Date planFinishedTime;

    /**
     * 实际完成时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ColumnAnnotation(FieldName = "real_finished_time",  FieldDescription="实际完成时间")
    private Date realFinishedTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getWorkTitle() {
        return workTitle;
    }

    public void setWorkTitle(String workTitle) {
        this.workTitle = workTitle;
    }

    public String getWorkContent() {
        return workContent;
    }

    public void setWorkContent(String workContent) {
        this.workContent = workContent;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getPlanFinishedTime() {
        return planFinishedTime;
    }

    public void setPlanFinishedTime(Date planFinishedTime) {
        this.planFinishedTime = planFinishedTime;
    }

    public Date getRealFinishedTime() {
        return realFinishedTime;
    }

    public void setRealFinishedTime(Date realFinishedTime) {
        this.realFinishedTime = realFinishedTime;
    }
}
