package com.hxoim.common.utils;

import com.alibaba.fastjson.JSONArray;

import java.util.List;

/**
 * 接收集合的工具类
 *
 * @author sunqian
 * @date 2019/6/29 14:45
 */
public class RequestList<T> {

    private String list;

    public List<T> getList(Class<T> clazz) {
        List<T> returnList = JSONArray.parseArray(list, clazz);
        return returnList;
    }

    public void setList(String list) {
        this.list = list;
    }
}
