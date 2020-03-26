package com.hxoim.notice.query.mapper;

import com.hxoim.notice.content.entity.NoticeContent;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 发布查询mapper接口
 *
 * @author gaozhenyuan
 * @date 2019/12/16 10:52
 */
public interface NoticeQueryMapper {

    /**
     * 获取当前登录人通知公告浏览列表（按分类）
     *
     * @author gaozhenyuan
     * @date 2019/12/16 14:23
     * @param parm(columnId,userId,orgId)
     */
    List<NoticeContent> selectNoticeByQuery(Map<String,Object> parm);

    /**
     * 根据关键字（标题）获取当前登录人通知公告浏览列表
     *
     * @author gaozhenyuan
     * @date 2019/12/16 14:23
     */
    List<NoticeContent> selectNoticeByKeyWord(@Param("userId") String userId, @Param("keyWord") String keyWord);
}