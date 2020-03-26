package com.hxoim.support.role.controller;

import com.github.pagehelper.PageInfo;
import com.hxoim.common.utils.Result;
import com.hxoim.support.role.entity.Role;
import com.hxoim.support.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ author：三凡
 * @ desc：角色管理
 * @ date：2019/5/27
 **/
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * @ author：三凡
     * @ desc：角色状态切换
     * @ date：2019/5/27
     **/
    @RequestMapping("/changeRoleState")
    public Result changeRoleState(Role role) {
        roleService.changeRoleState(role);
        return Result.success();
    }

    /**
     * @ author：三凡
     * @ desc：新增角色
     * @ date：2019/5/27
     **/
    @RequestMapping("/insertRole")
    public Result insertRole(Role role) {
        roleService.insertRole(role);
        return Result.success();
    }


    /**
     * @ author：三凡
     * @ desc：编辑 修改角色 先查询
     * @ date：2019/5/27
     **/
    @RequestMapping("/selectByPrimaryKey")
    public Result selectByPrimaryKey(Role role) {
        return Result.success(roleService.selectByPrimaryKey(role.getId()));
    }

    /**
     * @ author：三凡
     * @ desc：修改角色
     * @ date：2019/5/27
     **/
    @RequestMapping("/updateRole")
    public Result updateRole(Role role) {
        roleService.updateRole(role);
        return Result.success();
    }

    /**
     * @ author：三凡
     * @ desc：删除 角色
     * @ date：2019/5/27
     **/
    @RequestMapping("/deleteRole")
    public Result deleteRole(Role role) {
        roleService.deleteRole(role.getId());
        return Result.success();
    }

    /**
     * @ author：三凡
     * @ desc：角色列表
     * @ date：2019/5/27
     **/
    @RequestMapping("/selectRoleList")
    public Result selectRoleList(Integer pageNum, Integer pageSize, Role role) {
        PageInfo pageInfo = roleService.getroleLists(pageNum, pageSize, role.getRoleCode(), role.getOrgId());
        return Result.success(pageInfo.getList()).setTotal(pageInfo.getTotal());
    }

    /**
     * 初始化权限(admin)
     * 
     * @author sunqian
     * @date 2019/8/20 9:01
     */
    @RequestMapping("/initRole")
    public Result initRole(String loginName){
        roleService.initRole(loginName);
        return Result.success();
    }
}
