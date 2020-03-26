package com.hxoim.notice.access.mapper;

import com.hxoim.notice.access.entity.NoticeAccess;

import java.util.List;

/**
 * 公告浏览mapper接口
 *
 * @author gaozhenyuan
 * @date 2019/12/19 10:52
 */
public interface NoticeAccessMapper {

    int insert(List<NoticeAccess> list);

    int insertSelective(NoticeAccess record);

    int deleteByContentId(String contentId);

    int deleteByPrimaryKey(String id);

    List<NoticeAccess> selectAccessByContentId(String contentId);

   }