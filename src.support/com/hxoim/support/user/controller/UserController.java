package com.hxoim.support.user.controller;

import com.github.pagehelper.PageInfo;
import com.hxoim.common.utils.Result;
import com.hxoim.support.user.entity.User;
import com.hxoim.support.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ author：三凡
 * @ desc：用户管理
 * @ date：2019/5/27
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @ author：三凡
     * @ desc：重置密码
     * @ date：2019/5/27
     **/
    @RequestMapping("/resetPassword")
    public Result resetPassword(@RequestParam String userId) {
        userService.resetPassword(userId);
        return Result.success();
    }

    /**
     * @ author：孙登
     * @ desc：查询密码
     * @ date：2019/8/1
     **/
    @RequestMapping("/selectPassword")
    public Result selectPassword(@RequestParam String userId) {
        String password = userService.selectPassword(userId);
        return Result.success(password);
    }

    /**
     * @ author：孙登
     * @ desc：修改密码
     * @ date：2019/8/1
     **/
    @RequestMapping("/updatePassword")
    public Result updatePassword(String userId, String newPassword) {
        userService.updatePassword(userId, newPassword);
        return Result.success();
    }

    /**
     * @ author：三凡
     * @ desc：新增or修改 user
     * @ date：2019/5/27
     **/
    @RequestMapping("/InsertOrUpdateSysUser")
    public Result InserOrUpdateSysUser(User user) {
        userService.InserOrUpdateSysUser(user);
        return Result.success();
    }


    /**
     * @ author：三凡
     * @ desc：根据userId查询  去用户修改页面
     * @ date：2019/5/27
     **/
    @RequestMapping("/selectSysUserByUserId")
    public Result selectSysUserByUserId(@RequestParam String userId) {
        User user = userService.selectByPrimaryKey(userId);
        return Result.success(user);
    }


    /**
     * @ author：三凡
     * @ desc：根据userId 删除 用户
     * @ date：2019/5/27
     **/
    @RequestMapping("/deleteSysUser")
    public Result deleteSysUser(@RequestParam String userId) {
        userService.deleteByPrimaryKey(userId);
        return Result.success();
    }


    /**
     * @ author：三凡
     * @ desc：校验orgCode
     * @ date：2019/5/27
     **/
    @RequestMapping("/checkUserCode")
    public Result checkUserCode(@RequestParam String userName) {
        userService.selectByUserCode(userName);
        return Result.success();
    }


    /**
     * @ author：三凡
     * @ desc：根据userCode 修改状态
     * @ date：2019/5/27
     **/
    @RequestMapping("/updateUserStateByUserCode")
    public Result updateUserStateByUserCode(User user) {
        userService.updateUserStateByUserCode(user);
        return Result.success();
    }

    /**
     * @ author：三凡
     * @ desc：用户查询列表
     * @ date：2019/5/27
     **/
    @RequestMapping("/getSysUserList")
    public Result getSysUserList(Integer pageNum, Integer pageSize, String keyWord, String orgId) {
        PageInfo pageInfo = userService.getSysUserList(pageNum, pageSize, keyWord, orgId);
        return Result.success(pageInfo.getList()).setTotal(pageInfo.getTotal());
    }

    /**
     * @desc: 通过处室id查询用户
     * @author: lijing
     * @date: 2019/7/24
     */
    @RequestMapping("/selectUserByUserGroupId")
    public Result selectUserByUserGroupId(String userGroupId) {
        return Result.success(userService.selectUserByUserGroupId(userGroupId));
    }

    /**
     * 获取所有的使用中的管理员账号
     * 
     * @author sunqian
     * @date 2019/9/3 15:08
     */
    @RequestMapping("/selectSysUserList")
    public Result selectSysUserList() {
        List<User> list = userService.selectSysUserList();
        return Result.success(list);
    }
}
