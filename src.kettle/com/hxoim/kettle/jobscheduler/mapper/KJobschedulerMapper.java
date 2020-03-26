package com.hxoim.kettle.jobscheduler.mapper;

import com.hxoim.kettle.jobscheduler.entity.KJobscheduler;
import com.hxoim.kettle.jobscheduler.entity.KJobschedulerExample;
import java.util.List;
import java.util.Map;

public interface KJobschedulerMapper {
    int deleteByPrimaryKey(String id);

    int insert(KJobscheduler record);

    int insertSelective(KJobscheduler record);

    List<KJobscheduler> selectByExample(KJobschedulerExample example);

    KJobscheduler selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(KJobscheduler record);

    int updateByPrimaryKey(KJobscheduler record);

    int doubleScheduler(KJobscheduler record);


    /**
     * @desc: 定时任务列表
     * @author: lijing
     * @param params
     * @date: 2019/7/29
     */
    List<KJobscheduler> selectSchedulerList(Map<String, Object> params) ;
}