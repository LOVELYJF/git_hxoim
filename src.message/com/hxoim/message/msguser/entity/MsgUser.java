package com.hxoim.message.msguser.entity;

import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.IdAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;

import java.util.Date;

/**
 * m_msg_user
 */
@TableAnnotation(TableName = "m_msg_user", TableDescription="")
public class MsgUser {
    /**
     * 用户消息id
     */
    @IdAnnotation
    @ColumnAnnotation(FieldName = "id",  FieldDescription="用户消息id")
    private String id;

    /**
     * 消息id
     */
    @ColumnAnnotation(FieldName = "msg_id",  FieldDescription="消息id")
    private String msgId;

    /**
     * 讨论组ID
     */
    @ColumnAnnotation(FieldName = "discussion_group_id",  FieldDescription="讨论组ID")
    private String discussionGroupId;

    /**
     * 接收用户id
     */
    @ColumnAnnotation(FieldName = "receive_user_id",  FieldDescription="接收用户id")
    private String receiveUserId;

    /**
     * 接收用户名
     */
    @ColumnAnnotation(FieldName = "receive_username",  FieldDescription="接收用户名")
    private String receiveUsername;

    /**
     * 用户类型（1个人2处室3机构）
     */
    @ColumnAnnotation(FieldName = "handle_identify",  FieldDescription="用户类型（1个人2处室3机构）")
    private String handleIdentify;

    /**
     * 创建时间
     */
    @ColumnAnnotation(FieldName = "create_time",  FieldDescription="创建时间")
    private Date createTime;

    /**
     * 讨论组的人可以移除，移除时只是打标识，否则该人不能查询发送过的历史消息
     */
    @ColumnAnnotation(FieldName = "is_delete",  FieldDescription="讨论组的人可以移除，移除时只是打标识，否则该人不能查询发送过的历史消息")
    private String isDelete;

    public MsgUser(String id, String msgId, String discussionGroupId, String receiveUserId, String receiveUsername, String handleIdentify, Date createTime, String isDelete) {
        this.id = id;
        this.msgId = msgId;
        this.discussionGroupId = discussionGroupId;
        this.receiveUserId = receiveUserId;
        this.receiveUsername = receiveUsername;
        this.handleIdentify = handleIdentify;
        this.createTime = createTime;
        this.isDelete = isDelete;
    }

    public MsgUser() {
        super();
    }

    /**
     * 用户消息id
     * @return id 用户消息id
     */
    public String getId() {
        return id;
    }

    /**
     * 用户消息id
     * @param id 用户消息id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 消息id
     * @return msg_id 消息id
     */
    public String getMsgId() {
        return msgId;
    }

    /**
     * 消息id
     * @param msgId 消息id
     */
    public void setMsgId(String msgId) {
        this.msgId = msgId == null ? null : msgId.trim();
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
     * 接收用户id
     * @return receive_user_id 接收用户id
     */
    public String getReceiveUserId() {
        return receiveUserId;
    }

    /**
     * 接收用户id
     * @param receiveUserId 接收用户id
     */
    public void setReceiveUserId(String receiveUserId) {
        this.receiveUserId = receiveUserId == null ? null : receiveUserId.trim();
    }

    /**
     * 接收用户名
     * @return receive_username 接收用户名
     */
    public String getReceiveUsername() {
        return receiveUsername;
    }

    /**
     * 接收用户名
     * @param receiveUsername 接收用户名
     */
    public void setReceiveUsername(String receiveUsername) {
        this.receiveUsername = receiveUsername == null ? null : receiveUsername.trim();
    }

    /**
     * 用户类型（1个人2处室3机构）
     * @return handle_identify 用户类型（1个人2处室3机构）
     */
    public String getHandleIdentify() {
        return handleIdentify;
    }

    /**
     * 用户类型（1个人2处室3机构）
     * @param handleIdentify 用户类型（1个人2处室3机构）
     */
    public void setHandleIdentify(String handleIdentify) {
        this.handleIdentify = handleIdentify == null ? null : handleIdentify.trim();
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
     * 讨论组的人可以移除，移除时只是打标识，否则该人不能查询发送过的历史消息
     * @return is_delete 讨论组的人可以移除，移除时只是打标识，否则该人不能查询发送过的历史消息
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * 讨论组的人可以移除，移除时只是打标识，否则该人不能查询发送过的历史消息
     * @param isDelete 讨论组的人可以移除，移除时只是打标识，否则该人不能查询发送过的历史消息
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }
}