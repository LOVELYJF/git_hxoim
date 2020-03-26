package com.hxoim.support.sysdict.service.impl;

import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.common.tree.Tree;
import com.hxoim.common.tree.TreeUtil;
import com.hxoim.common.utils.StringUilt;
import com.hxoim.common.utils.UUIDGenerator;
import com.hxoim.common.utils.UserInfoUtil;
import com.hxoim.common.utils.UtilDateTime;
import com.hxoim.support.sysdict.entity.SysDict;
import com.hxoim.support.sysdict.mapper.SysDictItemMapper;
import com.hxoim.support.sysdict.mapper.SysDictMapper;
import com.hxoim.support.sysdict.service.SysDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @description：字典管理service实现类
 * @author ：张乾
 * @createDate ： 2019/5/27 16:22
 */
@Service
public class SysDictServiceImpl implements SysDictService {

    //注入字典管理mapper接口
    @Autowired
    private SysDictMapper sysDictMapper;

    //注入字典映射表信息接口
    @Autowired
    private SysDictItemMapper sysDictItemMapper;

    /**
     * 添加字典管理主表
     */
    @Override
    public void insertSysDict(SysDict sysDict) {
        if (sysDict == null) {
            throw new ParameterNullException("添加内容不能为空");
        }
        selectDictCode(sysDict);
        sysDict.setId(UUIDGenerator.getPrimaryKey());
        sysDict.setTimeStamp(String.valueOf(System.currentTimeMillis()));
        Integer maxOrderIndex = sysDictMapper.selectMAXOrderIndex();
        if (maxOrderIndex == null) {
            maxOrderIndex = Integer.valueOf(1);
            sysDict.setOrderindex(maxOrderIndex);
        } else {
            maxOrderIndex += 1;
            sysDict.setOrderindex(maxOrderIndex);
        }
        sysDictMapper.insertSysDict(sysDict);
    }

    /**
     * 修改字典
     */
    @Override
    public void updateSysDict(SysDict sysDict) {
        if (sysDict == null) {
            throw new ParameterNullException("修改内容不能为空");
        }
        selectDictCode(sysDict);
        sysDict.setModifyTime(new Date());
        sysDict.setModifyUser(UserInfoUtil.getUserInfo().getId());
        sysDictMapper.updateSysDict(sysDict);
    }

    /**
     * 删除字典
     */
    @Override
    @Transactional
    public void deleteSysDict(SysDict sysDict) {
        if (sysDict == null) {
            throw new ParameterNullException("删除内容不能为空");
        }
        //根据前台传过来的Id查询code
        String dictCode = sysDictMapper.seleteSysDictCode(sysDict.getId());
        sysDictMapper.deleteSysDict(dictCode);
        sysDictItemMapper.deleteItemByDictCode(dictCode);
    }

    /**
     * 查询及搜索字典
     */
    @Override
    public List<SysDict> selectAllSysDict() {
        return sysDictMapper.selectAllSysDict();
    }

    /**
     * description:验证dictCode是否唯一
     * create by: 张乾
     * createDate: 2019/5/30 9:01
     */
    @Override
    public void selectDictCode(SysDict sysDict) {
        if (sysDict == null) {
            throw new ParameterNullException("参数不能为空");
        }
        if (StringUilt.stringIsNullOrEmpty(sysDict.getDictCode())) {
            throw new ParameterNullException("字典编码不能为空");
        }
        if (StringUilt.stringIsNullOrEmpty(sysDict.getDictName())) {
            throw new ParameterNullException("字典名称不能为空");
        }
        int count = sysDictMapper.selectDictCode(sysDict);
        if (count > 0) {
            throw new ParameterNullException("该dictCode名称已存在");
        }
    }

    /**
     * @ description: 搜索字典
     * @ create by: 张乾
     * @ createDate: 2019/6/17 17:05
     */
    @Override
    public List<SysDict> selectDict(SysDict sysDict) {
        if (sysDict == null) {
            throw new ParameterNullException("字典不能为空");
        }
        return sysDictMapper.selectDict(sysDict);
    }

    /**
     * @ description: 查询字典树
     * @ create by: 张乾
     * @ createDate: 2019/6/18 11:15
     */
    @Override
    public List<Tree> selectDictTree() {
        return TreeUtil.listToTreeJson(sysDictMapper.selectDictTree());
    }

    /**
     * @ description: 通过code查询字典信息
     * @ create by: 张乾
     * @ createDate: 2019/6/18 16:54
     */
    @Override
    public SysDict selectDictByCode(String dictCode) {
        return sysDictMapper.selectDictByCode(dictCode);
    }
}
