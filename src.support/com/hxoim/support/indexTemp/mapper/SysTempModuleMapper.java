package com.hxoim.support.indexTemp.mapper;

import com.hxoim.support.indexTemp.entity.SysTempModule;

public interface SysTempModuleMapper {
    int deleteByPrimaryKey(String tempId);

    int insertSelective(SysTempModule record);

}