package com.hxoim.support.role.service;

import com.github.pagehelper.PageInfo;
import com.hxoim.support.role.entity.Role;

public interface RoleService {

    void selectByUserCode(String roleCode);

    /**
     * @author：三凡
     * @desc：新增角色
     * @date：2019/5/27
     **/
    void insertRole(Role role);

    /**
     * @author：三凡
     * @desc：角色状态切换
     * @date：2019/5/27
     **/
    void changeRoleState(Role role);

    /**
     * 编辑 修改角色 先查询
     */
    Role selectByPrimaryKey(String roleId);

    /**
     * 编辑 修改角色
     *
     * @param role
     */
    void updateRole(Role role);

    /**
     * 删除 角色
     *
     * @param roleId
     */
    void deleteRole(String roleId);

    PageInfo getroleLists(Integer pageNum, Integer pageSize, String roleName, String orgId);

    /**
     * 初始化所有权限
     * 
     * @author sunqian
     * @date 2019/8/20 8:16
     */
    void initRole(String loginName);
}
