package com.hxoim.notice.query.service;

import java.util.Map;

public interface NoticeQueryLogService {
    /**
     * 新增通知内容浏览记录
     *
     * @author gaozhenyuan
     * @date 2019/12/19 14:23
     */
    void insertQueryLog(String ip,String contentId);

    /**
     * 获取当前通知公告浏览记录列表
     * @author gaozhenyuan
     * @date 2019/12/19 14:23
     * @param contentId
     */
    Map<String, Object> selectNoticeLogByContentId(Integer pageNum, Integer pageSize, String contentId);
}
