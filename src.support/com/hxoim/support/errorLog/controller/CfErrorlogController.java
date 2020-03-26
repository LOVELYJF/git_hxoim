package com.hxoim.support.errorLog.controller;
/*
 * @description:
 * @author 杨波
 * @date:2019-08-13
 */

import com.github.pagehelper.PageInfo;
import com.hxoim.common.utils.Result;
import com.hxoim.support.errorLog.entity.CfErrorlogExtend;
import com.hxoim.support.errorLog.entity.CfErrorlogWithBLOBs;
import com.hxoim.support.errorLog.service.CfErrorlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/Errorlog")
public class CfErrorlogController {
    @Autowired
    private CfErrorlogService service;

    /**
     * @description:按主键删除错误日志
     * @author:杨波
     * @date:2019-08-13 * @param String id 错误日志主键
     * @return:
     **/
    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(String id) {
        service.deleteByPrimaryKey(id);
        return Result.success();
    }

    /**
     * @description:保存错误日志，包含二进制字段
     * @author:杨波
     * @date:2019-08-13 * @param CfErrorlogWithBLOBs record 要保存的错误日志
     * @return:
     **/
    @RequestMapping("/insert")
    public Result insert(CfErrorlogWithBLOBs record) {
        service.insert(record);
        return Result.success();
    }

    /**
     * @description:保存错误日志，包含二进制字段
     * @author:杨波
     * @date:2019-08-13 * @param CfErrorlogWithBLOBs record 要保存的错误日志
     * @return:
     **/
    @RequestMapping("/insertSelective")
    public Result insertSelective(CfErrorlogWithBLOBs record) {
        service.insertSelective(record);
        return Result.success();
    }

    /**
     * @description:按自定义条件查询，同时返回二进制字段
     * @author:杨波
     * @date:2019-08-13 * @param CfErrorlogExample example 自定义查询条件
     * @return:
     **/
    @RequestMapping("/select")
    public Result selectByExampleWithBLOBs(CfErrorlogExtend log) throws ParseException {
        PageInfo<CfErrorlogWithBLOBs> r = service.select(log);
        return Result.success(r);
    }

    /**
     * @description:按主键查询错误日志
     * @author:杨波
     * @date:2019-08-13 * @param String id 错误日志主键
     * @return:
     **/
    @RequestMapping("/selectByPrimaryKey")
    public Result selectByPrimaryKey(String id) {
        CfErrorlogWithBLOBs r = service.selectByPrimaryKey(id);
        return Result.success(r);
    }
}
