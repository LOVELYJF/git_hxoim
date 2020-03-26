package com.hxoim.support.dataServeAuth.mapper;

import com.hxoim.support.dataServeAuth.entity.DataServeAuth;
import com.hxoim.support.dataServeAuth.entity.DataServeAuthVO;

import java.util.List;
import java.util.Map;

public interface DataServeAuthMapper {
    int deleteById(String id);

    int insertSelective(DataServeAuth dataServeAuth);
    
    DataServeAuth selectById(String id);

    int updateSelective(DataServeAuth dataServeAuth);

    List<DataServeAuthVO> selectByServeIdAndInfoResourceId(String serveId);

    List<DataServeAuth> selectByDataInterfaceDefinitionId(String interfaceDefinitionId);

    int deleteByServeId(String serveId);

    DataServeAuthVO selectDataInterfaceByParam(Map<String,String> map);
}