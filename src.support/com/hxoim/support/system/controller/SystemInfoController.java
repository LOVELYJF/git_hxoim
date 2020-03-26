package com.hxoim.support.system.controller;

import com.hxoim.common.tree.Tree;
import com.hxoim.common.utils.Result;
import com.hxoim.support.system.entity.SystemInfo;
import com.hxoim.support.system.service.SystemInfoService;
import com.hxoim.support.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author sunqian
 * @Description 登录系统管理
 * @Date 14:17 2019/6/6
 */
@RestController
@RequestMapping("/systemInfo")
public class SystemInfoController {

    @Autowired
    private SystemInfoService systemInfoService;

    /**
     * @Author sunqian
     * @Desc 查询子节点
     * @Date 2019/6/18 14:18
     */
    @RequestMapping("/selectKidsSysInfoByPId")
    public Result selectKidsSysInfoByPId(SystemInfo systemInfo) {
        List<SystemInfo> list = systemInfoService.selectKidsSysInfo(systemInfo);
        return Result.success(list);
    }

    /**
     * @Author sunqian
     * @Desc 新增系统
     * @Date 2019/6/18 14:40
     */
    @RequestMapping("/insertSystemInfo")
    public Result insertSystemInfo(SystemInfo systemInfo) {
        systemInfoService.insertSystemInfo(systemInfo);
        return Result.success();
    }

    /**
     * @Author sunqian
     * @Desc 修改
     * @Date 2019/6/18 14:57
     */
    @RequestMapping("/updateSystemInfo")
    public Result updateSystemInfo(SystemInfo systemInfo) {
        systemInfoService.updateSystemInfo(systemInfo);
        return Result.success();
    }

    /**
     * @Author sunqian
     * @Desc 修改
     * @Date 2019/6/18 14:57
     */
    @RequestMapping("/deleteSystemInfo")
    public Result deleteSystemInfo(SystemInfo systemInfo) {
        systemInfoService.deleteSystemInfo(systemInfo);
        return Result.success();
    }

    /**
     * @ description: 查询业务系统树
     * @ create by: 张乾
     * @ createDate: 2019/6/4 15:25
     */
    @RequestMapping("/selectSystemInfoTree")
    public Result selectSystemInfoTree() {
        List<Tree> list = systemInfoService.selectSystemInfoTree();
        return Result.success(list);
    }

    /**
     * @Author sunqian
     * @Desc 根据id查询
     * @Date 2019/6/18 15:16
     */
    @RequestMapping("/selectSysInfoByPrimaryKey")
    public Result selectSysInfoByPrimaryKey(SystemInfo systemInfo) {
        SystemInfo sy = systemInfoService.selectSysInfoByPrimaryKey(systemInfo.getId());
        return Result.success(sy);
    }

    /**
     * 获取当前用户权限内的系统
     * 
     * @author sunqian
     * @date 2019/8/22 14:26
     */
    @RequestMapping("/selectUserGrantSystemInfo")
    public Result selectUserGrantSystemInfo() {
        List<SystemInfo> systemInfoList = systemInfoService.selectCurrUserGrantSystemInfo();
        return Result.success(systemInfoList);
    }
}