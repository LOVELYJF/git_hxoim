package com.hxoim.support.dataInterfaceAccess.mapper;

import com.hxoim.support.dataInterfaceAccess.entity.DataInterfaceAccessLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DataInterfaceAccessLogMapper {

    int insertSelective(DataInterfaceAccessLog dataInterfaceAccessLog);

    List<Map<String,Object>> executeSql(@Param("sql")String sql);

}
