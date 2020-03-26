package com.hxoim.support.decisionAnalysis.controller;

import com.hxoim.common.tree.Tree;
import com.hxoim.common.utils.Result;
import com.hxoim.support.decisionAnalysis.entity.DecisionAnalysis;
import com.hxoim.support.decisionAnalysis.entity.DecisionConfig;
import com.hxoim.support.decisionAnalysis.service.DecisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @desc: 决策分析模块
 * @author: sundeng
 * @date: 2019/8/12
 */
@RestController
@RequestMapping("/decisionAnalysis")
public class DecisionController {

    @Autowired
    private DecisionService decisionService;

    /**
     * @desc: 查询目录结构树
     * @author: sundeng
     * @date: 2019/8/12
     */
    @RequestMapping("/selectDecisionTree")
    public Result selectDecisionTree(){
        List<Tree> list  = decisionService.selectDecisionTree();
        return Result.success(list);
    }

    /**
     * @desc: 添加目录
     * @author: sundeng
     * @date: 2019/8/12
     */
    @RequestMapping("/insertdecision")
    public Result insertdecision(DecisionAnalysis decision){
        decisionService.insertdecision(decision);
        return Result.success();
    }

    /**
     * @desc: 回显数据
     * @author: sundeng
     * @date: 2019/8/12
     */
    @RequestMapping("/echoData")
    public Result echoData(String id){
        List<LinkedHashMap<String, Object>> list = decisionService.echoData(id);
        return Result.success(list);
    }

    /**
     * @desc: 修改目录
     * @author: sundeng
     * @date: 2019/8/12
     */
    @RequestMapping("/updatedecision")
    public Result updatedecision(DecisionAnalysis decision){
        decisionService.updatedecision(decision);
        return Result.success();
    }

    /**
     * @desc: 删除目录
     * @author: sundeng
     * @date: 2019/8/12
     */
    @RequestMapping("/deletedecision")
    public Result deletedecision(String id){
        decisionService.deletedecision(id);
        return Result.success();
    }

    /**
     * @desc: 根据id查询分析
     * @author: sundeng
     * @date: 2019/8/12
     */
    @RequestMapping("/selectdecision")
    public Result selectdecision(String id){
        List<LinkedHashMap<String, Object>> list = decisionService.selectdecision(id);
        return Result.success(list);
    }

    /**
     * @desc: 查询所有分析名
     * @author: sundeng
     * @date: 2019/8/12
     */
    @RequestMapping("/selectAlldecision")
    public Result selectAlldecision(){
        List<LinkedHashMap<String, Object>> list = decisionService.selectAlldecision();
        return Result.success(list);
    }

    /**
     * @desc: 保存sql和展示方式并查询
     * @author: sundeng
     * @date: 2019/8/12
     */
    @RequestMapping("/selectdecisionbySql")
    public Result selectdecisionbySql(DecisionAnalysis decision){
        List<LinkedHashMap<String, Object>> list = decisionService.selectdecisionbySql(decision);
        return Result.success(list);
    }

    /**
     * @desc: 查询配置项结构树
     * @author: sundeng
     * @date: 2019/8/13
     */
    @RequestMapping("/selectConfigTree")
    public Result selectConfigTree(String showWay){
        List<Tree> list  = decisionService.selectConfigTree(showWay);
        return Result.success(list);
    }

    /**
     * @desc: 配置项添加目录
     * @author: sundeng
     * @date: 2019/8/13
     */
    @RequestMapping("/insertConfigTree")
    public Result insertConfigTree(DecisionConfig decisionConfig){
        decisionService.insertConfigTree(decisionConfig);
        return Result.success();
    }

    /**
     * @desc: 配置项修改目录
     * @author: sundeng
     * @date: 2019/8/13
     */
    @RequestMapping("/updateConfigTree")
    public Result updateConfigTree(DecisionConfig decisionConfig){
        decisionService.updateConfigTree(decisionConfig);
        return Result.success();
    }

    /**
     * @desc: 配置项删除目录
     * @author: sundeng
     * @date: 2019/8/13
     */
    @RequestMapping("/deleteConfigTree")
    public Result deleteConfigTree(String id){
        decisionService.deleteConfigTree(id);
        return Result.success();
    }

    /**
     * @desc: 根据id查询配置项
     * @author: sundeng
     * @date: 2019/8/14
     */
    @RequestMapping("/selectConfigById")
    public Result selectConfigById(String id){
        List<LinkedHashMap<String, Object>> list = decisionService.selectConfigById(id);
        return Result.success(list);
    }

    /**
     * @desc: 保存配置信息
     * @author: sundeng
     * @date: 2019/8/14
     */
    @RequestMapping("/updateConfigById")
    public Result updateConfigById(DecisionAnalysis decision){
        decisionService.updateConfigById(decision);
        return Result.success();
    }

    /**
     * @desc: 查询全库信息占比
     * @author: sundeng
     * @date: 2019/11/25
     */
    @RequestMapping("/selectInformation")
    public Result selectInformation(){
        String info = decisionService.selectInformation();
        return Result.success(info);
    }
}
