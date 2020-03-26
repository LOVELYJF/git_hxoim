package com.hxoim.message.discussiongroup.controller;

import com.hxoim.common.utils.Result;
import com.hxoim.message.discussiongroup.entity.DiscussionGroup;
import com.hxoim.message.discussiongroup.service.DiscussionGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @desc: 消息讨论组controller
 * @author: lijing
 * @date: 2019/5/30
 */
@RestController
@RequestMapping("/discussionGroup")
public class DiscussionGroupController {

    @Autowired
    private DiscussionGroupService discussionGroupService;

    /**
     * @desc: 通过用户id查询讨论列表
     * @author: lijing
     * @date: 2019/5/30
     */
    @RequestMapping("/selectDisGroupListByUser")
    public Result selectDisGroupListByUser(String userId){
        List<DiscussionGroup> discussionGroups = discussionGroupService.selectDisGroupListByUser(userId);
        return Result.success(discussionGroups);
    }

    /**
     * @desc: 删除讨论组
     * @author: lijing
     * @date: 2019/5/30
     */
    @RequestMapping("/deleteDisGroup")
    public Result deleteDisGroup(String disGroupId){
        discussionGroupService.deleteDisGroup(disGroupId);
        return Result.success();
    }
}
