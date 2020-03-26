package com.hxoim.support.sysBusinessModule.controller;

import com.hxoim.common.tree.Tree;
import com.hxoim.common.utils.Result;
import com.hxoim.support.sysBusinessModule.entity.SysBusinessModule;
import com.hxoim.support.sysBusinessModule.service.SysBusinessModuleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sysBusinessModule")
public class SysBusinessModuleController {

    @Autowired
    private SysBusinessModuleService sysBusinessModuleService;

    /**
     *
     * @return
     */
    @RequestMapping("/selectSysBusinessModuleByPid")
    public Result selectSysBusinessModuleByPid(String pid){
        List<SysBusinessModule> sysBusinessModules = sysBusinessModuleService.selectSysBusinessModuleByPid(pid);
        return Result.success(sysBusinessModules);
    }

    /**
     *
     * @return
     */
    @RequestMapping("/selectSysBusinessModuleTree")
    public Result selectSysBusinessModuleTree(String systemId){
        List<Tree> trees = sysBusinessModuleService.selectSysBusinessModuleTree(systemId);
        return Result.success(trees);
    }

    /**
     *
     * @return
     */
    @RequestMapping("/selectSysBusinessModuleById")
    public Result selectSysBusinessModuleById(String id){
        if(StringUtils.isEmpty(id)){
            return Result.error("參數异常");
        }
        SysBusinessModule sysBusinessModule = sysBusinessModuleService.selectSysBusinessModuleById(id);
        return Result.success(sysBusinessModule);
    }
    /**
     *
     * @param sysBusinessModule
     * @return
     */
    @RequestMapping("/insertSysBusinessModule")
    public Result insertSysBusinessModule(SysBusinessModule sysBusinessModule){
        if(sysBusinessModule == null){
            return Result.error("參數异常");
        }
        sysBusinessModuleService.insertSysBusinessModule(sysBusinessModule);
        return Result.success();
    }

    /**
     *
     * @param sysBusinessModule
     * @return
     */
    @RequestMapping("/updateSysBusinessModule")
    public Result updateSysBusinessModule(SysBusinessModule sysBusinessModule){
        if(sysBusinessModule == null){
            return Result.error("參數异常");
        }
        sysBusinessModuleService.updateSysBusinessModule(sysBusinessModule);
        return Result.success();
    }

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping("/deleteSysBusinessModule")
    public Result deleteSysBusinessModule(String id){
        if(StringUtils.isEmpty(id)){
            return Result.error("參數异常");
        }
        sysBusinessModuleService.deleteSysBusinessModule(id);
        return Result.success();
    }

    /**
     * @param ids
     * @return
     */
    @RequestMapping("/sortSysBusinessModule")
    public Result sortSysBusinessModule(@RequestParam String[] ids){
        if(ids.length <1){
            return Result.error("参数异常");
        }
        sysBusinessModuleService.updateSortSysBusinessModule(ids);
        return Result.success();
    }
}
