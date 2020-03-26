package com.hxoim.support.dataInterfaceDefinition.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.IdAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * data_interface_definition
 */
@TableAnnotation(TableName = "data_interface_definition", TableDescription="")
public class DataInterfaceDefinition {
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
     * 元数据描述接口
     */
    @ColumnAnnotation(FieldName = "data_interface_desc",  FieldDescription="元数据描述接口")
    private String dataInterfaceDesc;

    /**
     * 数据接口
     */
    @ColumnAnnotation(FieldName = "data_interface",  FieldDescription="数据接口")
    private String dataInterface;

    /**
     * 说明
     */
    @ColumnAnnotation(FieldName = "introductions",  FieldDescription="说明")
    private String introductions;

    /**
     * 状态(0:启用1:删除)
     */
    @ColumnAnnotation(FieldName = "status",  FieldDescription="状态(0:启用1:停用)")
    private String status;

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
     * SQL语句
     */
    @ColumnAnnotation(FieldName = "data_sql",  FieldDescription="数据sql")
    private String dataSql;

    /**
     * 元数据描述
     */
    @ColumnAnnotation(FieldName = "data_desc",  FieldDescription="元数据描述")
    private String dataDesc;

    public DataInterfaceDefinition(String id, String infoResourceId, String dataInterfaceDesc, String dataInterface, String introductions, String status, String modifyUser, Date modifyTime,String dataSql,String dataDesc) {
        this.id = id;
        this.infoResourceId = infoResourceId;
        this.dataInterfaceDesc = dataInterfaceDesc;
        this.dataInterface = dataInterface;
        this.introductions = introductions;
        this.status = status;
        this.modifyUser = modifyUser;
        this.modifyTime = modifyTime;
        this.dataSql = dataSql;
        this.dataDesc = dataDesc;
    }

    public DataInterfaceDefinition() {
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
     * 信息资源id
     * @return info_resource_id 信息资源id
     */
    public String getInfoResourceId() {
        return infoResourceId;
    }

    /**
     * 信息资源id
     * @param infoResourceId 信息资源id
     */
    public void setInfoResourceId(String infoResourceId) {
        this.infoResourceId = infoResourceId == null ? null : infoResourceId.trim();
    }

    /**
     * 元数据描述接口
     * @return data_interface_desc 元数据描述接口
     */
    public String getDataInterfaceDesc() {
        return dataInterfaceDesc;
    }

    /**
     * 元数据描述接口
     * @param dataInterfaceDesc 元数据描述接口
     */
    public void setDataInterfaceDesc(String dataInterfaceDesc) {
        this.dataInterfaceDesc = dataInterfaceDesc == null ? null : dataInterfaceDesc.trim();
    }

    /**
     * 数据接口
     * @return data_interface 数据接口
     */
    public String getDataInterface() {
        return dataInterface;
    }

    /**
     * 数据接口
     * @param dataInterface 数据接口
     */
    public void setDataInterface(String dataInterface) {
        this.dataInterface = dataInterface == null ? null : dataInterface.trim();
    }

    /**
     * 说明
     * @return Introductions 说明
     */
    public String getIntroductions() {
        return introductions;
    }

    /**
     * 说明
     * @param introductions 说明
     */
    public void setIntroductions(String introductions) {
        this.introductions = introductions == null ? null : introductions.trim();
    }

    /**
     * 状态(0:启用1:停用)
     * @return status 状态(0:启用1:停用)
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态(0:启用1:停用)
     * @param status 状态(0:启用1:停用)
     */
    public void setStatus(String status) {
        this.status = status;
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

    public String getDataSql() {
        return dataSql;
    }

    public void setDataSql(String dataSql) {
        this.dataSql = dataSql;
    }

    public String getDataDesc() {
        return dataDesc;
    }

    public void setDataDesc(String dataDesc) {
        this.dataDesc = dataDesc;
    }
}