package com.hxoim.support.usergroup.controller;

import com.hxoim.common.tree.Tree;
import com.hxoim.common.utils.Result;
import com.hxoim.support.usergroup.entity.SystemUserGroup;
import com.hxoim.support.usergroup.service.SystemUserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description：系统用户组（处室）Controller
 * @author ：张乾
 * @createDate ： 2019/5/30 10:34
 */
@RestController
@RequestMapping("/systemUserGroup")
public class SystemUserGroupController {

    @Autowired
    private SystemUserGroupService systemUserGroupService;

    /**
     * @ description: 设置业务系统管理处室
     * @ create by: 张乾
     * @ createDate: 2019/5/30 13:52
     */
    @RequestMapping("/insertSystemUserGroup")
    public Result insertSystemUserGroup(SystemUserGroup systemUserGroup){
        systemUserGroupService.insertSystemUserGroup(systemUserGroup);
        return Result.success();
    }

    /**
     * @ description: 查询每个业务系统所拥有的管理处室
     * @ create by: 张乾
     * @ createDate: 2019/5/30 14:21
     */
    @RequestMapping("/selectSystemUserGroup")
    public Result selectSystemUserGroup(){
        List<SystemUserGroup> systemUserGroupList=systemUserGroupService.selectSystemUserGroup();
        return Result.success(systemUserGroupList);
    }

    /**
     * @ description: 删除该业务系统的管理处室
     * @ create by: 张乾
     * @ createDate: 2019/5/30 16:53
     */
    @RequestMapping("/deleteSystemUserGroup")
    public Result deleteSystemUserGroup(SystemUserGroup systemUserGroup){
        systemUserGroupService.deleteSystemUserGroup(systemUserGroup);
        return Result.success();
    }
    /**
     * @description:根据ID删除系统设置的管理处室
     * @author:杨波
     * @date:2019-07-21
     *  * @param SystemUserGroup systemUserGroup
     * @return:
     **/
    @RequestMapping("/deleteSystemUserGroupById")
    public Result deleteSystemUserGroupById(SystemUserGroup systemUserGroup){
        systemUserGroupService.deleteSystemUserGroupById(systemUserGroup);
        return Result.success();
    }
    /**
     * @ description:  查询该业务系统拥有的管理处室
     * @ create by: 张乾
     * @ createDate: 2019/5/30 19:05
     */
    @RequestMapping("/selectUserGroupBySyId")
    public Result selectUserGroupBySyId(SystemUserGroup systemUserGroup){
        List<SystemUserGroup> systemUserGroupList= systemUserGroupService.selectUserGroupBySyId(systemUserGroup);
        return Result.success(systemUserGroupList);
    }
}
