package com.hxoim.support.role.mapper;

import com.hxoim.common.tree.Tree;
import com.hxoim.support.role.entity.RoleGrant;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author sunqian
 * @Desc 角色授权
 * @Date 2019/6/24 16:32
 */
public interface RoleGrantMapper {

    /**
     * 获取已授权的所有模块id
     *
     * @author sunqian
     * @date 2019/6/24 17:42
     */
    List<String> selectGrantModuleId(String orgId);

    /**
     * 删除已授权
     *
     * @param id      角色id
     * @param tabName 表名
     * @author sunqian
     * @date 2019/6/25 9:41
     */
    void deleteGrantByTabName(@Param("id") String id, @Param("tabName") String tabName);

    /**
     * 获取已授权的id
     *
     * @return java.util.List<java.lang.String>
     * @author sunqian
     * @date 2019/6/25 17:50
     */
    List<String> selectGrantSysInfo(String roleId);

    /**
     * 模块授权
     *
     * @return void
     * @author sunqian
     * @date 2019/6/27 9:49
     */
    void insertGrantModule(List<RoleGrant> list);

    /**
     * 模块授权
     *
     * @return void
     * @author sunqian
     * @date 2019/6/27 9:49
     */
    void insertGrantSystem(List<RoleGrant> list);

    /**
     * 保存干部类别和信息集
     *
     * @author sunqian
     * @date 2019/6/27 10:23
     */
    void insertGrantLeaderTypeInfo(List<RoleGrant> list);

    /**
     * 保存机构权限
     *
     * @return void
     * @author sunqian
     * @date 2019/6/27 10:45
     */
    void insertGrantOrg(List<RoleGrant> list);

    /**
     * 保存干部信息集权限
     *
     * @return void
     * @author sundeng
     * @date 2019/8/8
     */
    void insertGrantLeaderInfo(List<RoleGrant> list);

    /**
     * 保存信息项权限
     *
     * @return void
     * @author sundeng
     * @date 2019/8/8
     */
    void insertGrantInfo(List<RoleGrant> list);

    /**
     * 授权的信息集
     *
     * @author sunqian
     * @date 2019/6/27 17:24
     */
    List<String> selectGrantLeaderTypeInfo(@Param("roleId") String roleId, @Param("leaderTypeId") String leaderTypeId);

    /**
     * 获取干部类别
     *
     * @author sunqian
     * @date 2019/6/28 11:02
     */
    List<Tree> selectLeaderType(String dictCode);

    /**
     * 获取授权的机构id
     *
     * @author sunqian
     * @date 2019/6/28 14:01
     */
    List<String> selectGrantOrg(String roleId);

    /**
     * 拷贝模块权限
     *
     * @author sunqian
     * @date 2019/6/29 10:46
     */
    void copyGrantModule(@Param("srcRoleId") String srcRoleId, @Param("targetRoleId") String targetRoleId);

    /**
     * 拷贝机构权限
     *
     * @author sunqian
     * @date 2019/6/29 10:46
     */
    void copyGrantOrg(@Param("srcRoleId") String srcRoleId, @Param("targetRoleId") String targetRoleId);

    /**
     * 拷贝干部类别权限
     *
     * @author sunqian
     * @date 2019/6/29 10:46
     */
    void copyGrantLeaderType(@Param("srcRoleId") String srcRoleId, @Param("targetRoleId") String targetRoleId);

    /**
     * 拷贝单点登录系统权限
     *
     * @author sunqian
     * @date 2019/6/29 10:46
     */
    void copyGrantSystem(@Param("srcRoleId") String srcRoleId, @Param("targetRoleId") String targetRoleId);

    /**
     * 获取人员信息集权限
     *
     * @author sundeng
     * @date 2019/8/8
     */
    List<Map<String,Object>> selectGrantdataInfo(@Param("roleId") String roleId,@Param("orgId") String orgId);

    /**
     * 获取信息列表权限
     *
     * @author sundeng
     * @date 2019/8/8
     */
    List<Map<String,Object>> selectGrantListInfo(String orgId);

    /**
     * 获取信息项权限
     *
     * @author sundeng
     * @date 2019/8/8
     */
    List<Map<String,Object>> selectGrantInfo(@Param("id") String id,@Param("tablecode") String tablecode);

    /**
     * 根据机构id获取角色id
     *
     * @author sundeng
     * @date 2019/8/8
     */
    String selectRoleId(String orgId);
}
