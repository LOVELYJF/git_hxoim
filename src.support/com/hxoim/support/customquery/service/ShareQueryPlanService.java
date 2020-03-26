package com.hxoim.support.customquery.service;

import com.hxoim.support.customquery.entity.paramentity.SharePlanParam;

import java.util.Map;

public interface ShareQueryPlanService {
    /**
     * @desc: 插入分享
     * @author: lijing
     * @date: 2019/8/10
     */
    void insertShareQuery(SharePlanParam sharePlanParam);

    /**
     * @desc: 分享用户列表
     * @author: lijing
     * @date: 2019/8/12
     */
    Map<String, Object> shareQueryList(String queryPlanId);
}
