package com.hxoim.message.message.entity;

import com.hxoim.message.msguser.entity.MsgUser;

import java.util.List;

/**
 * @desc: 消息实体扩展类
 * @author: lijing
 * @date: 2019/5/31
 */
public class MessageCustom extends Message{
    /**消息分类*/
    private String typeName;
    /**讨论组名称*/
    private String discussionGroupName;
    /**接收人列表*/
    private List<MsgUser> msgUserList;

    public String getDiscussionGroupName() {
        return discussionGroupName;
    }

    public void setDiscussionGroupName(String discussionGroupName) {
        this.discussionGroupName = discussionGroupName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<MsgUser> getMsgUserList() {
        return msgUserList;
    }

    public void setMsgUserList(List<MsgUser> msgUserList) {
        this.msgUserList = msgUserList;
    }
}
