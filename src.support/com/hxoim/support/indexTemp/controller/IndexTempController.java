package com.hxoim.support.indexTemp.controller;

import com.hxoim.common.tree.Tree;
import com.hxoim.common.utils.Result;
import com.hxoim.support.indexTemp.entity.IndexTemp;
import com.hxoim.support.indexTemp.service.IndexTempService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 首页模板
 *
 * @author zb
 * @email zb@hx-soft.cn
 * @date 2019-08-09 09:25:58
 */
@RestController
@RequestMapping("/indexTemp")
public class IndexTempController {
    @Autowired
    private IndexTempService indexTempService;

    /**
     * 查询当前处室首页模板
     * @return
     */
    @RequestMapping("/selectIndexTemp")
    public Result selectIndexTemp(){
        List<IndexTemp> list =indexTempService.selectIndexTempByOrg();
        return Result.success(list);
    }

    /**
     * 添加、修改当前处室模板
     * @param indexTemps
     * @return
     */
    @RequestMapping("/insertIndexTemp")
    public Result insertBatchIndexTemp(@RequestBody IndexTemp indexTemps[]){
        boolean flag =indexTempService.insertBatchSelective(indexTemps);
        if(!flag){
            return Result.error("保存模板异常");
        }
        return Result.success();
    }

    /**
     * 删除某个模板
     * @param id
     * @return
     */
    @RequestMapping("/deleteIndexTemp")
    public Result deleteIndexTemp(String id){
        indexTempService.deleteIndexTempById(id);
        return Result.success();
    }

    /**
     * 查询当前处室有哪些模块
     * @return
     */
    @RequestMapping("/selectSysTempModule")
    public Result selectSysTempModule(){
        List list = indexTempService.selectSysTempModule();
        return Result.success(list);
    }

    /**
     * 添加当前处室有哪些模块
     * @return
     */
    @RequestMapping("/insetSysTempModule")
    public Result insetSysTempModule(@RequestBody IndexTemp indexTemps[]){
        boolean flag = indexTempService.insertSysTempModule(indexTemps);
        if(!flag){
            return Result.error("新增模块异常");
        }
        return Result.success();
    }

    /**
     * 修改当前处室有哪些模块
     * @return
     */
    @RequestMapping("/updateSysTempModule")
    public Result updateSysTempModule(@RequestBody IndexTemp indexTemps[]){
        boolean flag = indexTempService.updateSysTempModule(indexTemps);
        if(!flag){
            return Result.error("修改模块异常");
        }
        return Result.success();
    }

    /**
     * 获取模板加载的表
     * @return
     */
    @RequestMapping("/selectIndexTempTable")
    public Result selectIndexTempTable(){

        List<LinkedHashMap<String, Object>> list = indexTempService.selectIndexTempTable();
        return Result.success(list);
    }

    /**
     * 根据表名获取树形结构
     * @param tableName
     * @return
     */
    @RequestMapping("/selectTemplateTree")
    public Result selectTree(String tableName,String tempId){
        if(StringUtils.isEmpty(tableName) || StringUtils.isEmpty(tempId)){
            return Result.error("参数异常");
        }
        Map map = indexTempService.selectTree(tableName, tempId);
        return Result.success(map);
    }

    @RequestMapping("/selectTree")
    public Result selectTree(String tableName){
        if(StringUtils.isEmpty(tableName)){
            return Result.error("参数异常");
        }
        List<Tree> trees = indexTempService.selectTree(tableName);
        return Result.success(trees);
    }

    /**
     * @desc: 查询数据列表
     * @author: lijing
     * @date: 2019/9/5
     */
    @RequestMapping("/selectTableList")
    public Result selectTableList(Integer pageSize, Integer pageNum, String tableName) {
        return Result.success(indexTempService.selectTableList(pageSize, pageNum, tableName));
    }

    /**
     * =================================
     * 查询首页某模块内容
     * @param tableName
     * @return
     */
    @RequestMapping("/selectSysModule")
    public Result selectSysModule(@RequestParam String tableName,@RequestParam String[] ids){
        if(StringUtils.isEmpty(tableName)){
            return Result.error("参数异常");
        }
        List<LinkedHashMap<String, Object>> list = indexTempService.selectSysModule(tableName,ids);
        return  Result.success(list);
    }

    /**
     * 新增首页某模块内容
     * @param params
     * @return
     */
    @RequestMapping("/insetSysModule")
    public Result insetSysModule(String params){
        if(StringUtils.isEmpty(params)){
            return Result.error("参数异常");
        }
        indexTempService.executeSysModule(params);
        return Result.success();
    }

    /**
     * 修改首页某模块内容
     * @param params
     * @return
     */
    @RequestMapping("/updateSysModule")
    public Result updateSysModule(String params){
        if(StringUtils.isEmpty(params)){
            return Result.error("参数异常");
        }
        indexTempService.executeSysModule(params);
        return Result.success();
    }

    /**
     * 删除首页某模块内容
     * @param params
     * @return
     */
    @RequestMapping("/deleteSysModule")
    public Result deleteSysModule(String params){
        if(StringUtils.isEmpty(params)){
            return Result.error("参数异常");
        }
        indexTempService.executeSysModule(params);
        return Result.success();
    }

    /**
     * 获取系统列表
     * @param
     * @return
     */
    @RequestMapping("/selectSystems")
    public Result selectSystems(){
        List systemInfos = indexTempService.selectSystemInfo();
        return Result.success(systemInfos);
    }

    @RequestMapping("/selectSystemModule")
    public Result selectSystemModule(){
        List<Tree> trees = indexTempService.selectSystemModule();
        return Result.success(trees);
    }
}
