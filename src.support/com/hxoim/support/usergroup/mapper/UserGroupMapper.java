package com.hxoim.support.usergroup.mapper;

import com.hxoim.common.tree.Tree;
import com.hxoim.support.usergroup.entity.UserGroup;
import com.hxoim.support.usergroup.entity.UserGroupUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * description: 用户组mapper接口
 * create by: 张乾
 * createDate: 2019/5/30 10:22
 */

public interface UserGroupMapper {

    /**
     * @ description:  通过管理处室id查询名称
     * @ create by: 张乾
     * @ createDate: 2019/5/30 15:31
     */
    String selectUserGroupNameByUgId(@Param(value = "ugIds") String ugIds);

    /**
     * @ description: 查询管理处室树
     * @ create by: 张乾
     * @ createDate: 2019/6/4 15:13
     */
    List<Tree> selectUserGroupTree(String id);

    int deleteByPrimaryKey(String id);

    int insert(UserGroup record);

    int insertSelective(UserGroup record);

    /**
    * @description:通过用户组ID查找用户组
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

    int updateByPrimaryKeySelective(UserGroup record);

    int updateByPrimaryKey(UserGroup record);

    /**
     * 删除用户组角色关系
     *
     * @author sunqian
     * @date 2019/7/1 16:06
     */
    void deleteUserGroupRoles(String id);

    /**
     * 删除用户组用户关系
     *
     * @author sunqian
     * @date 2019/7/1 16:06
     */
    void deleteUserGroupUser(String id);

    /**
     * 获取用户组合用户关系树
     *
     * @author sunqian
     * @date 2019/7/1 16:14
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
     * 删除已分配用户组
     *
     * @author sunqian
     * @date 2019/7/1 16:09
     */
    void deleteAssignUserGroup(String userId);

    /**
     * 分配用户组
     *
     * @author sunqian
     * @date 2019/7/1 16:09
     */
    void insertUgAndUser(Map map);

    /**
     * 用户授权
     *
     * @author sunqian
     * @date 2019/7/4 9:38
     */
    void assignRolesForUser(@Param("userId") String id, @Param("list") List<String> list);

    /**
     * 用户组授权
     *
     * @author sunqian
     * @date 2019/7/4 9:38
     */
    void assignRolesForUserGroup(@Param("ugId") String id, @Param("list") List<String> list);

    void deleteAssignUserRoles(String id);

    void deleteAssignUserGroupRoles(String id);

    /**
     * 根据用户查询处室
     * @param userId
     * @return
     */
    UserGroupUser selectUserGroupUser(String userId);
}
