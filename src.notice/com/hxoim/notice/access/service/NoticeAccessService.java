package com.hxoim.notice.access.service;

import com.hxoim.notice.access.entity.NoticeAccess;

import java.util.List;

public interface NoticeAccessService {
    /**
     * 新增浏览权限
     * @author gaozhenyuan
     * @date 2019/12/19 14:23
     */
    void insertAccess(String id, List<String> accessList);
    /**
     * 根据主键删除浏览权限
     * @author gaozhenyuan
     * @date 2019/12/19 11:27
     */
    void deleteNoticeAccessPrimaryKey(String id);
    /**
     * 根据内容ID查询其浏览权限列表
     * @author gaozhenyuan
     * @date 2019/12/19 14:23
     */
    List<NoticeAccess> selectAccessByContentId(String columnId);

}
