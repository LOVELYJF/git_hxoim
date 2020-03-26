package com.hxoim.support.operateLog.controller;
/*
 * @description:操作方式维护
 * @author 杨波
 * @date:2019-08-09
 */

import com.hxoim.common.utils.Result;
import com.hxoim.support.operateLog.entity.CfOperatemethod;
import com.hxoim.support.operateLog.service.CfOperatemethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Operatemethod")
public class CfOperatemethodController {
    @Autowired
    private CfOperatemethodService service;

    /**
     * @description:按主键删除操作方式
     * @author:杨波
     * @date:2019-08-09 * @param String id
     * @return:
     **/
    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(String id){
        service.deleteByPrimaryKey(id);
        return Result.success();
    }

    /**
     * @description:插入操作方式
     * @author:杨波
     * @date:2019-08-09 * @param CfOperatemethod record
     * @return:
     **/

    @RequestMapping("/insert")
    public Result insert(CfOperatemethod record){
        service.insert(record);
        return Result.success();
    }

    /**
     * @description:插入操作方式
     * @author:杨波
     * @date:2019-08-09 * @param CfOperatemethod record
     * @return:
     **/
    @RequestMapping("/insertSelective")
    public Result insertSelective(CfOperatemethod record){
        service.insertSelective(record);
        return Result.success();
    }

    /**
     * @description:查询操作方式,根据编号或名字查询
     * @author:杨波
     * @date:2019-08-09 * @param CfOperatemethodExample example
     * @return:
     **/
    @RequestMapping("/select")
    public Result selectByExample(CfOperatemethod record){

        List<CfOperatemethod> r=service.selectByExample(record);
        return Result.success(r);
    }

    /**
     * @description:按主键查询操作方式
     * @author:杨波
     * @date:2019-08-09 * @param String id
     * @return:
     **/
    @RequestMapping("/selectByPrimaryKey")
    public Result selectByPrimaryKey(String id){
        CfOperatemethod r = service.selectByPrimaryKey(id);
        return Result.success(r);
    }

    /**
     * @description:更新操作方式
     * @author:杨波
     * @date:2019-08-09
     * * @param CfOperatemethod record
     * @return:
     **/
    @RequestMapping("/updateByPrimaryKeySelective")
    public Result updateByPrimaryKeySelective(CfOperatemethod record){
        service.updateByPrimaryKeySelective(record);
        return Result.success();
    }

    /**
     * @description:更新操作方式
     * @author:杨波
     * @date:2019-08-09
     * * @param CfOperatemethod record
     * @return:
     **/
    @RequestMapping("/updateByPrimaryKey")
    public Result updateByPrimaryKey(CfOperatemethod record){
        service.updateByPrimaryKey(record);
        return Result.success();
    }
}
