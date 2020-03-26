package com.hxoim.support.sysdict.service;

import com.hxoim.common.tree.Tree;
import com.hxoim.support.sysdict.entity.SysDictItem;

import java.util.List;
import java.util.Map;

/**
 * @description：字典管理映射service接口
 * @author ：张乾
 * @createDate ： 2019/5/27 16:22
 */
public interface SysDictItemService {

    void insertSysDictItem(SysDictItem sysDictItem);

    void updateSysDictItem(SysDictItem sysDictItem);

    void deleteSysDictItem(SysDictItem sysDictItem);

    void sortByOrderIndex(String ids);

    /**
     * description: 通过父级code查询下级映射信息
     * create by: 张乾
     * createDate: 2019/5/29 16:36
     */
    List<SysDictItem> selectDictItemByPCode(SysDictItem sysDictItem);

    List<Tree> selectItemTree(SysDictItem sysDictItem);

    SysDictItem selectItemAllById(String id);

    List<Tree> selectItemByDictCode(String dictCode);

    /**
     * @desc: 查询字典树
     * @author: lijing
     * @date: 2019/8/8
     */
    List<Map<String,Object>> getDictInfoByDictCode(String dictCode, String itemCode);
}
