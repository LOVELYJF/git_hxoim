package com.hxoim.support.dataServeApply.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.IdAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * data_serve_apply
 */
@TableAnnotation(TableName = "data_serve_apply", TableDescription="")
public class DataServeApply {
    /**
     * id
     */
    @IdAnnotation
    @ColumnAnnotation(FieldName = "id",  FieldDescription="id")
    private String id;

    /**
     * 服务ip
     */
    @ColumnAnnotation(FieldName = "serve_ip",  FieldDescription="服务ip")
    private String serveIp;

    /**
     * 服务密码
     */
    @ColumnAnnotation(FieldName = "serve_password",  FieldDescription="服务密码")
    private String servePassword;

    /**
     * 服务用户名
     */
    @ColumnAnnotation(FieldName = "serve_username",  FieldDescription="服务用户名")
    private String serveUsername;

    /**
     * 申请机构
     */
    @ColumnAnnotation(FieldName = "apply_org",  FieldDescription="申请机构")
    private String applyOrg;

    /**
     * 申请处室
     */
    @ColumnAnnotation(FieldName = "apply_office",  FieldDescription="申请处室")
    private String applyOffice;

    /**
     * 软件开发方
     */
    @ColumnAnnotation(FieldName = "software_dev_name",  FieldDescription="软件开发方")
    private String softwareDevName;

    /**
     * 服务状态
     */
    @ColumnAnnotation(FieldName = "serve_status",  FieldDescription="服务状态")
    private String serveStatus;

    /**
     * 修改人
     */
    @ColumnAnnotation(FieldName = "modify_user",  FieldDescription="修改人")
    private String modifyUser;

    /**
     * 修改时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ColumnAnnotation(FieldName = "modify_time",  FieldDescription="修改时间")
    private Date modifyTime;

    /**
     * 申请说明
     */
    @ColumnAnnotation(FieldName = "apply_desc",  FieldDescription="申请说明")
    private String applyDesc;

    public DataServeApply(String id, String serveIp, String servePassword, String serveUsername, String applyOrg, String applyOffice, String softwareDevName, String serveStatus, String modifyUser, Date modifyTime, String applyDesc) {
        this.id = id;
        this.serveIp = serveIp;
        this.servePassword = servePassword;
        this.serveUsername = serveUsername;
        this.applyOrg = applyOrg;
        this.applyOffice = applyOffice;
        this.softwareDevName = softwareDevName;
        this.serveStatus = serveStatus;
        this.modifyUser = modifyUser;
        this.modifyTime = modifyTime;
        this.applyDesc =applyDesc;
    }

    public DataServeApply() {
        super();
    }

    /**
     * id
     * @return id id
     */
    public String getId() {
        return id;
    }

    /**
     * id
     * @param id id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 服务ip
     * @return serve_ip 服务ip
     */
    public String getServeIp() {
        return serveIp;
    }

    /**
     * 服务ip
     * @param serveIp 服务ip
     */
    public void setServeIp(String serveIp) {
        this.serveIp = serveIp == null ? null : serveIp.trim();
    }

    /**
     * 服务密码
     * @return serve_password 服务密码
     */
    public String getServePassword() {
        return servePassword;
    }

    /**
     * 服务密码
     * @param servePassword 服务密码
     */
    public void setServePassword(String servePassword) {
        this.servePassword = servePassword == null ? null : servePassword.trim();
    }

    /**
     * 服务用户名
     * @return serve_username 服务用户名
     */
    public String getServeUsername() {
        return serveUsername;
    }

    /**
     * 服务用户名
     * @param serveUsername 服务用户名
     */
    public void setServeUsername(String serveUsername) {
        this.serveUsername = serveUsername == null ? null : serveUsername.trim();
    }

    /**
     * 申请机构
     * @return apply_org 申请机构
     */
    public String getApplyOrg() {
        return applyOrg;
    }

    /**
     * 申请机构
     * @param applyOrg 申请机构
     */
    public void setApplyOrg(String applyOrg) {
        this.applyOrg = applyOrg == null ? null : applyOrg.trim();
    }

    /**
     * 申请处室
     * @return apply_office 申请处室
     */
    public String getApplyOffice() {
        return applyOffice;
    }

    /**
     * 申请处室
     * @param applyOffice 申请处室
     */
    public void setApplyOffice(String applyOffice) {
        this.applyOffice = applyOffice == null ? null : applyOffice.trim();
    }

    /**
     * 软件开发方
     * @return software_dev_name 软件开发方
     */
    public String getSoftwareDevName() {
        return softwareDevName;
    }

    /**
     * 软件开发方
     * @param softwareDevName 软件开发方
     */
    public void setSoftwareDevName(String softwareDevName) {
        this.softwareDevName = softwareDevName == null ? null : softwareDevName.trim();
    }

    /**
     * 服务状态
     * @return serve_status 服务状态
     */
    public String getServeStatus() {
        return serveStatus;
    }

    /**
     * 服务状态
     * @param serveStatus 服务状态
     */
    public void setServeStatus(String serveStatus) {
        this.serveStatus = serveStatus;
    }

    /**
     * 修改人
     * @return modify_user 修改人
     */
    public String getModifyUser() {
        return modifyUser;
    }

    /**
     * 修改人
     * @param modifyUser 修改人
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

    /**
     * 申请说明
     * @return apply_desc 申请说明
     */
    public String getApplyDesc() {
        return applyDesc;
    }

    /**
     * 申请说明
     * @param applyDesc 申请说明
     */
    public void setApplyDesc(String applyDesc) {
        this.applyDesc = applyDesc == null ? null : applyDesc.trim();
    }
}