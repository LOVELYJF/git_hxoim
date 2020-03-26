package com.hxoim.support.usergroup.entity;

import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;

import java.util.Date;

/**
 * @description：系统用户组中间表实体类
 * @author ：张乾
 * @createDate ： 2019/5/30 10:32
 * cf_system_usergroup
 */
@TableAnnotation(TableName = "cf_system_usergroup", TableDescription="")
public class SystemUserGroup {


    /**
     * 主键
     */
    @ColumnAnnotation(FieldName = "Id",  FieldDescription="主键")
    private String id;

    /**
     * 系统id
     */
    @ColumnAnnotation(FieldName = "sy_id",  FieldDescription="系统id")
    private String syId;

    /**
     * 用户组（处室）id
     */
    @ColumnAnnotation(FieldName = "ug_id",  FieldDescription="用户组（处室）id")
    private String ugId;

    /**
     *
     */
    @ColumnAnnotation(FieldName = "modify_user",  FieldDescription="")
    private String modifyUser;

    /**
     *
     */
    @ColumnAnnotation(FieldName = "modify_time",  FieldDescription="")
    private Date modifyTime;

    //系统名称
    @ColumnAnnotation(FieldName = "modify_time",  FieldDescription="系统名称")
    private String syName;
    //处室名称
    @ColumnAnnotation(FieldName = "modify_time",  FieldDescription="处室名称")
    private String ugName;
    //处室名称
    private String ugNames;

    //管理处室ids
    private String orgIds;
    //管理处室ids集合
    private String[] ugids;

    public String[] getUgids() {
        return ugids;
    }

    public void setUgids(String[] ugids) {
        this.ugids = ugids;
    }

    public String getOrgIds() {
        return orgIds;
    }

    public void setOrgIds(String orgIds) {
        this.orgIds = orgIds;
    }

    public SystemUserGroup(String id, String syId, String ugId, String modifyUser, Date modifyTime) {
        this.id = id;
        this.syId = syId;
        this.ugId = ugId;
        this.modifyUser = modifyUser;
        this.modifyTime = modifyTime;
    }

    public SystemUserGroup() {
        super();
    }

    /**
     * 主键
     * @return Id 主键
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
     * 系统id
     * @return sy_id 系统id
     */
    public String getSyId() {
        return syId;
    }

    /**
     * 系统id
     * @param syId 系统id
     */
    public void setSyId(String syId) {
        this.syId = syId == null ? null : syId.trim();
    }

    /**
     * 用户组（处室）id
     * @return ug_id 用户组（处室）id
     */
    public String getUgId() {
        return ugId;
    }

    /**
     * 用户组（处室）id
     * @param ugId 用户组（处室）id
     */
    public void setUgId(String ugId) {
        this.ugId = ugId == null ? null : ugId.trim();
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
     *
     * @return modify_time
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     *
     * @param modifyTime
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getSyName() {
        return syName;
    }

    public void setSyName(String syName) {
        this.syName = syName;
    }

    public String getUgName() {
        return ugName;
    }

    public void setUgName(String ugName) {
        this.ugName = ugName;
    }

    public String getUgNames() {
        return ugNames;
    }

    public void setUgNames(String ugNames) {
        this.ugNames = ugNames;
    }
}
