package com.hxoim.notice.query.mapper;

import com.hxoim.notice.content.entity.NoticeContent;
import com.hxoim.notice.query.entity.NoticeQueryLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 浏览记录mapper接口
 *
 * @author gaozhenyuan
 * @date 2019/12/23 10:52
 */
public interface NoticeQueryLogMapper {

    /**
     * 插入浏览记录
     * @author gaozhenyuan
     * @date 2019/12/16 14:23
     * @param noticeQueryLog
     */
    int insert(NoticeQueryLog noticeQueryLog);

    /**
     * 获取当前通知公告浏览记录列表
     *
     * @author gaozhenyuan
     * @date 2019/12/16 14:23
     */
    List<NoticeQueryLog> selectNoticeLogByContentId(@Param("contentId") String contentId);
}