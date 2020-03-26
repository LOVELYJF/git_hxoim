package com.hxoim.support.ETLDataException.service.impl;

import com.hxoim.common.Reflector.ReflectHelpper;
import com.hxoim.common.utils.Constants;
import com.hxoim.common.utils.EnumContainer;
import com.hxoim.common.utils.UUIDGenerator;
import com.hxoim.message.message.entity.Message;
import com.hxoim.message.message.entity.paramentity.SendMessageParam;
import com.hxoim.message.message.service.MessageService;
import com.hxoim.message.msguser.entity.MsgUser;
import com.hxoim.support.ETLDataException.entity.Wrongrecord;
import com.hxoim.support.ETLDataException.entity.WrongrecordExample;
import com.hxoim.support.ETLDataException.service.ETLDataExceptionService;
import com.hxoim.support.ETLDataException.service.WrongrecordService;
import com.hxoim.support.usergroup.entity.SystemUserGroup;
import com.hxoim.support.usergroup.service.SystemUserGroupService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/*
 * @description:定时从数据异常日志表取新的异常发送给相关负责处室,系统张表都有使用系统，每个使用系统都设置有管理处室
 * @author 杨波
 * @date:2019-07-17
 */
@Service
public class ETLDataExceptionServiceImpl implements ETLDataExceptionService {
    //判断是否在执行，默认设置每5秒处理一次，防止数量大以后5秒处理不完
    private boolean isRunning = false;

    @Autowired
    private WrongrecordService wrongRecordService = null;

    @Autowired
    private MessageService messageService = null;

    @Autowired
    private SystemUserGroupService systemUserGroupService = null;

    /**
     * @description:定时搜索数据转换日志表，将新的数据异常推送给负责处室，根据信息资源表使用系统的管理处室来发送消息
     * @author:杨波
     * @date:2019-07-17 * @param
     * @return:void
     **/
    @Override
    public void CollectExceptionSendToManager() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        isRunning = true;
        List<Wrongrecord> wrongRecords = getException();

        for (Wrongrecord record : wrongRecords
        ) {
            Message message = BuildMessage(record);
            Map<String, List<MsgUser>> msgUsers = getManageDepartments(record,message);

            SendMessageParam sendMessageParam=new SendMessageParam();
            sendMessageParam.setMessage(message);
            sendMessageParam.setMsgUserMap(msgUsers);

            messageService.sendMessage(sendMessageParam);

            record.setState(EnumContainer.EWrongRecordState.wrsSendMessage.ordinal());
            wrongRecordService.updateByPrimaryKey(record);
        }

        isRunning = false;
    }

    /**
     * @description:取未推送过消息的异常数据
     * @author:杨波
     * @date:2019-07-17 * @param
     * @return:java.util.List<com.hxoim.support.ETLDataException.entity.Wrongrecord>
     **/
    private List<Wrongrecord> getException() {
        WrongrecordExample example = new WrongrecordExample();
        WrongrecordExample.Criteria criteria = example.createCriteria();
        criteria.andStateEqualTo(0);

        List<Wrongrecord> wrongRecords = wrongRecordService.selectByExampleWithBLOBs(example);

        return wrongRecords;
    }

    /**
     * @description:根据数据异常日志创建消息
     * @author:杨波
     * @date:2019-07-17 * @param wrongrecord
     * @return:com.hxoim.message.message.entity.Message
     **/
    private Message BuildMessage(Wrongrecord wrongrecord) {
        Message message = new Message();
        ReflectHelpper.setModifyFields(message);
        message.setId(UUIDGenerator.getPrimaryKey());
        message.setContent(wrongrecord.getErrorinfo());
        message.setCreateTime(new Date());
        message.setDataSource(wrongrecord.getSystemname());
        message.setSendUserId("123");
        message.setSendUsername("系统管理员");
        message.setExceptionTable(wrongrecord.getTablename());
        message.setFeather("1");//1需要处理
        message.setTypeId("AA60011C-5051-46C4-BDFA-E46549DB9ED2");//异常数据处理消息
        message.setMsgStatus("0");//0未处理
        message.setIsTop("0");//不置顶
        message.setEstimateTime(DateUtils.addDays(new Date(), 5));//预计5天完成
        message.setHandleIdentify("1");//处理标识（1个人2处室3机构4讨论组）

        return message;
    }

    /**
     * @description:根据异常数据发生的表获取管理处室
     * @author:杨波
     * @date:2019-07-17 * @param record
     * @return:java.util.List<com.hxoim.message.msguser.entity.MsgUser>
     **/
    private Map<String, List<MsgUser>> getManageDepartments(Wrongrecord record, Message message) {
        Map<String, List<MsgUser>> msgUserMap=new HashMap<>();
        List<MsgUser> msgUsers = new ArrayList<>();

        List<SystemUserGroup> userGroups = getSystemUserGroups(record.getApplicationid());
        if(userGroups==null||userGroups.size()==0)
        {
            //该系统没有设置管理处室，发送给管理员
            MsgUser msgUser = BuildReceiver(message);
            msgUsers.add(msgUser);
            msgUserMap.put(Constants.PERSONAL,msgUsers);
            return msgUserMap;
        }
        for(SystemUserGroup userGroup:userGroups)
        {
            MsgUser msgUser = BuildReceiver(message, userGroup);
            msgUsers.add(msgUser);
        }
        msgUserMap.put(Constants.DEPARTMENT,msgUsers);

        return msgUserMap;
    }

    /**
     * @description:获取系统的管理处室
     * @author:杨波
     * @date:2019-07-21
     *  * @param sysId
     * @return:java.util.List<com.hxoim.support.usergroup.entity.SystemUserGroup>
     **/
    private List<SystemUserGroup> getSystemUserGroups(String sysId){
        SystemUserGroup userGroup=new SystemUserGroup();
        userGroup.setSyId(sysId);
        List<SystemUserGroup> userGroups = systemUserGroupService.selectUserGroupBySyId(userGroup);

        return userGroups;
    }
    /**
     * @description:如果信息资源表没有设置管理处室，则发送给系统管理员
     * @author:杨波
     * @date:2019-07-17 * @param message
     * @return:com.hxoim.message.msguser.entity.MsgUser
     **/
    private MsgUser BuildReceiver(Message message) {

        MsgUser msgUser = BuildReceiverModel(message);
        msgUser.setHandleIdentify("1");
        msgUser.setReceiveUserId("123");
        msgUser.setReceiveUsername("系统管理员");
        return msgUser;
    }

    /**
     * @description:根据消息和信息资源管理处室创建接受者
     * @author:杨波
     * @date:2019-07-17
     * * @param message
     * * @param userGroup
     * @return:com.hxoim.message.msguser.entity.MsgUser
     **/
    private MsgUser BuildReceiver(Message message, SystemUserGroup userGroup) {

        MsgUser msgUser = BuildReceiverModel(message);
        msgUser.setHandleIdentify("2");//接受处室
        msgUser.setReceiveUserId(userGroup.getUgId());
        msgUser.setReceiveUsername(userGroup.getUgName());
        return msgUser;
    }

    /**
     * @description:创建消息接受者模板
     * @author:杨波
     * @date:2019-07-17 * @param message
     * @return:com.hxoim.message.msguser.entity.MsgUser
     **/
    private MsgUser BuildReceiverModel(Message message) {

        MsgUser msgUser = new MsgUser();
        msgUser.setMsgId(message.getId());
        msgUser.setId(UUIDGenerator.getPrimaryKey());
        msgUser.setCreateTime(new Date());
        msgUser.setIsDelete("0");
        return msgUser;
    }
}
