package com.hxoim.support.role.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.IdAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author sunqian
 * @Desc 角色
 * @Date 2019/6/20 20:49
 * cf_role
 */
@TableAnnotation(TableName = "cf_role", TableDescription="")
public class Role {


    /**
     * 角色id
     */
    @IdAnnotation
    @ColumnAnnotation(FieldName = "id",  FieldDescription="角色id")
    private String id;

    /**
     * 角色编码
     */
    @ColumnAnnotation(FieldName = "role_code",  FieldDescription="角色编码")
    private String roleCode;

    /**
     * 角色名称
     */
    @ColumnAnnotation(FieldName = "role_name",  FieldDescription="角色名称")
    private String roleName;

    /**
     * 角色类型
     */
    @ColumnAnnotation(FieldName = "role_type",  FieldDescription="角色类型")
    private String roleType;

    /**
     * 角色描述
     */
    @ColumnAnnotation(FieldName = "role_desc",  FieldDescription="角色描述")
    private String roleDesc;

    /**
     * 角色状态(使用,禁用)
     */
    @ColumnAnnotation(FieldName = "role_state",  FieldDescription="角色状态(使用,禁用)")
    private String roleState;

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

    private String extend;//是否继承自用户组

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }

    public Role(String id, String roleCode, String roleName, String roleType, String roleDesc, String roleState, Integer orderIndex, String orgId, String modifyUser, Date modifyTime) {
        this.id = id;
        this.roleCode = roleCode;
        this.roleName = roleName;
        this.roleType = roleType;
        this.roleDesc = roleDesc;
        this.roleState = roleState;
        this.orderIndex = orderIndex;
        this.orgId = orgId;
        this.modifyUser = modifyUser;
        this.modifyTime = modifyTime;
    }

    public Role() {
        super();
    }

    /**
     * 角色id
     * @return id 角色id
     */
    public String getId() {
        return id;
    }

    /**
     * 角色id
     * @param id 角色id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 角色编码
     * @return role_code 角色编码
     */
    public String getRoleCode() {
        return roleCode;
    }

    /**
     * 角色编码
     * @param roleCode 角色编码
     */
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
    }

    /**
     * 角色名称
     * @return role_name 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 角色名称
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * 角色类型
     * @return role_type 角色类型
     */
    public String getRoleType() {
        return roleType;
    }

    /**
     * 角色类型
     * @param roleType 角色类型
     */
    public void setRoleType(String roleType) {
        this.roleType = roleType == null ? null : roleType.trim();
    }

    /**
     * 角色描述
     * @return role_desc 角色描述
     */
    public String getRoleDesc() {
        return roleDesc;
    }

    /**
     * 角色描述
     * @param roleDesc 角色描述
     */
    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc == null ? null : roleDesc.trim();
    }

    /**
     * 角色状态(使用,禁用)
     * @return role_state 角色状态(使用,禁用)
     */
    public String getRoleState() {
        return roleState;
    }

    /**
     * 角色状态(使用,禁用)
     * @param roleState 角色状态(使用,禁用)
     */
    public void setRoleState(String roleState) {
        this.roleState = roleState == null ? null : roleState.trim();
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