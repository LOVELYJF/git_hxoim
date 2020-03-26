package com.hxoim.kettle.logmanager.service;

import com.github.pagehelper.PageInfo;
import com.hxoim.kettle.logmanager.entity.TransLog;
import com.hxoim.kettle.logmanager.entity.TransstepLog;

import java.util.List;

public interface TransLogService {
    /**
     * @desc: 转换日志列表
     * @author: lijing
     * @date: 2019/7/12
     */
    PageInfo<TransLog> transLogList(String dirID, String name, Integer pageNum, Integer pageSize);

    /**
     * @desc: 转换日志列表详情
     * @author: lijing
     * @date: 2019/7/12
     */
    List<TransstepLog> transLogDestail(Integer idBatch);
}
