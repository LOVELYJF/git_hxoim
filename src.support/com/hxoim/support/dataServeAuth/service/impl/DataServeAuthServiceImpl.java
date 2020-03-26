package com.hxoim.support.dataServeAuth.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hxoim.common.utils.UUIDGenerator;
import com.hxoim.common.utils.UserInfoUtil;
import com.hxoim.support.dataServeAuth.entity.DataServeAuth;
import com.hxoim.support.dataServeAuth.entity.DataServeAuthVO;
import com.hxoim.support.dataServeAuth.mapper.DataServeAuthMapper;
import com.hxoim.support.dataServeAuth.service.DataServeAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DataServeAuthServiceImpl implements DataServeAuthService {
    @Autowired
    private DataServeAuthMapper dataServeAuthMapper;

    @Override
    public List<DataServeAuthVO> selectByServeIdAndInfoResourceId(String serveId) {
        return dataServeAuthMapper.selectByServeIdAndInfoResourceId(serveId);
    }

    @Override
    public List<DataServeAuth> selectByDataInterfaceDefinitionId(String interfaceDefinitionId) {
        return dataServeAuthMapper.selectByDataInterfaceDefinitionId(interfaceDefinitionId);
    }

    @Override
    public DataServeAuth selectDataServeAuthById(String id) {
        return dataServeAuthMapper.selectById(id);
    }

    @Override
    public int insertDataServeAuth(DataServeAuth dataServeAuth) {
        dataServeAuth.setId(UUIDGenerator.getPrimaryKey());
        dataServeAuth.setModifyUser(UserInfoUtil.getUserInfo().getId());
        dataServeAuth.setModifyTime(new Date());
        return dataServeAuthMapper.insertSelective(dataServeAuth);
    }

    @Override
    public int deleteById(String id) {
        return dataServeAuthMapper.deleteById(id);
    }

    @Override
    public void insertBatchDataServeAuth(String params) {
        //{a:[1,2,3,4],b:[{k1:v1,k2:v2},{k3:v3,k4:v4},{k5:v5,k6:v6}]}
        JSONObject jsonObject =JSONObject.parseObject(params);
        JSONArray serveArray =jsonObject.getJSONArray("serveIds");
        JSONArray interfaceArray =jsonObject.getJSONArray("serveAuth");
        String authDesc = jsonObject.getString("authDesc");
        for(int i=0;i<serveArray.size();i++){
            String serveId= serveArray.getString(i);
            dataServeAuthMapper.deleteByServeId(serveId);
            for(int j=0;j<interfaceArray.size();j++){
                JSONObject interfaceObj =interfaceArray.getJSONObject(j);
                String infoResourceId = interfaceObj.getString("infoResourceId");
                String interfaceDefinitionId = interfaceObj.getString("interfaceDefinitionId");
                DataServeAuth dataServeAuth =  new DataServeAuth();
                dataServeAuth.setId(UUIDGenerator.getPrimaryKey());
                dataServeAuth.setServeId(serveId);
                dataServeAuth.setInfoResourceId(infoResourceId);
                dataServeAuth.setInterfaceDefinitionId(interfaceDefinitionId);
                dataServeAuth.setAuthDesc(authDesc);
                dataServeAuth.setModifyUser(UserInfoUtil.getUserInfo().getId());
                dataServeAuth.setModifyTime(new Date());
                dataServeAuthMapper.insertSelective(dataServeAuth);
            }
        }


    }

}
