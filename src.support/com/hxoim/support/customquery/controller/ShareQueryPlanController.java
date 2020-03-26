package com.hxoim.support.customquery.controller;

import com.hxoim.common.utils.Result;
import com.hxoim.support.customquery.entity.paramentity.SharePlanParam;
import com.hxoim.support.customquery.service.ShareQueryPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @desc: 方案分享
 * @author: lijing
 * @date: 2019/8/10
 */
@RestController
@RequestMapping("/shareQueryPlan")
public class ShareQueryPlanController {
    @Autowired
    private ShareQueryPlanService shareQueryPlanService;

    /**
     * @desc: 插入分享
     * @author: lijing
     * @date: 2019/8/10
     */
    @RequestMapping("/insertShareQuery")
    public Result insertShareQuery(@RequestBody SharePlanParam sharePlanParam){
        shareQueryPlanService.insertShareQuery(sharePlanParam);
        return Result.success();
    }

    /**
     * @desc: 分享用户列表
     * @author: lijing
     * @date: 2019/8/12
     */
    @RequestMapping("/shareQueryList")
    public Result shareQueryList(String queryPlanId){
        Map<String, Object> result = shareQueryPlanService.shareQueryList(queryPlanId);
        return Result.success(result);
    }
}
