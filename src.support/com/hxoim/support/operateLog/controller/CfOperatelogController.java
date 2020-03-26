package com.hxoim.support.operateLog.controller;
/*
 * @description:
 * @author 杨波
 * @date:2019-08-02
 */

import com.github.pagehelper.PageInfo;
import com.hxoim.common.utils.Result;
import com.hxoim.support.operateLog.entity.CfOperatelog;
import com.hxoim.support.operateLog.entity.CfOperatelogExtend;
import com.hxoim.support.operateLog.service.CfOperatelogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/Operatelog")
public class CfOperatelogController {
    @Autowired
    private CfOperatelogService service;

    /**
     * @description: 按主键删除日志
     * @author:杨波
     * @date:2019-08-02
     * * @param String id
     * @return:
     **/
    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(String id) {
        service.deleteByPrimaryKey(id);
        return Result.success();
    }

    /**
     * @description:插入操作日志
     * @author:杨波
     * @date:2019-08-02
     * * @param CfOperatelog record
     * @return:
     **/
    @RequestMapping("/insert")
    public Result insert(CfOperatelog record) {
        service.insert(record);
        return Result.success();
    }

    /**
     * @description:插入操作日志
     * @author:杨波
     * @date:2019-08-02
     * * @param CfOperatelog record
     * @return:
     **/
    @RequestMapping("/insertSelective")
    public Result insertSelective(CfOperatelog record) {
        service.insertSelective(record);
        return Result.success();
    }

    /**
     * @description:通用查询,会按模块、操作员、操作日期、IP查询、操作方式组合查询
     * @author:杨波
     * @date:2019-08-02
     * * @param null
     * @return:
     **/
    @RequestMapping("/select")
    public Result selectByExample(CfOperatelogExtend record) throws ParseException {
        PageInfo<CfOperatelog> r = service.selectByExample(record);
        return Result.success(r);
    }

    /**
     * @description:按主键查询
     * @author:杨波
     * @date:2019-08-02 * @param String id
     * @return:
     **/
    @RequestMapping("/selectByPrimaryKey")
    public Result selectByPrimaryKey(String id){
        CfOperatelog r = service.selectByPrimaryKey(id);
        return Result.success(r);
    }

    /**
     * @description:修改日志
     * @author:杨波
     * @date:2019-08-02
     * * @param CfOperatelog record
     * @return:
     **/
    @RequestMapping("/updateByPrimaryKeySelective")
    public Result updateByPrimaryKeySelective(CfOperatelog record){
        service.updateByPrimaryKeySelective(record);
        return Result.success();
    }

    /**
     * @description:修改日志
     * @author:杨波
     * @date:2019-08-02
     * * @param CfOperatelog record
     * @return:
     **/
    @RequestMapping("/updateByPrimaryKey")
    public Result updateByPrimaryKey(CfOperatelog record){
        service.updateByPrimaryKey(record);
        return Result.success();
    }
}
