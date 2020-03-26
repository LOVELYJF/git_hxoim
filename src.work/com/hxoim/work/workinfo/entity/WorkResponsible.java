package com.hxoim.work.workinfo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 工作安排-工作责任实体类
 * 
 * @author gaozhenyuan
 * @date 2019/12/25 15:45
 */
@TableAnnotation(TableName = "work_responsible", TableDescription="工作责任")
public class WorkResponsible {
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
     * 工作信息表外键
     */
    @ColumnAnnotation(FieldName = "work_info_id",  FieldDescription="父级id")
    private String workInfoId;

    /**
     * 负责的工作内容
     */
    @ColumnAnnotation(FieldName = "responsible_content",  FieldDescription="负责的工作内容")
    private String responsibleContent;

    /**
     * 工作负责人id
     */
    @ColumnAnnotation(FieldName = "user_id",  FieldDescription="工作负责人id")
    private String userId;

    /**
     * 工作负责人
     */
    @ColumnAnnotation(FieldName = "user_name",  FieldDescription="工作负责人")
    private String userName;

    /**
     * 完成情况
     */
    @ColumnAnnotation(FieldName = "finished_desc",  FieldDescription="完成情况")
    private String finishedDesc;

    /**
     * 负责的工作状态(0:待分配;1:进行中;2:已完成;3:已确认)
     */
    @ColumnAnnotation(FieldName = "status",  FieldDescription="负责的工作状态(0:待分配;1:进行中;2:已完成;3:已确认)")
    private String status;

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

    /**
     * 下级责任人列表
     */
    private List<WorkResponsible> children = new ArrayList<>();

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

    public String getWorkInfoId() {
        return workInfoId;
    }

    public void setWorkInfoId(String workInfoId) {
        this.workInfoId = workInfoId;
    }

    public String getResponsibleContent() {
        return responsibleContent;
    }

    public void setResponsibleContent(String responsibleContent) {
        this.responsibleContent = responsibleContent;
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

    public String getFinishedDesc() {
        return finishedDesc;
    }

    public void setFinishedDesc(String finishedDesc) {
        this.finishedDesc = finishedDesc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public List<WorkResponsible> getChildren() {
        return children;
    }

    public void setChildren(List<WorkResponsible> children) {
        this.children = children;
    }



}