package com.hxoim.kettle.logmanager.mapper;

import com.hxoim.kettle.logmanager.entity.TransstepLog;

import java.util.List;
import java.util.Map;

public interface TransstepLogMapper {
    int insert(TransstepLog record);

    int insertSelective(TransstepLog record);

    /**
     * @desc: 转换日志列表详情
     * @author: lijing
     * @date: 2019/7/18
     */
    List<TransstepLog> transLogDestail(Integer idBatch);
    /**
     * 转换提取数据统计
     * @param idDirectory
     * @return
     */
    List<Map<String, Object>> transAssignData(Integer idDirectory);

    /**
     * 作业执行转换详情
     * @param idBatch
     * @return
     */
    List<TransstepLog> jobTransLogDestail(Integer idBatch);
}