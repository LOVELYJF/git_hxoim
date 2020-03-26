package com.hxoim.support.dataInterfaceDefinition.mapper;

import com.hxoim.support.dataInterfaceDefinition.entity.DataInterfaceDefinition;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DataInterfaceDefinitionMapper {
    int deleteById(String id);

    int insertSelective(DataInterfaceDefinition record);

    DataInterfaceDefinition selectById(String id);

    int updateSelective(DataInterfaceDefinition record);

    List<DataInterfaceDefinition> selectByInfoResourceId(String infoResourceId);

    List<DataInterfaceDefinition> selectUndistributedInterface(@Param("infoResourceIds") String infoResourceIds[], @Param("serveId") String serveId);

    List<DataInterfaceDefinition> selectDataInterface();
}