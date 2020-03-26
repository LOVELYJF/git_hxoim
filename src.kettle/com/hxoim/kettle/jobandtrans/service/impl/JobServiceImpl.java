package com.hxoim.kettle.jobandtrans.service.impl;
/*
 * @description:从数据库取出定时作业计划，放入quartz定时执行，可以动态往quartz中添加新任务，删除旧作业
 * @author 杨波
 * @date:2019-07-27
 */

import com.hxoim.common.utils.SpringUtil;
import com.hxoim.kettle.directory.entity.Directory;
import com.hxoim.kettle.directory.service.DirectoryService;
import com.hxoim.kettle.directory.service.impl.DirectoryServiceImpl;
import com.hxoim.kettle.jobandtrans.entity.JobWithBLOBs;
import com.hxoim.kettle.jobandtrans.mapper.JobMapper;
import com.hxoim.kettle.jobandtrans.service.JobService;
import com.hxoim.kettle.jobscheduler.entity.KJobscheduler;
import com.hxoim.kettle.jobscheduler.entity.KJobschedulerExample;
import com.hxoim.kettle.jobscheduler.service.KJobschedulerService;
import com.hxoim.kettle.util.QuartzJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private KJobschedulerService jobschedulerService;
    @Autowired
    private DirectoryService directoryService;
    @Autowired
    private JobMapper jobMapper;

    private List<Directory> directories;

    private static JobServiceImpl jobServiceInstance;

    public static JobServiceImpl Instance() {
        if (jobServiceInstance == null) {
            jobServiceInstance = SpringUtil.getBean(JobServiceImpl.class);
        }
        return jobServiceInstance;
    }

    /**
     * @description:从数据库加载所有定时作业
     * @author:杨波
     * @date:2019-07-28 * @param
     * @return:void
     **/
    @Override
    public void loadJob() {

        try {
            //取所有定时计划
            KJobschedulerExample example = new KJobschedulerExample();
            List<KJobscheduler> jobSchedulers = jobschedulerService.selectByExample(example);

            for (KJobscheduler jobScheduler : jobSchedulers
            ) {
                pushJob(jobScheduler);
            }

        } catch (Exception ep) {
            ep.printStackTrace();
        }
    }

    /**
     * @description: 获取作业目录
     * @author:杨波
     * @date:2019-07-28 * @param jobid
     * @return:com.hxoim.kettle.directory.entity.Directory
     **/
    private String getDirectory(long jobid) {

        JobWithBLOBs job = jobMapper.selectByPrimaryKey(jobid);
        if (directories == null) {
            directories = directoryService.selectDirectoryList();
        }
        String path = "/";
        Directory currentDirectory = null;
        for (Directory directory : directories) {
            if (directory.getIdDirectory().equals((long) job.getIdDirectory())) {
                currentDirectory = directory;
                break;
            }
        }
        if (currentDirectory == null) return path;

        while (currentDirectory != null) {
            path = "/"+currentDirectory.getDirectoryName() + path;
            long pId = currentDirectory.getIdDirectoryParent();
            currentDirectory = null;
            for (Directory directory : directories) {
                if (directory.getDirectoryName()!= DirectoryServiceImpl.rootDirectoryName &&
                        directory.getIdDirectory().equals(pId)) {
                    currentDirectory = directory;
                    break;
                }
            }
        }
        return path;
    }

    /**
     * @description:将作业放入quartz
     * @author:杨波
     * @date:2019-07-28 * @param job
     * @return:void
     **/
    private void pushJob(KJobscheduler job) {

        String jobDirect = getDirectory(job.getJobid());
        if (jobDirect == null) return;

        JobKey key = new JobKey(job.getId(), Scheduler.DEFAULT_GROUP);
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("jobName", job.getJobname());
        jobDataMap.put("jobDirect", jobDirect);

        JobDetail jobDetail = JobBuilder.newJob(QuartzJob.class)
                .withIdentity(key)
                .withDescription(job.getJobname())
                .setJobData(jobDataMap).build();

        TriggerKey triggerKey = new TriggerKey(job.getId());
        TriggerBuilder triggerBuilder = TriggerBuilder.newTrigger();
        triggerBuilder.withIdentity(triggerKey);
        //如果作业计划是运行状态才立即开始
        if (job.getStatus() == 1) {
            triggerBuilder.startNow();
        }

        String cron = "%s %s %s %s %s %s";
        cron = String.format(cron, job.getSeconds(), job.getMinutes(), job.getHours(),
                job.getDayofmonth(), job.getMonths(), job.getWeekday());

        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
        triggerBuilder.withSchedule(cronScheduleBuilder);

        CronTrigger trigger = (CronTrigger) triggerBuilder.build();

        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.scheduleJob(jobDetail, trigger);
            if (!scheduler.isShutdown()) {
                scheduler.start();
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void InsertJob(KJobscheduler job) {
        /**
         * @description:将定时计划加入quartz
         * @author:杨波
         * @date:2019-07-28
         *  * @param job
         * @return:void
         **/
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            TriggerKey triggerKey = TriggerKey.triggerKey(job.getId());
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            if (trigger != null) {
                return;
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        pushJob(job);
    }

    @Override
    public void RemoveJob(KJobscheduler job) {
        /**
         * @description:从quartz中移定时作业
         * @author:杨波
         * @date:2019-07-28
         *  * @param job
         * @return:void
         **/
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            TriggerKey triggerKey = TriggerKey.triggerKey(job.getId());
            scheduler.pauseTrigger(triggerKey);
            scheduler.unscheduleJob(triggerKey);
            scheduler.deleteJob(JobKey.jobKey(job.getId()));
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * @description:暂停作业计划
     * @author:杨波
     * @date:2019-07-29 * @param KJobscheduler job
     * @return:
     **/
    @Override
    public void PauseJob(KJobscheduler job) {
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            TriggerKey triggerKey = TriggerKey.triggerKey(job.getId());
            scheduler.pauseTrigger(triggerKey);

            job.setStatus(2);
            jobschedulerService.updateByPrimaryKeySelective(job);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * @description:恢复作业计划
     * @author:杨波
     * @date:2019-07-29 * @param KJobscheduler job
     * @return:
     **/
    @Override
    public void ResumeJob(KJobscheduler job) {
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            TriggerKey triggerKey = TriggerKey.triggerKey(job.getId());
            scheduler.resumeTrigger(triggerKey);

            job.setStatus(1);
            jobschedulerService.updateByPrimaryKeySelective(job);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * @description:执行一次作业计划
     * @author:杨波
     * @date:2019-07-29 * @param KJobscheduler job
     * @return:
     **/
    @Override
    public void TriggerJob(KJobscheduler job) {
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            JobKey jobKey = JobKey.jobKey(job.getId());
            scheduler.triggerJob(jobKey);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void UpdateJob(KJobscheduler job) {
        /**
         * @description:更新quartz中的定时作业
         * @author:杨波
         * @date:2019-07-28
         *  * @param job
         * @return:void
         **/
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            TriggerKey triggerKey = TriggerKey.triggerKey(job.getId());
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            if (trigger == null) {
                pushJob(job);
                return;
            }
            String cron = "%s %s %s %s %s %s";
            cron = String.format(cron, job.getSeconds(), job.getMinutes(), job.getHours(),
                    job.getDayofmonth(), job.getMonths(), job.getWeekday());
            if (trigger.getCronExpression().equals(cron)) return;

            TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
            triggerBuilder.withIdentity(triggerKey);
            triggerBuilder.startNow();
            triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cron));
            trigger = (CronTrigger) triggerBuilder.build();
            scheduler.rescheduleJob(triggerKey, trigger);

            job.setStatus(1);
            jobschedulerService.updateByPrimaryKeySelective(job);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * @description:开启quartz
     * @author:杨波
     * @date:2019-07-28 * @param
     * @return:void
     **/
    @Override
    public void StartQuartz() {

        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * @description:停止quartz
     * @author:杨波
     * @date:2019-07-28 * @param
     * @return:void
     **/
    @Override
    public void StopQuartz() {

        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.shutdown();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * @description:获取Quartz状态
     * @author:杨波
     * @date:2019-07-29 * @param null
     * @return:状态中文说明
     **/
    @Override
    public String QuartzStatus() {
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            if (scheduler.isStarted()) {
                return "运行";
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return "停止";
    }

    /**
     * @description:重新加载定时作业到quartz
     * @author:杨波
     * @date:2019-07-29 * @param null
     * @return:
     **/
    @Override
    public void ReloadJobs() {
        //获取所有定时作业
        KJobschedulerExample example = new KJobschedulerExample();
        List<KJobscheduler> jobSchedulers = jobschedulerService.selectByExample(example);

        List<JobKey> keys = new ArrayList<>();
        List<TriggerKey> triggerKeys = new ArrayList<>();

        //获取所有定时作业的作业键值和触发键值
        for (KJobscheduler jobScheduler : jobSchedulers
        ) {
            JobKey key = new JobKey(jobScheduler.getId(), Scheduler.DEFAULT_GROUP);
            keys.add(key);

            TriggerKey triggerKey = new TriggerKey(jobScheduler.getId());
            triggerKeys.add(triggerKey);
        }

        //先从quartz删除所有定时作业
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            //先暂停所有触发器
            for (TriggerKey triggerKey : triggerKeys
            ) {
                scheduler.pauseTrigger(triggerKey);
            }
            scheduler.unscheduleJobs(triggerKeys);
            scheduler.deleteJobs(keys);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

        //重新将定时作业添加到quartz
        for (KJobscheduler jobScheduler : jobSchedulers
        ) {
            pushJob(jobScheduler);
        }
    }

    /**
     * @description:校验定时作业表达式正确否
     * @author:杨波
     * @date:2019-07-29 * @param null
     * @return:
     **/
    @Override
    public void ValidateCronExpression(String cronExpression) throws ParseException {
        CronExpression expression = new CronExpression(cronExpression);
    }
}
