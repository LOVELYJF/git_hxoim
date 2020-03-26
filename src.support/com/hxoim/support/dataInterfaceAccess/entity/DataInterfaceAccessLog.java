package com.hxoim.support.dataInterfaceAccess.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.IdAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * cf_datainterface_accesslog
 */
@TableAnnotation(TableName = "cf_datainterface_accesslog", TableDescription="")
public class DataInterfaceAccessLog {
    /**
     *
     */
    @IdAnnotation
    @ColumnAnnotation(FieldName = "id",  FieldDescription="")
    private String id;

    /**
     * 服务ip
     */
    @ColumnAnnotation(FieldName = "serve_ip",  FieldDescription="服务ip")
    private String serveIp;

    /**
     * 服务用户名
     */
    @ColumnAnnotation(FieldName = "serve_username",  FieldDescription="服务用户名")
    private String serveUsername;

    /**
     * 服务密码
     */
    @ColumnAnnotation(FieldName = "serve_password",  FieldDescription="服务密码")
    private String servePassword;

    /**
     * 访问接口类型(0:元数据描述接口1:数据接口)
     */
    @ColumnAnnotation(FieldName = "interface_access_type",  FieldDescription="访问接口类型(0:元数据描述接口1:数据接口)")
    private String interfaceAccessType;

    /**
     * 访问接口名称
     */
    @ColumnAnnotation(FieldName = "interface_access_name",  FieldDescription="访问接口名称")
    private String interfaceAccessName;

    /**
     * 访问条件
     */
    @ColumnAnnotation(FieldName = "access_condition",  FieldDescription="访问条件")
    private String accessCondition;

    /**
     * 修改时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ColumnAnnotation(FieldName = "modify_time",  FieldDescription="修改时间")
    private Date modifyTime;

    public DataInterfaceAccessLog(String id, String serveIp, String serveUsername, String servePassword, String interfaceAccessType, String interfaceAccessName, String accessCondition, Date modifyTime) {
        this.id = id;
        this.serveIp = serveIp;
        this.serveUsername = serveUsername;
        this.servePassword = servePassword;
        this.interfaceAccessType = interfaceAccessType;
        this.interfaceAccessName = interfaceAccessName;
        this.accessCondition = accessCondition;
        this.modifyTime = modifyTime;
    }

    public DataInterfaceAccessLog() {
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
     * 访问接口类型(0:元数据描述接口1:数据接口)
     * @return interface_access_type 访问接口类型(0:元数据描述接口1:数据接口)
     */
    public String getInterfaceAccessType() {
        return interfaceAccessType;
    }

    /**
     * 访问接口类型(0:元数据描述接口1:数据接口)
     * @param interfaceAccessType 访问接口类型(0:元数据描述接口1:数据接口)
     */
    public void setInterfaceAccessType(String interfaceAccessType) {
        this.interfaceAccessType = interfaceAccessType == null ? null : interfaceAccessType.trim();
    }

    /**
     * 访问接口名称
     * @return interface_access_name 访问接口名称
     */
    public String getInterfaceAccessName() {
        return interfaceAccessName;
    }

    /**
     * 访问接口名称
     * @param interfaceAccessName 访问接口名称
     */
    public void setInterfaceAccessName(String interfaceAccessName) {
        this.interfaceAccessName = interfaceAccessName == null ? null : interfaceAccessName.trim();
    }

    /**
     * 访问条件
     * @return access_condition 访问条件
     */
    public String getAccessCondition() {
        return accessCondition;
    }

    /**
     * 访问条件
     * @param accessCondition 访问条件
     */
    public void setAccessCondition(String accessCondition) {
        this.accessCondition = accessCondition == null ? null : accessCondition.trim();
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
