package com.hxoim.person.markedcadre.mapper;

import com.hxoim.common.rmbKit.models.A17;
import com.hxoim.common.tree.Tree;
import com.hxoim.person.markedcadre.entity.McA01;
import com.hxoim.person.markedcadre.entity.McMarkedcadre;
import com.hxoim.person.markedcadre.entity.McMarkedcadreExample;
import com.hxoim.support.inforesource.entity.DataTableCol;
import com.hxoim.support.leaderInfo.util.LowerKeyMap;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface McMarkedcadreMapper {
    int deleteByPrimaryKey(@Param("id") String id);

    int insert(McMarkedcadre record);

    int insertSelective(McMarkedcadre record);

    List<McMarkedcadre> selectByExample(McMarkedcadreExample example);

    List<Tree> selectTree(String userId);

    McMarkedcadre selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(McMarkedcadre record);

    int updateByPrimaryKey(McMarkedcadre record);

    int getMaxSequence(com.hxoim.person.markedcadre.entity.McMarkedcadre id);

    //查询父级映射信息
    List<McMarkedcadre> selectAllMc();

    //通过父级查询下级映射信息
    List<McMarkedcadre> selectMcByPid(McMarkedcadre mcMarkedcadre);

    //description:同级排序
    void sortBySequence(String[] idArray);

    //description:查询所有列表信息
    List<LowerKeyMap<String,Object>> selectAllInfo();

    //description:根据id查询列表
    List<LowerKeyMap<String,Object>> selectInfoByNodeId(String id);

    //description:添加至名单
    void insertToList(McA01 mcA01);

    //description:从名单中删除
    void deleteForList(@Param("idArray") String[] idArray);

    //查询动态表头信息
    List<DataTableCol> selectDynamicColumn();

    //查询拼接信息
    String selectAppendInfo();

    //查询特征信息
    List<LinkedHashMap<String,Object>> selectTrait();

    //查询基本描述
    List<LinkedHashMap<String,Object>> selectDescription(String id);

    //查询职务变迁
    List<LinkedHashMap<String,Object>> selectJobChanges(String id);

    //查询学历情况
    List<LinkedHashMap<String,Object>> selectEducationInfo(String id);

    //查询考核情况
    List<LinkedHashMap<String,Object>> selectAssessInfo(String id);

    //查询工作经历
    List<LinkedHashMap<String,Object>> selectWorkExperience(String id);

    //查询任免表基本信息
    Map<String,Object> queryRmbDetail(String id);

    //查询简历信息
    List<A17> getResumeList(String id);

    /**
     * 通过人员id和名单id查询记录
     * @param paramMap
     * @return
     */
    int selectByNodeIdAndMc(Map<String, Object> paramMap);
}