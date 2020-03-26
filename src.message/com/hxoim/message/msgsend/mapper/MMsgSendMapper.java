package com.hxoim.message.msgsend.mapper;

import com.hxoim.message.msgsend.entity.MMsgSend;
import com.hxoim.message.msgsend.entity.MMsgSendExample;
import java.util.List;

public interface MMsgSendMapper {
    int deleteByPrimaryKey(String id);

    int insert(MMsgSend record);

    int insertSelective(MMsgSend record);

    List<MMsgSend> selectByExample(MMsgSendExample example);

    MMsgSend selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MMsgSend record);

    int updateByPrimaryKey(MMsgSend record);

    int markReaded(MMsgSend record);
}