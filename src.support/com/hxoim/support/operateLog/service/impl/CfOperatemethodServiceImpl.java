package com.hxoim.support.operateLog.service.impl;

import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.common.utils.StringUilt;
import com.hxoim.support.operateLog.entity.CfOperatemethod;
import com.hxoim.support.operateLog.entity.CfOperatemethodExample;
import com.hxoim.support.operateLog.mapper.CfOperatemethodMapper;
import com.hxoim.support.operateLog.service.CfOperatemethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * @description:操作方式维护
 * @author 杨波
 * @date:2019-08-09
 */
@Service
public class CfOperatemethodServiceImpl implements CfOperatemethodService {
    @Autowired
    private CfOperatemethodMapper mapper;

    /**
     * @description:按主键删除操作方式
     * @author:杨波
     * @date:2019-08-09 * @param String id
     * @return:
     **/
    @Override
    public int deleteByPrimaryKey(String id){
        if(StringUilt.stringIsNullOrEmpty(id))
        {
            throw new ParameterNullException("参数不能为空");
        }
        return mapper.deleteByPrimaryKey(id);
    }

    private void CheckInput(CfOperatemethod record){
        /**
        * @description:检查输入参数
        * @author:杨波
        * @date:2019-08-09
        *  * @param
        * @return:void
        **/
        if(record==null)
        {
            throw new ParameterNullException("参数不能为空");
        }
        if(StringUilt.stringIsNullOrEmpty(record.getName()))
        {
            throw new ParameterNullException("操作方式名称不能为空");
        }
    }
    /**
     * @description:插入操作方式
     * @author:杨波
     * @date:2019-08-09 * @param CfOperatemethod record
     * @return:
     **/

    @Override
    public int insert(CfOperatemethod record){
        CheckInput(record);
        return mapper.insert(record);
    }

    /**
     * @description:插入操作方式
     * @author:杨波
     * @date:2019-08-09 * @param CfOperatemethod record
     * @return:
     **/
    @Override
    public int insertSelective(CfOperatemethod record){
        CheckInput(record);
        return mapper.insertSelective(record);
    }

    /**
     * @description:查询操作方式
     * @author:杨波
     * @date:2019-08-09 * @param CfOperatemethodExample example
     * @return:
     **/
    @Override
    public List<CfOperatemethod> selectByExample(CfOperatemethodExample example){
        return mapper.selectByExample(example);
    }
    /**
     * @description:查询操作方式,根据编号或名字查询
     * @author:杨波
     * @date:2019-08-09 * @param CfOperatemethodExample example
     * @return:
     **/
    @Override
    public List<CfOperatemethod> selectByExample(CfOperatemethod record){
        CfOperatemethodExample example=new CfOperatemethodExample();
        CfOperatemethodExample.Criteria criteria=example.createCriteria();
        if(StringUilt.stringIsNullOrEmpty(record.getCode())==false )
        {
            criteria.andCodeEqualTo(record.getCode());
        }
        if(StringUilt.stringIsNullOrEmpty(record.getName())==false )
        {
            criteria.andNameEqualTo(record.getName());
        }
        example.setOrderByClause("sequence asc");
        List<CfOperatemethod>  r = mapper.selectByExample(example);

        return r;
    }
    /**
     * @description:按主键查询操作方式
     * @author:杨波
     * @date:2019-08-09 * @param String id
     * @return:
     **/
    @Override
    public CfOperatemethod selectByPrimaryKey(String id){
        if(StringUilt.stringIsNullOrEmpty(id))
        {
            throw new ParameterNullException("参数不能为空");
        }
        return mapper.selectByPrimaryKey(id);
    }

    /**
     * @description:更新操作方式
     * @author:杨波
     * @date:2019-08-09 * @param CfOperatemethod record
     * @return:
     **/
    @Override
    public int updateByPrimaryKeySelective(CfOperatemethod record){
        CheckInput(record);
        return mapper.updateByPrimaryKeySelective(record);
    }

    /**
     * @description:更新操作方式
     * @author:杨波
     * @date:2019-08-09 * @param CfOperatemethod record
     * @return:
     **/
    @Override
    public int updateByPrimaryKey(CfOperatemethod record){
        CheckInput(record);
        return mapper.updateByPrimaryKey(record);
    }
}
