package com.hxoim.kettle.jobandtrans.service;

import com.hxoim.kettle.jobandtrans.entity.custom.JobCustom;
import com.hxoim.kettle.jobandtrans.entity.custom.TransformationCustom;
import com.hxoim.kettle.jobandtrans.entity.paramentity.KettleParam;

import java.util.List;
import java.util.Map;

public interface JobAndTransService {
    /**
     * @desc: 统计作业转换执行情况
     * @author: lijing
     * @date: 2019/7/12
     */
    Map<String, Object> accountJobAndTrans(String dirID);

    /**
     * @desc: 作业列表
     * @author: lijing
     * @date: 2019/7/12
     */
    List<JobCustom> selectJobList(String dirID, String name);

    /**
     * @desc: 转换列表
     * @author: lijing
     * @date: 2019/7/12
     */
    List<TransformationCustom> selectTransList(String dirID, String name);

    /**
     * @desc: 启动转换
     * @author: lijing
     * @date: 2019/7/16
     */
    void transStart(KettleParam kettleParam);

    /**
     * @desc: 停止转换
     * @author: lijing
     * @date: 2019/7/16
     */
    void transStop(KettleParam kettleParam);

    /**
     * @desc: 启动作业
     * @author: lijing
     * @date: 2019/7/16
     */
    void jobStart(KettleParam kettleParam);

    /**
     * @desc: 停止作业
     * @author: lijing
     * @date: 2019/7/16
     */
    void jobStop(KettleParam kettleParam);
}
