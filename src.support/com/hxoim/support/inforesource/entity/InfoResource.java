package com.hxoim.support.inforesource.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.IdAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @resourceDesc: 信息资源管理
 * @Author: 张乾
 * @CreateDate: 2019/5/23$ 19:11$
 * info_resource
 */
@TableAnnotation(TableName = "info_resource", TableDescription="")
public class InfoResource {
    /**
     * 信息资源id
     */
    @IdAnnotation
    @ColumnAnnotation(FieldName = "Id",  FieldDescription="信息资源id")
    private String id;

    /**
     * 资源名称
     */
    @ColumnAnnotation(FieldName = "resource_name",  FieldDescription="资源名称")
    private String resourceName;

    /**
     * 资源编号
     */
    @ColumnAnnotation(FieldName = "resource_code",  FieldDescription="资源编号")
    private String resourceCode;

    /**
     * 资源描述
     */
    @ColumnAnnotation(FieldName = "resource_desc",  FieldDescription="资源描述")
    private String resourceDesc;

    /**
     * 上级分类
     */
    @ColumnAnnotation(FieldName = "pid",  FieldDescription="上级分类")
    private String pid;

    /**
     * 排序
     */
    @ColumnAnnotation(FieldName = "orderindex",  FieldDescription="排序")
    private Integer orderindex;

    /**
     *
     */
    @ColumnAnnotation(FieldName = "resource_type",  FieldDescription="资源类型")
    private String resourceType;

    /**
     *
     */
    @ColumnAnnotation(FieldName = "modify_user",  FieldDescription="")
    private String modifyUser;

    /**
     * 修改时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ColumnAnnotation(FieldName = "modify_time",  FieldDescription="修改时间")
    private Date modifyTime;

    public InfoResource(String id, String resourceName, String resourceCode, String resourceDesc, String pid, Integer orderindex, String resourceType, String modifyUser, Date modifyTime) {
        this.id = id;
        this.resourceName = resourceName;
        this.resourceCode = resourceCode;
        this.resourceDesc = resourceDesc;
        this.pid = pid;
        this.orderindex = orderindex;
        this.resourceType = resourceType;
        this.modifyUser = modifyUser;
        this.modifyTime = modifyTime;
    }

    public InfoResource() {
        super();
    }

    /**
     * 信息资源id
     * @return Id 信息资源id
     */
    public String getId() {
        return id;
    }

    /**
     * 信息资源id
     * @param id 信息资源id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 资源名称
     * @return resource_name 资源名称
     */
    public String getResourceName() {
        return resourceName;
    }

    /**
     * 资源名称
     * @param resourceName 资源名称
     */
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName == null ? null : resourceName.trim();
    }

    /**
     * 资源编号
     * @return resource_code 资源编号
     */
    public String getResourceCode() {
        return resourceCode;
    }

    /**
     * 资源编号
     * @param resourceCode 资源编号
     */
    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode == null ? null : resourceCode.trim();
    }

    /**
     * 资源描述
     * @return resource_desc 资源描述
     */
    public String getResourceDesc() {
        return resourceDesc;
    }

    /**
     * 资源描述
     * @param resourceDesc 资源描述
     */
    public void setResourceDesc(String resourceDesc) {
        this.resourceDesc = resourceDesc == null ? null : resourceDesc.trim();
    }

    /**
     * 上级分类
     * @return pid 上级分类
     */
    public String getPid() {
        return pid;
    }

    /**
     * 上级分类
     * @param pid 上级分类
     */
    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    /**
     * 排序
     * @return orderindex 排序
     */
    public Integer getOrderindex() {
        return orderindex;
    }

    /**
     * 排序
     * @param orderindex 排序
     */
    public void setOrderindex(Integer orderindex) {
        this.orderindex = orderindex;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    /**
     *
     * @return modify_user
     */
    public String getModifyUser() {
        return modifyUser;
    }

    /**
     *
     * @param modifyUser
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
