package com.hxoim.message.message.mapper;

import com.hxoim.message.message.entity.Message;
import com.hxoim.message.message.entity.MessageCustom;

import java.util.List;
import java.util.Map;

public interface MessageMapper {
    int deleteByPrimaryKey(String id);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKeyWithBLOBs(Message record);

    int updateByPrimaryKey(Message record);


    /**
     * @desc: 接收消息列表
     * @author: lijing
     * @param keyword 搜索条件
     * @date: 2019/5/31
     */
    List<MessageCustom> selectReceMsgList(Map<String, Object> keyword);

    /**
     * @desc: 讨论组接收消息列表
     * @author: lijing
     * @date: 2019/5/31
     */
    List<MessageCustom> selectDisGroupReceMsgList(Map<String, Object> keyword);

    /**
     * @desc: 发送消息列表
     * @author: lijing
     * @date: 2019/5/31
     */
    List<MessageCustom> selectSendMsgList(Map<String, Object> keyword);

    /**
     * @desc: 批量修改消息置顶状态
     * @author: lijing
     * @date: 2019/6/4
     */
    int updateIsTopBatch(Map<String, Object> keyword);

    /**
     * @desc: 通过消息id查询消息详情
     * @author: lijing
     * @date: 2019/6/10
     */
    MessageCustom selectMsgCustomById(Map<String, Object> keyword);
}