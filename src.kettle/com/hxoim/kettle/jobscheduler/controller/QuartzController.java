package com.hxoim.kettle.jobscheduler.controller;

import com.hxoim.common.utils.Result;
import com.hxoim.kettle.jobandtrans.service.impl.JobServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @description:Quartz开始、停止相关操作
 * @author 杨波
 * @date:2019-07-29
 */
@RestController
@RequestMapping("/Quartz")
public class QuartzController {
    /**
     * @description:开启quartz
     * @author:杨波
     * @date:2019-07-28 * @param
     * @return:void
     **/
    @RequestMapping("/Start")
    public Result StartQuartz() {

        JobServiceImpl.Instance().StartQuartz();
        return Result.success();
    }

    /**
     * @description:停止quartz
     * @author:杨波
     * @date:2019-07-28 * @param
     * @return:void
     **/
    @RequestMapping("/Stop")
    public Result StopQuartz() {

        JobServiceImpl.Instance().StopQuartz();
        return Result.success();
    }
    /**
     * @description:获取Quartz状态
     * @author:杨波
     * @date:2019-07-29
     *  * @param null
     * @return:状态中文说明
     **/
    @RequestMapping("/Status")
    public Result QuartzStatus(){
        String r = JobServiceImpl.Instance().QuartzStatus();
        return Result.success(r);
    }
}
