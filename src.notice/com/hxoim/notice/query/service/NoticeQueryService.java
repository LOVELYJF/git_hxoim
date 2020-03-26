package com.hxoim.notice.query.service;

import com.hxoim.notice.content.entity.NoticeContent;

import java.util.List;

public interface NoticeQueryService {
    /**
     * 获取当前登录人通知公告浏览列表（按分类）
     *
     * @author gaozhenyuan
     * @date 2019/12/16 14:23
     * @param columnId
     */
    List<NoticeContent> selectNoticeByQuery(String columnId);
    /**
     * 根据关键字（标题）获取当前登录人通知公告浏览列表
     *
     * @author gaozhenyuan
     * @date 2019/12/16 14:23
     * @param keyWord
     */
    List<NoticeContent> selectNoticeByKeyWord(String keyWord);

}
