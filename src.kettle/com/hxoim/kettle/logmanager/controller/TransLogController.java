package com.hxoim.kettle.logmanager.controller;

import com.github.pagehelper.PageInfo;
import com.hxoim.common.utils.Result;
import com.hxoim.kettle.logmanager.entity.TransLog;
import com.hxoim.kettle.logmanager.entity.TransstepLog;
import com.hxoim.kettle.logmanager.service.TransLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @desc: 转换日志
 * @author: lijing
 * @date: 2019/7/17
 */
@RestController
@RequestMapping("/transLog")
public class TransLogController {
    @Autowired
    private TransLogService transLogService;

    /**
     * @desc: 转换日志列表
     * @author: lijing
     * @date: 2019/7/12
     */
    @RequestMapping("/transLogList")
    public Result transLogList(String dirID, String name, Integer pageNum, Integer pageSize) {
        PageInfo<TransLog> pageInfo = transLogService.transLogList(dirID, name, pageNum, pageSize);
        return Result.success(pageInfo);
    }

    /**
     * @desc: 转换日志列表详情
     * @author: lijing
     * @date: 2019/7/12
     */
    @RequestMapping("/transLogDestail")
    public Result transLogDestail(Integer idBatch) {
        List<TransstepLog> pageInfo = transLogService.transLogDestail(idBatch);
        return Result.success(pageInfo);
    }
}
