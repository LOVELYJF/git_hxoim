package com.hxoim.support.reportManage.service;

import com.hxoim.common.tree.Tree;
import com.hxoim.support.decisionAnalysis.entity.DecisionAnalysis;
import com.hxoim.support.decisionAnalysis.entity.DecisionConfig;
import com.hxoim.support.reportManage.entity.ReportManage;

import java.util.LinkedHashMap;
import java.util.List;

public interface ReportService {

    /**
     * @desc: 查询目录结构树
     * @author: sundeng
     * @date: 2019/8/12
     */
    List<Tree> selectReportTree();

    /**
     * @desc: 添加目录
     * @author: sundeng
     * @date: 2019/8/12
     */
    void insertReport(ReportManage decision);

    /**
     * @desc: 回显数据
     * @author: sundeng
     * @date: 2019/8/12
     */
    List<LinkedHashMap<String,Object>> echoData(String id);

    /**
     * @desc: 修改目录
     * @author: sundeng
     * @date: 2019/8/12
     */
    void updateReport(ReportManage decision);

    /**
     * @desc: 删除目录
     * @author: sundeng
     * @date: 2019/8/12
     */
    void deleteReport(String id);

    /**
     * @desc: 根据id查询分析
     * @author: sundeng
     * @date: 2019/8/12
     */
    List<LinkedHashMap<String,Object>> selectReport(String id);

    /**
     * @desc: 查询所有分析名
     * @author: sundeng
     * @date: 2019/8/12
     */
    List<LinkedHashMap<String, Object>> selectAllReport();

    /**
     * @desc: 保存sql和展示方式并查询
     * @author: sundeng
     * @date: 2019/8/12
     */
    List<LinkedHashMap<String,Object>> selectdecisionbySql(DecisionAnalysis decision);

    /**
     * @desc: 查询配置项结构树
     * @author: sundeng
     * @date: 2019/8/13
     */
    List<Tree> selectConfigTree(String showWay);

    /**
     * @desc: 配置项添加目录
     * @author: sundeng
     * @date: 2019/8/13
     */
    void insertConfigTree(DecisionConfig decisionConfig);

    /**
     * @desc: 配置项修改目录
     * @author: sundeng
     * @date: 2019/8/13
     */
    void updateConfigTree(DecisionConfig decisionConfig);

    /**
     * @desc: 配置项删除目录
     * @author: sundeng
     * @date: 2019/8/13
     */
    void deleteConfigTree(String id);

    /**
     * @desc: 根据id查询配置项
     * @author: sundeng
     * @date: 2019/8/14
     */
    List<LinkedHashMap<String,Object>> selectConfigById(String id);

    /**
     * @desc: 保存配置信息
     * @author: sundeng
     * @date: 2019/8/14
     */
    void updateConfigById(DecisionAnalysis decision);
}
