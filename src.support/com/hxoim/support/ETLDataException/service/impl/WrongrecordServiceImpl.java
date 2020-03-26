package com.hxoim.support.ETLDataException.service.impl;
/*
 * @description:数据异常日志
 * @author 杨波
 * @date:2019-07-17
 */

import com.hxoim.common.SQLMapper.DynamicDataSource;
import com.hxoim.support.ETLDataException.entity.Wrongrecord;
import com.hxoim.support.ETLDataException.entity.WrongrecordExample;
import com.hxoim.support.ETLDataException.mapper.WrongrecordMapper;
import com.hxoim.support.ETLDataException.service.WrongrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WrongrecordServiceImpl implements WrongrecordService {
    @Autowired
    private WrongrecordMapper mapper = null;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        DynamicDataSource.setCustomerType(DynamicDataSource.predbDataSource);
        int result = mapper.deleteByPrimaryKey(id);
        DynamicDataSource.clearCustomerType();
        return result;
    }

    @Override
    public int insert(Wrongrecord record) {
        DynamicDataSource.setCustomerType(DynamicDataSource.predbDataSource);
        int result = mapper.insert(record);
        DynamicDataSource.clearCustomerType();
        return result;
    }

    @Override
    public int insertSelective(Wrongrecord record) {
        DynamicDataSource.setCustomerType(DynamicDataSource.predbDataSource);
        int result = mapper.insertSelective(record);
        DynamicDataSource.clearCustomerType();
        return result;
    }

    @Override
    public List<Wrongrecord> selectByExampleWithBLOBs(WrongrecordExample example) {
        DynamicDataSource.setCustomerType(DynamicDataSource.predbDataSource);
        List<Wrongrecord> result = mapper.selectByExampleWithBLOBs(example);
        DynamicDataSource.clearCustomerType();
        return result;
    }

    @Override
    public List<Wrongrecord> selectByExample(WrongrecordExample example) {
        DynamicDataSource.setCustomerType(DynamicDataSource.predbDataSource);
        List<Wrongrecord> result =
                mapper.selectByExample(example);
        DynamicDataSource.clearCustomerType();
        return result;
    }

    @Override
    public Wrongrecord selectByPrimaryKey(Integer id) {

        DynamicDataSource.setCustomerType(DynamicDataSource.predbDataSource);
        Wrongrecord result = mapper.selectByPrimaryKey(id);
        DynamicDataSource.clearCustomerType();
        return result;
    }

    @Override
    public int updateByPrimaryKeySelective(Wrongrecord record) {

        DynamicDataSource.setCustomerType(DynamicDataSource.predbDataSource);
        int result = mapper.updateByPrimaryKeySelective(record);
        DynamicDataSource.clearCustomerType();
        return result;
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(Wrongrecord record) {
        DynamicDataSource.setCustomerType(DynamicDataSource.predbDataSource);
        int result = mapper.updateByPrimaryKeyWithBLOBs(record);
        DynamicDataSource.clearCustomerType();
        return result;
    }

    @Override
    public int updateByPrimaryKey(Wrongrecord record) {
        DynamicDataSource.setCustomerType(DynamicDataSource.predbDataSource);
        int result = mapper.updateByPrimaryKey(record);
        DynamicDataSource.clearCustomerType();
        return result;
    }

}
