package com.hxoim.support.DataChangedLog.service;
/*
 * @description:
 * @author 杨波
 * @date:2019-06-10
 */

import com.github.pagehelper.PageInfo;
import com.hxoim.support.DataChangedLog.entity.CfDatachangedlog;
import com.hxoim.support.DataChangedLog.entity.CfDatachangedlogExample;
import com.hxoim.support.DataChangedLog.entity.CfDatachangedlogExtend;

import java.text.ParseException;
import java.util.List;

public interface DataChangedLogService {
    int deleteByPrimaryKey(String id);

    int insert(CfDatachangedlog record);

    int insertSelective(CfDatachangedlog record);

    List<CfDatachangedlog> selectByExampleWithBLOBs(CfDatachangedlogExample example);

    List<CfDatachangedlog> selectByExample(CfDatachangedlogExample example);
    PageInfo<CfDatachangedlog> select(CfDatachangedlogExtend record) throws ParseException;
    CfDatachangedlog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CfDatachangedlog record);

    int updateByPrimaryKeyWithBLOBs(CfDatachangedlog record);

    int updateByPrimaryKey(CfDatachangedlog record);
}
