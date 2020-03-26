package com.hxoim.kettle.logmanager.controller;

import com.github.pagehelper.PageInfo;
import com.hxoim.common.utils.Result;
import com.hxoim.kettle.logmanager.entity.JobLog;
import com.hxoim.kettle.logmanager.entity.JobitemLog;
import com.hxoim.kettle.logmanager.entity.TransstepLog;
import com.hxoim.kettle.logmanager.service.JobLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @desc: 作业日志
 * @author: lijing
 * @date: 2019/7/17
 */
@RestController
@RequestMapping("/jobLog")
public class JobLogController {
    @Autowired
    private JobLogService jobLogService;

    /**
     * @desc: 作业日志列表
     * @author: lijing
     * @date: 2019/7/12
     */
    @RequestMapping("/jobLogList")
    public Result jobLogList(String dirID, String name, Integer pageNum, Integer pageSize) {
        PageInfo<JobLog> pageInfo = jobLogService.jobLogList(dirID, name, pageNum, pageSize);
        return Result.success(pageInfo);
    }

    /**
     * @desc: 作业日志列表详情
     * @author: lijing
     * @date: 2019/7/12
     */
    @RequestMapping("/jobLogDestail")
    public Result jobLogDestail(Integer idBatch) {
        List<JobitemLog> pageInfo = jobLogService.jobLogDestail(idBatch);
        return Result.success(pageInfo);
    }

    /**
     * @desc: 任务执行统计（统计七天内数据）
     * @author: lijing
     * @date: 2019/7/20
     */
    @RequestMapping("/executeNum")
    public Result executeNum(Integer dirID){
        Map<String, Object> resultMap = jobLogService.executeNum(dirID);
        return Result.success(resultMap);
    }

    /**
     * @desc: 任务数据统计（统计七天内数据）
     * @author: lijing
     * @date: 2019/7/20
     */
    @RequestMapping("/assignmentStatistics")
    public Result assignmentStatistics(Integer dirID){
        Map<String, Object> resultMap = jobLogService.assignmentStatistics(dirID);
        return Result.success(resultMap);
    }

    /**
     * 作业执行转换详情
     * @param idBatch
     * @return
     */
    @RequestMapping("/jobTransLogDestail")
    public Result jobTransLogDestail(Integer idBatch){
        List<TransstepLog> result = jobLogService.jobTransLogDestail(idBatch);
        return Result.success(result);
    }
}
