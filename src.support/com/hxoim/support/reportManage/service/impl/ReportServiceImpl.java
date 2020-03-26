package com.hxoim.support.reportManage.service.impl;

import com.hxoim.general.select.mapper.SelectMapper;
import com.hxoim.general.select.entity.SqlVo;
import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.common.tree.Tree;
import com.hxoim.common.tree.TreeUtil;
import com.hxoim.common.utils.StringUilt;
import com.hxoim.support.decisionAnalysis.entity.DecisionAnalysis;
import com.hxoim.support.decisionAnalysis.entity.DecisionConfig;
import com.hxoim.support.decisionAnalysis.mapper.DecisionMapper;
import com.hxoim.support.reportManage.entity.ReportManage;
import com.hxoim.support.reportManage.mapper.ReportMapper;
import com.hxoim.support.reportManage.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private DecisionMapper decisionMapper;
    @Autowired
    private ReportMapper  reportMapper;

    @Autowired
    private SelectMapper selectMapper;

    /**
     * @desc: 查询目录结构树
     * @author: sundeng
     * @date: 2019/8/12
     */
    @Override
    public List<Tree> selectReportTree() {
        List<Tree> treeList = TreeUtil.listToTreeJson(reportMapper.selectReportTree());
        return treeList;
    }

    /**
     * @desc: 添加目录
     * @author: sundeng
     * @date: 2019/8/12
     */
    @Override
    public void insertReport(ReportManage decision) {
        if (decision == null) {
            throw new ParameterNullException("参数为空");
        }
        String pid = decision.getPid();
        if (pid == null){
            pid = "";
        }
        String sql = "insert into sys_report (id,pid,node_name," +
             //   "report_id," +  //1.1
                "order_index) values (UUID()," +
                     "'"+pid+"'," +
                     "'"+decision.getNodeName()+"'," +
                 //    "'"+decision.getReportId()+"'," + //1.1
                     "'"+decision.getOrderIndex()+"');";
        SqlVo sqlVo = SqlVo.getInstance(sql);
        int count = selectMapper.insert(sqlVo);
        if (count == 0){
            throw new ParameterNullException("操作失败");
        }
    }

    /**
     * @desc: 回显数据
     * @author: sundeng
     * @date: 2019/8/12
     */
    @Override
    public List<LinkedHashMap<String, Object>> echoData(String id) {
        if (id == null) {
            throw new ParameterNullException("参数为空");
        }
        String sql = "select pid,node_name,order_index from sys_report order by pid";
        SqlVo sqlVo = SqlVo.getInstance(sql);
        List<LinkedHashMap<String, Object>> list = selectMapper.select(sqlVo);
        return list;
    }

    /**
     * @desc: 修改目录
     * @author: sundeng
     * @date: 2019/8/12
     */
    @Override
    public void updateReport(ReportManage decision) {
        if (decision == null) {
            throw new ParameterNullException("参数为空");
        }
        String sql ="update sys_report set pid='"+decision.getPid()+"'," +
                    "node_name='"+decision.getNodeName()+"'," +
                    "order_index='"+decision.getOrderIndex()+"' " +
                    "where id = '"+decision.getId()+"'";
        SqlVo sqlVo = SqlVo.getInstance(sql);
        int count = selectMapper.update(sqlVo);
        if (count == 0){
            throw new ParameterNullException("操作失败");
        }
    }

    /**
     * @desc: 删除目录
     * @author: sundeng
     * @date: 2019/8/12
     */
    @Override
    public void deleteReport(String id) {
        if (id == null) {
            throw new ParameterNullException("参数为空");
        }
        int count = reportMapper.selectTreeNode1(id);
        if(count>0){
            throw new ParameterNullException("该机构有下级机构，无法删除！");
        }
        reportMapper.deleteTreeNode1(id);

    }

    /**
     * @desc: 根据id查询分析
     * @author: sundeng
     * @date: 2019/8/12
     */
    @Override
    public List<LinkedHashMap<String, Object>> selectReport(String id) {
        String sql = "select * from sys_report where id = '"+id+"'";
        SqlVo sqlVo = SqlVo.getInstance(sql);
        List<LinkedHashMap<String, Object>> list = selectMapper.select(sqlVo);
        return list;
    }

    /**
     * @desc: 查询所有分析名
     * @author: sundeng
     * @date: 2019/8/12
     */
    @Override
    public List<LinkedHashMap<String, Object>> selectAllReport() {
        String sql = "select id,pid,node_name from sys_report order by pid";
        SqlVo sqlVo = SqlVo.getInstance(sql);
        List<LinkedHashMap<String, Object>> list = selectMapper.select(sqlVo);
        return list;
    }

    /**
     * @desc: 保存sql和展示方式并查询
     * @author: sundeng
     * @date: 2019/8/12
     */
    @Override
    public List<LinkedHashMap<String, Object>> selectdecisionbySql(DecisionAnalysis decision) {
        String dasql = "update sys_decision_analysis set da_sql = '"+decision.getDaSql()+"' where id = '"+decision.getId()+"'";
        SqlVo sqlVo = SqlVo.getInstance(dasql);
        int count = selectMapper.update(sqlVo);
        if (count == 0){
            throw new ParameterNullException("操作失败");
        }
        SqlVo sqlVo1 = new SqlVo();
        sqlVo1.setSql(decision.getDaSql());
        List<LinkedHashMap<String, Object>> list = selectMapper.select(sqlVo1);
        return list;
    }

    /**
     * @desc: 查询配置项结构树
     * @author: sundeng
     * @date: 2019/8/13
     */
    @Override
    public List<Tree> selectConfigTree(String showWay) {
        List<Tree> treeList = TreeUtil.listToTreeJson(decisionMapper.selectConfigTree(showWay));
        return treeList;
    }

    /**
     * @desc: 配置项添加目录
     * @author: sundeng
     * @date: 2019/8/13
     */
    @Override
    public void insertConfigTree(DecisionConfig decisionConfig) {
        if (decisionConfig == null) {
            throw new ParameterNullException("参数为空");
        }
        String pid = decisionConfig.getPid();
        if (pid == null){
            pid = "";
        }
        String sql = "insert into decision_show (id,pid,show_way,json) values(UUID()," +
                     "'"+pid+"','"+decisionConfig.getShowWay()+"'," +
                     "'"+decisionConfig.getJson()+"')";
        SqlVo sqlVo = SqlVo.getInstance(sql);
        int count = selectMapper.insert(sqlVo);
        if (count == 0){
            throw new ParameterNullException("操作失败");
        }
    }

    /**
     * @desc: 配置项修改目录
     * @author: sundeng
     * @date: 2019/8/13
     */
    @Override
    public void updateConfigTree(DecisionConfig decisionConfig) {
        if (decisionConfig == null) {
            throw new ParameterNullException("参数为空");
        }
        String sql ="update decision_show set json='"+decisionConfig.getJson()+"' " +
                    "where id='"+decisionConfig.getId()+"'";
        SqlVo sqlVo = SqlVo.getInstance(sql);
        int count = selectMapper.update(sqlVo);
        if (count == 0){
            throw new ParameterNullException("操作失败");
        }
    }

    /**
     * @desc: 配置项删除目录
     * @author: sundeng
     * @date: 2019/8/13
     */
    @Override
    public void deleteConfigTree(String id) {
        if (id == null) {
            throw new ParameterNullException("参数为空");
        }
        int count = decisionMapper.selectTreeNode2(id);
        if(count>0){
            throw new ParameterNullException("该机构有下级机构，无法删除！");
        }
        decisionMapper.deleteTreeNode2(id);
    }

    /**
     * @desc: 根据id查询配置项
     * @author: sundeng
     * @date: 2019/8/14
     */
    @Override
    public List<LinkedHashMap<String, Object>> selectConfigById(String id) {
        if (id == null) {
            throw new ParameterNullException("参数为空");
        }
        int count = decisionMapper.selectTreeNode2(id);
        //如果有子级，查询全部
        if (count > 0){
            List<LinkedHashMap<String, Object>> list = decisionMapper.selectAllColumn(id);
            for (int i = 0; i < list.size(); i++) {
                LinkedHashMap<String, Object> map = list.get(i);
                String id1 = (String) map.get("id");
                count = decisionMapper.selectTreeNode2(id1);
                if (count > 0){
                    list.remove(i);
                }
            }
            return list;
        //如果无子级,根据id查询
        }else{
            return decisionMapper.selectColumn(id);
        }
    }

    /**
     * @desc: 保存配置信息
     * @author: sundeng
     * @date: 2019/8/14
     */
    @Override
    public void updateConfigById(DecisionAnalysis decision) {
        if (StringUilt.stringIsNullOrEmpty(decision.getId())) {
            throw new ParameterNullException("参数为空");
        }
        if (StringUilt.stringIsNullOrEmpty(decision.getJson())) {
            throw new ParameterNullException("参数为空");
        }
        String sql = "update sys_decision_analysis set json = '"+decision.getJson()+"' where id = '"+decision.getId()+"'";
        SqlVo sqlVo = SqlVo.getInstance(sql);
        int count = selectMapper.update(sqlVo);
        if (count == 0){
            throw new ParameterNullException("操作失败");
        }
    }
}
