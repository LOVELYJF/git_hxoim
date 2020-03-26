package com.hxoim.support.customquery.service;

import com.hxoim.support.customquery.entity.QueryPlanWithBLOBs;
import com.hxoim.support.customquery.entity.custom.QueryPlanCustom;

import java.util.List;

/**
 * @desc: 方案
 * @author: lijing
 * @date: 2019/8/9
 */
public interface QueryPlanService {
    /**
     * @desc: 插入方案
     * @author: lijing
     * @date: 2019/8/10
     */
    void insertorUpdateQuery(QueryPlanWithBLOBs queryPlanWithBLOBs);

    /**
     * @desc: 通过id查询方案
     * @author: lijing
     * @date: 2019/8/10
     */
    QueryPlanWithBLOBs selectQueryPlanById(String id);

    /**
     * @desc: 方案列表
     * @author: lijing
     * @date: 2019/8/10
     */
    List<QueryPlanCustom> selectQueryList();
}
