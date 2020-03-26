package com.hxoim.support.operateLog.service.impl;
/*
 * @description:
 * @author 杨波
 * @date:2019-08-02
 */

import com.github.pagehelper.PageInfo;
import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.common.utils.*;
import com.hxoim.support.operateLog.entity.CfOperatelog;
import com.hxoim.support.operateLog.entity.CfOperatelogExample;
import com.hxoim.support.operateLog.entity.CfOperatelogExtend;
import com.hxoim.support.operateLog.mapper.CfOperatelogMapper;
import com.hxoim.support.operateLog.service.CfOperatelogService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service
public class CfOperatelogServiceImpl implements CfOperatelogService {
    @Autowired
    private CfOperatelogMapper mapper;

    /**
     * @description: 按主键删除日志
     * @author:杨波
     * @date:2019-08-02 * @param String id
     * @return:
     **/
    @Override
    public int deleteByPrimaryKey(String id){
        if(StringUilt.stringIsNullOrEmpty(id))
        {
            throw new ParameterNullException("日志主键不能为空");
        }
        return mapper.deleteByPrimaryKey(id);
    }

    /**
     * @description:插入操作日志
     * @author:杨波
     * @date:2019-08-02 * @param CfOperatelog record
     * @return:
     **/
    @Override
    public int insert(CfOperatelog record){
        CheckInput(record);
        return mapper.insert(record);
    }

    /**
     * @description:插入操作日志
     * @author:杨波
     * @date:2019-08-02 * @param CfOperatelog record
     * @return:
     **/
    @Override
    public int insertSelective(CfOperatelog record){
        CheckInput(record);
        return mapper.insert(record);
    }

    private void CheckInput(CfOperatelog record) {
        if(record==null)
        {
            throw new ParameterNullException("日志不能为空");
        }
        if(StringUilt.stringIsNullOrEmpty(record.getOperateModel()))
        {
            throw new ParameterNullException("模块不能为空");
        }

        if(record.getOperateType()<=0)
        {
            throw new ParameterNullException("操作类型不对");
        }
        UserInfo userInfo = UserInfoUtil.getUserInfo();
        record.setOperatorId(userInfo.getId());
        record.setOperatorName(userInfo.getUserName());
        record.setId(UUIDGenerator.getPrimaryKey());
        record.setOperateDate(new Date());
        try {
            record.setIp(WebUtil.getIpAddr(DomainObjectUtil.getRequest()));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /**
     * @description:通用查询
     * @author:杨波
     * @date:2019-08-02 * @param null
     * @return:
     **/
    @Override
    public List<CfOperatelog> selectByExample(CfOperatelogExample example){
        return mapper.selectByExample(example);
    }
    /**
     * @description:通用查询,会按模块、操作员、操作日期、IP查询、操作方式组合查询
     * @author:杨波
     * @date:2019-08-02
     * * @param null
     * @return:
     **/
    @Override
    public PageInfo<CfOperatelog> selectByExample(CfOperatelogExtend record) throws ParseException {
        CfOperatelogExample example = new CfOperatelogExample();
        CfOperatelogExample.Criteria criteria = example.createCriteria();

        if (StringUilt.stringIsNullOrEmpty(record.getOperateModel()) == false) {
            criteria.andOperateModelLike(record.getOperateModel()+'%');
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
        if (record.getOperateTypes() != null && record.getOperateTypes().size() > 0) {
            criteria.andOperateTypeIn(record.getOperateTypes());
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
        List<CfOperatelog> r = mapper.selectByExample(example);

        //返回数据
        PageInfo<CfOperatelog> pageInfo = new PageInfo(r);
        return pageInfo;
    }
    /**
     * @description:按主键查询
     * @author:杨波
     * @date:2019-08-02 * @param String id
     * @return:
     **/
    @Override
    public CfOperatelog selectByPrimaryKey(String id){
        if(StringUilt.stringIsNullOrEmpty(id))
        {
            throw new ParameterNullException("日志主键不能为空");
        }
        return mapper.selectByPrimaryKey(id);
    }

    /**
     * @description:修改日志
     * @author:杨波
     * @date:2019-08-02 * @param CfOperatelog record
     * @return:
     **/
    @Override
    public int updateByPrimaryKeySelective(CfOperatelog record){
        CheckInput(record);
        return mapper.updateByPrimaryKeySelective(record);
    }

    /**
     * @description:修改日志
     * @author:杨波
     * @date:2019-08-02 * @param CfOperatelog record
     * @return:
     **/
    @Override
    public int updateByPrimaryKey(CfOperatelog record){
        CheckInput(record);
        return mapper.updateByPrimaryKey(record);
    }
}
