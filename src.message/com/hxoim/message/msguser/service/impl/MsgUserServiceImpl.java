package com.hxoim.message.msguser.service.impl;

import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.common.utils.Constants;
import com.hxoim.common.utils.UUIDGenerator;
import com.hxoim.message.msguser.entity.MsgUser;
import com.hxoim.message.msguser.mapper.MsgUserMapper;
import com.hxoim.message.msguser.service.MsgUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @desc: 消息用户sevice实现类
 * @author: lijing
 * @date: 2019/5/29
 */
@Service
public class MsgUserServiceImpl implements MsgUserService {

    @Autowired
    private MsgUserMapper msgUserMapper;

    /**
     * @desc: 批量插入讨论组用户
     * @author: lijing
     * @param disGroupUsers 讨论组用户
     * @param disGroupId 讨论组ID
     * @date: 2019/5/29
     */
    @Override
    public void insertDisGroupUsers(List<MsgUser> disGroupUsers, String disGroupId) {
        if (StringUtils.isEmpty(disGroupId)){
            throw new ParameterNullException("讨论组ID为空");
        }
        if (disGroupUsers == null || disGroupUsers.size() == 0){
            throw new ParameterNullException("讨论组成员为空");
        }

        //循环修改成员属性
        for (MsgUser disGroupUser : disGroupUsers) {
            disGroupUser.setDiscussionGroupId(disGroupId);
            disGroupUser.setId(UUIDGenerator.getPrimaryKey());
            disGroupUser.setCreateTime(new Date());
            disGroupUser.setIsDelete(Constants.NOT_DEL);
        }

        int insertDisGroupUser = msgUserMapper.insertMsgUsers(disGroupUsers);
        if (insertDisGroupUser == 0){
            throw new ParameterNullException("插入失败");
        }
    }

    /**
     * @desc: 通过讨论组ID删除成员(伪删除)
     * @author: lijing
     * @date: 2019/5/30
     */
    @Override
    public void deleteUsersByDisGroupId(String disGroupId) {
        if (StringUtils.isEmpty(disGroupId)){
            throw new ParameterNullException("讨论组ID为空");
        }

        int delUsers = msgUserMapper.deleteUsersByDisGroupId(disGroupId, Constants.IS_DEL);
        if (delUsers == 0){
            throw new ParameterNullException("成员删除失败");
        }
    }

    /**
     * @desc: 通过讨论组ID查询成员
     * @author: lijing
     * @date: 2019/5/30
     */
    @Override
    public List<MsgUser> selectDisGroupUsers(String disGroupID) {
        if (StringUtils.isEmpty(disGroupID)){
            throw new ParameterNullException("讨论组ID为空");
        }

        return msgUserMapper.selectDisGroupUsers(disGroupID, Constants.NOT_DEL);
    }

    /**
     * @desc: 批量插入消息用户
     * @author: lijing
     * @param msgUserMap 接收用户 key：标识  value：用户列表
     * @param msgID 消息id
     * @date: 2019/5/30
     */
    @Override
    public void insertMsgUsers(Map<String, List<MsgUser>> msgUserMap, String msgID) {
        if (msgUserMap == null || msgUserMap.size() == 0){
            throw new ParameterNullException("接收用户不能为空");
        }
        if (StringUtils.isEmpty(msgID)){
            throw new ParameterNullException("消息id不能为空");
        }

        //接收用户列表
        List<MsgUser> msgUserslist = new ArrayList<>();
        //设置用户相关属性值
        for (Map.Entry<String, List<MsgUser>> msgUserListEntry : msgUserMap.entrySet()) {
            for (MsgUser msguser : msgUserListEntry.getValue()) {
                msguser.setId(UUIDGenerator.getPrimaryKey());
                msguser.setCreateTime(new Date());
                msguser.setMsgId(msgID);
                msguser.setHandleIdentify(msgUserListEntry.getKey());
                msgUserslist.add(msguser);
            }
        }

        int insertMsgUsers = msgUserMapper.insertMsgUsers(msgUserslist);
        if (insertMsgUsers == 0){
            throw new ParameterNullException("插入失败");
        }
    }
}
