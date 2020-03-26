package com.hxoim.notice.query.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.common.utils.UUIDGenerator;
import com.hxoim.common.utils.UserInfoUtil;
import com.hxoim.notice.content.entity.NoticeContent;
import com.hxoim.notice.query.entity.NoticeQueryLog;
import com.hxoim.notice.query.mapper.NoticeQueryLogMapper;
import com.hxoim.notice.query.mapper.NoticeQueryMapper;
import com.hxoim.notice.query.service.NoticeQueryLogService;
import com.hxoim.notice.query.service.NoticeQueryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.*;

/**
 * 通知发布查询
 *
 * @author gaozhenyuan
 * @date 2019/12/19 15:43
 */
@Service
public class NoticeQueryLogServiceImpl implements NoticeQueryLogService {

    @Autowired
    private NoticeQueryLogMapper noticeQueryLogMapper;

    @Override
    public void insertQueryLog(String ip,String contentId) {
        NoticeQueryLog noticeQueryLog = new NoticeQueryLog();
        if (contentId == null) {
            throw new ParameterNullException("未获取到通知公告Id");
        }
        noticeQueryLog.setId(UUIDGenerator.getPrimaryKey());
        noticeQueryLog.setContentId(contentId);
        noticeQueryLog.setUserId(UserInfoUtil.getUserInfo().getId());
        noticeQueryLog.setUserName(UserInfoUtil.getUserInfo().getName());
        noticeQueryLog.setQueryTime(new Date());
        noticeQueryLog.setIp(ip);
        noticeQueryLogMapper.insert(noticeQueryLog);

    }

    @Override
    public Map<String, Object> selectNoticeLogByContentId(Integer pageNum, Integer pageSize,String contentId) {
        //结果map
        Map<String, Object> resultMap = new LinkedHashMap<>();
        List<NoticeQueryLog> list = new ArrayList<NoticeQueryLog>();
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        PageHelper.startPage(pageNum, pageSize);
        if (StringUtils.isBlank(contentId)) {
            throw new ParameterNullException("未获取到通知公告id！");
        }else{
            list = noticeQueryLogMapper.selectNoticeLogByContentId(contentId);
            PageInfo pageInfo = new PageInfo(list);
            resultMap.put("pageInfo", pageInfo);
            return resultMap;
        }
    }

}
