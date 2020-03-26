package com.hxoim.support.errorLog.service.impl;
/*
 * @description:错误日志管理
 * @author 杨波
 * @date:2019-08-13
 */

import com.github.pagehelper.PageInfo;
import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.common.utils.PageUtil;
import com.hxoim.common.utils.StringUilt;
import com.hxoim.common.utils.UUIDGenerator;
import com.hxoim.support.errorLog.entity.CfErrorlog;
import com.hxoim.support.errorLog.entity.CfErrorlogExample;
import com.hxoim.support.errorLog.entity.CfErrorlogExtend;
import com.hxoim.support.errorLog.entity.CfErrorlogWithBLOBs;
import com.hxoim.support.errorLog.mapper.CfErrorlogMapper;
import com.hxoim.support.errorLog.service.CfErrorlogService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service
public class CfErrorlogServiceImpl implements CfErrorlogService {
    @Autowired
    private CfErrorlogMapper mapper;

    /**
     * @description:按主键删除错误日志
     * @author:杨波
     * @date:2019-08-13 * @param String id 错误日志主键
     * @return:
     **/
    @Override
    public int deleteByPrimaryKey(String id) {
        if (StringUilt.stringIsNullOrEmpty(id)) {
            throw new ParameterNullException("参数不能为空");
        }
        return mapper.deleteByPrimaryKey(id);
    }

    private void CheckInput(CfErrorlogWithBLOBs record) {
        if (record == null) {
            throw new ParameterNullException("参数不能为空");
        }
        if (StringUilt.stringIsNullOrEmpty(record.getErrorInfo())) {
            throw new ParameterNullException("错误消息不能为空");
        }
        record.setOccurDate(new Date());
        record.setId(UUIDGenerator.getPrimaryKey());
    }

    /**
     * @description:保存错误日志，包含二进制字段
     * @author:杨波
     * @date:2019-08-13 * @param CfErrorlogWithBLOBs record 要保存的错误日志
     * @return:
     **/
    @Override
    public int insert(CfErrorlogWithBLOBs record) {
        CheckInput(record);
        return mapper.insert(record);
    }

    /**
     * @description:保存错误日志，包含二进制字段
     * @author:杨波
     * @date:2019-08-13 * @param CfErrorlogWithBLOBs record 要保存的错误日志
     * @return:
     **/
    @Override
    public int insertSelective(CfErrorlogWithBLOBs record) {
        CheckInput(record);
        return mapper.insert(record);
    }

    /**
     * @description:按自定义条件查询，同时返回二进制字段
     * @author:杨波
     * @date:2019-08-13 * @param CfErrorlogExample example 自定义查询条件
     * @return:
     **/
    @Override
    public List<CfErrorlogWithBLOBs> selectByExampleWithBLOBs(CfErrorlogExample example) {
        return mapper.selectByExampleWithBLOBs(example);
    }

    /**
     * @description:按自定义条件查询，不返回二进制字段
     * @author:杨波
     * @date:2019-08-13 * @param CfErrorlogExample example 自定义查询条件
     * @return:
     **/
    @Override
    public List<CfErrorlog> selectByExample(CfErrorlogExample example) {
        return mapper.selectByExample(example);
    }
    /**
     * @description:按日期范围和错误消息查询，返回二进制字段
     * @author:杨波
     * @date:2019-08-13
     *  * @param CfErrorlogExtend log 查询条件
     * @return:
     **/
    @Override
    public PageInfo<CfErrorlogWithBLOBs> select(CfErrorlogExtend log) throws ParseException {
        CfErrorlogExample example=new CfErrorlogExample();
        CfErrorlogExample.Criteria criteria=example.createCriteria();
        if(StringUilt.stringIsNullOrEmpty(log.getOperateFrom())==false )
        {
            criteria.andOccurDateGreaterThanOrEqualTo(
                    DateUtils.parseDate(log.getOperateFrom().replaceAll("T"," ").substring(0,16),
                            new String[]{"yyyy-MM-dd HH:mm"}));
        }
        if(StringUilt.stringIsNullOrEmpty(log.getOperateTo())==false )
        {
            criteria.andOccurDateLessThanOrEqualTo(
                    DateUtils.parseDate(log.getOperateTo().replaceAll("T"," ").substring(0,16),
                            new String[]{"yyyy-MM-dd HH:mm"}));
        }
        if(StringUilt.stringIsNullOrEmpty(log.getErrorInfo())==false )
        {
            criteria.andErrorInfoLike("%"+log.getErrorInfo()+"%");
        }

        PageUtil.pageHelp(log.getPageNum(), log.getPageSize());
        List<CfErrorlogWithBLOBs> r = mapper.selectByExampleWithBLOBs(example);
        PageInfo<CfErrorlogWithBLOBs> pageInfo = new PageInfo(r);

        return pageInfo;
    }
    /**
     * @description:按主键查询错误日志
     * @author:杨波
     * @date:2019-08-13 * @param String id 错误日志主键
     * @return:
     **/
    @Override
    public CfErrorlogWithBLOBs selectByPrimaryKey(String id) {
        return selectByPrimaryKey(id);
    }

    }
