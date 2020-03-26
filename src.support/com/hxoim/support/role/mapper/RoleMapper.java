package com.hxoim.support.role.mapper;

import com.hxoim.support.role.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RoleMapper {
    void deleteByPrimaryKey(String roleId);

    void insert(Role record);

    void insertSelective(Role record);

    Role selectByPrimaryKey(String roleId);

    void updateByPrimaryKeySelective(Role record);

    void updateByPrimaryKey(Role record);

    void selectByRoleCode(String roleCode);

    int findMaxOrderno();

    void changeRoleState(Role role);

    List<Role> selectRoleList(@Param("roleName") String roleName, @Param("orgId") String orgId);

    /**
     * 根据用户组id和机构id查询已授权的角色列表
     *
     * @author sunqian
     * @date 2019/7/2 16:23
     */
    List<Role> selectUserGroupAssignRoles(String id);

    /**
     * 根据用户id和机构id查询已授权的角色列表
     *
     * @author sunqian
     * @date 2019/7/2 18:31
     */
    List<Role> selectUserAssignRoles(String id);

    /**
     * 执行增删改sql
     *
     * @author sunqian
     * @date 2019/8/20 9:04
     */
    void executeCUDSql(String sql);

    /**
     * 执行查询sql
     *
     * @author sunqian
     * @date 2019/8/20 9:04
     */
    List<Map<String, Object>> executeSelectSql(String sql);
}