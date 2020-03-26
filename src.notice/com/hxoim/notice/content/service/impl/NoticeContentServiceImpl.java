package com.hxoim.notice.content.service.impl;

import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.common.utils.UUIDGenerator;
import com.hxoim.common.utils.UserInfoUtil;
import com.hxoim.common.utils.UtilDateTime;
import com.hxoim.notice.content.entity.NoticeContent;
import com.hxoim.notice.content.mapper.NoticeContentMapper;
import com.hxoim.notice.content.service.NoticeContentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 通知内容设置
 *
 * @author sunqian
 * @date 2019/9/19 15:43
 */
@Service
public class NoticeContentServiceImpl implements NoticeContentService {

    @Autowired
    private NoticeContentMapper noticeContentMapper;

    @Override
    public String insertOrUpdateContent(NoticeContent noticeContent, boolean isInsert) {
        if (noticeContent == null) {
            throw new ParameterNullException("编辑内容参数为空");
        }
        noticeContent.setModifyTime(new Date());
        noticeContent.setModifyUser(UserInfoUtil.getUserInfo().getId());
        if(StringUtils.isNotBlank(noticeContent.getIsPublish())){
            noticeContent.setPublishTime(new Date());
        }
        if (isInsert) {
            if(StringUtils.isBlank(noticeContent.getIsTopping())){
                noticeContent.setIsTopping("0");
            }
            noticeContent.setId(UUIDGenerator.getPrimaryKey());
            noticeContentMapper.insert(noticeContent);
            return noticeContent.getId();
        } else {
            noticeContentMapper.updateByPrimaryKeyWithBLOBs(noticeContent);
            return null;
        }
    }

    @Override
    public List<NoticeContent> selectContentByColumnId(String columnId) {
        List<NoticeContent> list = new ArrayList<NoticeContent>();
        Map<String,String> map = new HashMap<String, String>();
        String userId = UserInfoUtil.getUserInfo().getId();
        if (StringUtils.isBlank(userId)) {
            throw new ParameterNullException("获取登录人Id失败！");
        }else{
            map.put("userId",userId);
            map.put("columnId",columnId);
            list = noticeContentMapper.selectContentByColumnId(map);
            return list;
        }
    }

    @Override
    public NoticeContent selectContentPrimaryKey(String id) {
        if (StringUtils.isBlank(id)) {
            throw new ParameterNullException("参数id为空");
        }
        return noticeContentMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveSortContent(List<NoticeContent> list) {
        if (list == null || list.isEmpty()) {
            throw new ParameterNullException("集合参数为空");
        }
        for (int i = 0; i < list.size(); i++) {
            NoticeContent noticeContent = list.get(i);
            noticeContent.setSortId(i + 1);
        }
        noticeContentMapper.saveSortContent(list);
    }

    @Override
    public void deleteNoticeContentPrimaryKey(String id) {
        if (StringUtils.isBlank(id)) {
            throw new ParameterNullException("参数id为空");
        }
        noticeContentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateStatusByType(String id, String value, String type) {
        if (StringUtils.isBlank(id) || StringUtils.isBlank(type)) {
            throw new ParameterNullException("参数id或type为空");
        }
        NoticeContent noticeContent = new NoticeContent();
        noticeContent.setId(id);
        if ("top".equals(type)) {
            noticeContent.setIsTopping(value);
        } else if ("publish".equals(type)) {
            noticeContent.setIsPublish(value);
            if ("1".equals(value)) {
                noticeContent.setPublishTime(new Date());
            }
        }
        noticeContentMapper.updateByPrimaryKeySelective(noticeContent);
    }

    @Override
    public List<NoticeContent> selectNoticeContentListByKeyWord(String keyWord, String publishValue) {
        String userId = UserInfoUtil.getUserInfo().getId();
        return noticeContentMapper.selectNoticeContentListByKeyWord(userId,keyWord, publishValue);
    }
}
