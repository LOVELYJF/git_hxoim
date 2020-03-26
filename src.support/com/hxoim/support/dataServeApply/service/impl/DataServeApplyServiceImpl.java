package com.hxoim.support.dataServeApply.service.impl;

import com.hxoim.common.utils.UUIDGenerator;
import com.hxoim.common.utils.UserInfoUtil;
import com.hxoim.support.dataServeApply.entity.DataServeApply;
import com.hxoim.support.dataServeApply.mapper.DataServeApplyMapper;
import com.hxoim.support.dataServeApply.service.DataServeApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class DataServeApplyServiceImpl implements DataServeApplyService {

    @Autowired
    private DataServeApplyMapper dataServeApplyMapper;

    @Override
    public List<DataServeApply> selectDataServeApply(Map<String,String> map) {
        return dataServeApplyMapper.selectDataServeApply(map);
    }

    @Override
    public DataServeApply selectById(String id) {
        return dataServeApplyMapper.selectById(id);
    }

    @Override
    public int insertDataServeApply(DataServeApply dataServeApply) {
        dataServeApply.setId(UUIDGenerator.getPrimaryKey());
        dataServeApply.setModifyUser(UserInfoUtil.getUserInfo().getId());
        dataServeApply.setModifyTime(new Date());
        return dataServeApplyMapper.insertSelective(dataServeApply);
    }

    @Override
    public int updateDataServeApply(DataServeApply dataServeApply) {
        dataServeApply.setModifyUser(UserInfoUtil.getUserInfo().getId());
        dataServeApply.setModifyTime(new Date());
        return dataServeApplyMapper.updateSelective(dataServeApply);
    }

    @Override
    public int deleteDataServeApplyById(String id) {
        return dataServeApplyMapper.deleteById(id);
    }

    @Override
    public List<DataServeApply> selectOtherDataServeApply(String id) {
        return dataServeApplyMapper.selectOtherDataServeApply(id);
    }

    @Override
    public DataServeApply selectValidateByParams(String serveIp, String serveUsername) {
        return dataServeApplyMapper.selectValidateByParams(serveIp,serveUsername);
    }
}
