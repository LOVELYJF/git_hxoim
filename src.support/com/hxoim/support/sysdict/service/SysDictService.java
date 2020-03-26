package com.hxoim.support.sysdict.service;

import com.hxoim.common.tree.Tree;
import com.hxoim.common.utils.Result;
import com.hxoim.support.sysdict.entity.SysDict;
import com.hxoim.support.sysdict.entity.SysDictItem;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @description：字典管理service接口
 * @author ：张乾
 * @createDate ： 2019/5/27 16:22
 */
public interface SysDictService {

    void insertSysDict(SysDict sysDict);

    void  updateSysDict(SysDict sysDict);

    void deleteSysDict(SysDict sysDict);

    /**
     * description:查询及搜索字典管理
     * create by: 张乾
     * createDate: 2019/5/27 16:27
     */
    List<SysDict> selectAllSysDict();

    /**
     * description:验证dictCode是否唯一
     * create by: 张乾
     * createDate: 2019/5/30 9:01
     */
    void selectDictCode(SysDict sysDict);

     List<SysDict> selectDict(SysDict sysDict);

    List<Tree> selectDictTree();

    SysDict selectDictByCode(String dictCode);
}
