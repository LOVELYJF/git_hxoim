package com.hxoim.kettle.jobandtrans.service.impl;

import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.kettle.jobandtrans.entity.custom.JobCustom;
import com.hxoim.kettle.jobandtrans.entity.custom.TransformationCustom;
import com.hxoim.kettle.jobandtrans.entity.paramentity.KettleParam;
import com.hxoim.kettle.jobandtrans.mapper.JobMapper;
import com.hxoim.kettle.jobandtrans.mapper.TransformationMapper;
import com.hxoim.kettle.jobandtrans.service.JobAndTransService;
import com.hxoim.kettle.util.KettleExecu;
import org.apache.commons.lang3.StringUtils;
import org.pentaho.di.core.exception.KettleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @desc: 作业，转换service
 * @author: lijing
 * @date: 2019/7/12
 */
@Service
public class JobAndTransServiceImpl implements JobAndTransService {

    @Autowired
    private JobMapper jobMapper;
    @Autowired
    private TransformationMapper transformationMapper;
    /**kettle服务*/
    private KettleExecu kettleExecu = KettleExecu.getInstance();

    /**
     * @desc: 统计作业转换执行情况
     * @author: lijing
     * @date: 2019/7/12
     */
    @Override
    public Map<String, Object> accountJobAndTrans(String dirID) {
        if (StringUtils.isEmpty(dirID)){
            throw new ParameterNullException("所选任务不能为空");
        }
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> params = new HashMap<>();
        params.put("idDirectory", dirID);
        //作业数，运行中作业数
        Map<String, Object> jobMap = jobMapper.accountJob(params);
        //转换数，运行中转换数
        Map<String, Object> transMap = transformationMapper.accountTrans(params);
        map.putAll(jobMap);
        map.putAll(transMap);
        return map;
    }

    @Override
    public List<JobCustom> selectJobList(String dirID, String name) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("idDirectory", dirID);
        return jobMapper.selectJobList(params);
    }

    @Override
    public List<TransformationCustom> selectTransList(String dirID, String name) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("idDirectory", dirID);
        return transformationMapper.selectTransList(params);
    }

    /**
     * 启动转换
     * @param kettleParam
     */
    @Override
    public void transStart(KettleParam kettleParam) {
        try {
            if (StringUtils.isEmpty(kettleParam.getName())){
                throw new ParameterNullException("转换名称不能为空");
            }
            if (StringUtils.isEmpty(kettleParam.getDir())){
                throw new ParameterNullException("转换所在目录不能为空");
            }
            //查询转换是否启动
            int isStart = transformationMapper.selectIsStartTranByName(kettleParam.getName());
            if (isStart > 0){
                throw new ParameterNullException("该转换已经启动");
            }
            kettleExecu.transStart(kettleParam.getName(), kettleParam.getTransParam().split(","), kettleParam.getDir());
        } catch (KettleException e) {
            throw new ParameterNullException("启动失败");
        }
    }

    /**
     * 停止转换
     * @param kettleParam
     */
    @Override
    public void transStop(KettleParam kettleParam) {
        try {
            if (StringUtils.isEmpty(kettleParam.getName())){
                throw new ParameterNullException("转换名称不能为空");
            }
            //查询作业是否启动
            int isStart = transformationMapper.selectIsStartTranByName(kettleParam.getName());
            if (isStart == 0){
                throw new ParameterNullException("未启动或已执行完成");
            }
            kettleExecu.transStop(kettleParam.getName());
        } catch (KettleException e) {
            throw new ParameterNullException("停止失败");
        }
    }

    /**
     * 启动作业
     * @param kettleParam
     */
    @Override
    public void jobStart(KettleParam kettleParam) {
        try {
            if (StringUtils.isEmpty(kettleParam.getName())){
                throw new ParameterNullException("作业名称不能为空");
            }
            if (StringUtils.isEmpty(kettleParam.getDir())){
                throw new ParameterNullException("作业所在目录不能为空");
            }
            //查询作业是否启动
            int isStart = jobMapper.selectIsStartJobByName(kettleParam.getName());
            if (isStart > 0){
                throw new ParameterNullException("该作业已经启动");
            }
            kettleExecu.jobStart(kettleParam.getName(), kettleParam.getJobParam(), kettleParam.getDir());
        } catch (KettleException e) {
            throw new ParameterNullException("启动失败");
        }
    }

    /**
     * 停止作业
     * @param kettleParam
     */
    @Override
    public void jobStop(KettleParam kettleParam) {
        try {
            if (StringUtils.isEmpty(kettleParam.getName())){
                throw new ParameterNullException("作业名称不能为空");
            }
            //查询作业是否启动
            int isStart = jobMapper.selectIsStartJobByName(kettleParam.getName());
            if (isStart == 0){
                throw new ParameterNullException("未启动或已执行完成");
            }
            kettleExecu.jobStop(kettleParam.getName());
        } catch (KettleException e) {
            throw new ParameterNullException("停止失败");
        }
    }
}
