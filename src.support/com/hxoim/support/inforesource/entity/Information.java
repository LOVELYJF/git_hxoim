package com.hxoim.support.inforesource.entity;

import java.util.List;

/**
 * @description：信息资源项实体类
 * @author ：张乾
 * @createDate ： 2019/5/29 10:52
 */
public class Information {

    //主键
    private String id;
    //英文名称
    private String englishName;
    //中文名称
    private String chineseName;
    //数据类型
    private String dataType;
    //长度
    private Integer infoLength;
    //小数位
    private Integer infoDecimal;
    //数据字典
    private String dictCode;
    //排序
    private Integer orderindex;
    //修改人
    private String modifyUser;
    //修改时间
    private String modifyTime;
    //表名
    private String tableName;
    //旧列名
    private String oldEnglishName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public Integer getInfoLength() {
        return infoLength;
    }

    public void setInfoLength(Integer infoLength) {
        this.infoLength = infoLength;
    }

    public Integer getInfoDecimal() {
        return infoDecimal;
    }

    public void setInfoDecimal(Integer infoDecimal) {
        this.infoDecimal = infoDecimal;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getOldEnglishName() {
        return oldEnglishName;
    }

    public void setOldEnglishName(String oldEnglishName) {
        this.oldEnglishName = oldEnglishName;
    }

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }

    public Integer getOrderindex() {
        return orderindex;
    }

    public void setOrderindex(Integer orderindex) {
        this.orderindex = orderindex;
    }
}