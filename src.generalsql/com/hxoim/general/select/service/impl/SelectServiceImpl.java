package com.hxoim.general.select.service.impl;/*
 * @description:
 * @author 杨波
 * @date:2019-06-11
 */

import com.hxoim.general.select.mapper.SelectMapper;
import com.hxoim.general.select.entity.SqlVo;
import com.hxoim.general.select.service.SelectService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedHashMap;
import java.util.List;

public class SelectServiceImpl implements SelectService {
    @Autowired
    private SelectMapper sqlMapper;

    @Override
    public List<LinkedHashMap<String, Object>> select(SqlVo sql) {
        return sqlMapper.select(sql);
    }

    @Override
    public int insert(SqlVo sql) {
        return sqlMapper.insert(sql);
    }

    @Override
    public int update(SqlVo sql) {
        return sqlMapper.update(sql);
    }

    @Override
    public int delete(SqlVo sql) {
        return sqlMapper.delete(sql);
    }
}
