package com.hxoim.kettle.logmanager.service.impl;

import com.github.pagehelper.PageInfo;
import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.common.utils.PageUtil;
import com.hxoim.kettle.logmanager.entity.JobLog;
import com.hxoim.kettle.logmanager.entity.JobitemLog;
import com.hxoim.kettle.logmanager.entity.TransstepLog;
import com.hxoim.kettle.logmanager.mapper.JobLogMapper;
import com.hxoim.kettle.logmanager.mapper.JobitemLogMapper;
import com.hxoim.kettle.logmanager.mapper.TransLogMapper;
import com.hxoim.kettle.logmanager.mapper.TransstepLogMapper;
import com.hxoim.kettle.logmanager.service.JobLogService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @desc: 作业日志
 * @author: lijing
 * @date: 2019/7/17
 */
@Service
public class JobLogServiceImpl implements JobLogService {
    @Autowired
    private JobLogMapper jobLogMapper;
    @Autowired
    private JobitemLogMapper jobitemLogMapper;
    @Autowired
    private TransLogMapper transLogMapper;
    @Autowired
    private TransstepLogMapper transstepLogMapper;

    @Override
    public PageInfo<JobLog> jobLogList(String dirID, String name, Integer pageNum, Integer pageSize) {
        Map<String, Object> params = new HashMap<>();
        if (StringUtils.isEmpty(dirID)) {
            throw new ParameterNullException("任务不能为空");
        }
        params.put("idDirectory", dirID);
        params.put("name", name);
        //分页
        PageUtil.pageHelp(pageNum, pageSize);
        List<JobLog> jobLogs = jobLogMapper.jobLogList(params);
        //返回数据
        PageInfo<JobLog> pageInfo = new PageInfo(jobLogs);
        return pageInfo;
    }

    @Override
    public List<JobitemLog> jobLogDestail(Integer idBatch) {
        if (idBatch == null) {
            throw new ParameterNullException("请选择记录");
        }
        List<JobitemLog> jobitemLogs = jobitemLogMapper.jobLogDestail(idBatch);
        return jobitemLogs;
    }

    /**
     * 任务数据统计
     *
     * @param dirID
     * @return
     */
    @Override
    public Map<String, Object> assignmentStatistics(Integer dirID) {
        if (dirID == null) {
            throw new ParameterNullException("任务不能为空");
        }
        Map<String, Object> resultMap = new HashMap<>();
        //近七天日期
        List<String> dateList = getDays(7);
        /**封装读写错误数据封装*/
        //作业数据
        List<Map<String, Object>> jobAssignData = jobitemLogMapper.jobAssignData(dirID);
        //转换数据
        List<Map<String, Object>> transAssignData = transstepLogMapper.transAssignData(dirID);
        //近七天数据
        List<String> jobreadlines = new ArrayList<>();
        List<String> jobwritenlines = new ArrayList<>();
        List<String> jobupdatedlines = new ArrayList<>();
        List<String> jobinputlines = new ArrayList<>();
        List<String> joboutputlines = new ArrayList<>();
        List<String> jobrejectedlines = new ArrayList<>();
        List<String> joberrors = new ArrayList<>();
        List<String> transreadlines = new ArrayList<>();
        List<String> transwritenlines = new ArrayList<>();
        List<String> transupdatedlines = new ArrayList<>();
        List<String> transinputlines = new ArrayList<>();
        List<String> transoutputlines = new ArrayList<>();
        List<String> transrejectedlines = new ArrayList<>();
        List<String> transerrors = new ArrayList<>();
        boolean flag = false;
        for (String date : dateList) {
            //作业提取数据统计
            flag = false;
            for (Map<String, Object> jobAssignMap : jobAssignData) {
                if (!StringUtils.isEmpty(jobAssignMap.get("date") + "") && date.equals(jobAssignMap.get("date"))) {
                    flag = true;
                    jobreadlines.add(StringUtils.isEmpty(jobAssignMap.get("readlines") + "") ? "0" : jobAssignMap.get("readlines") + "");
                    jobwritenlines.add(StringUtils.isEmpty(jobAssignMap.get("writenlines") + "") ? "0" : jobAssignMap.get("writenlines") + "");
                    jobupdatedlines.add(StringUtils.isEmpty(jobAssignMap.get("updatedlines") + "") ? "0" : jobAssignMap.get("updatedlines") + "");
                    jobinputlines.add(StringUtils.isEmpty(jobAssignMap.get("inputlines") + "") ? "0" : jobAssignMap.get("inputlines") + "");
                    joboutputlines.add(StringUtils.isEmpty(jobAssignMap.get("outputlines") + "") ? "0" : jobAssignMap.get("outputlines") + "");
                    jobrejectedlines.add(StringUtils.isEmpty(jobAssignMap.get("rejectedlines") + "") ? "0" : jobAssignMap.get("rejectedlines") + "");
                    joberrors.add(StringUtils.isEmpty(jobAssignMap.get("errors") + "") ? "0" : jobAssignMap.get("errors") + "");
                }
            }
            if (!flag) {
                jobreadlines.add("0");
                jobwritenlines.add("0");
                jobupdatedlines.add("0");
                jobinputlines.add("0");
                joboutputlines.add("0");
                jobrejectedlines.add("0");
                joberrors.add("0");
            }
            //转换提取数据统计
            flag = false;
            for (Map<String, Object> transAssignMap : transAssignData) {
                if (!StringUtils.isEmpty(transAssignMap.get("date") + "") && date.equals(transAssignMap.get("date"))) {
                    flag = true;
                    transreadlines.add(StringUtils.isEmpty(transAssignMap.get("readlines") + "") ? "0" : transAssignMap.get("readlines") + "");
                    transwritenlines.add(StringUtils.isEmpty(transAssignMap.get("writenlines") + "") ? "0" : transAssignMap.get("writenlines") + "");
                    transupdatedlines.add(StringUtils.isEmpty(transAssignMap.get("updatedlines") + "") ? "0" : transAssignMap.get("updatedlines") + "");
                    transinputlines.add(StringUtils.isEmpty(transAssignMap.get("inputlines") + "") ? "0" : transAssignMap.get("inputlines") + "");
                    transoutputlines.add(StringUtils.isEmpty(transAssignMap.get("outputlines") + "") ? "0" : transAssignMap.get("outputlines") + "");
                    transrejectedlines.add(StringUtils.isEmpty(transAssignMap.get("rejectedlines") + "") ? "0" : transAssignMap.get("rejectedlines") + "");
                    transerrors.add(StringUtils.isEmpty(transAssignMap.get("errors") + "") ? "0" : transAssignMap.get("errors") + "");
                }
            }
            if (!flag) {
                transreadlines.add("0");
                transwritenlines.add("0");
                transupdatedlines.add("0");
                transinputlines.add("0");
                transoutputlines.add("0");
                transrejectedlines.add("0");
                transerrors.add("0");
            }
        }

        resultMap.put("dateList", dateList);
        resultMap.put("jobreadlines", jobreadlines);
        resultMap.put("jobwritenlines", jobwritenlines);
        resultMap.put("jobupdatedlines", jobupdatedlines);
        resultMap.put("jobinputlines", jobinputlines);
        resultMap.put("joboutputlines", joboutputlines);
        resultMap.put("jobrejectedlines", jobrejectedlines);
        resultMap.put("joberrors", joberrors);
        resultMap.put("transreadlines", transreadlines);
        resultMap.put("transwritenlines", transwritenlines);
        resultMap.put("transupdatedlines", transupdatedlines);
        resultMap.put("transinputlines", transinputlines);
        resultMap.put("transoutputlines", transoutputlines);
        resultMap.put("transrejectedlines", transrejectedlines);
        resultMap.put("transerrors", transerrors);
        return resultMap;
    }

