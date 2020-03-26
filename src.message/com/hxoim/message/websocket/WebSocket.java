package com.hxoim.message.websocket;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hxoim.common.utils.JWTUtil;
import com.hxoim.common.utils.SpringUtil;
import com.hxoim.message.discussiongroup.entity.DiscussionGroup;
import com.hxoim.message.message.entity.Message;
import com.hxoim.message.message.entity.paramentity.SendMessageParam;
import com.hxoim.message.message.service.MessageService;
import com.hxoim.message.msguser.entity.MsgUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description  websocket
 * @Author   lijing
 * @Create  2019/6/12
 */
@ServerEndpoint("/websocket/{token}")
@Component
@Scope("prototype")
public class WebSocket {

    /**消息处理service*/
//    @Autowired
//    private MessageService messageService;

    private Session session;
    private String userId;

    private WebSocketManager webSocketManager = SpringUtil.getBean(WebSocketManager.class);

//    public WebSocket() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
//        webSocketManager = WebSocketManager.getInstance();
//    }

    /**
     * 打开连接
     * @param session
     */
    @OnOpen
    public void onOpen(@PathParam(value = "token") String token, Session session) throws IOException {
        try {
            this.session = session;
            this.userId = JWTUtil.parseToken(token).getId();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        webSocketManager.add(userId, this);
        this.session.getBasicRemote().sendText("连接成功");
    }

    /**
     * 关闭连接
     */

    @OnClose
    public void onClose(){
        webSocketManager.remove(userId);
    }

    /**
     * 接收信息
     * @param message
     * @throws IOException
     */
    @OnMessage
    public void onMessage(String message) throws IOException {
        SendMessageParam sendMessageParam = sendMessageHandle(message);
        //添加消息以及相关信息
        //messageService.sendMessage(sendMessageParam);
        //推送消息
        webSocketManager.push(sendMessageParam);
    }

    /**
     * 连接错误
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

    /**
     * @desc: 解析消息内容
     * @author: lijing
     * @date: 2019/6/11
     */
    public SendMessageParam sendMessageHandle(String message){
        //消息相关信息封装bean
        SendMessageParam sendMessageParam = new SendMessageParam();
        JSONObject jsonObject = JSONObject.parseObject(message);
        //消息
        Message messageInfo = jsonObject.getObject("message", Message.class);
        //讨论组信息
        DiscussionGroup discussionGroup = jsonObject.getObject("discussionGroup", DiscussionGroup.class);
        //接收人员信息
        Map<String, List<MsgUser>> msgUserMap = new HashMap<>();

        //处理接收人员数据
        Map<String, JSONArray> map = jsonObject.getObject("msgUserMap", Map.class);
        for (Map.Entry<String, JSONArray> msgUserListEntry : map.entrySet()) {
            List<MsgUser> msgUsers = new ArrayList<>();
            List<JSONObject> lists = msgUserListEntry.getValue().toJavaObject(List.class);
            for (JSONObject list : lists) {
                MsgUser msgUser = list.toJavaObject(MsgUser.class);
                msgUsers.add(msgUser);
            }
            msgUserMap.put(msgUserListEntry.getKey(), msgUsers);
        }
        //信息封装
        sendMessageParam.setMessage(messageInfo);
        sendMessageParam.setMsgUserMap(msgUserMap);
        sendMessageParam.setDiscussionGroup(discussionGroup);

        return sendMessageParam;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
