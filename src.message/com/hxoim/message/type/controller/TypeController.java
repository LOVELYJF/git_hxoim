package com.hxoim.message.type.controller;

import com.hxoim.common.utils.Result;
import com.hxoim.message.type.entity.Type;
import com.hxoim.message.type.entity.TypeCustom;
import com.hxoim.message.type.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @desc 消息分类控制类
 * @author  lijing
 * @date  2019/5/27
 */
@RestController
@RequestMapping("/type")
public class TypeController {

    @Autowired
    private TypeService typeService;

    /**
     * @desc 新增消息分类
     * @author  lijing
     * @date  2019/5/27
     */
    @RequestMapping("/insertMsgType")
    public Result insertMsgType(Type type){
        String msgId = typeService.insertMsgType(type);
        return Result.success(msgId);
    }

    /**
     * @desc: 修改消息分类
     * @author: lijing
     * @date: 2019/5/28
     */
    @RequestMapping("/updateMsgType")
    public Result updateMsgType(Type type){
        typeService.updateMsgType(type);
        return Result.success();
    }

    /**
     * @desc: 查询消息分类列表
     * @author: lijing
     * @date: 2019/5/28
     */
    @RequestMapping("/selectMsgTypeList")
    public Result selectMsgTypeList(String id){
        List<TypeCustom> typeCustoms = typeService.selectMsgTypeList(id);
        return Result.success(typeCustoms);
    }

    /**
     * @desc: 通过ID查询消息分类
     * @author: lijing
     * @date: 2019/5/28
     */
    @RequestMapping("/selectMsgTypeByKey")
    public Result selectMsgTypeByKey(String id){
        Type type = typeService.selectMsgTypeByKey(id);
        return Result.success(type);
    }

    /**
     * @desc: 删除消息分类
     * @author: lijing
     * @date: 2019/5/28
     */
    @RequestMapping("/deleteMsgType")
    public Result deleteMsgType(String id){
        typeService.deleteMsgType(id);
        return Result.success();
    }

    /**
     * @desc: 查询所有分类
     * @author: lijing
     * @date: 2019/7/25
     */
    @RequestMapping("/selectAllType")
    public Result selectAllType(){
        List<Type> types = typeService.selectAllType();
        return Result.success(types);
    }
}
