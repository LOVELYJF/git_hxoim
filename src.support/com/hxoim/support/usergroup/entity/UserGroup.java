package com.hxoim.support.usergroup.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.IdAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @description：用户组（处室）实体类
 * @author ：张乾
 * @createDate ： 2019/5/30 10:20
 * cf_usergroup
 */
@TableAnnotation(TableName = "cf_usergroup", TableDescription="")
public class UserGroup {
    /**
     *
     */
    @IdAnnotation
    @ColumnAnnotation(FieldName = "id",  FieldDescription="")
    private String id;

    /**
     * ug_Code
     */
    @ColumnAnnotation(FieldName = "ug_Code",  FieldDescription="ug_Code")
    private String ugCode;

    /**
     * ug_name
     */
    @ColumnAnnotation(FieldName = "ug_name",  FieldDescription="ug_name")
    private String ugName;

    /**
     * ug_type
     */
    @ColumnAnnotation(FieldName = "ug_type",  FieldDescription="ug_type")
    private String ugType;

    /**
     * ug_desc
     */
    @ColumnAnnotation(FieldName = "ug_desc",  FieldDescription="ug_desc")
    private String ugDesc;

    /**
     * ug_state
     */
    @ColumnAnnotation(FieldName = "ug_state",  FieldDescription="ug_state")
    private String ugState;

    /**
     * ug_condition
     */
    @ColumnAnnotation(FieldName = "ug_condition",  FieldDescription="ug_condition")
    private String ugCondition;

    /**
     * orderno
     */
    @ColumnAnnotation(FieldName = "orderno",  FieldDescription="orderno")
    private Integer orderno;

    /**
     * ug_pid
     */
    @ColumnAnnotation(FieldName = "pid",  FieldDescription="ug_pid")
    private String pid;

    /**
     * org_id
     */
    @ColumnAnnotation(FieldName = "org_id",  FieldDescription="org_id")
    private String orgId;

    /**
     * 修改用户
     */
    @ColumnAnnotation(FieldName = "modify_user",  FieldDescription="修改用户")
    private String modifyUser;

    /**
     * 修改时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ColumnAnnotation(FieldName = "modify_time",  FieldDescription="修改时间")
    private Date modifyTime;

    public UserGroup(String id, String ugCode, String ugName, String ugType, String ugDesc, String ugState, String ugCondition, Integer orderno, String pid, String orgId, String modifyUser, Date modifyTime) {
        this.id = id;
        this.ugCode = ugCode;
        this.ugName = ugName;
        this.ugType = ugType;
        this.ugDesc = ugDesc;
        this.ugState = ugState;
        this.ugCondition = ugCondition;
        this.orderno = orderno;
        this.pid = pid;
        this.orgId = orgId;
        this.modifyUser = modifyUser;
        this.modifyTime = modifyTime;
    }

    public UserGroup() {
        super();
    }

    /**
     *
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * ug_Code
     * @return ug_Code ug_Code
     */
    public String getUgCode() {
        return ugCode;
    }

    /**
     * ug_Code
     * @param ugCode ug_Code
     */
    public void setUgCode(String ugCode) {
        this.ugCode = ugCode == null ? null : ugCode.trim();
    }

    /**
     * ug_name
     * @return ug_name ug_name
     */
    public String getUgName() {
        return ugName;
    }

    /**
     * ug_name
     * @param ugName ug_name
     */
    public void setUgName(String ugName) {
        this.ugName = ugName == null ? null : ugName.trim();
    }

    /**
     * ug_type
     * @return ug_type ug_type
     */
    public String getUgType() {
        return ugType;
    }

    /**
     * ug_type
     * @param ugType ug_type
     */
    public void setUgType(String ugType) {
        this.ugType = ugType == null ? null : ugType.trim();
    }

    /**
     * ug_desc
     * @return ug_desc ug_desc
     */
    public String getUgDesc() {
        return ugDesc;
    }

    /**
     * ug_desc
     * @param ugDesc ug_desc
     */
    public void setUgDesc(String ugDesc) {
        this.ugDesc = ugDesc == null ? null : ugDesc.trim();
    }

    /**
     * ug_state
     * @return ug_state ug_state
     */
    public String getUgState() {
        return ugState;
    }

    /**
     * ug_state
     * @param ugState ug_state
     */
    public void setUgState(String ugState) {
        this.ugState = ugState == null ? null : ugState.trim();
    }

    /**
     * ug_condition
     * @return ug_condition ug_condition
     */
    public String getUgCondition() {
        return ugCondition;
    }

    /**
     * ug_condition
     * @param ugCondition ug_condition
     */
    public void setUgCondition(String ugCondition) {
        this.ugCondition = ugCondition == null ? null : ugCondition.trim();
    }

    /**
     * orderno
     * @return orderno orderno
     */
    public Integer getOrderno() {
        return orderno;
    }

    /**
     * orderno
     * @param orderno orderno
     */
    public void setOrderno(Integer orderno) {
        this.orderno = orderno;
    }

    /**
     * ug_pid
     * @return pid ug_pid
     */
    public String getPid() {
        return pid;
    }

    /**
     * ug_pid
     * @param pid ug_pid
     */
    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    /**
     * org_id
     * @return org_id org_id
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     * org_id
     * @param orgId org_id
     */
    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    /**
     * 修改用户
     * @return modify_user 修改用户
     */
    public String getModifyUser() {
        return modifyUser;
    }

    /**
     * 修改用户
     * @param modifyUser 修改用户
     */
    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser == null ? null : modifyUser.trim();
    }

    /**
     * 修改时间
     * @return modify_time 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 修改时间
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
