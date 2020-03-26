package com.hxoim.kettle.logmanager.service;

import com.github.pagehelper.PageInfo;
import com.hxoim.kettle.logmanager.entity.JobLog;
import com.hxoim.kettle.logmanager.entity.JobitemLog;
import com.hxoim.kettle.logmanager.entity.TransstepLog;

import java.util.List;
import java.util.Map;

public interface JobLogService {
    /**
     * @desc: 作业日志列表
     * @author: lijing
     * @date: 2019/7/18
     */
    PageInfo<JobLog> jobLogList(String dirID, String name, Integer pageNum, Integer pageSize);

    /**
     * @desc: 作业日志列表详情
     * @author: lijing
     * @date: 2019/7/18
     */
    List<JobitemLog> jobLogDestail(Integer idBatch);

    /**
     * 任务数据统计
     * @param dirID
     * @return
     */
    Map<String, Object> assignmentStatistics(Integer dirID);

    /**
     * 任务执行统计
     * @param dirID
     * @return
     */
    Map<String, Object> executeNum(Integer dirID);

    /**
     * 作业执行转换详情
     * @param idBatch
     * @return
     */
    List<TransstepLog> jobTransLogDestail(Integer idBatch);

}
