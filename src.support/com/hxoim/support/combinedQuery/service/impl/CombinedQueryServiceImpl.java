package com.hxoim.support.combinedQuery.service.impl;

import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.common.utils.UUIDGenerator;
import com.hxoim.support.combinedQuery.entity.CombinedQuery;
import com.hxoim.support.combinedQuery.mapper.CombinedQueryMapper;
import com.hxoim.support.combinedQuery.service.CombinedQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 组合查询服务层实现类
 *
 * @author sunqian
 * @date 2019/8/26 14:23
 */
@Service
public class CombinedQueryServiceImpl implements CombinedQueryService {

    @Autowired
    private CombinedQueryMapper combinedQueryMapper;

    @Override
    public List<CombinedQuery> selectCombinedQueryList() {
        CombinedQuery record = new CombinedQuery();
        record.setConditionType("1");
        //查询类型为1 的条件
        List<CombinedQuery> list = combinedQueryMapper.selectCombinedQueryList(record);
        return list;
    }

    @Override
    public List<CombinedQuery> selectCombinedQueryAllList() {
        return combinedQueryMapper.selectCombinedQueryAllList();
    }

    @Override
    public void updateListOrderIndex(List<CombinedQuery> list) {
        combinedQueryMapper.updateListOrderIndex(list);
    }

    @Override
    public CombinedQuery selectCombinedPrimaryKey(String id) {
        return combinedQueryMapper.selectByPrimaryKey(id);
    }

    @Override
    public void insertOrUpdateCombinedQuery(CombinedQuery combinedQuery, boolean isInsert) {
        if (combinedQuery == null) {
            throw new ParameterNullException("参数为空");
        }
        //新增
        if (isInsert == true) {
            combinedQuery.setId(UUIDGenerator.getPrimaryKey());
            combinedQuery.setOrderIndex(combinedQueryMapper.selectMaxOrderIndex());
            combinedQueryMapper.insertSelective(combinedQuery);
        } else {
            combinedQueryMapper.updateByPrimaryKeySelective(combinedQuery);
        }
    }

    @Override
    public void deleteCombinedQuery(String id) {
        combinedQueryMapper.deleteByPrimaryKey(id);
    }
}
