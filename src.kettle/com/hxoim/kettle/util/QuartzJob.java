package com.hxoim.kettle.util;
/*
 * @description:
 * @author 杨波
 * @date:2019-07-28
 */

import org.pentaho.di.core.exception.KettleException;
import org.quartz.*;

public class QuartzJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDetail jobDetail = jobExecutionContext.getJobDetail();
        JobDataMap jobDataMap = jobDetail.getJobDataMap();
        try {
            KettleExecu.getInstance().jobStart(jobDataMap.getString("jobName"),null,
                    jobDataMap.getString("jobDirect"));
        } catch (KettleException e) {
            e.printStackTrace();
        }

    }
}
