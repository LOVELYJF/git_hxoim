package com.hxoim.support.combinedQuery.mapper;

import com.hxoim.support.combinedQuery.entity.CombinedQuery;

import java.util.List;

public interface CombinedQueryMapper {
    int deleteByPrimaryKey(String id);

    int insert(CombinedQuery record);

    int insertSelective(CombinedQuery record);

    CombinedQuery selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CombinedQuery record);

    int updateByPrimaryKeyWithBLOBs(CombinedQuery record);

    int updateByPrimaryKey(CombinedQuery record);

    /**
     * 根据属性查询数据
     *
     * @author sunqian
     * @date 2019/8/26 14:41
     */
    List<CombinedQuery> selectCombinedQueryList(CombinedQuery record);

    /**
     * 组合查询条件列表
     * 
     * @author sunqian
     * @date 2019/9/5 17:23
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
     * 获取排序
     * 
     * @author sunqian
     * @date 2019/9/9 15:07
     */
    Integer selectMaxOrderIndex();
}