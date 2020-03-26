package com.hxoim.kettle.logmanager.mapper;

import com.hxoim.kettle.logmanager.entity.TransLog;

import java.util.List;
import java.util.Map;

public interface TransLogMapper {
    int insert(TransLog record);

    int insertSelective(TransLog record);

    /**
     * @desc: 转换日志列表
     * @author: lijing
     * @date: 2019/7/18
     */
    List<TransLog> transLogList(Map<String, Object> params);

    /**
     * 转换执行次数
     * @param idDirectory
     * @return
     */
    List<Map<String, Object>> transExecuteNum(Integer idDirectory);
}