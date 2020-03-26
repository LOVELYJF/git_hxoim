package com.hxoim.support.b01.mapper;

import com.hxoim.common.tree.Tree;
import com.hxoim.support.b01.entity.OrgGrant;
import com.hxoim.support.role.entity.RoleGrant;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrgGrantMapper {
    /**
     * 获取已授权的所有模块id
     *
     * @param roleId 角色id
     * @return java.util.List<com.hxoim.common.tree.Tree>
     * @author sunqian
     * @date 2019/6/24 17:42
     */
    List<String> selectGrantModuleId(String roleId);

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
    List<String> selectGrantSysInfo(String orgId);

    /**
     * 模块授权
     *
     * @return void
     * @author sunqian
     * @date 2019/6/27 9:49
     */
    void insertGrantModule(List<OrgGrant> list);

    /**
     * 系统授权
     *
     * @return void
     * @author sunqian
     * @date 2019/6/27 9:49
     */
    void insertGrantSystem(List<OrgGrant> list);

    /**
     * 保存干部类别和信息集
     *
     * @author sunqian
     * @date 2019/6/27 10:23
     */
    void insertGrantLeaderTypeInfo(List<OrgGrant> list);

    /**
     * 保存机构权限
     *
     * @return void
     * @author sunqian
     * @date 2019/6/27 10:45
     */
    void insertGrantOrg(List<OrgGrant> list);

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
    List<String> selectGrantOrg(String orgId);

    /**
     * 拷贝模块权限
     *
     * @author sunqian
     * @date 2019/6/29 10:46
     */
    void copyGrantModule(@Param("srcOrgId") String srcOrgId, @Param("tarOrgId") String tarOrgId);

    /**
     * 拷贝机构权限
     *
     * @author sunqian
     * @date 2019/6/29 10:46
     */
    void copyGrantOrg(@Param("srcOrgId") String srcOrgId, @Param("tarOrgId") String tarOrgId);

    /**
     * 拷贝干部类别权限
     *
     * @author sunqian
     * @date 2019/6/29 10:46
     */
    void copyGrantLeaderType(@Param("srcOrgId") String srcOrgId, @Param("tarOrgId") String tarOrgId);

    /**
     * 拷贝单点登录系统权限
     *
     * @author sunqian
     * @date 2019/6/29 10:46
     */
    void copyGrantSystem(@Param("srcOrgId") String srcOrgId, @Param("tarOrgId") String tarOrgId);

    /**
     * 获取该机构下的干部类别和信息集权限
     *
     * @author sunqian
     * @date 2019/8/21 11:19
     */
    List<Tree> selectOrgGrantLeaderType(@Param("orgId") String orgId, @Param("leaderTypeId")String leaderTypeId);
}