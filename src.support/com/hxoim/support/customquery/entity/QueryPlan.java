package com.hxoim.support.customquery.entity;

import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.IdAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;

import java.util.Date;

/**
 * q_query_plan
 */
@TableAnnotation(TableName = "q_query_plan", TableDescription="")
public class QueryPlan {
    /**
     * 唯一标识ID
     */
    @IdAnnotation
    @ColumnAnnotation(FieldName = "id",  FieldDescription="唯一标识ID")
    private String id;

    /**
     * 方案名称
     */
    @ColumnAnnotation(FieldName = "plan_name",  FieldDescription="方案名称")
    private String planName;

    /**
     * 是删除;0--未删除;1--已删除
     */
    @ColumnAnnotation(FieldName = "is_delete",  FieldDescription="是删除;0--未删除;1--已删除")
    private String isDelete;

    /**
     * 创建人
     */
    @ColumnAnnotation(FieldName = "create_userid",  FieldDescription="创建人")
    private String createUserid;

    /**
     * 创建时间
     */
    @ColumnAnnotation(FieldName = "create_time",  FieldDescription="创建时间")
    private Date createTime;

    /**
     * 排序
     */
    @ColumnAnnotation(FieldName = "order_index",  FieldDescription="排序")
    private Long orderIndex;

    /**
     * 更新时间
     */
    @ColumnAnnotation(FieldName = "modify_time",  FieldDescription="更新时间")
    private Date modifyTime;

    /**
     * 修改人
     */
    @ColumnAnnotation(FieldName = "modify_user",  FieldDescription="修改人")
    private String modifyUser;

    public QueryPlan(String id, String planName, String isDelete, String createUserid, Date createTime, Long orderIndex, Date modifyTime, String modifyUser) {
        this.id = id;
        this.planName = planName;
        this.isDelete = isDelete;
        this.createUserid = createUserid;
        this.createTime = createTime;
        this.orderIndex = orderIndex;
        this.modifyTime = modifyTime;
        this.modifyUser = modifyUser;
    }

    public QueryPlan() {
        super();
    }

    /**
     * 唯一标识ID
     * @return id 唯一标识ID
     */
    public String getId() {
        return id;
    }

    /**
     * 唯一标识ID
     * @param id 唯一标识ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 方案名称
     * @return plan_name 方案名称
     */
    public String getPlanName() {
        return planName;
    }

    /**
     * 方案名称
     * @param planName 方案名称
     */
    public void setPlanName(String planName) {
        this.planName = planName == null ? null : planName.trim();
    }

    /**
     * 是删除;0--未删除;1--已删除
     * @return is_delete 是删除;0--未删除;1--已删除
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * 是删除;0--未删除;1--已删除
     * @param isDelete 是删除;0--未删除;1--已删除
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }

    /**
     * 创建人
     * @return create_userid 创建人
     */
    public String getCreateUserid() {
        return createUserid;
    }

    /**
     * 创建人
     * @param createUserid 创建人
     */
    public void setCreateUserid(String createUserid) {
        this.createUserid = createUserid == null ? null : createUserid.trim();
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 排序
     * @return order_index 排序
     */
    public Long getOrderIndex() {
        return orderIndex;
    }

    /**
     * 排序
     * @param orderIndex 排序
     */
    public void setOrderIndex(Long orderIndex) {
        this.orderIndex = orderIndex;
    }

    /**
     * 更新时间
     * @return modify_time 更新时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 更新时间
     * @param modifyTime 更新时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 修改人
     * @return modify_user 修改人
     */
    public String getModifyUser() {
        return modifyUser;
    }

    /**
     * 修改人
     * @param modifyUser 修改人
     */
    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser == null ? null : modifyUser.trim();
    }
}