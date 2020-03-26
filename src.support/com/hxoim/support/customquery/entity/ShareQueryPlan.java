package com.hxoim.support.customquery.entity;

import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.IdAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;

/**
 * q_share_queryplan
 */
@TableAnnotation(TableName = "q_share_queryplan", TableDescription="")
public class ShareQueryPlan {
    /**
     * id
     */
    @IdAnnotation
    @ColumnAnnotation(FieldName = "id",  FieldDescription="id")
    private String id;

    /**
     * 方案id
     */
    @ColumnAnnotation(FieldName = "plan_id",  FieldDescription="方案id")
    private String planId;

    /**
     * 用户id
     */
    @ColumnAnnotation(FieldName = "userid",  FieldDescription="用户id")
    private String userid;

    /**
     * 用户名
     */
    @ColumnAnnotation(FieldName = "username",  FieldDescription="用户名")
    private String username;

    public ShareQueryPlan(String id, String planId, String userid, String username) {
        this.id = id;
        this.planId = planId;
        this.userid = userid;
        this.username = username;
    }

    public ShareQueryPlan() {
        super();
    }

    /**
     * id
     * @return id id
     */
    public String getId() {
        return id;
    }

    /**
     * id
     * @param id id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 方案id
     * @return plan_id 方案id
     */
    public String getPlanId() {
        return planId;
    }

    /**
     * 方案id
     * @param planId 方案id
     */
    public void setPlanId(String planId) {
        this.planId = planId == null ? null : planId.trim();
    }

    /**
     * 用户id
     * @return userid 用户id
     */
    public String getUserid() {
        return userid;
    }

    /**
     * 用户id
     * @param userid 用户id
     */
    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    /**
     * 用户名
     * @return username 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 用户名
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
}