package com.hxoim.work.workinfo.service.impl;

import com.hxoim.common.utils.UUIDGenerator;
import com.hxoim.common.utils.UserInfoUtil;
import com.hxoim.work.workinfo.entity.WorkInfo;
import com.hxoim.work.workinfo.entity.WorkProce;
import com.hxoim.work.workinfo.entity.WorkResponsible;
import com.hxoim.work.workinfo.mapper.WorkInfoMapper;
import com.hxoim.work.workinfo.mapper.WorkProceMapper;
import com.hxoim.work.workinfo.mapper.WorkResponsibleMapper;
import com.hxoim.work.workinfo.service.WorkResponsibleService;
import org.apache.poi.poifs.property.Child;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 通知公告浏览权限
 * @author gaozhenyuan
 * @date 2019/12/19 15:43
 */
@Service
public class WorkResponsibleServiceImpl implements WorkResponsibleService {

    @Autowired
    private WorkResponsibleMapper workResponsibleMapper;
    @Autowired
    private WorkInfoMapper workInfoMapper;
    @Autowired
    private WorkProceMapper workProceMapper;

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

    @Override
    public int insertWorkResponsible(WorkResponsible workResponsible) {
        if(workResponsible.getId()==null || workResponsible.getId()==""){
            String id = UUIDGenerator.getPrimaryKey();
            workResponsible.setId(id);
            return workResponsibleMapper.insert(workResponsible);
        }
        return workResponsibleMapper.updateWorkResponsible(workResponsible);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return workResponsibleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateWorkResponsible(WorkResponsible workResponsible) {
        return workResponsibleMapper.updateWorkResponsible(workResponsible);
    }

    @Override
    public int updateByPrimaryKeySelective(WorkResponsible workResponsible) {
        return workResponsibleMapper.updateByPrimaryKeySelective(workResponsible);
    }

    @Override
    public List<WorkResponsible> selectListByUserId(String id) {
        return workResponsibleMapper.selectListByUserId(id);
    }

    @Override
    public List<WorkResponsible> selectListByWorkInfoId(String id) {
        List<WorkResponsible> workResponsibles = workResponsibleMapper.selectListByWorkInfoId(id);
        return workResponsibles;
    }

    @Override
    public List<WorkResponsible> selectAllListByWorkInfoId(String id) {
        List<WorkResponsible> workResponsibles = workResponsibleMapper.selectListByWorkInfoId(id);
        if(workResponsibles.size() > 0){
            List<WorkInfo> workInfos = workInfoMapper.selectWorkInfoByPId(id);
            if(workInfos.size() > 0){
                for (int i = 0; i < workResponsibles.size(); i++){
                    for(int j = 0; j < workInfos.size(); j++){
                        if(workResponsibles.get(i).getUserId().equals(workInfos.get(j).getUserId())){
                            List<WorkResponsible> child = selectListByWorkInfoId(workInfos.get(j).getId());
                            workResponsibles.get(i).setChildren(child);
                        }
                    }
                }
            }
        }
        return workResponsibles;
    }

    @Override
    public WorkResponsible selectWorkResponsibleById(String id) {
        return workResponsibleMapper.selectWorkResponsibleById(id);
    }

    @Override
    public void updateStatusById(String id) {
        workResponsibleMapper.updateStatusById(id);
    }

    @Override
    public void insertWorkProce(WorkProce workProce) {
        workProce.setId(UUIDGenerator.getPrimaryKey());
        workProce.setUserId(UserInfoUtil.getUserInfo().getId());
        workProceMapper.insert(workProce);
    }

    @Override
    public void updateStatusByIds(String ids) {
        String[] Ids = ids.split(",");
        workResponsibleMapper.updateStatusByIds(Ids);
    }

    @Override
    public void updateByStatusSelective(WorkResponsible workResponsible) {
        if("3".equals(workResponsible.getStatus())){
            workResponsible.setRealFinishedTime(new Date());
        }
        workResponsibleMapper.updateByPrimaryKeySelective(workResponsible);
        List<WorkResponsible> workResponsibles = workResponsibleMapper.selectListByWorkInfoId(workResponsible.getWorkInfoId());
        int m=0;
        for(int k=0;k<workResponsibles.size();k++){
            if("3".equals(workResponsibles.get(k).getStatus())){
                m=m+1;
            }
        }
        if(m==workResponsibles.size()){
            WorkInfo  workInfo=new WorkInfo();
            workInfo.setId(workResponsible.getWorkInfoId());
            workInfo.setStatus("1");
            workInfo.setRealFinishedTime(new Date());

            workInfoMapper.updateByPrimaryKeySelective(workInfo);
        }
    }


}