    @Override
    public Map<String, Object> executeNum(Integer dirID) {
        if (dirID == null) {
            throw new ParameterNullException("任务不能为空");
        }
        Map<String, Object> resultMap = new HashMap<>();
        /**封装执行次数数据*/
        //作业执行次数
        List<Map<String, Object>> jobExecuteNum = jobLogMapper.jobExecuteNum(dirID);
        //转换执行次数
        List<Map<String, Object>> transExecuteNum = transLogMapper.transExecuteNum(dirID);
        //近七天日期
        List<String> dateList = getDays(7);
        //近七天数据
        List<String> jobNumList = new ArrayList<>();
        List<String> transNumList = new ArrayList<>();
        boolean flag = false;
        for (String date : dateList) {
            //作业执行次数
            flag = false;
            for (Map<String, Object> jobExecuteMap : jobExecuteNum) {
                if (!StringUtils.isEmpty(jobExecuteMap.get("date") + "") && date.equals(jobExecuteMap.get("date"))) {
                    flag = true;
                    jobNumList.add(StringUtils.isEmpty(jobExecuteMap.get("num") + "") ? "0" : jobExecuteMap.get("num") + "");
                }
            }
            if (!flag) {
                jobNumList.add("0");
            }
            //转换执行次数
            flag = false;
            for (Map<String, Object> transExecuteMap : transExecuteNum) {
                if (!StringUtils.isEmpty(transExecuteMap.get("date") + "") && date.equals(transExecuteMap.get("date"))) {
                    flag = true;
                    transNumList.add(StringUtils.isEmpty(transExecuteMap.get("num") + "") ? "0" : transExecuteMap.get("num") + "");
                }
            }
            if (!flag) {
                transNumList.add("0");
            }
        }
        resultMap.put("dateList", dateList);
        resultMap.put("jobNumList", jobNumList);
        resultMap.put("transNumList", transNumList);
        return resultMap;
    }

    @Override
    public List<TransstepLog> jobTransLogDestail(Integer idBatch) {
        if (idBatch == null) {
            throw new ParameterNullException("任务不能为空");
        }
        return transstepLogMapper.jobTransLogDestail(idBatch);
    }

    /**
     * 获取过去7天内的日期数组
     *
     * @param intervals intervals天内
     * @return 日期数组
     */
    public static ArrayList<String> getDays(int intervals) {
        ArrayList<String> pastDaysList = new ArrayList<>();
        for (int i = intervals - 1; i >= 0; i--) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - i);
            Date today = calendar.getTime();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String result = format.format(today);
            pastDaysList.add(result);
        }
        return pastDaysList;
    }
}
