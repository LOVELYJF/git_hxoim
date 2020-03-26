package com.hxoim.support.dicitemmap.mapper;

import com.hxoim.support.dicitemmap.entity.DictItemMapping;

import java.util.List;
import java.util.Map;

public interface DictItemMappingMapper {
    int deleteByPrimaryKey(String id);

    int insert(DictItemMapping record);

    int insertSelective(DictItemMapping record);

    DictItemMapping selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DictItemMapping record);

    int updateByPrimaryKey(DictItemMapping record);

    /**
     * 字典列表
     * @return
     */
    List<DictItemMapping> selectDictMapping(Map<String, Object> params);
    /**
     * 字典项列表
     * @return
     */
    List<DictItemMapping> selectDictItemMapping(Map<String, Object> params);

    /**
     * 数据共享字典项所属系统列表
     * @return
     */
    List<Map<String, String>> selectApplicationIds();
}