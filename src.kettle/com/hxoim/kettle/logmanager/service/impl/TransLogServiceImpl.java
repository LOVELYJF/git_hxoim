package com.hxoim.kettle.logmanager.service.impl;

import com.github.pagehelper.PageInfo;
import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.common.utils.PageUtil;
import com.hxoim.kettle.logmanager.entity.TransLog;
import com.hxoim.kettle.logmanager.entity.TransstepLog;
import com.hxoim.kettle.logmanager.mapper.TransLogMapper;
import com.hxoim.kettle.logmanager.mapper.TransstepLogMapper;
import com.hxoim.kettle.logmanager.service.TransLogService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @desc: 转换日志
 * @author: lijing
 * @date: 2019/7/17
 */
@Service
public class TransLogServiceImpl implements TransLogService {
    @Autowired
    private TransLogMapper transLogMapper;
    @Autowired
    private TransstepLogMapper transstepLogMapper;

    @Override
    public PageInfo<TransLog> transLogList(String dirID, String name, Integer pageNum, Integer pageSize) {
        if (StringUtils.isEmpty(dirID)){
            throw new ParameterNullException("任务不能为空");
        }
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("idDirectory", dirID);
        paramMap.put("name", name);
        //分页
        PageUtil.pageHelp(pageNum, pageSize);
        List<TransLog> transLogs = transLogMapper.transLogList(paramMap);
        //返回数据
        PageInfo<TransLog> pageInfo = new PageInfo(transLogs);
        return pageInfo;
    }

    @Override
    public List<TransstepLog> transLogDestail(Integer idBatch) {
        if (idBatch == null){
            throw new ParameterNullException("请选择记录");
        }
        List<TransstepLog> transLogs = transstepLogMapper.transLogDestail(idBatch);
        return transLogs;
    }
}
