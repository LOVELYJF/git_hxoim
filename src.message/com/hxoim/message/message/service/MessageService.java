package com.hxoim.message.message.service;

import com.github.pagehelper.PageInfo;
import com.hxoim.message.message.entity.Message;
import com.hxoim.message.message.entity.MessageCustom;
import com.hxoim.message.message.entity.paramentity.SelectMsgListParam;
import com.hxoim.message.message.entity.paramentity.SendMessageParam;

/**
 * @desc: 消息service
 * @author: lijing
 * @date: 2019/5/30
 */
public interface MessageService {

    /**
     * @desc: 发送普通消息
     * @author: lijing
     * @param sendMessageParam 消息参数bean
     * @date: 2019/5/30
     */
    void sendMessage(SendMessageParam sendMessageParam) throws IllegalAccessException, InstantiationException, ClassNotFoundException;

    /**
     * @desc: 接收消息列表
     * @author: lijing
     * @param selectMsgListParam 消息列表参数bean
     * @date: 2019/5/31
     */
    PageInfo selectMsgList(SelectMsgListParam selectMsgListParam) throws Exception;

    /**
     * @desc: 批量修改消息置顶状态
     * @author: lijing
     * @param ids 需要修改置顶状态id
     * @param isTop 置顶状态
     * @date: 2019/6/4
     */
    void updateIsTopBatch(String ids, String isTop);

    /**
     * @desc: 处理消息
     * @author: lijing
     * @date: 2019/6/6
     */
    void handleMsg(Message message);

    /**
     * @desc: 设置预计完成时间
     * @author: lijing
     * @date: 2019/6/6
     */
    void setEstimateTime(Message message);

    /**
     * @desc: 通过消息id查询消息详情
     * @author: lijing
     * @param id 消息id
     * @param messageCategory 消息类别 1普通消息 2讨论组
     * @date: 2019/6/10
     */
    MessageCustom selectMsgCustomById(String id, String messageCategory);

    /**
     * @desc: 通过消息id获取消息基本信息
     * @author: lijing
     * @date: 2019/6/10
     */
    Message selectMsgByID(String id);
}
