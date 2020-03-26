package com.hxoim.support.b01.service;

import com.hxoim.common.tree.Tree;
import com.hxoim.support.b01.entity.OrgGrant;

import java.util.List;

/**
 * @Author sunqian
 * @Desc 机构授权
 * @Date 2019/6/24 11:12
 */
public interface OrgGrantService {

    /**
     * 获取模块授权树
     *
     * @Author sunqian
     * @Date 2019/6/24 16:47
     */
    OrgGrant selectGrantModule(String orgId);

    /**
     * 获取单点登录系统
     *
     * @author sunqian
     * @date 2019/6/25 16:45
     */
    OrgGrant selectGrantSystem(String orgId);

    /**
     * 保存模块授权
     *
     * @param orgGrant
     * @return void
     * @author sunqian
     * @date 2019/6/27 9:45
     */
    void insertGrantModule(OrgGrant orgGrant);

    /**
     * 保存系统授权
     *
     * @return void
     * @author sunqian
     * @date 2019/6/27 9:45
     */
    void insertGrantSystem(OrgGrant orgGrant);

    /**
     * 保存干部类别权限
     *
     * @return void
     * @author sunqian
     * @date 2019/6/27 9:45
     */
    void insertGrantLeaderTypeInfo(OrgGrant orgGrant);

    /**
     * 保存机构权限
     *
     * @return void
     * @author sunqian
     * @date 2019/6/27 9:45
     */
    void insertGrantOrg(OrgGrant orgGrant);

    /**
     * 获得干部类别信息权限
     *
     * @author sunqian
     * @date 2019/6/27 11:05
     */
    OrgGrant selectGrantLeaderType(String orgId, String leaderTypeId);

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
    OrgGrant selectGrantOrg(String orgId);

    void copyOrgGrantForOtherOrg(String srcRoleId, List<String> list);

}
