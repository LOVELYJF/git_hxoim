package com.hxoim.support.role.controller;

import com.hxoim.common.tree.Tree;
import com.hxoim.common.utils.Result;
import com.hxoim.support.role.entity.Role;
import com.hxoim.support.role.entity.RoleGrant;
import com.hxoim.support.role.service.RoleGrantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author sunqian
 * 角色授权
 * @date 2019/6/24 16:40
 */
@RestController
@RequestMapping("/roleGrant")
public class RoleGrantController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setAutoGrowCollectionLimit(Integer.MAX_VALUE);
    }

    @Autowired
    private RoleGrantService roleGrantService;

    /**
     * 获取模块授权树
     *
     * @author sunqian
     * @date 2019/6/24 16:47
     */
    @RequestMapping("/selectGrantModule")
    public Result selectGrantModule(Role role) {
        RoleGrant roleGrant = roleGrantService.selectGrantModule(role.getId());
        return Result.success(roleGrant);
    }

    /**
     * 获取单点登录系统
     *
     * @author sunqian
     * @date 2019/6/25 16:45
     */
    @RequestMapping("/selectGrantSystem")
    public Result selectGrantSystem(Role role) {
        RoleGrant roleGrant = roleGrantService.selectGrantSystem(role.getId());
        return Result.success(roleGrant);
    }

    /**
     * 获取干部类别
     *
     * @author sunqian
     * @date 2019/6/28 9:47
     */
    @RequestMapping("/selectLeaderType")
    public Result selectLeaderType() {
        List<Tree> list = roleGrantService.selectLeaderType();
        return Result.success(list);
    }

    /**
     * 获取干部类别信息集权限
     *
     * @author sunqian
     * @date 2019/6/27 10:52
     */
    @RequestMapping("/selectGrantLeaderType")
    public Result selectGrantLeaderType(Role role, String leaderTypeId) {
        RoleGrant roleGrant = roleGrantService.selectGrantLeaderType(role.getId(), leaderTypeId);
        return Result.success(roleGrant);
    }

    /**
     * 获取机构权限
     *
     * @author sunqian
     * @date 2019/6/28 13:54
     */
    @RequestMapping("/selectGrantOrg")
    public Result selectGrantOrg(Role role) {
        RoleGrant roleGrant = roleGrantService.selectGrantOrg(role.getId());
        return Result.success(roleGrant);
    }

    /**
     * 获取人员信息集权限
     *
     * @author sundeng
     * @date 2019/8/8
     */
    @RequestMapping("/selectGrantdataInfo")
    public Result selectGrantdataInfo(Role role) {
        List<Map<String,Object>> list = roleGrantService.selectGrantdataInfo(role.getId());
        return Result.success(list);
    }

    /**
     * 获取信息列表
     *
     * @author sundeng
     * @date 2019/8/8
     */
    @RequestMapping("/selectGrantListInfo")
    public Result selectGrantListInfo() {
        List<Map<String,Object>> list = roleGrantService.selectGrantListInfo();
        return Result.success(list);
    }

    /**
     * 获取信息项权限
     *
     * @author sundeng
     * @date 2019/8/8
     */
    @RequestMapping("/selectGrantInfo")
    public Result selectGrantInfo(Role role,String tablecode) {
        List<Map<String,Object>> list = roleGrantService.selectGrantInfo(role.getId(),tablecode);
        return Result.success(list);
    }

    /**
     * 保存选中的模块
     *
     * @author sunqian
     * @date 2019/6/25 9:31
     */
    @RequestMapping("/insertGrantModule")
    public Result insertGrantModule(RoleGrant roleGrant) {
        roleGrantService.insertGrantModule(roleGrant);
        return Result.success();
    }

    /**
     * 保存选中的机构
     *
     * @author sunqian
     * @date 2019/6/25 9:31
     */
    @RequestMapping("/insertGrantOrg")
    public Result insertGrantOrg(RoleGrant roleGrant) {
        roleGrantService.insertGrantOrg(roleGrant);
        return Result.success();
    }

    /**
     * 保存选中的干部类别
     *
     * @author sunqian
     * @date 2019/6/25 9:31
     */
    @RequestMapping("/insertGrantLeaderType")
    public Result insertGrantLeaderType(RoleGrant roleGrant) {
        roleGrantService.insertGrantLeaderTypeInfo(roleGrant);
        return Result.success();
    }

    /**
     * 保存选中的单点登录系统
     *
     * @author sunqian
     * @date 2019/6/25 9:31
     */
    @RequestMapping("/insertGrantSystem")
    public Result insertGrantSystem(RoleGrant roleGrant) {
        roleGrantService.insertGrantSystem(roleGrant);
        return Result.success();
    }

    /**
     * 保存选中的信息集
     *
     * @author sundeng
     * @date 2019/8/8
     */
    @RequestMapping("/insertGrantLeaderInfo")
    public Result insertGrantLeaderInfo(@RequestBody RoleGrant roleGrant) {
        roleGrantService.insertGrantLeaderInfo(roleGrant);
        return Result.success();
    }

    /**
     * 保存选中的信息项
     *
     * @author sundeng
     * @date 2019/8/8
     */
    @RequestMapping("/insertGrantInfo")
    public Result insertGrantInfo(@RequestBody RoleGrant roleGrant) {
        roleGrantService.insertGrantInfo(roleGrant);
        return Result.success();
    }

    /**
     * 拷贝角色权限
     *
     * @author sunqian
     * @date 2019/6/28 16:07
     */
    @RequestMapping("/copyRoleGrantForOtherRole")
    public Result copyRoleGrantForOtherRole(String srcRoleId, RoleGrant roleGrant) {
        roleGrantService.copyRoleGrantForOtherRole(srcRoleId, roleGrant.getCheckList());
        return Result.success();
    }
}