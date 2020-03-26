package com.hxoim.message.discussiongroup.service.impl;

import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.common.utils.UUIDGenerator;
import com.hxoim.common.utils.UserInfoUtil;
import com.hxoim.message.discussiongroup.entity.DiscussionGroup;
import com.hxoim.message.discussiongroup.mapper.DiscussionGroupMapper;
import com.hxoim.message.discussiongroup.service.DiscussionGroupService;
import com.hxoim.message.msguser.entity.MsgUser;
import com.hxoim.message.msguser.service.MsgUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @desc: TODO
 * @author: lijing
 * @date: 2019/5/29
 */
@Service
public class DiscussionGroupServiceImpl implements DiscussionGroupService {

    @Autowired
    private DiscussionGroupMapper discussionGroupMapper;
    @Autowired
    private MsgUserService msgUserService;

    /**
     * @desc: 新增讨论组
     * @author: lijing
     * @param discussionGroup 讨论组
     * @param disGroupUsers 讨论组成员
     * @date: 2019/5/29
     */
    @Override
    public String insertDisGroup(DiscussionGroup discussionGroup, List<MsgUser> disGroupUsers) {
        if (disGroupUsers == null || disGroupUsers.size() == 0){
            throw new ParameterNullException("成员为空");
        }

        //没有名称时，以其中一位成员姓名为讨论组名称
        if (StringUtils.isEmpty(discussionGroup.getName())){
            discussionGroup.setName(disGroupUsers.get(0).getReceiveUsername());
        }
        discussionGroup.setCreateTime(new Date());
        discussionGroup.setId(UUIDGenerator.getPrimaryKey());

        //插入讨论组
        int insertDisGroup = discussionGroupMapper.insert(discussionGroup);
        if (insertDisGroup != 1){
            throw new ParameterNullException("讨论组新建失败");
        }

        //插入讨论组成员
        msgUserService.insertDisGroupUsers(disGroupUsers, discussionGroup.getId());
        return discussionGroup.getId();
    }

    /**
     * @desc: 通过用户查询讨论组列表
     * @author: lijing
     * @date: 2019/5/29
     */
    @Override
    public List<DiscussionGroup> selectDisGroupListByUser(String userId) {
        if (StringUtils.isEmpty(userId)){
            userId = UserInfoUtil.getUserInfo().getId();
        }

        return discussionGroupMapper.selectDisGroupListByUser(userId);
    }

    /**
     * @desc: 删除讨论组
     * @author: lijing
     * @date: 2019/5/30
     */
    @Override
    @Transactional(rollbackFor=Exception.class)
    public void deleteDisGroup(String disGroupId) {
        if (StringUtils.isEmpty(disGroupId)){
            throw new ParameterNullException("讨论组ID为空");
        }

        //删除讨论组
        int delDisGroup = discussionGroupMapper.deleteByPrimaryKey(disGroupId);
        if (delDisGroup == 0){
            throw new ParameterNullException("删除讨论组失败");
        }

        //删除讨论组成员
        msgUserService.deleteUsersByDisGroupId(disGroupId);
    }
}
