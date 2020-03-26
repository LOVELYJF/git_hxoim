package com.hxoim.support.system.entity;

public class UserSystem {
    //中间表ID
    private String id;
    //用户ID
    private String userId;
    //映射名称
    private String mappingUsername;
    //映射密码
    private String mappingPassword;
    //系统表ID
    private String syId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMappingUsername() {
        return mappingUsername;
    }

    public void setMappingUsername(String mappingUsername) {
        this.mappingUsername = mappingUsername;
    }

    public String getMappingPassword() {
        return mappingPassword;
    }

    public void setMappingPassword(String mappingPassword) {
        this.mappingPassword = mappingPassword;
    }

    public String getSyId() {
        return syId;
    }

    public void setSyId(String syId) {
        this.syId = syId;
    }
}