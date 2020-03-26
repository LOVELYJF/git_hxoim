package com.hxoim.common.utils;

import com.github.pagehelper.PageHelper;

import java.util.List;

/**
 * @desc: 分页工具类
 * @author: lijing
 * @date: 2019/6/1
 */
public class PageUtil<T> {

    private int page;
    private int limit;
    private int total;
    private List<T> list;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        //现职页数需要从1开始
        if (page <= 0) {
            page = 1;
        }
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    /**
     * @param pageNum  页码
     * @param pageSize 分页大小
     * @desc: 列表分页
     * @author: lijing
     * @date: 2019/6/1
     */
    public static void pageHelp(Integer pageNum, Integer pageSize) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        //设置传入页码，以及每页的大小
        PageHelper.startPage(pageNum, pageSize);
    }
}
