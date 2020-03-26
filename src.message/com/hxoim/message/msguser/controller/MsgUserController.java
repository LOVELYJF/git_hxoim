package com.hxoim.message.msguser.controller;

import com.hxoim.common.utils.Result;
import com.hxoim.message.msguser.entity.MsgUser;
import com.hxoim.message.msguser.service.MsgUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @desc: 消息用户controller
 * @author: lijing
 * @date: 2019/5/30
 */
@RestController
@RequestMapping("/msgUser")
public class MsgUserController {

    @Autowired
    private MsgUserService msgUserService;

    /**
     * @desc: 通过讨论组id查询成员列表
     * @author: lijing
     * @date: 2019/5/30
     */
    @RequestMapping("/selectDisGroupUsers")
    public Result selectDisGroupUsers(String disGroupId){
        List<MsgUser> msgUsers = msgUserService.selectDisGroupUsers(disGroupId);
        return Result.success(msgUsers);
    }
}
