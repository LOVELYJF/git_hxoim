package com.hxoim.message.message.entity.paramentity;

/**
 * @desc: 消息列表接收参数bean
 * @author: lijing
 * @date: 2019/6/4
 */
public class SelectMsgListParam {
    /**页码*/
    private Integer pageNum;
    /**分页大小*/
    private Integer pageSize;
    /**发送时间开始时间*/
    private String startTime;
    /**发送时间结束时间*/
    private String endTime;
    /**消息分类ID*/
    private String typeId;
    /**处理状态*/
    private String handleStatus;
    /**发送类别*/
    private String messageCategory;
    /**发件箱or收件箱*/
    private String receiveOrSend;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getHandleStatus() {
        return handleStatus;
    }

    public void setHandleStatus(String handleStatus) {
        this.handleStatus = handleStatus;
    }

    public String getMessageCategory() {
        return messageCategory;
    }

    public void setMessageCategory(String messageCategory) {
        this.messageCategory = messageCategory;
    }

    public String getReceiveOrSend() {
        return receiveOrSend;
    }

    public void setReceiveOrSend(String receiveOrSend) {
        this.receiveOrSend = receiveOrSend;
    }
}
