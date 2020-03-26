package com.hxoim.support.usergroup.mapper;

import com.hxoim.support.usergroup.entity.SystemUserGroup;

import java.util.List;

/**
 * description:系统用户组（处室）mapper接口
 * create by: 张乾
 * createDate: 2019/5/30 10:37
 */
public interface SystemUserGroupMapper {

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

    void insertSystemUserGroup(SystemUserGroup systemUserGroup);

    /**
     * @ description: 查询每个业务系统所拥有的管理处室
     * @ create by: 张乾
     * @ createDate: 2019/5/30 14:21
     */
    List<SystemUserGroup> selectSystemUserGroup();

    /**
     * @ description:  查询该业务系统拥有的管理处室
     * @ create by: 张乾
     * @ createDate: 2019/5/30 19:05
     */
    List<SystemUserGroup> selectUserGroupBySyId(SystemUserGroup systemUserGroup);

}
