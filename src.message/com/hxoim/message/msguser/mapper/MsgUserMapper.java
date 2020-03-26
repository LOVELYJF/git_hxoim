package com.hxoim.message.msguser.mapper;

import com.hxoim.message.msguser.entity.MsgUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MsgUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(MsgUser record);

    int insertSelective(MsgUser record);

    MsgUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MsgUser record);

    int updateByPrimaryKey(MsgUser record);

    /**
     * @desc: 批量插入消息用户
     * @author: lijing
     * @date: 2019/5/30
     */
    int insertMsgUsers(@Param("disMsgUsers") List<MsgUser> disMsgUsers);

    /**
     * @desc: 通过讨论组ID删除成员
     * @author: lijing
     * @date: 2019/5/30
     */
    int deleteUsersByDisGroupId(String disGroupID, String isDelete);

    /**
     * @desc: 通过讨论组ID查询成员
     * @author: lijing
     * @date: 2019/5/30
     */
    List<MsgUser> selectDisGroupUsers(String disGroupID, String isDelete);
}