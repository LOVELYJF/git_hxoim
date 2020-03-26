package com.hxoim.support.usergroup.controller;

import com.hxoim.common.tree.Tree;
import com.hxoim.common.utils.RequestList;
import com.hxoim.common.utils.Result;
import com.hxoim.support.role.entity.Role;
import com.hxoim.support.usergroup.entity.UserGroup;
import com.hxoim.support.usergroup.service.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 用户组管理
 *
 * @author sunqian
 * @date 2019/7/1 15:02
 */
@RestController
@RequestMapping("/userGroup")
public class UserGroupController {

    @Autowired
    private UserGroupService userGroupService;

    /**
     * 新增用户组
     *
     * @author sunqian
     * @date 2019/7/1 15:03
     */
    @RequestMapping("/insertUserGroup")
    public Result insertUserGroup(UserGroup userGroup) {
        userGroupService.insertUserGroup(userGroup);
        return Result.success();
    }

    /**
     * 删除用户组
     *
     * @author sunqian
     * @date 2019/7/1 15:03
     */
    @RequestMapping("/deleteUserGroup")
    public Result deleteUserGroup(UserGroup userGroup) {
        userGroupService.deleteUserGroup(userGroup.getId());
        return Result.success();
    }

    /**
     * 修改用户组
     *
     * @author sunqian
     * @date 2019/7/1 15:24
     */
    @RequestMapping("/updateUserGroup")
    public Result updateUserGroup(UserGroup userGroup) {
        userGroupService.updateUserGroup(userGroup);
        return Result.success();
    }

    /**
     * 获取用户组和用户关系树
     *
     * @author sunqian
     * @date 2019/7/1 16:09
     */
    @RequestMapping("/selectUserGroupUserTree")
    public Result selectUserGroupUserTree(String orgId) {
        List<Tree> list = userGroupService.selectUserGroupUserTree(orgId);
        return Result.success(list);
    }

    /**
     * 获取用户组
     *
     * @author sunqian
     * @date 2019/7/1 16:09
     */
    @RequestMapping("/selectUserGroupList")
    public Result selectUserGroupList(String orgId) {
        List<UserGroup> list = userGroupService.selectUserGroupList(orgId);
        return Result.success(list);
    }

    /**
     * @description:返回指定机构的用户组（处室）树
     * @author:杨波
     * @date:2019-07-20 * @param id
     * @return:java.util.List<com.hxoim.common.tree.Tree>
     **/
    @RequestMapping("/selectUserGroupTree")
    public Result selectUserGroupTree(String id) {

        List<Tree> result = userGroupService.selectUserGroupTree(id);
        return Result.success(result);
    }

    /**
     * 用户分配用户组
     *
     * @author sunqian
     * @date 2019/7/1 16:09
     */
    @RequestMapping("/assignUgIdForUser")
    public Result assignUgIdForUser(String ugId, String userId) {
        userGroupService.assignUgIdForUser(ugId, userId);
        return Result.success();
    }

    /**
     * 获取用户和用户组的角色
     *
     * @author sunqian
     * @date 2019/7/2 11:31
     */
    @RequestMapping("/selectRoleWithUserGroupAndUser")
    public Result selectRoleWithUserGroupAndUser(String type, String id, String orgId) {
        Map<String, Object> map = userGroupService.selectRoleWithUserGroupAndUser(type, id, orgId);
        return Result.success(map);
    }

    /**
     * 为用户组或用户分配角色根据type判断
     *
     * @author sunqian
     * @date 2019/7/4 9:31
     */
    @RequestMapping("/assignRolesForUserOrUserGroup")
    public Result assignRolesForUserOrUserGroup(String type, String id, RequestList<String> requestList) {
        userGroupService.assignRolesForUserOrUserGroup(type, id, requestList.getList(String.class));
        return Result.success();
    }

    /**
     * 根据类型获取角色
     *
     * @author sunqian
     * @date 2019/7/4 11:22
     */
    @RequestMapping("/selectUserOrUserGroupAssignRoles")
    public Result selectUserOrUserGroupAssignRoles(String type, String id) {
        List<Role> list = userGroupService.selectAssignRole(type, id);
        return Result.success(list);
    }
}
