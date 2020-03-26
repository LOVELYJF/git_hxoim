package com.hxoim.support.sysdict.controller;

import com.hxoim.common.tree.Tree;
import com.hxoim.common.utils.Constants;
import com.hxoim.common.utils.Result;
import com.hxoim.support.sysdict.entity.SysDict;
import com.hxoim.support.sysdict.service.SysDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @description：字典管理Controller
 * @author ：张乾
 * @createDate ： 2019/5/27 16:22
 */
@RestController
@RequestMapping("/sysDict")
public class SysDictController {

    //注入字典管理Service
    @Autowired
    private SysDictService sysDictService;

    /**
     * description:添加字典管理
     * create by: 张乾
     * createDate: 2019/5/27 16:29
     */
    @RequestMapping("/insertSysDict")
    public Result insertSysDict(SysDict sysDict) {
        sysDictService.insertSysDict(sysDict);
        return Result.success();
    }

    /**
     * description:修改字典
     * create by: 张乾
     * createDate: 2019/5/27 16:29
     */
    @RequestMapping("/updateSysDict")
    public Result updateSysDict(SysDict sysDict) {
        sysDictService.updateSysDict(sysDict);
        return Result.success();
    }

    /**
     * description:删除字典
     * create by: 张乾
     * createDate: 2019/5/27 16:29
     */
    @RequestMapping("/deleteSysDict")
    public Result deleteSysDict(SysDict sysDict){
        sysDictService.deleteSysDict(sysDict);
        return Result.success();
    }

    /**
     * description:查询字典名称和code
     * create by: 张乾
     * createDate: 2019/5/27 16:29
     */
    @RequestMapping("/selectAllSysDict")
    public Result selectAllSysDict(){
        List<SysDict> sysDiceList=sysDictService.selectAllSysDict();
        return Result.success(sysDiceList);
    }

    /**
     * description:验证dictCode是否唯一
     * create by: 张乾
     * createDate: 2019/5/30 9:01
     */
    @RequestMapping("/selectDictCode")
    public Result selectDictCode(SysDict sysDict){
        sysDictService.selectDictCode(sysDict);
        return Result.success();
    }

    /**
     * @ description: 搜索
     * @ create by: 张乾
     * @ createDate: 2019/6/17 17:01
     */
    @RequestMapping("/selectDict")
    public Result selectDict(SysDict sysDict){
        List<SysDict> list=sysDictService.selectDict(sysDict);
        return Result.success(list);
    }

    /**
     *@ description: 查询字典树
     *@ create by: 张乾
     *@ createDate: 2019/6/18 11:16
     */
    @RequestMapping("/selectDictTree")
    public Result selectDictTree(){
        List<Tree> list=sysDictService.selectDictTree();
        return Result.success(list);
    }

    /**
     * @ description: 通过code查询字典
     * @ create by: 张乾
     * @ createDate: 2019/6/18 16:52
     */
    @RequestMapping("/selectDictByCode")
    public Result selectDictByCode(String dictCode){
        SysDict sysDict=sysDictService.selectDictByCode(dictCode);
        return Result.success(sysDict);
    }
}
