package com.hxoim.support.dicitemmap.service.impl;

import com.github.pagehelper.PageInfo;
import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.common.utils.PageUtil;
import com.hxoim.common.utils.UUIDGenerator;
import com.hxoim.support.dicitemmap.entity.DictItemMapping;
import com.hxoim.support.dicitemmap.mapper.DictItemMappingMapper;
import com.hxoim.support.dicitemmap.service.DictItemMappingService;
import com.hxoim.support.sysdict.entity.SysDict;
import com.hxoim.support.sysdict.mapper.SysDictMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @desc: 数据共享字典对应管理
 * @author: lijing
 * @date: 2019/7/23
 */
@Service
public class DictItemMappingServiceImpl implements DictItemMappingService {
    @Autowired
    private DictItemMappingMapper dictItemMappingMapper;
    @Autowired
    private SysDictMapper sysDictMapper;

    @Override
    public PageInfo<SysDict> selectDictMapping(Integer pageNum, Integer pageSize, String keyword, String standard) {
        Map<String, Object> param = new HashMap<>();
        param.put("keyword", keyword);
        param.put("standard", standard);
        //分页
        PageUtil.pageHelp(pageNum, pageSize);
        List<SysDict> sysDicts = sysDictMapper.selectDictList(param);
        //返回数据
        PageInfo<SysDict> pageInfo = new PageInfo(sysDicts);
        return pageInfo;
    }

    @Override
    public PageInfo<DictItemMapping> selectDictItemMapping(Integer pageNum, Integer pageSize, String keyword, String applicationId, String dicCode) {
        Map<String, Object> param = new HashMap<>();
        if (StringUtils.isEmpty(dicCode)){
            throw new ParameterNullException("请选择父级菜单");
        }
        //分页
        PageUtil.pageHelp(pageNum, pageSize);
        param.put("dicItemKeyword", keyword);
        param.put("applicationId", applicationId);
        param.put("dicCode", dicCode);
        List<DictItemMapping> dictItemMappings = dictItemMappingMapper.selectDictItemMapping(param);
        //返回数据
        PageInfo<DictItemMapping> pageInfo = new PageInfo(dictItemMappings);
        return pageInfo;
    }

    @Override
    public void addOrUpdateDictItemMapping(DictItemMapping dictItemMapping) {
        //非空判断
        if (StringUtils.isEmpty(dictItemMapping.getDictCode())){
            throw new ParameterNullException("字典编码不能为空");
        }
        if (StringUtils.isEmpty(dictItemMapping.getItemCode())){
            throw new ParameterNullException("字典项编码不能为空");
        }
        //新增
        if (StringUtils.isEmpty(dictItemMapping.getId())){
            dictItemMapping.setId(UUIDGenerator.getPrimaryKey());
            int insert = dictItemMappingMapper.insertSelective(dictItemMapping);
            if (insert < 1){
                throw new ParameterNullException("添加失败");
            }
        }else{
            int update = dictItemMappingMapper.updateByPrimaryKeySelective(dictItemMapping);
            if (update < 1){
                throw new ParameterNullException("修改失败");
            }
        }
    }

    @Override
    public void deleteDictItemMapping(String id) {
        if (StringUtils.isEmpty(id)){
            throw new ParameterNullException("字典项id不能为空");
        }
        int delete = dictItemMappingMapper.deleteByPrimaryKey(id);
        if (delete < 1){
            throw new ParameterNullException("删除失败");
        }
    }

    @Override
    public List<SysDict> selectAllDict() {
        return sysDictMapper.selectAllSysDict();
    }

    @Override
    public List<Map<String, String>> selectApplicationIds() {
        return dictItemMappingMapper.selectApplicationIds();
    }
}
