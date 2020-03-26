package com.hxoim.kettle.jobandtrans.service;
/*
 * @description:启动从数据库加载定时任务的作业到quartz
 * @author 杨波
 * @date:2019-07-27
 */

import com.hxoim.kettle.jobscheduler.entity.KJobscheduler;

import java.text.ParseException;

public interface JobService {
    /**
    * @description:加载定时作业到quartz
    * @author:杨波
    * @date:2019-07-27
    *  * @param null
    * @return:
    **/
    void loadJob();

    /**
     * @description:将定时计划加入quartz
     * @author:杨波
     * @date:2019-07-28
     *  * @param job
     * @return:void
     **/
    void InsertJob(KJobscheduler job);

    /**
     * @description:从quartz中移定时作业
     * @author:杨波
     * @date:2019-07-28
     *  * @param job
     * @return:void
     **/
    void RemoveJob(KJobscheduler job);

    /**
    * @description:暂停作业计划
    * @author:杨波
    * @date:2019-07-29
    *  * @param KJobscheduler job
    * @return:
    **/
    void PauseJob(KJobscheduler job);

    /**
    * @description:恢复作业计划
    * @author:杨波
    * @date:2019-07-29
    *  * @param KJobscheduler job
    * @return:
    **/
    void ResumeJob(KJobscheduler job);

    /**
     * @description:更新quartz中的定时作业
     * @author:杨波
     * @date:2019-07-28
     *  * @param job
     * @return:void
     **/
    void UpdateJob(KJobscheduler job);

    /**
     * @description:开启quartz
     * @author:杨波
     * @date:2019-07-28 * @param
     * @return:void
     **/
    void StartQuartz();

    /**
     * @description:停止quartz
     * @author:杨波
     * @date:2019-07-28 * @param
     * @return:void
     **/
    void StopQuartz();

    /**
    * @description:获取Quartz状态
    * @author:杨波
    * @date:2019-07-29
    *  * @param null
    * @return:状态中文说明
    **/
    String QuartzStatus();
    /**
     * @description:执行一次作业计划
     * @author:杨波
     * @date:2019-07-29
     *  * @param KJobscheduler job
     * @return:
     **/
    void TriggerJob(KJobscheduler job);

    /**
    * @description:重新加载定时作业到quartz
    * @author:杨波
    * @date:2019-07-29
    *  * @param null
    * @return:
    **/
    void ReloadJobs();

    /**
    * @description:校验定时作业表达式正确否
    * @author:杨波
    * @date:2019-07-29
    *  * @param null
    * @return:
    **/
    void ValidateCronExpression(String cronExpression) throws ParseException;
}
