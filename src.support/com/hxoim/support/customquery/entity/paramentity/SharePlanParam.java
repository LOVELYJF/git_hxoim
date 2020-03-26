package com.hxoim.support.customquery.entity.paramentity;

import com.hxoim.support.customquery.entity.ShareQueryPlan;

import java.util.List;

/**
 * @desc: 分享方案参数实体类
 * @author: lijing
 * @date: 2019/8/9
 */
public class SharePlanParam {
    //需要分享列表
    private List<ShareQueryPlan> shareQueryPlanList;
    //需要删除的列表
    private List<ShareQueryPlan> shareQueryPlanDeleteList;

    public List<ShareQueryPlan> getShareQueryPlanList() {
        return shareQueryPlanList;
    }

    public void setShareQueryPlanList(List<ShareQueryPlan> shareQueryPlanList) {
        this.shareQueryPlanList = shareQueryPlanList;
    }

    public List<ShareQueryPlan> getShareQueryPlanDeleteList() {
        return shareQueryPlanDeleteList;
    }

    public void setShareQueryPlanDeleteList(List<ShareQueryPlan> shareQueryPlanDeleteList) {
        this.shareQueryPlanDeleteList = shareQueryPlanDeleteList;
    }
}
