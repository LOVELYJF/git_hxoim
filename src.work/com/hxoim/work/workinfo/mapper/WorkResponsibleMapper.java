package com.hxoim.work.workinfo.mapper;


import com.hxoim.work.workinfo.entity.WorkResponsible;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 我的工作mapper接口
 *
 * @author gaozhenyuan
 * @date 2019/12/19 10:52
 */
public interface WorkResponsibleMapper {

    int insert(WorkResponsible workResponsible);

    int deleteByPrimaryKey(String id);

    int updateWorkResponsible(WorkResponsible workResponsible);

    int updateByPrimaryKeySelective(WorkResponsible workResponsible);

    List<WorkResponsible> selectListByUserId(String userId);

    List<WorkResponsible> selectListByWorkInfoId(String workInfoId);

    WorkResponsible selectWorkResponsibleById(String id);

    void updateStatusById(String id);


    void updateStatusByIds(@Param("ids") String[] ids);
}