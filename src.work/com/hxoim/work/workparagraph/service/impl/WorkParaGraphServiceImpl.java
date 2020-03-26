package com.hxoim.work.workparagraph.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hxoim.common.utils.UUIDGenerator;
import com.hxoim.common.utils.UserInfo;
import com.hxoim.common.utils.UserInfoUtil;
import com.hxoim.work.workinfo.entity.WorkInfo;
import com.hxoim.work.workparagraph.entity.WorkParaGraph;
import com.hxoim.work.workparagraph.mapper.WorkParaGraphMapper;
import com.hxoim.work.workparagraph.service.WorkParaGraphService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WorkParaGraphServiceImpl implements WorkParaGraphService {

    @Autowired
    private WorkParaGraphMapper workParaGraphMapper;

    @Override
    public Map<String,Object> selectWorkParagraph(Integer pageNum, Integer pageSize,String workTitle,String startTime) {
        Map<String, Object> resultMap = new LinkedHashMap<>();
        Map<String,String> parm = new HashMap<String,String>();
        List<WorkParaGraph> list = new ArrayList<>();
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        PageHelper.startPage(pageNum, pageSize);
        String userId = UserInfoUtil.getUserInfo().getId();
        if(StringUtils.isNotBlank(workTitle)){
            workTitle = "'%"+workTitle+"%'";
        }
        parm.put("userId",userId);
        parm.put("workTitle",workTitle);
        parm.put("startTime",startTime);
        list = workParaGraphMapper.selectWorkParagraph(parm);
        PageInfo pageInfo = new PageInfo(list);
        resultMap.put("pageInfo", pageInfo);
        return resultMap;
    }

    @Override
    public WorkParaGraph selectWorkParagraphById(String id) {
        return workParaGraphMapper.selectWorkParagraphById(id);
    }

    @Override

    public void insertWorkParagraph(WorkParaGraph workParaGraph,String pid) {
        UserInfo user = UserInfoUtil.getUserInfo();
        workParaGraph.setId(UUIDGenerator.getPrimaryKey());//id
        workParaGraph.setModifyTime(new Date());//修改时间
        workParaGraph.setModifyUser(user.getUserName());//修改用户
        workParaGraph.setpId(pid);//父级id
        workParaGraphMapper.insertSelective(workParaGraph);
    }

    @Override
    public Map<String,Object>  selectWorkParagraphByStatus(Integer pageNum, Integer pageSize,String workTitle, String startTime) {
        //结果map
        Map<String, Object> resultMap = new LinkedHashMap<>();
        Map<String,String> parm = new HashMap<String,String>();
        List<WorkParaGraph> list = new ArrayList<>();
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        PageHelper.startPage(pageNum, pageSize);
        String userId = UserInfoUtil.getUserInfo().getId();
        if(StringUtils.isNotBlank(workTitle)){
            workTitle = "'%"+workTitle+"%'";
        }
        parm.put("userId",userId);
        parm.put("workTitle",workTitle);
        parm.put("startTime",startTime);
        list = workParaGraphMapper.selectWorkParagraphByStatus(parm);
        PageInfo pageInfo = new PageInfo(list);
        resultMap.put("pageInfo", pageInfo);
        return resultMap;

    }

    @Override
    public List<Map<String,Object>> selectTodoPersonList(String id) {
        return workParaGraphMapper.selectTodoPersonList(id);
    }

    @Override
    public void updateFinishdescById(String id, String finishiedesc) {
        workParaGraphMapper.updateFinishdescById(id,finishiedesc);
    }

}
