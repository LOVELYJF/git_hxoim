package com.hxoim.support.user.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.IdAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author sunqian
 * @Desc 用户
 * @Date 2019/6/20 20:26
 * cf_user
 */
@TableAnnotation(TableName = "cf_user", TableDescription="")
public class User {
    /**
     * 用户id
     */
    @IdAnnotation
    @ColumnAnnotation(FieldName = " ",  FieldDescription="用户id")
    private String id;

    /**
     * 用户名称
     */
    @ColumnAnnotation(FieldName = "user_name",  FieldDescription="用户名称")
    private String name;

    /**
     * 登录名
     */
    @ColumnAnnotation(FieldName = "user_code",  FieldDescription="登录名")
    private String userName;

    /**
     * 用户类型(管理员.普通用户)
     */
    @ColumnAnnotation(FieldName = "user_type",  FieldDescription="用户类型(管理员.普通用户)")
    private String userType;

    /**
     * 用户状态(使用,禁用)
     */
    @ColumnAnnotation(FieldName = "user_state",  FieldDescription="用户状态(使用,禁用)")
    private String userState;

    /**
     * 用户照片
     */
    @ColumnAnnotation(FieldName = "user_photo",  FieldDescription="用户照片")
    private String userPhoto;

    /**
     * 用户邮箱
     */
    @ColumnAnnotation(FieldName = "user_email",  FieldDescription="用户邮箱")
    private String userEmail;

    /**
     * 用户电话
     */
    @ColumnAnnotation(FieldName = "user_mobile",  FieldDescription="用户电话")
    private String userMobile;

    /**
     * 用户密码
     */
    @ColumnAnnotation(FieldName = "user_Password",  FieldDescription="用户密码")
    private String password;

    /**
     * 排序
     */
    @ColumnAnnotation(FieldName = "order_index",  FieldDescription="排序")
    private Integer orderIndex;

    /**
     * 所属机构id
     */
    @ColumnAnnotation(FieldName = "org_id",  FieldDescription="所属机构id")
    private String orgId;

    /**
     * 所属机构id
     */
    @ColumnAnnotation(FieldName = "org_name",  FieldDescription="所属机构名称")
    private String orgName;

    /**
     * 修改用户
     */
    @ColumnAnnotation(FieldName = "modify_user",  FieldDescription="修改用户")
    private String modifyUser;

    /**
     * 修改时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ColumnAnnotation(FieldName = "modify_time",  FieldDescription="修改时间")
    private Date modifyTime;

    public User(String id, String name, String userName, String userType, String userState, String userPhoto, String userEmail, String userMobile, String password, Integer orderIndex, String orgId, String modifyUser, Date modifyTime) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.userType = userType;
        this.userState = userState;
        this.userPhoto = userPhoto;
        this.userEmail = userEmail;
        this.userMobile = userMobile;
        this.password = password;
        this.orderIndex = orderIndex;
        this.orgId = orgId;
        this.modifyUser = modifyUser;
        this.modifyTime = modifyTime;
    }

    public User() {
        super();
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    /**
     * 用户id
     * @return id 用户id
     */
    public String getId() {
        return id;
    }

    /**
     * 用户id
     * @param id 用户id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 用户名称
     * @return name 用户名称
     */
    public String getName() {
        return name;
    }

    /**
     * 用户名称
     * @param name 用户名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 登录名
     * @return user_name 登录名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 登录名
     * @param userName 登录名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 用户类型(管理员.普通用户)
     * @return user_type 用户类型(管理员.普通用户)
     */
    public String getUserType() {
        return userType;
    }

    /**
     * 用户类型(管理员.普通用户)
     * @param userType 用户类型(管理员.普通用户)
     */
    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    /**
     * 用户状态(使用,禁用)
     * @return user_state 用户状态(使用,禁用)
     */
    public String getUserState() {
        return userState;
    }

    /**
     * 用户状态(使用,禁用)
     * @param userState 用户状态(使用,禁用)
     */
    public void setUserState(String userState) {
        this.userState = userState == null ? null : userState.trim();
    }

    /**
     * 用户照片
     * @return user_photo 用户照片
     */
    public String getUserPhoto() {
        return userPhoto;
    }

    /**
     * 用户照片
     * @param userPhoto 用户照片
     */
    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto == null ? null : userPhoto.trim();
    }

    /**
     * 用户邮箱
     * @return user_email 用户邮箱
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * 用户邮箱
     * @param userEmail 用户邮箱
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    /**
     * 用户电话
     * @return user_mobile 用户电话
     */
    public String getUserMobile() {
        return userMobile;
    }

    /**
     * 用户电话
     * @param userMobile 用户电话
     */
    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile == null ? null : userMobile.trim();
    }

    /**
     * 用户密码
     * @return password 用户密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 用户密码
     * @param password 用户密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
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
     * 所属机构id
     * @return org_id 所属机构id
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     * 所属机构id
     * @param orgId 所属机构id
     */
    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
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