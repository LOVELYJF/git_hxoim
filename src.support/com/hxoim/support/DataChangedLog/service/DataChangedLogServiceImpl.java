package com.hxoim.support.DataChangedLog.service;
/*
 * @description:
 * @author 杨波
 * @date:2019-06-10
 */

import com.github.pagehelper.PageInfo;
import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.common.utils.PageUtil;
import com.hxoim.common.utils.StringUilt;
import com.hxoim.common.utils.UUIDGenerator;
import com.hxoim.support.DataChangedLog.entity.CfDatachangedlog;
import com.hxoim.support.DataChangedLog.entity.CfDatachangedlogExample;
import com.hxoim.support.DataChangedLog.entity.CfDatachangedlogExtend;
import com.hxoim.support.DataChangedLog.mapper.CfDatachangedlogMapper;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service
public class DataChangedLogServiceImpl implements DataChangedLogService {
    @Autowired
    private CfDatachangedlogMapper dclMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return dclMapper.deleteByPrimaryKey(id);
    }

    private void CheckInput(CfDatachangedlog record) {
        if (null == record.getId() || record.getId().isEmpty()) {
            record.setId(UUIDGenerator.getPrimaryKey());
        }
        if (null == record.getOperateDate()) {
            record.setOperateDate(new Date());
        }
        if (null == record.getTableName() || record.getTableName().isEmpty()) {
            throw new ParameterNullException("表名不能为空！");
        }
        if (null == record.getOperatorName() || record.getOperatorName().isEmpty()) {
            throw new ParameterNullException("操作人不能为空！");
        }
        if (null == record.getChangedData() || record.getChangedData().isEmpty()) {
            throw new ParameterNullException("修改数据不能为空！");
        }
    }

    @Override
    public int insert(CfDatachangedlog record) {
        CheckInput(record);
        return dclMapper.insert(record);
    }

    @Override
    public int insertSelective(CfDatachangedlog record) {
        CheckInput(record);
        return dclMapper.insertSelective(record);
    }

    @Override
    public List<CfDatachangedlog> selectByExampleWithBLOBs(CfDatachangedlogExample example) {
        return dclMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public List<CfDatachangedlog> selectByExample(CfDatachangedlogExample example) {
        return dclMapper.selectByExample(example);
    }
    @Override
    public PageInfo<CfDatachangedlog> select(CfDatachangedlogExtend record) throws ParseException {
        CfDatachangedlogExample example=new CfDatachangedlogExample();
        CfDatachangedlogExample.Criteria criteria = example.createCriteria();

        if (StringUilt.stringIsNullOrEmpty(record.getTableName()) == false) {
            criteria.andTableNameLike(record.getTableName());
        }
        if (StringUilt.stringIsNullOrEmpty(record.getTableDesc()) == false) {
            criteria.andTableDescLike(record.getTableDesc());
        }
        if (StringUilt.stringIsNullOrEmpty(record.getIp()) == false) {
            criteria.andIpEqualTo(record.getIp());
        }
        if (StringUilt.stringIsNullOrEmpty(record.getOperatorId()) == false) {
            criteria.andOperatorIdEqualTo(record.getOperatorId());
        }
        if (StringUilt.stringIsNullOrEmpty(record.getOperatorName()) == false) {
            criteria.andOperatorNameEqualTo(record.getOperatorName());
        }

        if (StringUilt.stringIsNullOrEmpty(record.getOperateFrom()) == false) {
            criteria.andOperateDateGreaterThanOrEqualTo(
                    DateUtils.parseDate(record.getOperateFrom().replaceAll("T"," ").substring(0,16), new String[]{"yyyy-MM-dd HH:mm"}));
        }
        if (StringUilt.stringIsNullOrEmpty(record.getOperateTo()) == false) {
            criteria.andOperateDateLessThanOrEqualTo(
                    DateUtils.parseDate(record.getOperateTo().replaceAll("T"," ").substring(0,16), new String[]{"yyyy-MM-dd HH:mm"}));
        }
        example.setOrderByClause("operate_date asc");

        //分页
        PageUtil.pageHelp(record.getPageNum(), record.getPageSize());
        List<CfDatachangedlog> r = dclMapper.selectByExampleWithBLOBs(example);

        //返回数据
        PageInfo<CfDatachangedlog> pageInfo = new PageInfo(r);
        return pageInfo;
    }
    @Override
    public CfDatachangedlog selectByPrimaryKey(String id) {
        return dclMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CfDatachangedlog record) {
        return dclMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(CfDatachangedlog record) {
        return dclMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(CfDatachangedlog record) {
        return dclMapper.updateByPrimaryKey(record);
    }
}
