package com.hxoim.message.msgsend.service;
/*
 * @description:
 * @author 杨波
 * @date:2019-07-23
 */

import com.hxoim.message.msgsend.entity.MMsgSend;
import com.hxoim.message.msgsend.entity.MMsgSendExample;

import java.util.List;

public interface MsgSendService {
    /**
    * @description:通过id删除消息发送记录
    * @author:杨波
    * @date:2019-07-23
    *  * @param String id
    * @return:
    **/
    int deleteByPrimaryKey(String id);
    /**
    * @description:插入消息发送记录
    * @author:杨波
    * @date:2019-07-23
    *  * @param MMsgSend record
    * @return:
    **/
    int insert(MMsgSend record);

    /**
    * @description:查询消息发送记录
    * @author:杨波
    * @date:2019-07-23
    *  * @param MMsgSendExample example
    * @return:
    **/
    List<MMsgSend> selectByExample(MMsgSendExample example);

    /**
    * @description:通过主键查询消息发送记录
    * @author:杨波
    * @date:2019-07-23
    *  * @param String id
    * @return:
    **/
    MMsgSend selectByPrimaryKey(String id);
    /**
    * @description:修改消息发送记录
    * @author:杨波
    * @date:2019-07-23
    *  * @param MMsgSend record
    * @return:
    **/
    int updateByPrimaryKey(MMsgSend record);
}
