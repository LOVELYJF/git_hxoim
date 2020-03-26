package com.hxoim.message.read.controller;

import com.hxoim.common.utils.Result;
import com.hxoim.message.read.entity.paramentity.ReadMarkParam;
import com.hxoim.message.read.service.ReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc: 消息阅读控制层
 * @author: lijing
 * @date: 2019/6/5
 */
@RestController
@RequestMapping("/read")
public class ReadController {

    @Autowired
    private ReadService readService;

    /**
     * @desc: 批量阅读消息
     * @author: lijing
     * @date: 2019/6/4
     */
    @RequestMapping("/readingMark")
    public Result readingMark(ReadMarkParam readMarkParam) throws Exception {
        readService.readingMark(readMarkParam);
        return Result.success();
    }

    /**
     * @desc: 未读消息数量
     * @author: lijing
     * @date: 2019/6/12
     */
    @RequestMapping("/notReadNum")
    public Result notReadNum() {
        int num = readService.notReadNum();
        return Result.success(num);
    }
}
