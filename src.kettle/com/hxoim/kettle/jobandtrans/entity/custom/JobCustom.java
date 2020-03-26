package com.hxoim.kettle.jobandtrans.entity.custom;


import com.hxoim.kettle.jobandtrans.entity.Job;

import java.util.Date;

/**
 * @desc: 作业扩展实体类
 * @author: lijing
 * @date: 2019/7/12
 */
public class JobCustom extends Job {
    //成功数
    private Integer successNum;
    //执行过数
    private Integer finishJobNum;
    //最后执行时间
    private Date jobLogDate;
    //作业状态
    private String jobLogStatus;

    public String getJobLogStatus() {
        return jobLogStatus;
    }

    public void setJobLogStatus(String jobLogStatus) {
        this.jobLogStatus = jobLogStatus;
    }

    public Date getJobLogDate() {
        return jobLogDate;
    }

    public void setJobLogDate(Date jobLogDate) {
        this.jobLogDate = jobLogDate;
    }

    public Integer getFinishJobNum() {
        return finishJobNum;
    }

    public Integer getSuccessNum() {
        return successNum;
    }

    public void setSuccessNum(Integer successNum) {
        this.successNum = successNum;
    }

    public void setFinishJobNum(Integer finishJobNum) {
        this.finishJobNum = finishJobNum;
    }
}
