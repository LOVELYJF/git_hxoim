package com.hxoim.message.msguser.service;

import com.hxoim.message.msguser.entity.MsgUser;

import java.util.List;
import java.util.Map;

/**
 * @desc: 消息用户service
 * @author: lijing
 * @date: 2019/5/29
 */
public interface MsgUserService {

    /**
     * @desc: 批量插入讨论组用户
     * @author: lijing
     * @param disGroupUsers 讨论组用户
     * @param disGroupId 讨论组ID
     * @date: 2019/5/29
     */
    void insertDisGroupUsers(List<MsgUser> disGroupUsers, String disGroupId);

    /**
     * @desc: 通过讨论组ID删除成员
     * @author: lijing
     * @param disGroupId 讨论组ID
     * @date: 2019/5/30
     */
    void deleteUsersByDisGroupId(String disGroupId);

    /**
     * @desc: 通过讨论组ID查询成员
     * @author: lijing
     * @date: 2019/5/30
     */
    List<MsgUser> selectDisGroupUsers(String disGroupID);

    /**
     * @desc: 批量插入消息用户
     * @author: lijing
     * @param msgUserMap 接收用户 key：标识  value：用户列表
     * @param msgID 消息id
     * @date: 2019/5/30
     */
    void insertMsgUsers(Map<String, List<MsgUser>> msgUserMap, String msgID);

}
