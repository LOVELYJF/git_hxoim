package com.hxoim.kettle.logmanager.mapper;

import com.hxoim.kettle.logmanager.entity.JobitemLog;

import java.util.List;
import java.util.Map;

public interface JobitemLogMapper {
    int insert(JobitemLog record);

    int insertSelective(JobitemLog record);

    /**
     * @desc: 作业日志列表详情
     * @author: lijing
     * @date: 2019/7/18
     */
    List<JobitemLog> jobLogDestail(Integer idBatch);
    /**
     * 作业提取数据统计
     * @param idDirectory
     * @return
     */
    List<Map<String, Object>> jobAssignData(Integer idDirectory);
}