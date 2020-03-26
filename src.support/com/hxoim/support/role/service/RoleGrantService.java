package com.hxoim.support.role.service;

import com.hxoim.common.tree.Tree;
import com.hxoim.support.role.entity.RoleGrant;

import java.util.List;
import java.util.Map;

/**
 * @Author sunqian
 * @Desc 角色授权
 * @Date 2019/6/24 16:41
 */
public interface RoleGrantService {

    /**
     * 获取模块授权树
     *
     * @param roleId 角色id
     * @Author sunqian
     * @Date 2019/6/24 16:47
     */
    RoleGrant selectGrantModule(String roleId);

    /**
     * 获取单点登录系统
     *
     * @author sunqian
     * @date 2019/6/25 16:45
     */
    RoleGrant selectGrantSystem(String roleId);

    /**
     * 保存模块授权
     *
     * @return void
     * @author sunqian
     * @date 2019/6/27 9:45
     */
    void insertGrantModule(RoleGrant roleGrant);

    /**
     * 保存系统授权
     *
     * @return void
     * @author sunqian
     * @date 2019/6/27 9:45
     */
    void insertGrantSystem(RoleGrant roleGrant);

    /**
     * 保存干部类别权限
     *
     * @return void
     * @author sunqian
     * @date 2019/6/27 9:45
     */
    void insertGrantLeaderTypeInfo(RoleGrant roleGrant);

    /**
     * 保存机构权限
     *
     * @return void
     * @author sunqian
     * @date 2019/6/27 9:45
     */
    void insertGrantOrg(RoleGrant roleGrant);

    /**
     * 保存信息集权限
     *
     * @author sundeng
     * @date 2019/8/8
     */
    void insertGrantLeaderInfo(RoleGrant roleGrant);

    /**
     * 保存信息项权限
     *
     * @author sundeng
     * @date 2019/8/8
     */
    void insertGrantInfo(RoleGrant roleGrant);

    /**
     * 获得干部类别信息权限
     *
     * @author sunqian
     * @date 2019/6/27 11:05
     */
    RoleGrant selectGrantLeaderType(String roleId, String leaderTypeId);

    /**
     * 获取干部类别
     *
     * @author sunqian
     * @date 2019/6/28 9:48
     */
    List<Tree> selectLeaderType();

    /**
     * 获取机构授权
     *
     * @author sunqian
     * @date 2019/6/28 13:55
     */
    RoleGrant selectGrantOrg(String id);

    /**
     * 拷贝角色权限
     *
     * @author sunqian
     * @date 2019/6/28 15:55
     */
    void copyRoleGrantForOtherRole(String srcRoleId, List<String> list);

    /**
     * 获取人员信息集权限
     *
     * @author sundeng
     * @date 2019/8/8
     */
    List<Map<String,Object>> selectGrantdataInfo(String id);

    /**
     * 获取信息列表
     *
     * @author sundeng
     * @date 2019/8/8
     */
    List<Map<String,Object>> selectGrantListInfo();

    /**
     * 获取信息项
     *
     * @author sundeng
     * @date 2019/8/8
     */
    List<Map<String,Object>> selectGrantInfo(String id,String tablecode);
}
