package com.hxoim.kettle.jobandtrans.mapper;

import com.hxoim.kettle.jobandtrans.entity.Job;
import com.hxoim.kettle.jobandtrans.entity.JobWithBLOBs;
import com.hxoim.kettle.jobandtrans.entity.custom.JobCustom;

import java.util.List;
import java.util.Map;

public interface JobMapper {
    int deleteByPrimaryKey(Long idJob);

    int insert(JobWithBLOBs record);

    int insertSelective(JobWithBLOBs record);

    JobWithBLOBs selectByPrimaryKey(Long idJob);

    int updateByPrimaryKeySelective(JobWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(JobWithBLOBs record);

    int updateByPrimaryKey(Job record);

    /**
     * @desc: 作业数，运行中作业数
     * @author: lijing
     * @date: 2019/7/12
     */
    Map<String, Object> accountJob(Map<String, Object> params);

    /**
     * @desc: 作业列表
     * @author: lijing
     * @date: 2019/7/12
     */
    List<JobCustom> selectJobList(Map<String, Object> params);

    /**
     * @desc: 该作业是否已经启动
     * @author: lijing
     * @date: 2019/7/16
     */
    int selectIsStartJobByName(String jobName);
}