package com.hxoim.support.module.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.IdAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * cf_module
 */
@TableAnnotation(TableName = "cf_module", TableDescription="")
public class Module {
    /**
     * 模块ID,主键
     */
    @IdAnnotation
    @ColumnAnnotation(FieldName = "id",  FieldDescription="模块ID,主键")
    private String id;

    /**
     * 模块编码
     */
    @ColumnAnnotation(FieldName = "mu_code",  FieldDescription="模块编码")
    private String muCode;

    /**
     * 模块名称
     */
    @ColumnAnnotation(FieldName = "mu_name",  FieldDescription="模块名称")
    private String muName;

    /**
     * 模块类型(1-导航,2-按钮,3-分类)
     */
    @ColumnAnnotation(FieldName = "mu_type",  FieldDescription="模块类型(1-导航,2-按钮,3-分类)")
    private String muType;

    /**
     * 模块描述
     */
    @ColumnAnnotation(FieldName = "mu_desc",  FieldDescription="模块描述")
    private String muDesc;

    /**
     * 模块状态(是否使用)
     */
    @ColumnAnnotation(FieldName = "mu_state",  FieldDescription="模块状态(是否使用)")
    private String muState;

    /**
     * 模块图片
     */
    @ColumnAnnotation(FieldName = "mu_icon",  FieldDescription="模块图片")
    private String muIcon;

    /**
     * 模块父ID
     */
    @ColumnAnnotation(FieldName = "p_id",  FieldDescription="模块父ID")
    private String pId;

    /**
     * 模块访问地址
     */
    @ColumnAnnotation(FieldName = "url",  FieldDescription="模块访问地址")
    private String url;

    /**
     * 组件路径
     */
    @ColumnAnnotation(FieldName = "assembly",  FieldDescription="组件路径")
    private String assembly;

    /**
     * 排序
     */
    @ColumnAnnotation(FieldName = "order_index",  FieldDescription="排序")
    private Integer orderIndex;

    /**
     * 修改用户
     */
    @ColumnAnnotation(FieldName = "modify_user",  FieldDescription="修改用户")
    private String modifyUser;

    /**
     * 修改时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ColumnAnnotation(FieldName = "modify_time",  FieldDescription="修改时间")
    private Date modifyTime;

    public Module(String id, String muCode, String muName, String muType, String muDesc, String muState, String muIcon, String pId, String url, String assembly, Integer orderIndex, String modifyUser, Date modifyTime) {
        this.id = id;
        this.muCode = muCode;
        this.muName = muName;
        this.muType = muType;
        this.muDesc = muDesc;
        this.muState = muState;
        this.muIcon = muIcon;
        this.pId = pId;
        this.url = url;
        this.assembly = assembly;
        this.orderIndex = orderIndex;
        this.modifyUser = modifyUser;
        this.modifyTime = modifyTime;
    }

    public Module() {
        super();
    }

    /**
     * 模块ID,主键
     * @return id 模块ID,主键
     */
    public String getId() {
        return id;
    }

    /**
     * 模块ID,主键
     * @param id 模块ID,主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 模块编码
     * @return mu_code 模块编码
     */
    public String getMuCode() {
        return muCode;
    }

    /**
     * 模块编码
     * @param muCode 模块编码
     */
    public void setMuCode(String muCode) {
        this.muCode = muCode == null ? null : muCode.trim();
    }

    /**
     * 模块名称
     * @return mu_name 模块名称
     */
    public String getMuName() {
        return muName;
    }

    /**
     * 模块名称
     * @param muName 模块名称
     */
    public void setMuName(String muName) {
        this.muName = muName == null ? null : muName.trim();
    }

    /**
     * 模块类型(1-导航,2-按钮,3-分类)
     * @return mu_type 模块类型(1-导航,2-按钮,3-分类)
     */
    public String getMuType() {
        return muType;
    }

    /**
     * 模块类型(1-导航,2-按钮,3-分类)
     * @param muType 模块类型(1-导航,2-按钮,3-分类)
     */
    public void setMuType(String muType) {
        this.muType = muType == null ? null : muType.trim();
    }

    /**
     * 模块描述
     * @return mu_desc 模块描述
     */
    public String getMuDesc() {
        return muDesc;
    }

    /**
     * 模块描述
     * @param muDesc 模块描述
     */
    public void setMuDesc(String muDesc) {
        this.muDesc = muDesc == null ? null : muDesc.trim();
    }

    /**
     * 模块状态(是否使用)
     * @return mu_state 模块状态(是否使用)
     */
    public String getMuState() {
        return muState;
    }

    /**
     * 模块状态(是否使用)
     * @param muState 模块状态(是否使用)
     */
    public void setMuState(String muState) {
        this.muState = muState == null ? null : muState.trim();
    }

    /**
     * 模块图片
     * @return mu_icon 模块图片
     */
    public String getMuIcon() {
        return muIcon;
    }

    /**
     * 模块图片
     * @param muIcon 模块图片
     */
    public void setMuIcon(String muIcon) {
        this.muIcon = muIcon == null ? null : muIcon.trim();
    }

    /**
     * 模块父ID
     * @return p_id 模块父ID
     */
    public String getpId() {
        return pId;
    }

    /**
     * 模块父ID
     * @param pId 模块父ID
     */
    public void setpId(String pId) {
        this.pId = pId == null ? null : pId.trim();
    }

    /**
     * 模块访问地址
     * @return url 模块访问地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 模块访问地址
     * @param url 模块访问地址
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 组件路径
     * @return assembly 组件路径
     */
    public String getAssembly() {
        return assembly;
    }

    /**
     * 组件路径
     * @param assembly 组件路径
     */
    public void setAssembly(String assembly) {
        this.assembly = assembly == null ? null : assembly.trim();
    }

    /**
     * 排序
     * @return order_index 排序
     */
    public Integer getOrderIndex() {
        return orderIndex;
    }

    /**
     * 排序
     * @param orderIndex 排序
     */
    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
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