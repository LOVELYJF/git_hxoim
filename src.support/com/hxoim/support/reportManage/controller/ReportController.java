package com.hxoim.support.reportManage.controller;

import com.hxoim.common.tree.Tree;
import com.hxoim.common.utils.Result;
import com.hxoim.support.decisionAnalysis.entity.DecisionAnalysis;
import com.hxoim.support.decisionAnalysis.entity.DecisionConfig;
import com.hxoim.support.decisionAnalysis.service.DecisionService;
import com.hxoim.support.reportManage.entity.ReportManage;
import com.hxoim.support.reportManage.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @desc: 决策分析模块
 * @author: sundeng
 * @date: 2019/8/12
 */
@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private DecisionService decisionService;
    @Autowired
    private ReportService   reportService;

    /**
     * @desc: 查询目录结构树
     * @author: sundeng
     * @date: 2019/8/12
     */
    @RequestMapping("/selectReportTree")
    public Result selectReportTree(){
        List<Tree> list  = reportService.selectReportTree();
        return Result.success(list);
    }

    /**
     * @desc: 添加目录
     * @author: sundeng
     * @date: 2019/8/12
     */
    @RequestMapping("/insertReport")
    public Result insertReport(ReportManage decision){
        reportService.insertReport(decision);
        return Result.success();
    }

    /**
     * @desc: 回显数据
     * @author: sundeng
     * @date: 2019/8/12
     */
    @RequestMapping("/echoData")
    public Result echoData(String id){
        List<LinkedHashMap<String, Object>> list = reportService.echoData(id);
        return Result.success(list);
    }

    /**
     * @desc: 修改目录
     * @author: sundeng
     * @date: 2019/8/12
     */
    @RequestMapping("/updateReport")
    public Result updateReport(ReportManage decision){
        reportService.updateReport(decision);
        return Result.success();
    }

    /**
     * @desc: 删除目录
     * @author: sundeng
     * @date: 2019/8/12
     */
    @RequestMapping("/deleteReport")
    public Result deleteReport(String id){
        reportService.deleteReport(id);
        return Result.success();
    }

    /**
     * @desc: 根据id查询分析
     * @author: sundeng
     * @date: 2019/8/12
     */
    @RequestMapping("/selectReport")
    public Result selectReport(String id){
        List<LinkedHashMap<String, Object>> list = reportService.selectReport(id);
        return Result.success(list);
    }

    /**
     * @desc: 查询所有报表
     * @author: sundeng
     * @date: 2019/8/12
     */
    @RequestMapping("/selectAllReport")
    public Result selectAllReport(){
        List<LinkedHashMap<String, Object>> list = reportService.selectAllReport();
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

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.retainAll(Arrays.asList(new int[]{2,4}));

        System.out.println(list);
    }
}
