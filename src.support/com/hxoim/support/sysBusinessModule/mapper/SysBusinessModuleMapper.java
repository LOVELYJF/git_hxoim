package com.hxoim.support.sysBusinessModule.mapper;

import com.hxoim.common.tree.Tree;
import com.hxoim.support.sysBusinessModule.entity.SysBusinessModule;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysBusinessModuleMapper {
    int deleteByPrimaryKey(String id);

    int insertSelective(SysBusinessModule record);

    SysBusinessModule selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysBusinessModule record);

    List<SysBusinessModule> selectSysBusinessModuleByPid(String pid);

    List<Tree> selectTree(String systemId);

    void updateSortSysBusinessModule(@Param("ids") String[] ids);
}