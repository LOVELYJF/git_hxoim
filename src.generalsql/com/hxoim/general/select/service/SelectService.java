package com.hxoim.general.select.service;/*
 * @description:
 * @author 杨波
 * @date:2019-06-11
 */

import com.hxoim.general.select.entity.SqlVo;

import java.util.LinkedHashMap;
import java.util.List;

public interface SelectService {
    List<LinkedHashMap<String, Object>> select(SqlVo sql);
    int insert(SqlVo sql);
    int update(SqlVo sql);
    int delete(SqlVo sql);
}
