package com.hxoim.message.message.service.impl;

import com.github.pagehelper.PageInfo;
import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.common.utils.*;
import com.hxoim.message.discussiongroup.entity.DiscussionGroup;
import com.hxoim.message.discussiongroup.service.DiscussionGroupService;
import com.hxoim.message.message.entity.Message;
import com.hxoim.message.message.entity.MessageCustom;
import com.hxoim.message.message.entity.paramentity.SelectMsgListParam;
import com.hxoim.message.message.entity.paramentity.SendMessageParam;
import com.hxoim.message.message.mapper.MessageMapper;
import com.hxoim.message.message.service.MessageService;
import com.hxoim.message.msguser.entity.MsgUser;
import com.hxoim.message.msguser.service.MsgUserService;
import com.hxoim.message.read.entity.Read;
import com.hxoim.message.read.entity.paramentity.ReadMarkParam;
import com.hxoim.message.read.service.ReadService;
import com.hxoim.message.websocket.WebSocketManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @desc: 消息模块实现层
 * @author: lijing
 * @date: 2019/5/31
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private WebSocketManager webSocketManager;
    @Autowired
    private DiscussionGroupService discussionGroupService;
    @Autowired
    private MsgUserService msgUserService;
    @Autowired
    private ReadService readService;

    /**
     * @desc: 发送普通消息，并推送到客户端
     * @author: lijing
     * @param sendMessageParam 消息参数bean
     * @date: 2019/6/11
     */
    @Override
    @Transactional(rollbackFor=Exception.class)
    public void sendMessage(SendMessageParam sendMessageParam) {
        //接收用户
        Map<String, List<MsgUser>> msgUserMap = sendMessageParam.getMsgUserMap();
        //消息
        Message message = sendMessageParam.getMessage();
        if (msgUserMap == null || msgUserMap.size() == 0){
            throw new ParameterNullException("接收用户为空");
        }
        if (StringUtils.isEmpty(message.getContent())){
            throw new ParameterNullException("接收内容为空");
        }

        //讨论组
        if (msgUserMap.get(Constants.DISCUSSIONGROUP) != null && msgUserMap.get(Constants.DISCUSSIONGROUP).size() != 0){
            if (sendMessageParam.getDiscussionGroup() == null){
                throw new ParameterNullException("讨论组为空");
            }
            DiscussionGroup discussionGroup = sendMessageParam.getDiscussionGroup();
            List<MsgUser> msgUsers = msgUserMap.get(Constants.DISCUSSIONGROUP);
            //添加讨论组
            if (StringUtils.isEmpty(discussionGroup.getId())){
                String discusGroupId = discussionGroupService.insertDisGroup(discussionGroup, msgUsers);
                discussionGroup.setId(discusGroupId);
            }
            /**添加消息*/
            //讨论组id
            message.setDiscussionGroupId(discussionGroup.getId());
            //处理标识
            message.setHandleIdentify(Constants.DISCUSSIONGROUP);
            //设置消息基本信息
            setMessageInfo(message);
            int insertMsg = messageMapper.insert(message);
            if (insertMsg == 0){
                throw new ParameterNullException("发送失败");
            }
        }else{     //普通消息
            //添加消息
            if (msgUserMap.get(Constants.ORGANIZATION) != null && msgUserMap.get(Constants.ORGANIZATION).size() > 0){
                //机构
                message.setHandleIdentify(Constants.ORGANIZATION);
            }else if (msgUserMap.get(Constants.DEPARTMENT) != null && msgUserMap.get(Constants.DEPARTMENT).size() > 0){
                //处室
                message.setHandleIdentify(Constants.DEPARTMENT);
            }else if (msgUserMap.get(Constants.PERSONAL) != null && msgUserMap.get(Constants.PERSONAL).size() > 0){
                //个人
                message.setHandleIdentify(Constants.PERSONAL);
            }
            //设置消息基本信息
            setMessageInfo(message);
            int insertMsg = messageMapper.insert(message);
            if (insertMsg == 0){
                throw new ParameterNullException("发送失败");
            }
            //接收人添加
            msgUserService.insertMsgUsers(msgUserMap, message.getId());

            //向客户端推送消息
            webSocketManager.push(sendMessageParam);
        }
    }

    /**
     * @desc: 消息信息初始化
     * @author: lijing
     * @date: 2019/6/11
     */
    public void setMessageInfo(Message message){
        //当前登录用户
        UserInfo userInfo = null;
        try {
            userInfo = UserInfoUtil.getUserInfo();
        }
        catch (Exception ep)
        {}
        //杨波 考虑到系统自动发送的消息是没有发送人的，所在多加一个处理
        if (userInfo == null && StringUilt.stringIsNullOrEmpty(message.getSendUsername()) ){
            throw new ParameterNullException("没有设置发送用户！");
        }
        //发送者没有设置发送用户信息时才自动添加
        if (userInfo != null&& StringUilt.stringIsNullOrEmpty(message.getSendUsername())) {
            message.setMsgStatus(Constants.NOT_HANDLE_MESSAGE);
            message.setCreateTime(new Date());
            message.setSendTime(new Date());
            message.setIsTop(Constants.NOT_TOP);
            message.setSendUserId(userInfo.getId());
            message.setSendUsername(userInfo.getName());
            message.setId(UUIDGenerator.getPrimaryKey());
        }
    }

    /**
     * @desc: 消息列表
     * @author: lijing
     * @param selectMsgListParam 消息列表参数bean
     * @date: 2019/5/31
     */
    @Override
    public PageInfo selectMsgList(SelectMsgListParam selectMsgListParam) throws Exception{
        //当前登录用户
        UserInfo user = UserInfoUtil.getUserInfo();
        if (user == null){
            throw new ParameterNullException("用户信息获取失败");
        }

        //参数集合
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userId", user.getId());
        paramMap.put("msgStatus", selectMsgListParam.getHandleStatus());
        if (StringUtils.isNotEmpty(selectMsgListParam.getTypeId())){
            paramMap.put("typeId", selectMsgListParam.getTypeId());
        }
        if (StringUtils.isNotEmpty(selectMsgListParam.getStartTime())){
            paramMap.put("startTime", selectMsgListParam.getStartTime());
        }
        if (StringUtils.isNotEmpty(selectMsgListParam.getEndTime())){
            paramMap.put("endTime", selectMsgListParam.getEndTime());
        }
        if (StringUtils.isNotEmpty(selectMsgListParam.getMessageCategory())){
            paramMap.put("messageCategory", selectMsgListParam.getMessageCategory());
        }
        if (StringUtils.isNotEmpty(selectMsgListParam.getHandleStatus())){
            paramMap.put("handleStatus", selectMsgListParam.getHandleStatus());
        }
        // TODO  用户所属机构，处室消息
        paramMap.put("orgId", "");
        paramMap.put("departmentId", "");

        //分页
        PageUtil.pageHelp(selectMsgListParam.getPageNum(), selectMsgListParam.getPageSize());

        //请求列表
        List<MessageCustom> messageCustoms = null;

        if (Constants.SEND.equals(selectMsgListParam.getReceiveOrSend())){
            //已发送消息列表
            messageCustoms = messageMapper.selectSendMsgList(paramMap);
        }else if (Constants.RECEIVE.equals(selectMsgListParam.getReceiveOrSend())){
            if (Constants.GENERAL_MESSAGE.equals(selectMsgListParam.getMessageCategory())){
                //普通接收消息列表
                messageCustoms = messageMapper.selectReceMsgList(paramMap);
            }else if (Constants.DISCUSSION_MESSAGE.equals(selectMsgListParam.getMessageCategory())){
                //讨论组接收消息列表
                messageCustoms = messageMapper.selectDisGroupReceMsgList(paramMap);
            }else{
                throw new ParameterNullException("参数错误");
            }
        }else{
            throw new ParameterNullException("参数错误");
        }
        //返回数据
        PageInfo<MessageCustom> pageInfo = new PageInfo(messageCustoms);
        return pageInfo;
    }

    /**
     * @desc: 批量修改消息置顶状态
     * @author: lijing
     * @param ids 需要修改置顶状态id
     * @param isTop 置顶状态
     * @date: 2019/6/4
     */
    @Override
    public void updateIsTopBatch(String ids, String isTop){
        if (StringUtils.isEmpty(ids)){
            throw new ParameterNullException("操作数据为空");
        }
        if (StringUtils.isEmpty(isTop)){
            throw new ParameterNullException("置顶状态为空");
        }

        //请求参数
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("ids", ids);
        paramMap.put("isTop", isTop);

        int updateIsTop = messageMapper.updateIsTopBatch(paramMap);
        if (updateIsTop == 0){
            throw new ParameterNullException("操作失败");
        }
    }

    /**
     * @desc: 处理消息
     * @author: lijing
     * @date: 2019/6/6
     */
    @Override
    public void handleMsg(Message message) {
        if (StringUtils.isEmpty(message.getId())){
            throw new ParameterNullException("消息Id为空");
        }
        if (StringUtils.isEmpty(message.getHandleResult())){
            throw new ParameterNullException("处理结果为空");
        }
        //当前登录用户
        UserInfo userInfo = UserInfoUtil.getUserInfo();
        if (userInfo == null){
            throw new ParameterNullException("用户信息获取失败");
        }

        //设置消息信息
        message.setHandleUserId(userInfo.getId());
        message.setHandleUsername(userInfo.getName());
        message.setFinishTime(new Date());
        message.setMsgStatus(Constants.HISTORY_MESSAGE);

        //处理
        int handleMsg = messageMapper.updateByPrimaryKeySelective(message);
        if (handleMsg == 0){
            throw new ParameterNullException("处理失败");
        }
        //处理消息自动添加已读信息
        ReadMarkParam read=new ReadMarkParam();
        List<String> ids=new ArrayList<>();
        ids.add(message.getId());
        read.setMsgIds(ids);
        try {
            readService.readingMark(read);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @desc: 设置预计完成时间
     * @author: lijing
     * @date: 2019/6/6
     */
    @Override
    public void setEstimateTime(Message message) {
        if (StringUtils.isEmpty(message.getId())){
            throw new ParameterNullException("消息Id为空");
        }
        if (message.getEstimateTime() == null){
            throw new ParameterNullException("预计完成时间为空");
        }

        //设置预计完成时间
        int setEstimateTime = messageMapper.updateByPrimaryKeySelective(message);
        if (setEstimateTime == 0){
            throw new ParameterNullException("处理失败");
        }
    }

    /**
     * @desc: 通过消息id查询消息详情
     * @author: lijing
     * @param id 消息id
     * @param messageCategory 消息类别 1普通消息 2讨论组
     * @date: 2019/6/10
     */
    @Override
    public MessageCustom selectMsgCustomById(String id, String messageCategory) {
        if (StringUtils.isEmpty(id)){
            throw new ParameterNullException("消息id为空");
        }
        if (StringUtils.isEmpty(messageCategory)){
            throw new ParameterNullException("消息类别为空");
        }
        //参数集合
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        paramMap.put("messageCategory", messageCategory);
        MessageCustom messageCustom = messageMapper.selectMsgCustomById(paramMap);
        return messageCustom;
    }

    /**
     * @desc: 通过消息id获取消息基本信息
     * @author: lijing
     * @date: 2019/6/10
     */
    @Override
    public Message selectMsgByID(String id) {
        if (StringUtils.isEmpty(id)){
            throw new ParameterNullException("消息id为空");
        }
        //查询消息
        Message message = messageMapper.selectByPrimaryKey(id);
        return message;
    }

}
