package com.hxoim.support.DataChangedLog.entity;/*
 * @description:对日志的扩展，用于日志查询
 * @author 杨波
 * @date:2019-08-09
 */

public class CfDatachangedlogExtend extends CfDatachangedlog {

    public String getOperateFrom() {
        return operateFrom;
    }

    public void setOperateFrom(String operateFrom) {
        this.operateFrom = operateFrom;
    }

    //操作日期到从
    private String operateFrom;

    public String getOperateTo() {
        return operateTo;
    }

    public void setOperateTo(String operateTo) {
        this.operateTo = operateTo;
    }

    //操作日期到
    private String operateTo;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    private int pageNum;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    private  int pageSize;
}
