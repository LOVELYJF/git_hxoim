package com.hxoim.kettle.logmanager.mapper;

import com.hxoim.kettle.logmanager.entity.JobLog;

import java.util.List;
import java.util.Map;

public interface JobLogMapper {
    int insert(JobLog record);

    int insertSelective(JobLog record);

    /**
     * @desc: 作业日志列表
     * @author: lijing
     * @date: 2019/7/18
     */
    List<JobLog> jobLogList(Map<String, Object> params);

    /**
     * 作业执行次数
     * @param idDirectory
     * @return
     */
    List<Map<String, Object>> jobExecuteNum(Integer idDirectory);
}