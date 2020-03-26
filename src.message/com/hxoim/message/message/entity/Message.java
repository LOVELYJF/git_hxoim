package com.hxoim.message.message.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.IdAnnotation;
import com.hxoim.common.hxannotation.IgnoreLogAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@TableAnnotation(TableName = "m_message", TableDescription="")
public class Message {
    /**
     *
     */
    @IdAnnotation
    @ColumnAnnotation(FieldName = "id",  FieldDescription="")
    private String id;

    /**
     * 发送人
     */
    @ColumnAnnotation(FieldName = "send_user_id",  FieldDescription="发送人")
    private String sendUserId;

    /**
     * 发送用户名
     */
    @ColumnAnnotation(FieldName = "send_username",  FieldDescription="发送用户名")
    private String sendUsername;

    /**
     * 发送时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ColumnAnnotation(FieldName = "send_time",  FieldDescription="发送时间")
    private Date sendTime;

    /**
     * 分类ID
     */
    @ColumnAnnotation(FieldName = "type_id",  FieldDescription="分类ID")
    private String typeId;

    /**
     * 讨论组ID
     */
    @ColumnAnnotation(FieldName = "discussion_group_id",  FieldDescription="讨论组ID")
    private String discussionGroupId;

    /**
     * 类型（1需要处理0不需要处理）
     */
    @ColumnAnnotation(FieldName = "feather",  FieldDescription="类型（1需要处理0不需要处理）")
    private String feather;

    /**
     * 处理标识（1个人2处室3机构4讨论组）
     */
    @ColumnAnnotation(FieldName = "handle_identify",  FieldDescription="处理标识（1个人2处室3机构4讨论组）")
    private String handleIdentify;

    /**
     * 处理人
     */
    @ColumnAnnotation(FieldName = "handle_user_id",  FieldDescription="处理人")
    private String handleUserId;

    /**
     *
     */
    @ColumnAnnotation(FieldName = "handle_username",  FieldDescription="")
    private String handleUsername;

    /**
     * 处理结果
     */
    @ColumnAnnotation(FieldName = "handle_result",  FieldDescription="处理结果")
    private String handleResult;

    /**
     * 预计完成时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ColumnAnnotation(FieldName = "estimate_time",  FieldDescription="预计完成时间")
    private Date estimateTime;

    /**
     * 实际完成时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ColumnAnnotation(FieldName = "finish_time",  FieldDescription="实际完成时间")
    private Date finishTime;

    /**
     * 处理状态（1处理0未处理）
     */
    @ColumnAnnotation(FieldName = "msg_status",  FieldDescription="处理状态（1处理0未处理）")
    private String msgStatus;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ColumnAnnotation(FieldName = "create_time",  FieldDescription="创建时间")
    private Date createTime;

    /**
     * 数据来源系统
     */
    @ColumnAnnotation(FieldName = "data_source",  FieldDescription="数据来源系统")
    private String dataSource;

    /**
     * 异常来源表
     */
    @ColumnAnnotation(FieldName = "exception_table",  FieldDescription="异常来源表")
    private String exceptionTable;

    /**
     * 是否置顶
     */
    @ColumnAnnotation(FieldName = "is_top",  FieldDescription="是否置顶")
    private String isTop;

    /**
     * 消息内容
     */
    @IgnoreLogAnnotation
    @ColumnAnnotation(FieldName = "content",  FieldDescription="消息内容")
    private String content;

    public Message(String id, String sendUserId, String sendUsername, Date sendTime, String typeId, String discussionGroupId, String feather, String handleIdentify, String handleUserId, String handleUsername, String handleResult, Date estimateTime, Date finishTime, String msgStatus, Date createTime, String dataSource, String exceptionTable, String isTop) {
        this.id = id;
        this.sendUserId = sendUserId;
        this.sendUsername = sendUsername;
        this.sendTime = sendTime;
        this.typeId = typeId;
        this.discussionGroupId = discussionGroupId;
        this.feather = feather;
        this.handleIdentify = handleIdentify;
        this.handleUserId = handleUserId;
        this.handleUsername = handleUsername;
        this.handleResult = handleResult;
        this.estimateTime = estimateTime;
        this.finishTime = finishTime;
        this.msgStatus = msgStatus;
        this.createTime = createTime;
        this.dataSource = dataSource;
        this.exceptionTable = exceptionTable;
        this.isTop = isTop;
    }

    public Message(String id, String sendUserId, String sendUsername, Date sendTime, String typeId, String discussionGroupId, String feather, String handleIdentify, String handleUserId, String handleUsername, String handleResult, Date estimateTime, Date finishTime, String msgStatus, Date createTime, String dataSource, String exceptionTable, String isTop, String content) {
        this.id = id;
        this.sendUserId = sendUserId;
        this.sendUsername = sendUsername;
        this.sendTime = sendTime;
        this.typeId = typeId;
        this.discussionGroupId = discussionGroupId;
        this.feather = feather;
        this.handleIdentify = handleIdentify;
        this.handleUserId = handleUserId;
        this.handleUsername = handleUsername;
        this.handleResult = handleResult;
        this.estimateTime = estimateTime;
        this.finishTime = finishTime;
        this.msgStatus = msgStatus;
        this.createTime = createTime;
        this.dataSource = dataSource;
        this.exceptionTable = exceptionTable;
        this.isTop = isTop;
        this.content = content;
    }

    public Message() {
        super();
    }

