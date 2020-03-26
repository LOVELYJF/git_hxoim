package com.hxoim.support.customquery.mapper;

import com.hxoim.support.customquery.entity.ShareQueryPlan;

import java.util.List;

public interface ShareQueryPlanMapper {
    int deleteByPrimaryKey(String id);

    int insert(ShareQueryPlan record);

    int insertSelective(ShareQueryPlan record);

    ShareQueryPlan selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ShareQueryPlan record);

    int updateByPrimaryKey(ShareQueryPlan record);

    /**
     * @desc: 删除分享用户
     * @author: lijing
     * @date: 2019/8/12
     */
    int deleteShareUser(ShareQueryPlan record);

    /**
     * @desc: 查询分享用户列表
     * @author: lijing
     * @date: 2019/8/12
     */
    List<String> selectShareUsers(String queryPlanId);
}