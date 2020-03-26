package com.hxoim.message.msgsend.controller;

import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.common.utils.Result;
import com.hxoim.common.utils.StringUilt;
import com.hxoim.message.msgsend.entity.MMsgSend;
import com.hxoim.message.msgsend.entity.MMsgSendExample;
import com.hxoim.message.msgsend.service.MsgSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 * @description:后台向用户发送消息的日志
 * @author 杨波
 * @date:2019-07-23
 */
@RestController
@RequestMapping("/MMsgSend")
public class MMsgSendController {
    @Autowired
    private MsgSendService msgSendService;

    /**
     * @description:通过id删除消息发送记录
     * @author:杨波
     * @date:2019-07-23 * @param String id
     * @return:
     **/
    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(String id) {
         msgSendService.deleteByPrimaryKey(id);
         return Result.success();
    }

    /**
     * @description:插入消息发送记录
     * @author:杨波
     * @date:2019-07-23 * @param MMsgSend record
     * @return:
     **/
    @RequestMapping("/insert")
    public Result insert(MMsgSend record) {
        if(StringUilt.stringIsNullOrEmpty(record.getMsgid()))
        {
            throw new ParameterNullException("参数消息不能为空！");
        }
        if(StringUilt.stringIsNullOrEmpty(record.getReceiveUserId()))
        {
            throw new ParameterNullException("参数用户ID不能为空！");
        }
        if(StringUilt.stringIsNullOrEmpty(record.getReceiveUsername()))
        {
            throw new ParameterNullException("参数用户名不能为空！");
        }
        msgSendService.insert(record);
        return Result.success();
    }

    /**
     * @description:查询消息发送记录
     * @author:杨波
     * @date:2019-07-23 * @param MMsgSendExample example
     * @return:
     **/
    @RequestMapping("/select")
    public Result select(String userid) {
        if(StringUilt.stringIsNullOrEmpty(userid))
        {
            throw new ParameterNullException("用户ID参数不能为空！");
        }
        MMsgSendExample example=new MMsgSendExample();
        MMsgSendExample.Criteria criteria=example.createCriteria();
        criteria.andReceiveUserIdEqualTo(userid);
        example.setOrderByClause("send_time asc");
        List<MMsgSend> r = msgSendService.selectByExample(example);
        return Result.success(r);
    }

    /**
     * @description:通过主键查询消息发送记录
     * @author:杨波
     * @date:2019-07-23 * @param String id
     * @return:
     **/
    @RequestMapping("/selectByPrimaryKey")
    public Result selectByPrimaryKey(String id) {
        MMsgSend mMsgSend = msgSendService.selectByPrimaryKey(id);
        return Result.success(mMsgSend);
    }

    /**
     * @description:修改消息发送记录
     * @author:杨波
     * @date:2019-07-23 * @param MMsgSend record
     * @return:
     **/
    @RequestMapping("/updateByPrimaryKey")
    public Result updateByPrimaryKey(MMsgSend record) {
        msgSendService.updateByPrimaryKey(record);
        return Result.success();
    }
}
