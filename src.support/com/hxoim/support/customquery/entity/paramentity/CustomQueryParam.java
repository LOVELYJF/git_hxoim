package com.hxoim.support.customquery.entity.paramentity;

import com.hxoim.support.customquery.entity.custom.ConditionEntity;
import com.hxoim.support.customquery.entity.custom.OrderEntity;

import java.util.List;

/**
 * @desc: 自定义查询参数实体类
 * @author: lijing
 * @date: 2019/8/2
 */
public class CustomQueryParam {
    /**
     * 页码
     */
    private int pageNum;

    /**
     * 每页显示条数
     */
    private int pageSize;

    /**
     * 是否分页
     */
    private boolean isPage;

    /**
     * 条件数组
     */
    private List<ConditionEntity> conditionEntities;

    /**
     * 排序数组
     */
    private List<OrderEntity> orderEntities;

    /**
     * 列集合
     */
    private List<String> fileds;

    /**
     * 机构id 多个逗号分隔
     */
    private String b0111;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<ConditionEntity> getConditionEntities() {
        return conditionEntities;
    }

    public void setConditionEntities(List<ConditionEntity> conditionEntities) {
        this.conditionEntities = conditionEntities;
    }

    public List<OrderEntity> getOrderEntities() {
        return orderEntities;
    }

    public void setOrderEntities(List<OrderEntity> orderEntities) {
        this.orderEntities = orderEntities;
    }

    public List<String> getFileds() {
        return fileds;
    }

    public void setFileds(List<String> fileds) {
        this.fileds = fileds;
    }

    public String getB0111() {
        return b0111;
    }

    public void setB0111(String b0111) {
        this.b0111 = b0111;
    }

    public boolean getIsPage() {
        return isPage;
    }

    public void setIsPage(boolean isPage) {
        this.isPage = isPage;
    }
}