    /**
     *
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 发送人
     * @return send_user_id 发送人
     */
    public String getSendUserId() {
        return sendUserId;
    }

    /**
     * 发送人
     * @param sendUserId 发送人
     */
    public void setSendUserId(String sendUserId) {
        this.sendUserId = sendUserId == null ? null : sendUserId.trim();
    }

    /**
     * 发送用户名
     * @return send_username 发送用户名
     */
    public String getSendUsername() {
        return sendUsername;
    }

    /**
     * 发送用户名
     * @param sendUsername 发送用户名
     */
    public void setSendUsername(String sendUsername) {
        this.sendUsername = sendUsername == null ? null : sendUsername.trim();
    }

    /**
     * 发送时间
     * @return send_time 发送时间
     */
    public Date getSendTime() {
        return sendTime;
    }

    /**
     * 发送时间
     * @param sendTime 发送时间
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    /**
     * 分类ID
     * @return type_id 分类ID
     */
    public String getTypeId() {
        return typeId;
    }

    /**
     * 分类ID
     * @param typeId 分类ID
     */
    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    /**
     * 讨论组ID
     * @return discussion_group_id 讨论组ID
     */
    public String getDiscussionGroupId() {
        return discussionGroupId;
    }

    /**
     * 讨论组ID
     * @param discussionGroupId 讨论组ID
     */
    public void setDiscussionGroupId(String discussionGroupId) {
        this.discussionGroupId = discussionGroupId == null ? null : discussionGroupId.trim();
    }

    /**
     * 类型（1需要处理0不需要处理）
     * @return feather 类型（1需要处理0不需要处理）
     */
    public String getFeather() {
        return feather;
    }

    /**
     * 类型（1需要处理0不需要处理）
     * @param feather 类型（1需要处理0不需要处理）
     */
    public void setFeather(String feather) {
        this.feather = feather == null ? null : feather.trim();
    }

    /**
     * 处理标识（1个人2处室3机构4讨论组）
     * @return handle_identify 处理标识（1个人2处室3机构4讨论组）
     */
    public String getHandleIdentify() {
        return handleIdentify;
    }

    /**
     * 处理标识（1个人2处室3机构4讨论组）
     * @param handleIdentify 处理标识（1个人2处室3机构4讨论组）
     */
    public void setHandleIdentify(String handleIdentify) {
        this.handleIdentify = handleIdentify == null ? null : handleIdentify.trim();
    }

    /**
     * 处理人
     * @return handle_user_id 处理人
     */
    public String getHandleUserId() {
        return handleUserId;
    }

    /**
     * 处理人
     * @param handleUserId 处理人
     */
    public void setHandleUserId(String handleUserId) {
        this.handleUserId = handleUserId == null ? null : handleUserId.trim();
    }

    /**
     *
     * @return handle_username
     */
    public String getHandleUsername() {
        return handleUsername;
    }

    /**
     *
     * @param handleUsername
     */
    public void setHandleUsername(String handleUsername) {
        this.handleUsername = handleUsername == null ? null : handleUsername.trim();
    }

    /**
     * 处理结果
     * @return handle_result 处理结果
     */
    public String getHandleResult() {
        return handleResult;
    }

    /**
     * 处理结果
     * @param handleResult 处理结果
     */
    public void setHandleResult(String handleResult) {
        this.handleResult = handleResult == null ? null : handleResult.trim();
    }

    /**
     * 预计完成时间
     * @return estimate_time 预计完成时间
     */
    public Date getEstimateTime() {
        return estimateTime;
    }

    /**
     * 预计完成时间
     * @param estimateTime 预计完成时间
     */
    public void setEstimateTime(Date estimateTime) {
        this.estimateTime = estimateTime;
    }

    /**
     * 实际完成时间
     * @return finish_time 实际完成时间
     */
    public Date getFinishTime() {
        return finishTime;
    }

    /**
     * 实际完成时间
     * @param finishTime 实际完成时间
     */
    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    /**
     * 处理状态（1处理0未处理）
     * @return msg_status 处理状态（1处理0未处理）
     */
    public String getMsgStatus() {
        return msgStatus;
    }

    /**
     * 处理状态（1处理0未处理）
     * @param msgStatus 处理状态（1处理0未处理）
     */
    public void setMsgStatus(String msgStatus) {
        this.msgStatus = msgStatus == null ? null : msgStatus.trim();
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
     * 数据来源系统
     * @return data_source 数据来源系统
     */
    public String getDataSource() {
        return dataSource;
    }

    /**
     * 数据来源系统
     * @param dataSource 数据来源系统
     */
    public void setDataSource(String dataSource) {
        this.dataSource = dataSource == null ? null : dataSource.trim();
    }

    /**
     * 异常来源表
     * @return exception_table 异常来源表
     */
    public String getExceptionTable() {
        return exceptionTable;
    }

    /**
     * 异常来源表
     * @param exceptionTable 异常来源表
     */
    public void setExceptionTable(String exceptionTable) {
        this.exceptionTable = exceptionTable == null ? null : exceptionTable.trim();
    }

    /**
     * 是否置顶
     * @return is_top 是否置顶
     */
    public String getIsTop() {
        return isTop;
    }

    /**
     * 是否置顶
     * @param isTop 是否置顶
     */
    public void setIsTop(String isTop) {
        this.isTop = isTop == null ? null : isTop.trim();
    }

    /**
     * 消息内容
     * @return content 消息内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 消息内容
     * @param content 消息内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}