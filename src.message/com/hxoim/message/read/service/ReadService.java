package com.hxoim.message.read.service;

import com.hxoim.message.read.entity.paramentity.ReadMarkParam;

/**
 * @desc: 消息阅读业务接口
 * @author: lijing
 * @date: 2019/6/5
 */
public interface ReadService {
    /**
     * @desc: 批量阅读消息
     * @author: lijing
     * @date: 2019/6/5
     */
    void readingMark(ReadMarkParam readMarkParam) throws Exception;

    /**
     * @desc: 未读消息数量
     * @author: lijing
     * @date: 2019/6/11
     */
    int notReadNum();
}
