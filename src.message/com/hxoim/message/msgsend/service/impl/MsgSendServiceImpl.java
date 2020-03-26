package com.hxoim.message.msgsend.service.impl;
/*
 * @description:后台给用户发送消息的记录
 * @author 杨波
 * @date:2019-07-23
 */

import com.hxoim.message.msgsend.entity.MMsgSend;
import com.hxoim.message.msgsend.entity.MMsgSendExample;
import com.hxoim.message.msgsend.mapper.MMsgSendMapper;
import com.hxoim.message.msgsend.service.MsgSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MsgSendServiceImpl implements MsgSendService {
    @Autowired
    private MMsgSendMapper msgSendMapper;
    /**
     * @description:通过id删除消息发送记录
     * @author:杨波
     * @date:2019-07-23
     *  * @param String id
     * @return:
     **/
    @Override
    public int deleteByPrimaryKey(String id){
        return msgSendMapper.deleteByPrimaryKey(id);
    }
    /**
     * @description:插入消息发送记录
     * @author:杨波
     * @date:2019-07-23
     *  * @param MMsgSend record
     * @return:
     **/
    @Override
    public int insert(MMsgSend record){
        return msgSendMapper.insert(record);
    }

    /**
     * @description:查询消息发送记录
     * @author:杨波
     * @date:2019-07-23
     *  * @param MMsgSendExample example
     * @return:
     **/
    @Override
    public List<MMsgSend> selectByExample(MMsgSendExample example){
        return msgSendMapper.selectByExample(example);
    }

    /**
     * @description:通过主键查询消息发送记录
     * @author:杨波
     * @date:2019-07-23
     *  * @param String id
     * @return:
     **/
    @Override
    public MMsgSend selectByPrimaryKey(String id){
        return msgSendMapper.selectByPrimaryKey(id);
    }
    /**
     * @description:修改消息发送记录
     * @author:杨波
     * @date:2019-07-23
     *  * @param MMsgSend record
     * @return:
     **/
    @Override
    public int updateByPrimaryKey(MMsgSend record){
        return msgSendMapper.updateByPrimaryKey(record);
    }
}
