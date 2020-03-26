package com.hxoim.support.decisionAnalysis.service;

import com.hxoim.common.tree.Tree;
import com.hxoim.support.decisionAnalysis.entity.DecisionAnalysis;
import com.hxoim.support.decisionAnalysis.entity.DecisionConfig;

import java.util.LinkedHashMap;
import java.util.List;

public interface DecisionService {

    /**
     * @desc: 查询目录结构树
     * @author: sundeng
     * @date: 2019/8/12
     */
    List<Tree> selectDecisionTree();

    /**
     * @desc: 添加目录
     * @author: sundeng
     * @date: 2019/8/12
     */
    void insertdecision(DecisionAnalysis decision);

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
    void updatedecision(DecisionAnalysis decision);

    /**
     * @desc: 删除目录
     * @author: sundeng
     * @date: 2019/8/12
     */
    void deletedecision(String id);

    /**
     * @desc: 根据id查询分析
     * @author: sundeng
     * @date: 2019/8/12
     */
    List<LinkedHashMap<String,Object>> selectdecision(String id);

    /**
     * @desc: 查询所有分析名
     * @author: sundeng
     * @date: 2019/8/12
     */
    List<LinkedHashMap<String, Object>> selectAlldecision();

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

    /**
     * @desc: 查询全库信息占比
     * @author: sundeng
     * @date: 2019/11/25
     */
    String selectInformation();
}
