package com.hxoim.message.message.controller;

import com.github.pagehelper.PageInfo;
import com.hxoim.common.utils.Result;
import com.hxoim.message.message.entity.Message;
import com.hxoim.message.message.entity.MessageCustom;
import com.hxoim.message.message.entity.paramentity.SelectMsgListParam;
import com.hxoim.message.message.entity.paramentity.SendMessageParam;
import com.hxoim.message.message.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc: 消息controller
 * @author: lijing
 * @date: 2019/6/1
 */
@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    /**
     * @desc: 发送消息
     * @author: lijing
     * @date: 2019/7/25
     */
    @RequestMapping("/sendMessage")
    public Result sendMessage(@RequestBody SendMessageParam sendMessageParam){
        try {
            messageService.sendMessage(sendMessageParam);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return Result.error("发送失败");
        } catch (InstantiationException e) {
            e.printStackTrace();
            return Result.success("发送失败");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return Result.success("发送失败");
        }
        return Result.success();
    }

    /**
     * @desc: 消息列表
     * @author: lijing
     * @param selectMsgListParam 消息列表参数bean
     * @date: 2019/5/31
     */
    @RequestMapping("/selectMsgList")
    public Result selectMsgList(SelectMsgListParam selectMsgListParam) throws Exception{
        PageInfo<MessageCustom> pageInfo = messageService.selectMsgList(selectMsgListParam);
        return Result.success(pageInfo);
    }

    /**
     * @desc: 消息置顶状态修改
     * @author: lijing
     * @date: 2019/6/4
     */
    @RequestMapping("/updateTopMsg")
    public Result updateTopMsg(String ids, String isTop){
        messageService.updateIsTopBatch(ids, isTop);
        return Result.success();
    }

    /**
     * @desc: 处理消息
     * @author: lijing
     * @date: 2019/6/6
     */
    @RequestMapping("/handleMsg")
    public Result handleMsg(Message message){
        messageService.handleMsg(message);
        return Result.success();
    }

    /**
     * @desc: 设置预计完成时间
     * @author: lijing
     * @date: 2019/6/6
     */
    @RequestMapping("/setEstimateTime")
    public Result setEstimateTime(Message message){
        messageService.setEstimateTime(message);
        return Result.success();
    }

    /**
     * @desc: 通过消息id查询消息详情
     * @author: lijing
     * @param id 消息id
     * @param messageCategory 消息类别 1普通消息 2讨论组
     * @date: 2019/6/10
     */
    @RequestMapping("/selectMsgCustomById")
    public Result selectMsgCustomById(String id, String messageCategory){
        MessageCustom messageCustom = messageService.selectMsgCustomById(id, messageCategory);
        return Result.success(messageCustom);
    }

    /**
     * @desc: 通过消息id获取消息基本信息
     * @author: lijing
     * @date: 2019/6/10
     */
    @RequestMapping("/selectMsgByID")
    public Result selectMsgByID(String id){
        Message message = messageService.selectMsgByID(id);
        return Result.success(message);
    }
}
