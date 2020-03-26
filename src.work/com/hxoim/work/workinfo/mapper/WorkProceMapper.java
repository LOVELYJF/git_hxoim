package com.hxoim.work.workinfo.mapper;


import com.hxoim.work.workinfo.entity.WorkProce;
import com.hxoim.work.workinfo.entity.WorkResponsible;

import java.util.List;

/**
 * 我的工作mapper接口
 *
 * @author gaozhenyuan
 * @date 2019/12/19 10:52
 */
public interface WorkProceMapper {

    int insert(WorkProce workProce);

    int deleteByPrimaryKey(String id);

    int update(WorkProce workProce);

    List<WorkProce> selectListById(String id);

    WorkProce selectWorkProceById(String id);

   }