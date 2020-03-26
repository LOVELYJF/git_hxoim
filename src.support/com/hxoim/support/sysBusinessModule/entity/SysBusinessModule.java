package com.hxoim.support.sysBusinessModule.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.IdAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * sys_business_module
 */
@TableAnnotation(TableName = "sys_business_module", TableDescription="")
public class SysBusinessModule {
    /**
     * 主键
     */
    @IdAnnotation
    @ColumnAnnotation(FieldName = "id",  FieldDescription="主键")
    private String id;

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

    /**
     * 系统模块名称
     */
    @ColumnAnnotation(FieldName = "node_name",  FieldDescription="系统模块名称")
    private String nodeName;

    /**
     * 父ID
     */
    @ColumnAnnotation(FieldName = "pid",  FieldDescription="父ID")
    private String pid;

    /**
     * 图标
     */
    @ColumnAnnotation(FieldName = "bm_icon",  FieldDescription="图标")
    private String bmIcon;

    /**
     * URL
     */
    @ColumnAnnotation(FieldName = "bm_url",  FieldDescription="URL")
    private String bmUrl;

    /**
     * 排序
     */
    @ColumnAnnotation(FieldName = "order_index",  FieldDescription="排序")
    private Integer orderIndex;

    /**
     * 系统表ID
     */
    @ColumnAnnotation(FieldName = "system_id",  FieldDescription="系统表ID")
    private String systemId;

    /**
     * 系统模块类型
     */
    @ColumnAnnotation(FieldName = "bm_type",  FieldDescription="系统模块类型")
    private String bmType;

    /**
     * 参数设置
     */
    @ColumnAnnotation(FieldName = "bm_arguments",  FieldDescription="参数设置")
    private String bmArguments;
    /**
     * 用到的表
     */
    @ColumnAnnotation(FieldName = "bm_use_table",  FieldDescription="用到的表")
    private String bmUseTable;
    /**
     * 主键字段名
     */
    @ColumnAnnotation(FieldName = "bm_primark",  FieldDescription="主键字段名")
    private String bmPrimark;

    public SysBusinessModule(String id, String modifyUser, Date modifyTime, String nodeName, String pid, String bmIcon, String bmUrl, Integer orderIndex, String systemId, String bmType, String bmArguments, String bmUseTable, String bmPrimark) {
        this.id = id;
        this.modifyUser = modifyUser;
        this.modifyTime = modifyTime;
        this.nodeName = nodeName;
        this.pid = pid;
        this.bmIcon = bmIcon;
        this.bmUrl = bmUrl;
        this.orderIndex = orderIndex;
        this.systemId = systemId;
        this.bmType = bmType;
        this.bmArguments = bmArguments;
        this.bmUseTable = bmUseTable;
        this.bmPrimark = bmPrimark;
    }

    public SysBusinessModule() {
        super();
    }

    /**
     * 主键
     * @return id 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 主键
     * @param id 主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    /**
     * 父ID
     * @return pid 父ID
     */
    public String getPid() {
        return pid;
    }

    /**
     * 父ID
     * @param pid 父ID
     */
    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    /**
     * 图标
     * @return bm_icon 图标
     */
    public String getBmIcon() {
        return bmIcon;
    }

    /**
     * 图标
     * @param bmIcon 图标
     */
    public void setBmIcon(String bmIcon) {
        this.bmIcon = bmIcon == null ? null : bmIcon.trim();
    }

    /**
     * URL
     * @return bm_url URL
     */
    public String getBmUrl() {
        return bmUrl;
    }

    /**
     * URL
     * @param bmUrl URL
     */
    public void setBmUrl(String bmUrl) {
        this.bmUrl = bmUrl == null ? null : bmUrl.trim();
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
     * 系统表ID
     * @return system_id 系统表ID
     */
    public String getSystemId() {
        return systemId;
    }

    /**
     * 系统表ID
     * @param systemId 系统表ID
     */
    public void setSystemId(String systemId) {
        this.systemId = systemId == null ? null : systemId.trim();
    }

    /**
     * 系统模块类型
     * @return bm_type 系统模块类型
     */
    public String getBmType() {
        return bmType;
    }

    /**
     * 系统模块类型
     * @param bmType 系统模块类型
     */
    public void setBmType(String bmType) {
        this.bmType = bmType == null ? null : bmType.trim();
    }

    /**
     * 参数设置
     * @return bm_arguments 参数设置
     */
    public String getBmArguments() {
        return bmArguments;
    }

    /**
     * 参数设置
     * @param bmArguments 参数设置
     */
    public void setBmArguments(String bmArguments) {
        this.bmArguments = bmArguments == null ? null : bmArguments.trim();
    }

    public String getBmUseTable() {
        return bmUseTable;
    }

    public void setBmUseTable(String bmUseTable) {
        this.bmUseTable = bmUseTable;
    }

    public String getBmPrimark() {
        return bmPrimark;
    }

    public void setBmPrimark(String bmPrimark) {
        this.bmPrimark = bmPrimark;
    }
}