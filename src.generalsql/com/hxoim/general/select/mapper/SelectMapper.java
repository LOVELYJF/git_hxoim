package com.hxoim.general.select.mapper;
/*
 * @description:直接执行SQL语句的接口
 * @author 杨波
 * @date:2019-06-05
 */

import com.hxoim.general.select.entity.SqlVo;
import com.hxoim.common.tree.Tree;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;

@Repository
public interface SelectMapper {
    List<LinkedHashMap<String, Object>> select(SqlVo sql);
    int insert(SqlVo sql);
    int update(SqlVo sql);
    int delete(SqlVo sql);
    List<Tree> selectTree(SqlVo sql);
}
