package com.hxoim.support.indexTemp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * index_temp
 */
@TableAnnotation(TableName = "index_temp", TableDescription="")
public class IndexTemp {
    /**
     * 
     */
    @ColumnAnnotation(FieldName = "id",  FieldDescription="")
    private String id;

    /**
     * 机构
     */
    @ColumnAnnotation(FieldName = "org_id",  FieldDescription="机构")
    private String orgId;

    /**
     * 宽度
     */
    @ColumnAnnotation(FieldName = "temp_width",  FieldDescription="宽度")
    private Integer tempWidth;

    /**
     * 高度
     */
    @ColumnAnnotation(FieldName = "temp_height",  FieldDescription="高度")
    private Integer tempHeight;

    /**
     * 修改人
     */
    @ColumnAnnotation(FieldName = "modify_user",  FieldDescription="修改人")
    private String modifyUser;

    /**
     * 修改时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ColumnAnnotation(FieldName = "modify_time",  FieldDescription="修改时间")
    private Date modifyTime;

    /**
     * 序号
     */
    @ColumnAnnotation(FieldName = "order_no",  FieldDescription="序号")
    private Integer orderNo;

    /**
     * 坐标x轴
     */
    @ColumnAnnotation(FieldName = "topleft_x",  FieldDescription="坐标x轴")
    private Integer topleftX;

    /**
     * 坐标y轴
     */
    @ColumnAnnotation(FieldName = "topleft_y",  FieldDescription="坐标y轴")
    private Integer topleftY;

    /**
     * 模块
     */
    private List<SysTempModule> stms;

    /**
     *  模块对象
     */
    private List<LinkedHashMap<String, Object>> moduleObj;

    /**
     * 表名
     */
    @ColumnAnnotation(FieldName = "table_name",  FieldDescription="表名")
    private String tableName;
    /**
     *
     */
    @ColumnAnnotation(FieldName = "table_code",  FieldDescription="表名")
    private String tableCode;
    /**
     * 模块路径
     */
    @ColumnAnnotation(FieldName = "module_url",  FieldDescription="模块路径")
    private String moduleUrl;

    public IndexTemp(String id, String orgId, Integer tempWidth, Integer tempHeight, String modifyUser, Date modifyTime, Integer orderNo, Integer topleftX, Integer topleftY, List<SysTempModule> stms, List<LinkedHashMap<String, Object>> moduleObj, String tableName, String tableCode, String moduleUrl) {
        this.id = id;
        this.orgId = orgId;
        this.tempWidth = tempWidth;
        this.tempHeight = tempHeight;
        this.modifyUser = modifyUser;
        this.modifyTime = modifyTime;
        this.orderNo = orderNo;
        this.topleftX = topleftX;
        this.topleftY = topleftY;
        this.stms = stms;
        this.moduleObj = moduleObj;
        this.tableName = tableName;
        this.tableCode = tableCode;
        this.moduleUrl = moduleUrl;
    }

    public IndexTemp() {
        super();
    }

    /**
     * 
     * @return id 
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 机构
     * @return org_id 机构
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     * 机构
     * @param orgId 机构
     */
    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    /**
     * 宽度
     * @return temp_width 宽度
     */
    public Integer getTempWidth() {
        return tempWidth;
    }

    /**
     * 宽度
     * @param tempWidth 宽度
     */
    public void setTempWidth(Integer tempWidth) {
        this.tempWidth = tempWidth == null ? null : tempWidth;
    }

    /**
     * 高度
     * @return temp_height 高度
     */
    public Integer getTempHeight() {
        return tempHeight;
    }

    /**
     * 高度
     * @param tempHeight 高度
     */
    public void setTempHeight(Integer tempHeight) {
        this.tempHeight = tempHeight == null ? null : tempHeight;
    }

    /**
     * 修改人
     * @return modify_user 修改人
     */
    public String getModifyUser() {
        return modifyUser;
    }

    /**
     * 修改人
     * @param modifyUser 修改人
     */
    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser == null ? null : modifyUser.trim();
    }

    /**
     * 修改时间
     * @return modify_time 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 修改时间
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 序号
     * @return order_no 序号
     */
    public Integer getOrderNo() {
        return orderNo;
    }

    /**
     * 序号
     * @param orderNo 序号
     */
    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * 坐标x轴
     * @return topleft_x 坐标x轴
     */
    public Integer getTopleftX() {
        return topleftX;
    }

    /**
     * 坐标x轴
     * @param topleftX 坐标x轴
     */
    public void setTopleftX(Integer topleftX) {
        this.topleftX = topleftX == null ? null : topleftX;
    }

    /**
     * 坐标y轴
     * @return topleft_y 坐标y轴
     */
    public Integer getTopleftY() {
        return topleftY;
    }

    /**
     * 坐标y轴
     * @param topleftY 坐标y轴
     */
    public void setTopleftY(Integer topleftY) {
        this.topleftY = topleftY == null ? null : topleftY;
    }

    public List<SysTempModule> getStms() {
        return stms;
    }

    public void setStms(List<SysTempModule> stms) {
        this.stms = stms;
    }

    public List<LinkedHashMap<String, Object>> getModuleObj() {
        return moduleObj;
    }

    public void setModuleObj(List<LinkedHashMap<String, Object>> moduleObj) {
        this.moduleObj = moduleObj;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getModuleUrl() {
        return moduleUrl;
    }

    public void setModuleUrl(String moduleUrl) {
        this.moduleUrl = moduleUrl;
    }

    public String getTableCode() {
        return tableCode;
    }

    public void setTableCode(String tableCode) {
        this.tableCode = tableCode;
    }
}