package com.hxoim.message.read.entity;

import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.IdAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;

import java.util.Date;
/**
 * m_read
 */
@TableAnnotation(TableName = "m_read", TableDescription="")
public class Read {
    /**
     *
     */
    @IdAnnotation
    @ColumnAnnotation(FieldName = "id",  FieldDescription="")
    private String id;

    /**
     * 处理人
     */
    @ColumnAnnotation(FieldName = "read_user_id",  FieldDescription="处理人")
    private String readUserId;

    /**
     * 消息ID
     */
    @ColumnAnnotation(FieldName = "msg_id",  FieldDescription="消息ID")
    private String msgId;

    /**
     * 阅读时间
     */
    @ColumnAnnotation(FieldName = "read_time",  FieldDescription="阅读时间")
    private Date readTime;

    public Read(String id, String readUserId, String msgId, Date readTime) {
        this.id = id;
        this.readUserId = readUserId;
        this.msgId = msgId;
        this.readTime = readTime;
    }

    public Read() {
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
     * 处理人
     * @return read_user_id 处理人
     */
    public String getReadUserId() {
        return readUserId;
    }

    /**
     * 处理人
     * @param readUserId 处理人
     */
    public void setReadUserId(String readUserId) {
        this.readUserId = readUserId == null ? null : readUserId.trim();
    }

    /**
     * 消息ID
     * @return msg_id 消息ID
     */
    public String getMsgId() {
        return msgId;
    }

    /**
     * 消息ID
     * @param msgId 消息ID
     */
    public void setMsgId(String msgId) {
        this.msgId = msgId == null ? null : msgId.trim();
    }

    /**
     * 阅读时间
     * @return read_time 阅读时间
     */
    public Date getReadTime() {
        return readTime;
    }

    /**
     * 阅读时间
     * @param readTime 阅读时间
     */
    public void setReadTime(Date readTime) {
        this.readTime = readTime;
    }
}