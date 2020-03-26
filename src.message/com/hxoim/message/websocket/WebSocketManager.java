package com.hxoim.message.websocket;

import com.hxoim.common.utils.UUIDGenerator;
import com.hxoim.message.message.entity.paramentity.SendMessageParam;
import com.hxoim.message.msgsend.entity.MMsgSend;
import com.hxoim.message.msgsend.mapper.MMsgSendMapper;
import com.hxoim.message.msguser.entity.MsgUser;
import com.hxoim.message.msguser.mapper.MsgUserMapper;
import com.hxoim.support.user.entity.User;
import com.hxoim.support.user.mapper.UserMapper;
import com.hxoim.support.usergroup.entity.UserGroupUser;
import com.hxoim.support.usergroup.mapper.UserGroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description websocket管理
 * @Author lijing
 * @Create 2019/6/12
 */
@Component
public class WebSocketManager {

    private final Map<String, WebSocket> webSocketMap = new ConcurrentHashMap<>();

    //当前连接数
    private Integer onlineCount = 0;

    private Lock lock = new ReentrantLock();
    @Autowired
    private UserGroupMapper userGroupMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MMsgSendMapper msgSendMapper;
    @Autowired
    private MsgUserMapper msgUserMapper;

    /**
     * 添加 WebSocket
     *
     * @param userId    webSocket类型
     * @param webSocket webSocket实例
     */
    public void add(String userId, WebSocket webSocket) {
        lock.lock();
        try {
            webSocketMap.put(userId, webSocket);
            onlineCount++;
        } finally {
            lock.unlock();
        }
    }

    /**
     * 移除webSocket
     *
     * @param userId 用户id
     */
    public void remove(String userId) {
        lock.lock();
        try {
            webSocketMap.remove(userId);
            onlineCount--;
        } finally {
            lock.unlock();
        }
    }

    /**
     * 获取当前建立连接的用户数
     *
     * @return
     */
    public Integer getOnlineCount() {
        return onlineCount;
    }

    /**
     * 向客户端推送消息
     *
     * @param sendMessageParam 消息信息
     * @throws IOException
     */
    public void push(SendMessageParam sendMessageParam) {
        //消息内容
        String content = sendMessageParam.getMessage().getContent();
        //接收用户
        Map<String, List<MsgUser>> msgUserMap = sendMessageParam.getMsgUserMap();

        //遍历查找在线用户并推送消息
        for (Map.Entry<String, List<MsgUser>> msgUserListEntry : msgUserMap.entrySet()) {
            for (MsgUser msgUser : msgUserListEntry.getValue()) {

                //直接发给用户的消息
                if (msgUser.getHandleIdentify().equals("1")) {
                    RecordSendLog(msgUser.getMsgId(),msgUser.getReceiveUserId(),msgUser.getReceiveUsername(), content);

                } else if (msgUser.getHandleIdentify().equals("2")) {

                    //查找该处室下所有用户
                    List<UserGroupUser> userGroupUsers = userGroupMapper.selectUserGroupUsers(msgUser.getReceiveUserId());

                    for (UserGroupUser userGroupUser : userGroupUsers
                    ) {
                        RecordSendLog(msgUser.getMsgId(),userGroupUser.getUserId(),userGroupUser.getName(), content);
                    }
                } else if (msgUser.getHandleIdentify().equals("3")) {

                    //查找该机构下所有用户
                    List<User> users = userMapper.getSysUserList("", msgUser.getReceiveUserId());
                    for (User user : users
                    ) {
                        RecordSendLog(msgUser.getMsgId(),user.getId(),user.getName(), content);
                    }
                }
            }
        }
    }
    /**
     * @description:记录消息发送日志，网站可以通过此记录查询是否有自己的消息
     * @author:杨波
     * @date:2019-07-23
     *  * @param userId
     * @param userName
     * @param content
     * @return:void
     **/
    private void RecordSendLog(String msgid ,String userId,String userName, String content)
    {

        MMsgSend mMsgSend=new MMsgSend();
        mMsgSend.setId(UUIDGenerator.getPrimaryKey());
        mMsgSend.setSendTime(new Date());
        mMsgSend.setMsgid(msgid);
        mMsgSend.setIsreaded(false);
        mMsgSend.setReceiveUserId(userId);
        mMsgSend.setReceiveUsername(userName);
        try{
            msgSendMapper.insert(mMsgSend);
        }catch (Exception e){
            e.printStackTrace();
        }
        SendToClient(userId,content);
    }
    /**
     * @description:将消息推送给在线的客户
     * @author:杨波
     * @date:2019-07-23
     *  * @param userId
     * @param content
     * @return:void
     **/
    private void SendToClient(String userId, String content) {

        WebSocket webSocket = webSocketMap.get(userId);
        if (webSocket != null) {
            //发送消息
            try {
                webSocket.getSession().getBasicRemote().sendText(content);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
