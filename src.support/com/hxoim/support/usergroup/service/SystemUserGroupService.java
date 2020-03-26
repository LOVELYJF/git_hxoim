package com.hxoim.support.usergroup.service;

import com.hxoim.common.tree.Tree;
import com.hxoim.support.usergroup.entity.SystemUserGroup;

import java.util.List;

/**
 * description:系统用户组service接口
 * create by: 张乾
 * createDate: 2019/5/30 10:38
 */
public interface SystemUserGroupService {

    /**
     * @ description:设置业务系统管理处室
     * @ create by: 张乾
     * @ createDate: 2019/5/30 13:52
     */
    void insertSystemUserGroup(SystemUserGroup systemUserGroup);

    /**
     * @ description: 查询每个业务系统所拥有的管理处室
     * @ create by: 张乾
     * @ createDate: 2019/5/30 14:21
     */
    List<SystemUserGroup> selectSystemUserGroup();

    /**
     * @description:根据系统ID删除选择系统的所有管理处室
     * @author:杨波
     * @date:2019-07-21
     *  * @param SystemUserGroup systemUserGroup
     * @return:
     **/
    void deleteSystemUserGroup(SystemUserGroup systemUserGroup);

    /**
     * @description:根据ID删除系统设置的管理处室
     * @author:杨波
     * @date:2019-07-21
     *  * @param SystemUserGroup systemUserGroup
     * @return:
     **/
    void deleteSystemUserGroupById(SystemUserGroup systemUserGroup);

    /**
     * @ description:  查询该业务系统拥有的管理处室
     * @ create by: 张乾
     * @ createDate: 2019/5/30 19:05
     */
    List<SystemUserGroup> selectUserGroupBySyId(
            SystemUserGroup systemUserGroup);

}
