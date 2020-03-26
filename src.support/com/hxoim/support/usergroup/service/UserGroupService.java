package com.hxoim.support.usergroup.service;

import com.hxoim.common.tree.Tree;
import com.hxoim.support.role.entity.Role;
import com.hxoim.support.usergroup.entity.UserGroup;
import com.hxoim.support.usergroup.entity.UserGroupUser;

import java.util.List;
import java.util.Map;

/**
 * description: 用户组service接口
 * create by: 张乾
 * createDate: 2019/5/30 10:23
 */
public interface UserGroupService {

    /**
     * @ description: 查询管理处室树
     * @ create by: 张乾
     * @ createDate: 2019/6/4 15:06
     */
    List<Tree> selectUserGroupTree(String id);

    /**
     * 新增用户组
     *
     * @author sunqian
     * @date 2019/7/1 15:05
     */
    void insertUserGroup(UserGroup userGroup);

    /**
     * 修改用户组
     *
     * @author sunqian
     * @date 2019/7/1 15:25
     */
    void updateUserGroup(UserGroup userGroup);

    /**
     * 删除用户组
     *
     * @author sunqian
     * @date 2019/7/1 16:01
     */
    void deleteUserGroup(String id);

    /**
     * 获取用户组合用户关系树
     *
     * @author sunqian
     * @date 2019/7/1 16:09
     */
    List<Tree> selectUserGroupUserTree(String orgId);

    /**
     * 获取用户组
     *
     * @author sunqian
     * @date 2019/7/1 16:09
     */
    List<UserGroup> selectUserGroupList(String orgId);

    /**
     * 用户分配用户组
     *
     * @author sunqian
     * @date 2019/7/1 16:09
     */
    void assignUgIdForUser(String ugId, String userId);

    /**
     * 获取所有的角色和已分配的角色(type:user--表示用户;usergroup--表示用户组)
     *
     * @author sunqian
     * @date 2019/7/2 14:22
     */
    Map<String, Object> selectRoleWithUserGroupAndUser(String type, String id, String orgId);

    /**
     * 获取已分配的角色(type:user--表示用户;usergroup--表示用户组)
     *
     * @author sunqian
     * @date 2019/7/2 15:34
     */
    List<Role> selectAssignRole(String type, String id);

    /**
     * 为用户组或用户分配角色
     *
     * @author sunqian
     * @date 2019/7/4 9:38
     */
    void assignRolesForUserOrUserGroup(String type, String id, List<String> roleIds);

    /**
    * @description:通过ID获取用户组
    * @author:杨波
    * @date:2019-07-17
    *  * @param String id
    * @return:
    **/
    UserGroup selectByPrimaryKey(String id);
    /**
     * @description:通过用户组ID，查找它的所有用户
     * @author:杨波
     * @date:2019-07-17
     *  * @param String ugid
     * @return:
     **/
    List<UserGroupUser> selectUserGroupUsers(String ugid);

    /**
     * 根据用户查询处室
     * @param userId
     * @return
     */
    UserGroupUser selectUserGroupUserByUserId(String userId);
}
