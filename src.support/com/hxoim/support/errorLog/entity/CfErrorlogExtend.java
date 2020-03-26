package com.hxoim.support.errorLog.entity;
/*
 * @description:扩展错误日志类，支持按时间范围查询
 * @author 杨波
 * @date:2019-08-13
 */

public class CfErrorlogExtend extends CfErrorlogWithBLOBs {
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
