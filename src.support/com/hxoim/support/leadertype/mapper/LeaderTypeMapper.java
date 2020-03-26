package com.hxoim.support.leadertype.mapper;

import com.hxoim.support.inforesource.entity.DataTable;
import com.hxoim.support.leadertype.entity.LeaderTypeInfo;

import java.util.List;

public interface LeaderTypeMapper {
    List<DataTable> selectOrgLeaderTypeInfo(LeaderTypeInfo leaderTypeInfo);
}
