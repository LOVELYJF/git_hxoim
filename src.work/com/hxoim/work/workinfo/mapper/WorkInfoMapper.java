package com.hxoim.work.workinfo.mapper;


import com.hxoim.work.workinfo.entity.WorkInfo;

import java.util.List;
import java.util.Map;

/**
 * 我的工作mapper接口
 *
 * @author gaozhenyuan
 * @date 2019/12/19 10:52
 */
public interface WorkInfoMapper {

    char WORKINFO_UNassigning ='0'; // 未分配

    char WORKINFO_UNDERWAY ='1'; //进行中

    char WORKINFO_FINISHED ='2'; //已完成


    int insert(WorkInfo workInfo);

    int deleteByPrimaryKey(String id);

    int update(WorkInfo workInfo);

    int updateByPrimaryKeySelective(WorkInfo workInfo);

    List<WorkInfo> selectWorkInfoList(Map<String,String> parm);

    List<WorkInfo> selectWorkInfoByPId(String id);

    WorkInfo selectWorkInfoById(String id);

   }