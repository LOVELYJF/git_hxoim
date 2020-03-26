package com.hxoim.work.workinfo.service;

import com.hxoim.notice.access.entity.NoticeAccess;
import com.hxoim.work.workinfo.entity.WorkInfo;

import java.util.List;
import java.util.Map;

public interface WorkInfoService {

    /**
     * 新增我的工作
     * @author gaozhenyuan
     * @date 2019/12/25 14:23
     */
    String insertWorkInfo(WorkInfo workInfo);

    /**
     * 删除我的工作
     * @author gaozhenyuan
     * @date 2019/12/25 14:23
     */
    int deleteByPrimaryKey(String id);

    /**
     * 修改我的工作
     * @author gaozhenyuan
     * @date 2019/12/25 14:23
     */
    int updateWorkInfo(WorkInfo workInfo);

    /**
     * 修改我的工作(可单项修改)
     * @author gaozhenyuan
     * @date 2019/12/25 14:23
     */
    int updateByPrimaryKeySelective(WorkInfo workInfo);

    /**
     * 查询我的工作列表
     * @author gaozhenyuan
     * @date 2019/12/25 14:23
     */
    Map<String, Object> selectWorkInfoList(Integer pageNum, Integer pageSize, String workTitle, String startTime, String status);

    /**
     * 根据Pid查询其所属属的子工作
     * @author gaozhenyuan
     * @date 2019/12/25 14:23
     */
    List<WorkInfo> selectWorkInfoByPId(String id);

    /**
     * 查询我的工作详情
     * @author gaozhenyuan
     * @date 2019/12/25 14:23
     */
    WorkInfo selectWorkInfoById(String id);

}
