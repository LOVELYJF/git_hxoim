package com.hxoim.message.discussiongroup.service;

import com.hxoim.message.discussiongroup.entity.DiscussionGroup;
import com.hxoim.message.msguser.entity.MsgUser;

import java.util.List;

/**
 * @desc: 讨论组service
 * @author: lijing
 * @date: 2019/5/29
 */
public interface DiscussionGroupService {
    /**
     * @desc: 新增讨论组
     * @author: lijing
     * @date: 2019/5/29
     */
    String insertDisGroup(DiscussionGroup discussionGroup, List<MsgUser> disGroupUsers);

    /**
     * @desc: 根据用户查询讨论组列表
     * @author: lijing
     * @date: 2019/5/29
     */
    List<DiscussionGroup> selectDisGroupListByUser(String userId);

    /**
     * @desc: 删除讨论组
     * @author: lijing
     * @date: 2019/5/30
     */
    void deleteDisGroup(String disGroupId);
}
