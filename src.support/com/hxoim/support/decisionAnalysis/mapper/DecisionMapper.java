package com.hxoim.support.decisionAnalysis.mapper;

import com.hxoim.common.tree.Tree;
import com.hxoim.support.decisionAnalysis.entity.DecisionAnalysis;

import java.util.LinkedHashMap;
import java.util.List;

public interface DecisionMapper {
    /**
     * @desc: 查询目录结构树
     * @author: sundeng
     * @date: 2019/8/12
     */
    List<Tree> selectDecisionTree();

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

    /**
     * @desc: 查询全部列
     * @author: sundeng
     * @date: 2019/8/14
     */
    List<LinkedHashMap<String,Object>> selectAllColumn(String id);

    /**
     * @desc: 根据id查询列
     * @author: sundeng
     * @date: 2019/8/14
     */
    List<LinkedHashMap<String,Object>> selectColumn(String id);

    /**
     * @desc: 查询a01表个数
     * @author: sundeng
     * @date: 2019/11/25
     */
    int selectA01();

    /**
     * @desc: 查询职务统计
     * @author: sundeng
     * @date: 2019/11/25
     */
    List<LinkedHashMap<String,Object>> selectRank();

    /**
     * @desc: 查询性别统计
     * @author: sundeng
     * @date: 2019/11/26
     */
    int selectA01Sex();

    /**
     * @desc: 查询民族统计
     * @author: sundeng
     * @date: 2019/11/26
     */
    int selectNationality();

    /**
     * @desc: 查询年龄结构
     * @author: sundeng
     * @date: 2019/11/26
     */
    List<LinkedHashMap<String,Object>> selectAge();

    /**
     * @desc: 查询学历结构
     * @author: sundeng
     * @date: 2019/11/26
     */
    List<LinkedHashMap<String,Object>> selectEducation();
}