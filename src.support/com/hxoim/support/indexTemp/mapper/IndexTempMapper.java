package com.hxoim.support.indexTemp.mapper;

import com.hxoim.support.indexTemp.entity.IndexTemp;

import java.util.List;

public interface IndexTempMapper {

    int insertSelective(IndexTemp record);

    int updateSelective(IndexTemp record);

    IndexTemp selectIndexTempById(String id);

    List<IndexTemp> selectIndexTempByOrg(String orgId);

    int deleteIndexTempById(String orgId);

}