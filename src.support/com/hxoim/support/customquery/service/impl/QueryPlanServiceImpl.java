package com.hxoim.support.customquery.service.impl;

import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.common.utils.UUIDGenerator;
import com.hxoim.common.utils.UserInfo;
import com.hxoim.common.utils.UserInfoUtil;
import com.hxoim.support.customquery.entity.QueryPlanWithBLOBs;
import com.hxoim.support.customquery.entity.ShareQueryPlan;
import com.hxoim.support.customquery.entity.custom.QueryPlanCustom;
import com.hxoim.support.customquery.mapper.QueryPlanMapper;
import com.hxoim.support.customquery.mapper.ShareQueryPlanMapper;
import com.hxoim.support.customquery.service.QueryPlanService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @desc: 方案实现层
 * @author: lijing
 * @date: 2019/8/9
 */
@Service
public class QueryPlanServiceImpl implements QueryPlanService {
    @Autowired
    private QueryPlanMapper queryPlanMapper;
    @Autowired
    private ShareQueryPlanMapper shareQueryPlanMapper;

    @Transactional(rollbackFor=Exception.class)
    @Override
    public void insertorUpdateQuery(QueryPlanWithBLOBs queryPlanWithBLOBs) {
        //当前登录用户
        UserInfo user = UserInfoUtil.getUserInfo();
        if (user == null){
            throw new ParameterNullException("用户信息获取失败");
        }
        //添加
        if (StringUtils.isEmpty(queryPlanWithBLOBs.getId())){
            queryPlanWithBLOBs.setId(UUIDGenerator.getPrimaryKey());
            queryPlanWithBLOBs.setCreateTime(new Date());
            queryPlanWithBLOBs.setCreateUserid(user.getId());
            queryPlanWithBLOBs.setIsDelete("0");
            //插入关系
            ShareQueryPlan shareQueryplan = new ShareQueryPlan();
            shareQueryplan.setId(UUIDGenerator.getPrimaryKey());
            shareQueryplan.setPlanId(queryPlanWithBLOBs.getId());
            shareQueryplan.setUserid(user.getId());
            shareQueryplan.setUsername(user.getName());

            //插入
            int insertQuery = queryPlanMapper.insertSelective(queryPlanWithBLOBs);
            if (insertQuery == 0){
                throw new ParameterNullException("保存失败");
            }
            int insertShare = shareQueryPlanMapper.insertSelective(shareQueryplan);
            if (insertShare == 0){
                throw new ParameterNullException("保存失败");
            }
        }else{
            //修改
            queryPlanWithBLOBs.setModifyTime(new Date());
            queryPlanWithBLOBs.setModifyUser(user.getId());
            int update = queryPlanMapper.updateByPrimaryKeySelective(queryPlanWithBLOBs);
            if (update == 0){
                throw new ParameterNullException("修改失败");
            }
        }
    }

    @Override
    public QueryPlanWithBLOBs selectQueryPlanById(String id) {
        return queryPlanMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<QueryPlanCustom> selectQueryList() {
        //当前登录用户
        UserInfo user = UserInfoUtil.getUserInfo();
        if (user == null){
            throw new ParameterNullException("用户信息获取失败");
        }

        //参数
        Map<String, String> params = new HashMap<>();
        params.put("userId", user.getId());

        return queryPlanMapper.selectQueryList(params);
    }
}
