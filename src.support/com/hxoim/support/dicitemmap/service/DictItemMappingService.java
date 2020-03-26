package com.hxoim.support.dicitemmap.service;

import com.github.pagehelper.PageInfo;
import com.hxoim.support.dicitemmap.entity.DictItemMapping;
import com.hxoim.support.sysdict.entity.SysDict;

import java.util.List;
import java.util.Map;

public interface DictItemMappingService {
    /**
     * 数据共享字典列表
     * @param pageNum
     * @param pageSize
     * @param keyword
     * @return
     */
    PageInfo<SysDict> selectDictMapping(Integer pageNum, Integer pageSize, String keyword, String standard);

    /**
     * 数据共享字典项列表
     * @param keyword
     * @return
     */
    PageInfo<DictItemMapping> selectDictItemMapping(Integer pageNum, Integer pageSize, String keyword, String applicationId, String dicCode);

    /**
     * 数据共享字典项添加或者修改
     * @param dictItemMapping
     */
    void addOrUpdateDictItemMapping(DictItemMapping dictItemMapping);

    /**
     * 数据共享字典项删除
     * @return
     */
    void deleteDictItemMapping(String id);

    /**
     * 查询全部字典
     * @return
     */
    List<SysDict> selectAllDict();

    /**
     * 数据共享字典项所属系统列表
     * @return
     */
    List<Map<String, String>> selectApplicationIds();
}
