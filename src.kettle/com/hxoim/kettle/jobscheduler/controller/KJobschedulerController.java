package com.hxoim.kettle.jobscheduler.controller;
/*
 * @description:
 * @author 杨波
 * @date:2019-07-28
 */

import com.hxoim.common.utils.Result;
import com.hxoim.kettle.jobandtrans.service.impl.JobServiceImpl;
import com.hxoim.kettle.jobscheduler.entity.KJobscheduler;
import com.hxoim.kettle.jobscheduler.entity.KJobschedulerExample;
import com.hxoim.kettle.jobscheduler.service.KJobschedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/KJobscheduler")
public class KJobschedulerController {
    @Autowired
    private KJobschedulerService service;
    /**
     * @description:通过主键删除定时作业
     * @author:杨波
     * @date:2019-07-28
     *  * @param String id 主键
     * @return:
     **/
    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(String id){

        service.deleteByPrimaryKey(id);
        return Result.success();
    }

    /**
     * @description:插入新的定时作业
     * @author:杨波
     * @date:2019-07-28
     *  * @param KJobscheduler record 定时作业
     * @return:
     **/
    @RequestMapping("/insert")
    public Result insert(KJobscheduler record){
         service.insert(record);
        return Result.success();
    }

    /**
     * @description:插入新的定时作业
     * @author:杨波
     * @date:2019-07-28
     *  * @param KJobscheduler record 定时作业
     * @return:
     **/
    @RequestMapping("/insertSelective")
    public Result insertSelective(KJobscheduler record){
        service.insertSelective(record);
        return Result.success();
    }

    /**
     * @description:通过作业主键查询，主键<=0查询所有定时计划
     * @author:杨波
     * @date:2019-07-28
     *  * @param long jobid 作业主键
     * @return:
     **/
    @RequestMapping("/select")
    public Result selectByExample(long jobid){
        KJobschedulerExample example=new KJobschedulerExample();
        KJobschedulerExample.Criteria criteria=example.createCriteria();
        if(jobid>0)
        {
            criteria.andJobidEqualTo(jobid);
        }
        example.setOrderByClause("jobname asc");

        List<KJobscheduler>  r = service.selectByExample(example);
        return Result.success(r);
    }

    /**
     * @description:通过主键获取定时作业
     * @author:杨波
     * @date:2019-07-28
     *  * @param String id 主键
     * @return:
     **/
    @RequestMapping("/selectByPrimaryKey")
    public Result selectByPrimaryKey(String id){
        KJobscheduler r = service.selectByPrimaryKey(id);
        return Result.success(r);
    }

    /**
     * @description:修改定时作业
     * @author:杨波
     * @date:2019-07-28
     *  * @param KJobscheduler record 定时作业
     * @return:
     **/
    @RequestMapping("/updateByPrimaryKeySelective")
    public Result updateByPrimaryKeySelective(KJobscheduler record){
        service.updateByPrimaryKeySelective(record);
        return Result.success();
    }
    /**
     * @description:修改定时作业
     * @author:杨波
     * @date:2019-07-28
     *  * @param KJobscheduler record 定时作业
     * @return:
     **/
    @RequestMapping("/updateByPrimaryKey")
    public Result updateByPrimaryKey(KJobscheduler record){
        service.updateByPrimaryKey(record);
        return Result.success();
    }

    /**
     * @description:同一个作业只能有一个定时计划
     * @author:杨波
     * @date:2019-07-28
     *  * @param KJobscheduler record 定时作业
     * @return:
     **/
    @RequestMapping("/doubleScheduler")
    public Result doubleScheduler(KJobscheduler record){
        service.doubleScheduler(record);
        return Result.success();
    }
    /**
     * @description:暂停作业计划
     * @author:杨波
     * @date:2019-07-29
     *  * @param KJobscheduler job
     * @return:
     **/
    @RequestMapping("/PauseJob")
    public Result PauseJob(KJobscheduler job){
        JobServiceImpl.Instance().PauseJob(job);
        return Result.success();
    }

    /**
     * @description:恢复作业计划
     * @author:杨波
     * @date:2019-07-29
     *  * @param KJobscheduler job
     * @return:
     **/
    @RequestMapping("/ResumeJob")
    public Result ResumeJob(KJobscheduler job){
        JobServiceImpl.Instance().ResumeJob(job);
        return Result.success();
    }

    /**
     * @description:执行一次作业计划
     * @author:杨波
     * @date:2019-07-29
     *  * @param KJobscheduler job
     * @return:
     **/
    @RequestMapping("/TriggerJob")
    public Result TriggerJob(KJobscheduler job){
        JobServiceImpl.Instance().TriggerJob(job);
        return Result.success();
    }
    /**
     * @description:重新加载定时作业到quartz
     * @author:杨波
     * @date:2019-07-29
     *  * @param null
     * @return:
     **/
    @RequestMapping("/ReloadJobs")
    public Result ReloadJobs(){
        JobServiceImpl.Instance().ReloadJobs();
        return Result.success();
    }
    /**
     * @description:校验定时作业表达式正确否
     * @author:杨波
     * @date:2019-07-29
     *  * @param null
     * @return:
     **/
    @RequestMapping("/ValidateCronExpression")
    public Result ValidateCronExpression(String cronExpression) throws ParseException {
        JobServiceImpl.Instance().ValidateCronExpression(cronExpression);
        return Result.success();
    }
    /**
     * @desc: 定时任务列表
     * @author: lijing
     * @date: 2019/7/29
     */
    @RequestMapping("/selectSchedulerList")
    public Result selectSchedulerList(String dirID, String name) {
        List<KJobscheduler> jobschedulers = service.selectSchedulerList(dirID, name);
        return Result.success(jobschedulers);
    }
}
