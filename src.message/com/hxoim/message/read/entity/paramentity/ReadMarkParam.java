package com.hxoim.message.read.entity.paramentity;

import java.util.List;

/**
 * @desc: 消息标记参数bean
 * @author: lijing
 * @date: 2019/6/5
 */
public class ReadMarkParam {
    /**消息ID组*/
    private List<String> msgIds;

    public List<String> getMsgIds() {
        return msgIds;
    }

    public void setMsgIds(List<String> msgIds) {
        this.msgIds = msgIds;
    }
}
