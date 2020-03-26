package com.hxoim.support.reportManage.mapper;

import com.hxoim.common.tree.Tree;
import com.hxoim.support.decisionAnalysis.entity.DecisionAnalysis;

import java.util.LinkedHashMap;
import java.util.List;

public interface ReportMapper {
    /**
     * @desc: 查询目录结构树
     * @author: sundeng
     * @date: 2019/8/12
     */
    List<Tree> selectReportTree();

    /**
     * @desc: 查询配置项结构树
     * @author: sundeng
     * @date: 2019/8/13
     */
    List<Tree> selectConfigTree(String showWay);

    /**
     * @desc: 查询分析下有无分析
     * @author: sundeng
     * @date: 2019/8/13
     */
    int selectTreeNode1(String id);

    /**
     * @desc: 删除分析
     * @author: sundeng
     * @date: 2019/8/13
     */
    void deleteTreeNode1(String id);

    /**
     * @desc: 查询配置项下有无配置
     * @author: sundeng
     * @date: 2019/8/13
     */
    int selectTreeNode2(String id);

    /**
     * @desc: 配置项删除配置
     * @author: sundeng
     * @date: 2019/8/13
     */
    void deleteTreeNode2(String id);

    List<LinkedHashMap<String,Object>> selectAllColumn(String id);

    List<LinkedHashMap<String,Object>> selectColumn(String id);
}