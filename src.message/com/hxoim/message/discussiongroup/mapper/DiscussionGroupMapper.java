package com.hxoim.message.discussiongroup.mapper;

import com.hxoim.message.discussiongroup.entity.DiscussionGroup;

import java.util.List;

public interface DiscussionGroupMapper {
    int deleteByPrimaryKey(String id);

    int insert(DiscussionGroup record);

    int insertSelective(DiscussionGroup record);

    DiscussionGroup selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DiscussionGroup record);

    int updateByPrimaryKey(DiscussionGroup record);

    /**
     * @desc: 通过用户查询讨论组列表
     * @author: lijing
     * @date: 2019/5/30
     */
    List<DiscussionGroup> selectDisGroupListByUser(String userId);
}