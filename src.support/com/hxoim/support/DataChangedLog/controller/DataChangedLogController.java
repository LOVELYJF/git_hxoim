package com.hxoim.support.DataChangedLog.controller;

import com.github.pagehelper.PageInfo;
import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.common.utils.Result;
import com.hxoim.common.utils.UUIDGenerator;
import com.hxoim.support.DataChangedLog.entity.CfDatachangedlog;
import com.hxoim.support.DataChangedLog.entity.CfDatachangedlogExample;
import com.hxoim.support.DataChangedLog.entity.CfDatachangedlogExtend;
import com.hxoim.support.DataChangedLog.service.DataChangedLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/*
 * @description:数据修改日志查询维护
 * @author 杨波
 * @date:2019-06-10
 */
@RestController
@RequestMapping("/DataChangedLog")
public class DataChangedLogController {
    @Autowired
    private DataChangedLogService dclService;

    /**
     * @description:新增日志，Id或操作时间为空时，系统自动赋值，表名，操作人，修改内容不能为空
     * @author:杨波
     * @date:2019-06-10
     *  * @param record
     * @return:int
     **/
    @RequestMapping("/insertSelective")
    public int insertSelective(CfDatachangedlog record) {

        return dclService.insertSelective(record);
    }
    /**
     * @description:查询数据修改日志
     * @author:杨波
     * @date:2019-06-10
     *  * @param example
     * @return:java.util.List<com.hxoim.support.DataChangedLog.entity.CfDatachangedlog>
     **/
    @RequestMapping("/selectByExampleWithBLOBs")
    public List<CfDatachangedlog> selectByExampleWithBLOBs(CfDatachangedlogExample example) {
        return dclService.selectByExampleWithBLOBs(example);
    }
    @RequestMapping("/select")
    public Result select(CfDatachangedlogExtend record) throws ParseException {
        PageInfo<CfDatachangedlog> r = dclService.select(record);
        return Result.success(r);
    }
}
