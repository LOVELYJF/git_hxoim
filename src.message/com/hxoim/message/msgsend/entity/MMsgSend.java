package com.hxoim.message.msgsend.entity;

import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.IdAnnotation;
import com.hxoim.common.hxannotation.IgnoreLogAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;
import java.util.Date;

/**
 * m_msg_send
 */
@TableAnnotation(TableName = "m_msg_send", TableDescription="")
public class MMsgSend {
    /**
     * 主键
     */
    @IdAnnotation
    @ColumnAnnotation(FieldName = "id",  FieldDescription="主键")
    private String id;

    /**
     * 消息
     */
    @ColumnAnnotation(FieldName = "msgid",  FieldDescription="消息")
    private String msgid;

    /**
     * 接收者
     */
    @ColumnAnnotation(FieldName = "receive_user_id",  FieldDescription="接收者")
    private String receiveUserId;

    /**
     * 接收用户名
     */
    @ColumnAnnotation(FieldName = "receive_username",  FieldDescription="接收用户名")
    private String receiveUsername;

    /**
     * 发送时间
     */
    @ColumnAnnotation(FieldName = "send_time",  FieldDescription="发送时间")
    private Date sendTime;

    /**
     * 是否已读
     */
    @ColumnAnnotation(FieldName = "isreaded",  FieldDescription="是否已读")
    private Boolean isreaded;

    public MMsgSend(String id, String msgid, String receiveUserId, String receiveUsername, Date sendTime, Boolean isreaded) {
        this.id = id;
        this.msgid = msgid;
        this.receiveUserId = receiveUserId;
        this.receiveUsername = receiveUsername;
        this.sendTime = sendTime;
        this.isreaded = isreaded;
    }

    public MMsgSend() {
        super();
    }

    /**
     * 主键
     * @return id 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 主键
     * @param id 主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 消息
     * @return msgid 消息
     */
    public String getMsgid() {
        return msgid;
    }

    /**
     * 消息
     * @param msgid 消息
     */
    public void setMsgid(String msgid) {
        this.msgid = msgid == null ? null : msgid.trim();
    }

    /**
     * 接收者
     * @return receive_user_id 接收者
     */
    public String getReceiveUserId() {
        return receiveUserId;
    }

    /**
     * 接收者
     * @param receiveUserId 接收者
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
     * 是否已读
     * @return isreaded 是否已读
     */
    public Boolean getIsreaded() {
        return isreaded;
    }

    /**
     * 是否已读
     * @param isreaded 是否已读
     */
    public void setIsreaded(Boolean isreaded) {
        this.isreaded = isreaded;
    }
}