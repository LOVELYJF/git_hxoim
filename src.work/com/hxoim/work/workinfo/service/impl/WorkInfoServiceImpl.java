package com.hxoim.work.workinfo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.common.utils.UUIDGenerator;
import com.hxoim.common.utils.UserInfoUtil;
import com.hxoim.work.workinfo.entity.WorkInfo;
import com.hxoim.work.workinfo.mapper.WorkInfoMapper;
import com.hxoim.work.workinfo.service.WorkInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 通知公告浏览权限
 * @author gaozhenyuan
 * @date 2019/12/19 15:43
 */
@Service
public class WorkInfoServiceImpl implements WorkInfoService {

    @Autowired
    private WorkInfoMapper workInfoMapper;

    @Override
    public String insertWorkInfo(WorkInfo workInfo) {
        String id = UUIDGenerator.getPrimaryKey();
        String userId = UserInfoUtil.getUserInfo().getId();
        workInfo.setId(id);
        workInfo.setUserId(userId);
        workInfo.setStatus("0");
        workInfoMapper.insert(workInfo);
        return id;
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return workInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateWorkInfo(WorkInfo workInfo) {
        return workInfoMapper.update(workInfo);
    }

    @Override
    public int updateByPrimaryKeySelective(WorkInfo workInfo) {
        return workInfoMapper.updateByPrimaryKeySelective(workInfo);
    }

    @Override
    public Map<String, Object> selectWorkInfoList(Integer pageNum, Integer pageSize,String workTitle,String startTime,String status) {
        //结果map
        Map<String, Object> resultMap = new LinkedHashMap<>();
        Map<String,String> parm = new HashMap<String,String>();
        List<WorkInfo> list = new ArrayList<>();
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        PageHelper.startPage(pageNum, pageSize);
        String userId = UserInfoUtil.getUserInfo().getId();
        if(StringUtils.isNotBlank(workTitle)){
            workTitle = "%"+workTitle+"%";
        }
        parm.put("userId",userId);
        parm.put("workTitle",workTitle);
        parm.put("startTime",startTime);
        parm.put("status",status);
        list = workInfoMapper.selectWorkInfoList(parm);
        PageInfo pageInfo = new PageInfo(list);
        resultMap.put("pageInfo", pageInfo);
        return resultMap;
    }

    @Override
    public List<WorkInfo> selectWorkInfoByPId(String id) {
        return workInfoMapper.selectWorkInfoByPId(id);
    }

    @Override
    public WorkInfo selectWorkInfoById(String id) {
        return workInfoMapper.selectWorkInfoById(id);
    }

   /* @Override
    public void insertAccess(String id, List<String> orgIdList) {
        List<NoticeAccess> accessList = new ArrayList<NoticeAccess>();
        NoticeAccess noticeAccess;
        if (id == null) {
            throw new ParameterNullException("未获取到通知公告Id！");
        }
        if (noticeAccessMapper.deleteByContentId(id) >= 0) {
            for(int i = 0;i < orgIdList.size();i++){
                noticeAccess = new NoticeAccess();
                noticeAccess.setId(UUIDGenerator.getPrimaryKey());
                noticeAccess.setContentId(id);
                noticeAccess.setOrgId(orgIdList.get(i));
                accessList.add(noticeAccess);
            }
            noticeAccessMapper.insert(accessList);
        } else {
            throw new ParameterNullException("授权失败！");
        }
    }

    @Override
    public void deleteNoticeAccessPrimaryKey(String id) {
        if (StringUtils.isBlank(id)) {
            throw new ParameterNullException("参数id为空");
        }
        noticeAccessMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<NoticeAccess> selectAccessByContentId(String contentId) {
        List<NoticeAccess> list = new ArrayList<NoticeAccess>();
        if (StringUtils.isBlank(contentId)) {
            throw new ParameterNullException("未获取到内容Id！");
        }else{
            list = noticeAccessMapper.selectAccessByContentId(contentId);
        return list;
        }
    }*/

}
