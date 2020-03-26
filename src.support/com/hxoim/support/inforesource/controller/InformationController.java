package com.hxoim.support.inforesource.controller;

import com.hxoim.common.tree.Tree;
import com.hxoim.common.utils.Result;
import com.hxoim.support.inforesource.entity.Information;
import com.hxoim.support.inforesource.service.InformationService;
import com.hxoim.support.sysdict.entity.SysDictItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.List;

/**
 * @description：信息资源项controller
 * @author ：张乾
 * @createDate ： 2019/5/29 10:53
 */
@RestController
@RequestMapping("/information")
public class InformationController {

    @Autowired
    private InformationService informationService;

    /**
     * 方法实现说明 ：  新创建的表添加列,同时给信息项添加数据
     * @author ：     张乾
     * @date ：       2019/5/24 11:06
     */
    @RequestMapping("/insertColumn")
    public Result insertColumn(Information information){
        informationService.insertColumn(information);
        return Result.success();
    }

    /**
     * description: 修改列
     * create by: 张乾
     * createDate: 2019/5/28 9:30
     */
    @RequestMapping("/updateColumn")
    public Result updateColumn(Information information){
        informationService.updateColumn(information);
        return Result.success();
    }

    /**
     * description: 删除列
     * create by: 张乾
     * createDate: 2019/5/28 10:44
     */
    @RequestMapping("/dropColumn")
    public Result dropColumn(Information information){
        informationService.dropColumn(information);
        return Result.success();
    }

    /**
     * description: 验证列名是否存在
     * create by: 张乾
     * createDate: 2019/5/28 11:03
     */
    @RequestMapping("/selectColumnName")
    public Result selectColumnName(Information information){
        informationService.selectColumnName(information);
        return Result.success();
    }

    /**
     * description: 点击信息项维护显示页面
     * create by: 张乾
     * createDate: 2019/5/29 15:07
     */
    @RequestMapping("/selectInformation")
    public Result selectInformation(String tableName){
        List<Information> informationList=informationService.selectInformation(tableName);
        return Result.success(informationList);
    }

    /**
     * description: 点击数据字典显示
     * create by: 张乾
     * createDate: 2019/5/29 15:22
     */
    @RequestMapping("/selectSysDictItem")
    public Result selectSysDictItem(String dictCode){
        List<Tree> list=informationService.selectSysDictItem(dictCode);
        return Result.success(list);
    }

    /**
     * @ description: 排序
     * @ create by: 张乾
     * @ createDate: 2019/6/13 11:16
     */
    @RequestMapping("/sortInformations")
    public Result sortInformations(String[] ids){
        informationService.sortInformations(ids);
        return Result.success();
    }
}
