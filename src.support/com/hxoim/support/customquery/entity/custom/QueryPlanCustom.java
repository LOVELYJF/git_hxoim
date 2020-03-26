package com.hxoim.support.customquery.entity.custom;

import com.hxoim.support.customquery.entity.QueryPlanWithBLOBs;

/**
 * @desc: 方案扩展实体类
 * @author: lijing
 * @date: 2019/8/10
 */
public class QueryPlanCustom extends QueryPlanWithBLOBs {
    //被分享用户id
    private String shareUserID;
    //被分享用户名
    private String shareUserName;

    public String getShareUserID() {
        return shareUserID;
    }

    public void setShareUserID(String shareUserID) {
        this.shareUserID = shareUserID;
    }

    public String getShareUserName() {
        return shareUserName;
    }

    public void setShareUserName(String shareUserName) {
        this.shareUserName = shareUserName;
    }
}
