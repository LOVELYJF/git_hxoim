package com.hxoim.support.combinedQuery.service;

import com.hxoim.support.combinedQuery.entity.CombinedQuery;

import java.util.List;

/**
 * 组合查询服务层接口
 *
 * @author sunqian
 * @date 2019/8/26 14:22
 */
public interface CombinedQueryService {
    /**
     * 组合查询条件列表
     * 
     * @author sunqian
     * @date 2019/8/26 14:37
     */
    List<CombinedQuery> selectCombinedQueryList();

    /**
     * 组合查询条件列表
     * 
     * @author sunqian
     * @date 2019/9/5 17:22
     */
    List<CombinedQuery> selectCombinedQueryAllList();

    /**
     * 保存排序
     *
     * @author sunqian
     * @date 2019/9/6 14:11
     */
    void updateListOrderIndex(List<CombinedQuery> list);

    /**
     * 根据主键查询
     *
     * @author sunqian
     * @date 2019/9/9 14:33
     */
    CombinedQuery selectCombinedPrimaryKey(String id);

    void insertOrUpdateCombinedQuery(CombinedQuery combinedQuery, boolean isInsert);

    /**
     * 删除条件模版
     *
     * @author sunqian
     * @date 2019/9/9 15:37
     */
    void deleteCombinedQuery(String id);
}
