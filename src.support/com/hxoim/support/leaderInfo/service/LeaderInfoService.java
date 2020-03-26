package com.hxoim.support.leaderInfo.service;

import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface LeaderInfoService {

    //根据id查询返回数据
    Map<String,Object> selectBasicInfo(Integer pageNum, Integer pageSize, String orgId);

    //查询数据信息集
    List<Map<String,Object>> selectLeaderInfoData(String tablecode, String id);
}
