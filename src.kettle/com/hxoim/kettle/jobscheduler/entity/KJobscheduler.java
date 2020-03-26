package com.hxoim.kettle.jobscheduler.entity;

import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.IdAnnotation;
import com.hxoim.common.hxannotation.IgnoreLogAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;

/**
 * k_jobscheduler
 */
@TableAnnotation(TableName = "k_jobscheduler", TableDescription="")
public class KJobscheduler {
    /**
     * 主键
     */
    @IdAnnotation
    @ColumnAnnotation(FieldName = "id",  FieldDescription="主键")
    private String id;

    /**
     * 作业
     */
    @ColumnAnnotation(FieldName = "jobId",  FieldDescription="作业")
    private Long jobid;

    /**
     * 作业名称
     */
    @ColumnAnnotation(FieldName = "jobName",  FieldDescription="作业名称")
    private String jobname;

    /**
     * 是否重复
     */
    @ColumnAnnotation(FieldName = "isRepeat",  FieldDescription="是否重复")
    private String isrepeat;

    /**
     * 定时类型
     */
    @ColumnAnnotation(FieldName = "scheduleType",  FieldDescription="定时类型")
    private Integer scheduletype;

    /**
     * 秒
     */
    @ColumnAnnotation(FieldName = "seconds",  FieldDescription="秒")
    private String seconds;

    /**
     * 分
     */
    @ColumnAnnotation(FieldName = "minutes",  FieldDescription="分")
    private String minutes;

    /**
     * 时
     */
    @ColumnAnnotation(FieldName = "hours",  FieldDescription="时")
    private String hours;

    /**
     * 周几
     */
    @ColumnAnnotation(FieldName = "weekday",  FieldDescription="周几")
    private String weekday;

    /**
     * 每月第几日
     */
    @ColumnAnnotation(FieldName = "dayOfMonth",  FieldDescription="每月第几日")
    private String dayofmonth;

    /**
     * 哪几个月
     */
    @ColumnAnnotation(FieldName = "months",  FieldDescription="哪几个月")
    private String months;

    /**
     * 执行配置
     */
    @ColumnAnnotation(FieldName = "executionConfig",  FieldDescription="执行配置")
    private String executionconfig;

    /**
     * 状态(1、运行，2、暂停，3、停止)
     */
    @ColumnAnnotation(FieldName = "status",  FieldDescription="状态(1、运行，2、暂停，3、停止)")
    private Integer status;

    public KJobscheduler(String id, Long jobid, String jobname, String isrepeat, Integer scheduletype, String seconds, String minutes, String hours, String weekday, String dayofmonth, String months, String executionconfig, Integer status) {
        this.id = id;
        this.jobid = jobid;
        this.jobname = jobname;
        this.isrepeat = isrepeat;
        this.scheduletype = scheduletype;
        this.seconds = seconds;
        this.minutes = minutes;
        this.hours = hours;
        this.weekday = weekday;
        this.dayofmonth = dayofmonth;
        this.months = months;
        this.executionconfig = executionconfig;
        this.status = status;
    }

    public KJobscheduler() {
        super();
    }

    /**
     * 主键
     * @return id 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 主键
     * @param id 主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 作业
     * @return jobId 作业
     */
    public Long getJobid() {
        return jobid;
    }

    /**
     * 作业
     * @param jobid 作业
     */
    public void setJobid(Long jobid) {
        this.jobid = jobid;
    }

    /**
     * 作业名称
     * @return jobName 作业名称
     */
    public String getJobname() {
        return jobname;
    }

    /**
     * 作业名称
     * @param jobname 作业名称
     */
    public void setJobname(String jobname) {
        this.jobname = jobname == null ? null : jobname.trim();
    }

    /**
     * 是否重复
     * @return isRepeat 是否重复
     */
    public String getIsrepeat() {
        return isrepeat;
    }

    /**
     * 是否重复
     * @param isrepeat 是否重复
     */
    public void setIsrepeat(String isrepeat) {
        this.isrepeat = isrepeat;
    }

    /**
     * 定时类型
     * @return scheduleType 定时类型
     */
    public Integer getScheduletype() {
        return scheduletype;
    }

    /**
     * 定时类型
     * @param scheduletype 定时类型
     */
    public void setScheduletype(Integer scheduletype) {
        this.scheduletype = scheduletype;
    }

    /**
     * 秒
     * @return seconds 秒
     */
    public String getSeconds() {
        return seconds;
    }

    /**
     * 秒
     * @param seconds 秒
     */
    public void setSeconds(String seconds) {
        this.seconds = seconds == null ? null : seconds.trim();
    }

    /**
     * 分
     * @return minutes 分
     */
    public String getMinutes() {
        return minutes;
    }

    /**
     * 分
     * @param minutes 分
     */
    public void setMinutes(String minutes) {
        this.minutes = minutes == null ? null : minutes.trim();
    }

    /**
     * 时
     * @return hours 时
     */
    public String getHours() {
        return hours;
    }

    /**
     * 时
     * @param hours 时
     */
    public void setHours(String hours) {
        this.hours = hours == null ? null : hours.trim();
    }

    /**
     * 周几
     * @return weekday 周几
     */
    public String getWeekday() {
        return weekday;
    }

    /**
     * 周几
     * @param weekday 周几
     */
    public void setWeekday(String weekday) {
        this.weekday = weekday == null ? null : weekday.trim();
    }

    /**
     * 每月第几日
     * @return dayOfMonth 每月第几日
     */
    public String getDayofmonth() {
        return dayofmonth;
    }

    /**
     * 每月第几日
     * @param dayofmonth 每月第几日
     */
    public void setDayofmonth(String dayofmonth) {
        this.dayofmonth = dayofmonth == null ? null : dayofmonth.trim();
    }

    /**
     * 哪几个月
     * @return months 哪几个月
     */
    public String getMonths() {
        return months;
    }

    /**
     * 哪几个月
     * @param months 哪几个月
     */
    public void setMonths(String months) {
        this.months = months == null ? null : months.trim();
    }

    /**
     * 执行配置
     * @return executionConfig 执行配置
     */
    public String getExecutionconfig() {
        return executionconfig;
    }

    /**
     * 执行配置
     * @param executionconfig 执行配置
     */
    public void setExecutionconfig(String executionconfig) {
        this.executionconfig = executionconfig == null ? null : executionconfig.trim();
    }

    /**
     * 状态(1、运行，2、暂停，3、停止)
     * @return status 状态(1、运行，2、暂停，3、停止)
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态(1、运行，2、暂停，3、停止)
     * @param status 状态(1、运行，2、暂停，3、停止)
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}