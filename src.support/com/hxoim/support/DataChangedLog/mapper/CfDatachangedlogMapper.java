package com.hxoim.support.DataChangedLog.mapper;

import com.hxoim.support.DataChangedLog.entity.CfDatachangedlog;
import com.hxoim.support.DataChangedLog.entity.CfDatachangedlogExample;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CfDatachangedlogMapper {
    int deleteByPrimaryKey(String id);

    int insert(CfDatachangedlog record);

    int insertSelective(CfDatachangedlog record);

    List<CfDatachangedlog> selectByExampleWithBLOBs(CfDatachangedlogExample example);

    List<CfDatachangedlog> selectByExample(CfDatachangedlogExample example);

    CfDatachangedlog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CfDatachangedlog record);

    int updateByPrimaryKeyWithBLOBs(CfDatachangedlog record);

    int updateByPrimaryKey(CfDatachangedlog record);
}