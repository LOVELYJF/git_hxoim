package com.hxoim.support.decisionAnalysis.entity;

import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.IdAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;

@TableAnnotation(TableName = "sys_decision_analysis", TableDescription="")
public class DecisionAnalysis {

    /**
     * id
     */
    @IdAnnotation
    @ColumnAnnotation(FieldName = "id", FieldDescription = "id")
    private String id;

    /**
     * 父id
     */
    @IdAnnotation
    @ColumnAnnotation(FieldName = "pid", FieldDescription = "父id")
    private String pid;

    /**
     * 决策分析名称
     */
    @IdAnnotation
    @ColumnAnnotation(FieldName = "node_name", FieldDescription = "决策分析名称")
    private String nodeName;

    /**
     * 排序
     */
    @IdAnnotation
    @ColumnAnnotation(FieldName = "order_index", FieldDescription = "排序")
    private int orderIndex;

    /**
     * 数据库语句
     */
    @IdAnnotation
    @ColumnAnnotation(FieldName = "da_sql", FieldDescription = "数据库语句")
    private String daSql;

    /**
     * 存储信息
     */
    @IdAnnotation
    @ColumnAnnotation(FieldName = "json", FieldDescription = "存储信息")
    private String json;

    /**
     * 修改人
     */
    @IdAnnotation
    @ColumnAnnotation(FieldName = "modify_user", FieldDescription = "修改人")
    private String modifyUser;

    /**
     * 修改时间
     */
    @IdAnnotation
    @ColumnAnnotation(FieldName = "modify_time", FieldDescription = "修改时间")
    private String modifyTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public int getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(int orderIndex) {
        this.orderIndex = orderIndex;
    }

    public String getDaSql() {
        return daSql;
    }

    public void setDaSql(String daSql) {
        this.daSql = daSql;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }
}
