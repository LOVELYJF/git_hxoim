package com.hxoim.support.dicitemmap.controller;

import com.github.pagehelper.PageInfo;
import com.hxoim.common.utils.Result;
import com.hxoim.support.dicitemmap.entity.DictItemMapping;
import com.hxoim.support.dicitemmap.service.DictItemMappingService;
import com.hxoim.support.sysdict.entity.SysDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @desc: 数据共享字典对应管理
 * @author: lijing
 * @date: 2019/7/23
 */
@RestController
@RequestMapping("/dictItemMapping")
public class DictItemMappingController {
    @Autowired
    private DictItemMappingService dictItemMappingService;

    /**
     * 数据共享字典列表
     * @return
     */
    @RequestMapping("/selectDictMapping")
    public Result selectDictMapping(Integer pageNum, Integer pageSize, String keyword, String standard){
        PageInfo<SysDict> pageInfo = dictItemMappingService.selectDictMapping(pageNum, pageSize, keyword, standard);
        return Result.success(pageInfo);
    }

    /**
     * 查询全部字典
     * @return
     */
    @RequestMapping("/selectAllDict")
    public Result selectAllDict(){
        List<SysDict> sysDicts = dictItemMappingService.selectAllDict();
        return Result.success(sysDicts);
    }

    /**
     * 数据共享字典项列表
     * @return
     */
    @RequestMapping("/selectDictItemMapping")
    public Result selectDictItemMapping(Integer pageNum, Integer pageSize, String keyword, String applicationId, String dicCode){
        PageInfo<DictItemMapping> dictItemMappings = dictItemMappingService.selectDictItemMapping(pageNum, pageSize, keyword, applicationId, dicCode);
        return Result.success(dictItemMappings);
    }

    /**
     * 数据共享字典项添加或者修改
     * @return
     */
    @RequestMapping("/addOrUpdateDictItemMapping")
    public Result addOrUpdateDictItemMapping(DictItemMapping dictItemMapping){
        dictItemMappingService.addOrUpdateDictItemMapping(dictItemMapping);
        return Result.success();
    }

    /**
     * 数据共享字典项删除
     * @return
     */
    @RequestMapping("/deleteDictItemMapping")
    public Result deleteDictItemMapping(String id){
        dictItemMappingService.deleteDictItemMapping(id);
        return Result.success();
    }

    /**
     * 数据共享字典项所属系统列表
     * @return
     */
    @RequestMapping("/selectApplicationIds")
    public Result selectApplicationIds(){
        List<Map<String, String>> datas = dictItemMappingService.selectApplicationIds();
        return Result.success(datas);
    }
}
