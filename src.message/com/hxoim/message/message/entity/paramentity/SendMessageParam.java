package com.hxoim.message.message.entity.paramentity;

import com.hxoim.message.discussiongroup.entity.DiscussionGroup;
import com.hxoim.message.message.entity.Message;
import com.hxoim.message.msguser.entity.MsgUser;

import java.util.List;
import java.util.Map;

/**
 * @desc: 发送消息参数bean
 * @author: lijing
 * @date: 2019/6/5
 */
public class SendMessageParam {
    /**消息内容*/
    private Message message;
    /**接收用户   key：类型1个人 2处室 3机构 4讨论组*/
    private Map<String, List<MsgUser>> msgUserMap;
    /**讨论组信息*/
    private DiscussionGroup discussionGroup;

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Map<String, List<MsgUser>> getMsgUserMap() {
        return msgUserMap;
    }

    public void setMsgUserMap(Map<String, List<MsgUser>> msgUserMap) {
        this.msgUserMap = msgUserMap;
    }

    public DiscussionGroup getDiscussionGroup() {
        return discussionGroup;
    }

    public void setDiscussionGroup(DiscussionGroup discussionGroup) {
        this.discussionGroup = discussionGroup;
    }
}
