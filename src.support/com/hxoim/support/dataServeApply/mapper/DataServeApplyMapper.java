package com.hxoim.support.dataServeApply.mapper;

import com.hxoim.support.dataServeApply.entity.DataServeApply;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DataServeApplyMapper {
    int deleteById(String id);

    int insertSelective(DataServeApply record);

    DataServeApply selectById(String id);

    int updateSelective(DataServeApply record);

    List<DataServeApply> selectDataServeApply(Map<String,String> map);

    List<DataServeApply> selectOtherDataServeApply(String id);

    DataServeApply selectValidateByParams(@Param("serveIp") String serveIp, @Param("serveUsername") String serveUsername);
}