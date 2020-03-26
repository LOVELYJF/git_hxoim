package com.hxoim.support.customquery.mapper;

import com.hxoim.general.select.entity.SqlVo;
import com.hxoim.support.customquery.entity.QueryPlan;
import com.hxoim.support.customquery.entity.QueryPlanWithBLOBs;
import com.hxoim.support.customquery.entity.custom.QueryPlanCustom;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface QueryPlanMapper {
    int deleteByPrimaryKey(String id);

    int insert(QueryPlanWithBLOBs record);

    int insertSelective(QueryPlanWithBLOBs record);

    QueryPlanWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(QueryPlanWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(QueryPlanWithBLOBs record);

    int updateByPrimaryKey(QueryPlan record);

    /**
     * @desc: 方案列表
     * @author: lijing
     * @date: 2019/8/10
     */
    List<QueryPlanCustom> selectQueryList(Map<String, String> params);

    List<LinkedHashMap<String, Object>> select(SqlVo sql);
}