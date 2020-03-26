package com.hxoim.message.type.mapper;

import com.hxoim.message.type.entity.Type;
import com.hxoim.message.type.entity.TypeCustom;

import java.util.List;

public interface TypeMapper {
    int deleteByPrimaryKey(String id);

    int insert(Type record);

    int insertSelective(Type record);

    Type selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);

    /**
     * @desc 获取消息分类列表
     * @author  lijing
     * @date  2019/5/27
     */
    List<TypeCustom> getTypeLists(String id);

    /**
     * @desc: 查询所有分类
     * @author: lijing
     * @date: 2019/7/25
     */
    List<Type> selectAllType();
}