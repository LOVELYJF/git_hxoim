package com.hxoim.support.system.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.IdAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author sunqian
 * @Description 系统实体
 * @Date 14:29 2019/6/6
 * cf_system
 */
@TableAnnotation(TableName = "cf_system", TableDescription="")
public class SystemInfo {
    /**
     * 系统id
     */
    @IdAnnotation
    @ColumnAnnotation(FieldName = "id",  FieldDescription="系统id")
    private String id;

    /**
     * 系统名称
     */
    @ColumnAnnotation(FieldName = "system_name",  FieldDescription="系统名称")
    private String systemName;

    /**
     * 登录url
     */
    @ColumnAnnotation(FieldName = "login_url",  FieldDescription="登录url")
    private String loginUrl;

    /**
     * 主页url
     */
    @ColumnAnnotation(FieldName = "home_url",  FieldDescription="主页url")
    private String homeUrl;

    /**
     * 父ID
     */
    @ColumnAnnotation(FieldName = "p_id",  FieldDescription="父ID")
    private String pId;

    /**
     * 系统类型(1-分类,2-系统)
     */
    @ColumnAnnotation(FieldName = "system_type",  FieldDescription="系统类型(1-分类,2-系统)")
    private String systemType;

    /**
     * 是否改造（0-未改造，1-改造）
     */
    @ColumnAnnotation(FieldName = "is_remodel",  FieldDescription="是否改造（0-未改造，1-改造）")
    private String isRemodel;

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
     * 排序
     */
    @ColumnAnnotation(FieldName = "order_index",  FieldDescription="排序")
    private Integer orderIndex;

    public SystemInfo(String id, String systemName, String loginUrl, String homeUrl, String pId, String systemType, String isRemodel, String modifyUser, Date modifyTime, Integer orderIndex) {
        this.id = id;
        this.systemName = systemName;
        this.loginUrl = loginUrl;
        this.homeUrl = homeUrl;
        this.pId = pId;
        this.systemType = systemType;
        this.isRemodel = isRemodel;
        this.modifyUser = modifyUser;
        this.modifyTime = modifyTime;
        this.orderIndex = orderIndex;
    }

    public SystemInfo() {
        super();
    }

    /**
     * 系统id
     * @return id 系统id
     */
    public String getId() {
        return id;
    }

    /**
     * 系统id
     * @param id 系统id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 系统名称
     * @return system_name 系统名称
     */
    public String getSystemName() {
        return systemName;
    }

    /**
     * 系统名称
     * @param systemName 系统名称
     */
    public void setSystemName(String systemName) {
        this.systemName = systemName == null ? null : systemName.trim();
    }

    /**
     * 登录url
     * @return login_url 登录url
     */
    public String getLoginUrl() {
        return loginUrl;
    }

    /**
     * 登录url
     * @param loginUrl 登录url
     */
    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl == null ? null : loginUrl.trim();
    }

    /**
     * 主页url
     * @return home_url 主页url
     */
    public String getHomeUrl() {
        return homeUrl;
    }

    /**
     * 主页url
     * @param homeUrl 主页url
     */
    public void setHomeUrl(String homeUrl) {
        this.homeUrl = homeUrl == null ? null : homeUrl.trim();
    }

    /**
     * 父ID
     * @return p_id 父ID
     */
    public String getpId() {
        return pId;
    }

    /**
     * 父ID
     * @param pId 父ID
     */
    public void setpId(String pId) {
        this.pId = pId == null ? null : pId.trim();
    }

    /**
     * 系统类型(1-分类,2-系统)
     * @return system_type 系统类型(1-分类,2-系统)
     */
    public String getSystemType() {
        return systemType;
    }

    /**
     * 系统类型(1-分类,2-系统)
     * @param systemType 系统类型(1-分类,2-系统)
     */
    public void setSystemType(String systemType) {
        this.systemType = systemType == null ? null : systemType.trim();
    }

    /**
     * 是否改造（0-未改造，1-改造）
     * @return is_remodel 是否改造（0-未改造，1-改造）
     */
    public String getIsRemodel() {
        return isRemodel;
    }

    /**
     * 是否改造（0-未改造，1-改造）
     * @param isRemodel 是否改造（0-未改造，1-改造）
     */
    public void setIsRemodel(String isRemodel) {
        this.isRemodel = isRemodel == null ? null : isRemodel.trim();
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
}