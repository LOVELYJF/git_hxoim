package com.hxoim.support.module.controller;

import com.hxoim.common.tree.Tree;
import com.hxoim.common.utils.Result;
import com.hxoim.common.utils.UserInfoUtil;
import com.hxoim.support.module.entity.Module;
import com.hxoim.support.module.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Desc: 模块管理CRUD
 * @Author：sunqian
 * @CreateDate: 2019-6-3 10:40:11
 */
@RestController
@RequestMapping("/module")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    /**
     * @author: sunqian
     * @desc: 获取模块树
     * @date: 2019/6/4 10:16
     */
    @RequestMapping("/selectModuleTree")
    public Result selectModuleTree() {
        List<Tree> list = moduleService.selectModuleTree(UserInfoUtil.getUserInfo());
        return Result.success(list);
    }

    /**
     * @author: sunqian
     * @desc: 新增模块
     * @date: 2019/6/4 10:17
     */
    @RequestMapping("/insertModule")
    public Result insertModule(Module module) {
        moduleService.insertModule(module);
        return Result.success();
    }

    /**
     * @return com.hxoim.common.utils.Result
     * @Author sunqian
     * @Description 更新模块
     * @Date 16:59 2019/6/4
     * @Param [module]
     */
    @RequestMapping("/updateModule")
    public Result updateModule(Module module) {
        moduleService.updateModule(module);
        return Result.success();
    }

    /**
     * @return com.hxoim.common.utils.Result
     * @Author sunqian
     * @Description 根据父id查询所有的子模块
     * @Date 13:48 2019/6/4
     * @Param [pId]
     */
    @RequestMapping("/selectModulesByPid")
    public Result selectModulesByPid(String pId) {
        List<Module> list = moduleService.selectModulesByPid(pId);
        return Result.success(list);
    }

    /**
     * @return com.hxoim.common.utils.Result
     * @Author sunqian
     * @Description 根据模块id查询模块信息
     * @Date 15:24 2019/6/4
     * @Param [id] 模块id
     */
    @RequestMapping("/selectModuleById")
    public Result selectModuleById(String id) {
        Module module = moduleService.selectModuleById(id);
        return Result.success(module);
    }

    /**
     * @return com.hxoim.common.utils.Result
     * @Author sunqian
     * @Description 根据id删除模块
     * @Date 16:48 2019/6/5
     * @Param [id] 模块id
     */
    @RequestMapping("/deleteModuleById")
    public Result deleteModuleById(String id) {
        moduleService.deleteModuleById(id);
        return Result.success();
    }

    /**
     * 获取用户下的模块
     * 
     * @author sunqian
     * @date 2019/7/8 10:47
     */
    @RequestMapping("/selectGrantModuleTree")
    public Result selectGrantModuleTree() {
        Map<String, Object> map = moduleService.selectGrantModuleTree(UserInfoUtil.getUserInfo().getId());
        return Result.success(map);
    }
}