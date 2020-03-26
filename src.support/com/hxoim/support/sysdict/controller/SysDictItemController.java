package com.hxoim.support.sysdict.controller;

import com.hxoim.common.tree.Tree;
import com.hxoim.common.utils.Result;
import com.hxoim.support.sysdict.entity.SysDictItem;
import com.hxoim.support.sysdict.service.SysDictItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @description：字典管理映射类Controller
 * @author ：张乾
 * @createDate ： 2019/5/27 16:22
 */
@RestController
@RequestMapping("/sysDictItem")
public class SysDictItemController {

    //注入字典管理映射类接口
    @Autowired
    private SysDictItemService sysDictItemService;

    /**
     * description:添加字典映射表信息
     * create by: 张乾
     * createDate: 2019/5/27 16:30
     */
    @RequestMapping("/insertSysDictItem")
    public Result insertSysDictItem(SysDictItem sysDictItem){
        sysDictItemService.insertSysDictItem(sysDictItem);
        return Result.success();
    }

    /**
     * description:修改字典映射表信息
     * create by: 张乾
     * createDate: 2019/5/27 16:30
     */
    @RequestMapping("/updateSysDictItem")
    public Result updateSysDictItem(SysDictItem sysDictItem){
        sysDictItemService.updateSysDictItem(sysDictItem);
        return Result.success();
    }

    /**
     * description:删除字典映射表信息
     * create by: 张乾
     * createDate: 2019/5/27 16:30
     */
    @RequestMapping("/deleteSysDictItem")
    public Result deleteSysDictItem(SysDictItem sysDictItem){
        sysDictItemService.deleteSysDictItem(sysDictItem);
        return Result.success();
    }

    /**
     * description:同级排序
     * create by: 张乾
     * createDate: 2019/5/27 16:31
     */
    @RequestMapping("/sortByOrderIndex")
    public Result sortByOrderIndex(String ids){
        sysDictItemService.sortByOrderIndex(ids);
        return Result.success();
    }

    /**
     * description: 通过父级code查询下级映射信息
     * create by: 张乾
     * createDate: 2019/5/29 16:36
     */
    @RequestMapping("/selectDictItemByPCode")
    public Result selectDictItemByPCode(SysDictItem sysDictItem){
        List<SysDictItem> SysDictItemList= sysDictItemService.selectDictItemByPCode(sysDictItem);
        return Result.success(SysDictItemList);
    }

    /**
     * @ description: 查询映射表树
     * @ create by: 张乾
     * @ createDate: 2019/6/18 15:41
     */
    @RequestMapping("/selectItemTree")
    public Result selectItemTree(SysDictItem sysDictItem){
        List<Tree> list=sysDictItemService.selectItemTree(sysDictItem);
        return Result.success(list);
    }

    /**
     * @ description: 通过id查询映射信息
     * @ create by: 张乾
     * @ createDate: 2019/6/18 16:46
     */
    @RequestMapping("/selectItemAllById")
    public Result selectItemAllById(String id){
        SysDictItem sysDictItem=sysDictItemService.selectItemAllById(id);
        return Result.success(sysDictItem);
    }

    /**
     * @ description: 根据dictCode查询字典映射信息
     * @ create by: 张乾
     * @ createDate: 2019/6/24 18:27
     */
    @RequestMapping("/selectItemByDictCode")
    public Result selectItemByDictCode(String dictCode){
        List<Tree> list=sysDictItemService.selectItemByDictCode(dictCode);
        return Result.success(list);
    }

    /**
     * @desc: 查询字典树
     * @author: lijing
     * @date: 2019/8/8
     */
    @RequestMapping("/getDictInfoByDictCode")
    public Result getDictInfoByDictCode(String dictCode, String itemCode){
        List<Map<String,Object>> list=sysDictItemService.getDictInfoByDictCode(dictCode, itemCode);
        return Result.success(list);
    }
}
