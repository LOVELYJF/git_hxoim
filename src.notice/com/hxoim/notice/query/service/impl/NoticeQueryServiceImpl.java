package com.hxoim.notice.query.service.impl;

import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.common.utils.UserInfo;
import com.hxoim.common.utils.UserInfoUtil;
import com.hxoim.notice.content.entity.NoticeContent;
import com.hxoim.notice.query.mapper.NoticeQueryMapper;
import com.hxoim.notice.query.service.NoticeQueryService;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 通知发布查询
 *
 * @author gaozhenyuan
 * @date 2019/12/19 15:43
 */
@Service
public class NoticeQueryServiceImpl implements NoticeQueryService {

    @Autowired
    private NoticeQueryMapper noticeQueryMapper;

    @Override
    public List<NoticeContent> selectNoticeByQuery(String columnId) {
        List<NoticeContent> list = new ArrayList<NoticeContent>();
        Map<String,Object> parm = new HashMap<String, Object>();
        String userId = UserInfoUtil.getUserInfo().getId();
        if (StringUtils.isBlank(userId)) {
            throw new ParameterNullException("获取登录人Id失败！");
        }else{
            parm.put("userId",userId);
            parm.put("columnId",columnId);
            list = noticeQueryMapper.selectNoticeByQuery(parm);
            return list;
        }
    }

    @Override
    public List<NoticeContent> selectNoticeByKeyWord(String keyWord) {
        List<NoticeContent> list = new ArrayList<NoticeContent>();
        String userId = UserInfoUtil.getUserInfo().getId();
        if (StringUtils.isBlank(userId)) {
            throw new ParameterNullException("获取登录人Id失败！");
        }else{
            list = noticeQueryMapper.selectNoticeByKeyWord(userId,keyWord);
            return list;
        }
    }

}
