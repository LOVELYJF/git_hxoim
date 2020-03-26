package com.hxoim.support.dataServeAuth.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.IdAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * data_serve_auth
 */
@TableAnnotation(TableName = "data_serve_auth", TableDescription="")
public class DataServeAuth {
    /**
     * id
     */
    @IdAnnotation
    @ColumnAnnotation(FieldName = "id",  FieldDescription="id")
    private String id;

    /**
     * 信息资源id
     */
    @ColumnAnnotation(FieldName = "info_resource_id",  FieldDescription="信息资源id")
    private String infoResourceId;

    /**
     * 数据接口定义id
     */
    @ColumnAnnotation(FieldName = "interface_definition_id",  FieldDescription="数据接口定义id")
    private String interfaceDefinitionId;

    /**
     * 数据服务id
     */
    @ColumnAnnotation(FieldName = "serve_id",  FieldDescription="数据服务id")
    private String serveId;

    /**
     * 分配描述
     */
    @ColumnAnnotation(FieldName = "auth_desc",  FieldDescription="分配描述")
    private String authDesc;

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

    public DataServeAuth(String id, String interfaceDefinitionId,String infoResourceId,  String serveId, String authDesc, String modifyUser, Date modifyTime) {
        this.id = id;
        this.interfaceDefinitionId = interfaceDefinitionId;
        this.infoResourceId = infoResourceId;
        this.serveId = serveId;
        this.authDesc = authDesc;
        this.modifyUser = modifyUser;
        this.modifyTime = modifyTime;
    }

    public DataServeAuth() {
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
     * 数据接口定义id
     * @return interface_definition_id 数据接口定义id
     */
    public String getInterfaceDefinitionId() {
        return interfaceDefinitionId;
    }

    /**
     * 数据接口定义id
     * @param interfaceDefinitionId 数据接口定义id
     */
    public void setInterfaceDefinitionId(String interfaceDefinitionId) {
        this.interfaceDefinitionId = interfaceDefinitionId == null ? null : interfaceDefinitionId.trim();
    }

    /**
     * 数据服务id
     * @return serve_id 数据服务id
     */
    public String getServeId() {
        return serveId;
    }

    /**
     * 数据服务id
     * @param serveId 数据服务id
     */
    public void setServeId(String serveId) {
        this.serveId = serveId == null ? null : serveId.trim();
    }

    public String getInfoResourceId() {
        return infoResourceId;
    }

    public void setInfoResourceId(String infoResourceId) {
        this.infoResourceId = infoResourceId;
    }

    public String getAuthDesc() {
        return authDesc;
    }

    public void setAuthDesc(String authDesc) {
        this.authDesc = authDesc;
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
}