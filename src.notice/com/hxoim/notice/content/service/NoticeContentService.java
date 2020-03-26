package com.hxoim.notice.content.service;

import com.hxoim.notice.content.entity.NoticeContent;

import java.util.List;

public interface NoticeContentService {
    /**
     * 新增或者更新通知内容
     *
     * @author sunqian
     * @date 2019/9/19 14:23
     */
    String insertOrUpdateContent(NoticeContent noticeContent, boolean isInsert);

    List<NoticeContent> selectContentByColumnId(String columnId);
    /**
     * 根据主键查询发布内容
     *
     * @author sunqian
     * @date 2019/9/24 17:50
     */
    NoticeContent selectContentPrimaryKey(String id);
    /**
     * 保存排序
     *
     * @author sunqian
     * @date 2019/9/25 11:27
     */
    void saveSortContent(List<NoticeContent> list);
    /**
     * 根据主键删除发布内容
     *
     * @author sunqian
     * @date 2019/9/25 11:27
     */
    void deleteNoticeContentPrimaryKey(String id);
    /**
     * 根据主键更新状态(置顶、发布等)
     *
     * @author sunqian
     * @date 2019/9/25 15:24
     */
    void updateStatusByType(String id, String value, String type);
    /**
     * 根据关键字查询
     *
     * @author sunqian
     * @date 2019/9/25 18:29
     *
     */
    List<NoticeContent> selectNoticeContentListByKeyWord(String keyWord, String publishValue);
}
