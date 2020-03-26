package com.hxoim.support.sysdict.mapper;

import com.hxoim.common.tree.Tree;
import com.hxoim.support.sysdict.entity.SysDict;

import java.util.List;
import java.util.Map;

/**
 * @description：字典管理Mapper接口
 * @author ：张乾
 * @createDate ： 2019/5/27 16:22
 */
public interface SysDictMapper {

    void insertSysDict(SysDict sysDict);

    /**
     * description:查询排序字段最大值
     * create by: 张乾
     * createDate: 2019/5/27 16:41
     */
    Integer selectMAXOrderIndex();

    void updateSysDict(SysDict sysDict);

    void deleteSysDict(String dictCode);

    /**
     * description:查询和搜索字典管理列表
     * create by: 张乾
     * createDate: 2019/5/27 16:45
     */
    List<SysDict> selectAllSysDict();

    /**
     * description:通过id查询code
     * create by: 张乾
     * createDate: 2019/5/27 16:46
     */
    String seleteSysDictCode(String dictId);

    /**
     * description:验证dictCode是否唯一
     * create by: 张乾
     * createDate: 2019/5/30 9:01
     */
    int selectDictCode(SysDict sysDict);

    String selectSysDictName(String dictCode);

    List<SysDict> selectDict(SysDict sysDict);

    List<Tree> selectDictTree();

    SysDict selectDictByCode(String dictCode);

    /**
     * 查询字典列表（带搜索）
     * @param params
     * @return
     */
    List<SysDict> selectDictList(Map<String, Object> params);
}
