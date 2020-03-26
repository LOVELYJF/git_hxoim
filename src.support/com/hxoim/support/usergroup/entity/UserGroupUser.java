package com.hxoim.support.usergroup.entity;

import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.IdAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;

import java.util.Date;

/*
 * @description:用户组用户
 * @author 杨波
 * @date:2019-07-17
 * cf_usergroup_user
 */
@TableAnnotation(TableName = "cf_usergroup_user", TableDescription="")
public class UserGroupUser {



    /**
     *
     */
    @IdAnnotation
    @ColumnAnnotation(FieldName = "id",  FieldDescription="")
    private String id;

    /**
     * 用户组id
     */
    @ColumnAnnotation(FieldName = "ug_id",  FieldDescription="用户组id")
    private String ugId;

    /**
     *
     */
    @ColumnAnnotation(FieldName = "user_id",  FieldDescription="")
    private String userId;

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

    @ColumnAnnotation(FieldName = "name",  FieldDescription="")
    private String name;

    @ColumnAnnotation(FieldName = "ugName",  FieldDescription="")
    private String ugName;

    public UserGroupUser(String id, String ugId, String userId, String modifyUser, Date modifyTime) {
        this.id = id;
        this.ugId = ugId;
        this.userId = userId;
        this.modifyUser = modifyUser;
        this.modifyTime = modifyTime;
    }

    public UserGroupUser() {
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
     * 用户组id
     * @return ug_id 用户组id
     */
    public String getUgId() {
        return ugId;
    }

    /**
     * 用户组id
     * @param ugId 用户组id
     */
    public void setUgId(String ugId) {
        this.ugId = ugId == null ? null : ugId.trim();
    }

    /**
     *
     * @return user_id
     */
    public String getUserId() {
        return userId;
    }

    /**
     *
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUgName() {
        return ugName;
    }

    public void setUgName(String ugName) {
        this.ugName = ugName;
    }
}
