package com.hxoim.support.b01.controller;

import com.hxoim.common.utils.Result;
import com.hxoim.support.b01.entity.B02;
import com.hxoim.support.b01.service.B02Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ description：机构编制Controller
 * @ author：张乾
 * @ createDate ： 2019/6/6 11:05
 */
@RestController
@RequestMapping("/b02")
public class B02Controller {

    @Autowired
    private B02Service b02Service;

    /**
     * @ description: 查询机构编制信息
     * @ create by: 张乾
     * @ createDate: 2019/6/7 16:02
     */
    @RequestMapping("/selectB02Byb0111")
    public Result selectB02Byb0111(String b0111){
        B02 b02=b02Service.selectB02Byb0111(b0111);
        return Result.success(b02);
    }

    /**
     * @ description: 编辑编制信息
     * @ create by: 张乾
     * @ createDate: 2019/6/7 16:29
     */
    @RequestMapping("/updateB02")
    public Result updateB02(B02 b02){
        b02Service.updateB02(b02);
        return Result.success();
    }

    /**
     * @ description: 删除编制信息
     * @ create by: 张乾
     * @ createDate: 2019/6/7 17:07
     */
    @RequestMapping("/deleteB02")
    public Result deleteB02(String b0111){
        b02Service.deleteB02(b0111);
        return Result.success();
    }
    /**
     * @ description: 插入编制信息
     * @ create by: 杨波
     * @ createDate: 2019/7/25 09:38
     */
    @RequestMapping("/insertB02")
    public Result insertB02(B02 b02) {
        b02Service.insertB02(b02);
        return Result.success();
    }
}
