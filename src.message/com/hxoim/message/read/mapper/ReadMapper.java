package com.hxoim.message.read.mapper;

import com.hxoim.message.read.entity.Read;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ReadMapper {
    int deleteByPrimaryKey(String id);

    int insert(Read record);

    int insertSelective(Read record);

    Read selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Read record);

    int updateByPrimaryKey(Read record);

    /**
     * @desc: 消息是否已读
     * @author: lijing
     * @param userId 用户id
     * @param msgId 消息id
     * @date: 2019/6/5
     */
    int selectIsReadMsg(@Param("msgId") String msgId, @Param("userId") String userId);

    /**
     * @desc: 批量阅读消息
     * @author: lijing
     * @param readList
     * @date: 2019/6/5
     */
    int readingMark(@Param("readList") List<Read> readList);

    /**
     * @desc: 未读普通消息数
     * @author: lijing
     * @date: 2019/6/11
     */
    int notReadNum(Map<String, Object> paramMap);

    /**
     * @desc: 未读讨论组消息数
     * @author: lijing
     * @date: 2019/6/11
     */
    int notReadNumDisc(Map<String, Object> paramMap);
}