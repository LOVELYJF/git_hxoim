package com.hxoim.support.inforesource.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.IdAnnotation;
import com.hxoim.common.hxannotation.IgnoreLogAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * data_table_col
 */
@TableAnnotation(TableName = "data_table_col", TableDescription="")
public class DataTableCol {
    /**
     * 主键唯一标识
     */
    @IdAnnotation
    @ColumnAnnotation(FieldName = "ID",  FieldDescription="主键唯一标识")
    private String id;

    /**
     * 表编码
     */
    @ColumnAnnotation(FieldName = "TAB_CODE",  FieldDescription="表编码")
    private String tabCode;

    /**
     * 列编码
     */
    @ColumnAnnotation(FieldName = "COL_CODE",  FieldDescription="列编码")
    private String colCode;

    /**
     * 名称
     */
    @ColumnAnnotation(FieldName = "COL_NAME",  FieldDescription="名称")
    private String colName;

    /**
     * 另显示名
     */
    @ColumnAnnotation(FieldName = "COL_NAME_SHOW",  FieldDescription="另显示名")
    private String colNameShow;

    /**
     * 是否系统字段,0-是系统字段;1-不是系统字段
     */
    @ColumnAnnotation(FieldName = "IS_SYSTEM_FIELD",  FieldDescription="是否系统字段,0-是系统字段;1-不是系统字段")
    private String isSystemField;

    /**
     * 是否可编辑,0-可编辑;1-不可编辑
     */
    @ColumnAnnotation(FieldName = "IS_SYSTEM_FIELD_READONLY",  FieldDescription="是否可编辑,0-可编辑;1-不可编辑")
    private String isSystemFieldReadonly;

    /**
     * 数据类型
     */
    @ColumnAnnotation(FieldName = "DATA_TYPE",  FieldDescription="数据类型")
    private String dataType;

    /**
     * 小数位
     */
    @ColumnAnnotation(FieldName = "DECIMAL_PLACE",  FieldDescription="小数位")
    private String decimalPlace;

    /**
     * 是否计算列,0是计算列,1-不是计算列
     */
    @ColumnAnnotation(FieldName = "IS_CALCULATE_FIELD",  FieldDescription="是否计算列,0是计算列,1-不是计算列")
    private String isCalculateField;

    /**
     * 计算公式
     */
    @ColumnAnnotation(FieldName = "FORMULAS",  FieldDescription="计算公式")
    private String formulas;

    /**
     * 可作为查询项
     */
    @ColumnAnnotation(FieldName = "IS_SHOW",  FieldDescription="可作为查询项")
    private String isShow;

    /**
     * 控件类型
     */
    @ColumnAnnotation(FieldName = "CONTROL_TYPE",  FieldDescription="控件类型")
    private String controlType;

    /**
     * 显示格式  1=年.月  2=年.月.日  3=年
     */
    @ColumnAnnotation(FieldName = "SHOW_FORMAT",  FieldDescription="显示格式  1=年.月  2=年.月.日  3=年")
    private String showFormat;

    /**
     * 关联字典
     */
    @ColumnAnnotation(FieldName = "DIC_CODE",  FieldDescription="关联字典")
    private String dicCode;

    /**
     * 默认值
     */
    @ColumnAnnotation(FieldName = "DEFAULT_VALUE",  FieldDescription="默认值")
    private String defaultValue;

    /**
     * 时间戳
     */
    @ColumnAnnotation(FieldName = "TIME_STAMP",  FieldDescription="时间戳")
    private String timeStamp;

    /**
     * 逻辑删除,0-未删除,1-已删除
     */
    @ColumnAnnotation(FieldName = "IS_DELETED",  FieldDescription="逻辑删除,0-未删除,1-已删除")
    private String isDeleted;

    /**
     * 修改人
     */
    @ColumnAnnotation(FieldName = "MODIFY_USER",  FieldDescription="修改人")
    private String modifyUser;

    /**
     * 修改时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ColumnAnnotation(FieldName = "MODIFY_TIME",  FieldDescription="修改时间")
    private Date modifyTime;

    /**
     * 排序
     */
    @ColumnAnnotation(FieldName = "ORDER_INDEX",  FieldDescription="排序")
    private Integer orderIndex;

    /**
     * 
     */
    @ColumnAnnotation(FieldName = "A01_MAPPING",  FieldDescription="")
    private String a01Mapping;

    /**
     * 表单：是否在表单中显示
     */
    @ColumnAnnotation(FieldName = "IS_SHOW_AT_FORM",  FieldDescription="表单：是否在表单中显示")
    private String isShowAtForm;

    /**
     * 表单：跨列
     */
    @ColumnAnnotation(FieldName = "COLSPAN",  FieldDescription="表单：跨列")
    private String colspan;

    /**
     * 列表：是否在列表中显示
     */
    @ColumnAnnotation(FieldName = "IS_SHOW_AT_LIST",  FieldDescription="列表：是否在列表中显示")
    private String isShowAtList;

    /**
     * 列表：对齐方式 1居中 2居左 3居右
     */
    @ColumnAnnotation(FieldName = "ALIGN",  FieldDescription="列表：对齐方式 1居中 2居左 3居右")
    private String align;

    /**
     * 列表：是否可排序
     */
    @ColumnAnnotation(FieldName = "SORT_ABLE",  FieldDescription="列表：是否可排序")
    private String sortAble;

    /**
     * 是否是系统字段
     */
    @ColumnAnnotation(FieldName = "IS_SYSTEM",  FieldDescription="是否是系统字段")
    private String isSystem;

    /**
     * 是否必填;0-为空;1-不为空
     */
    @ColumnAnnotation(FieldName = "IS_NECESSARY",  FieldDescription="是否必填;0-为空;1-不为空")
    private String isNecessary;

    /**
     * 
     */
    @ColumnAnnotation(FieldName = "LENGTH_1",  FieldDescription="")
    private Integer length1;

    /**
     * 
     */
    @ColumnAnnotation(FieldName = "WIDTH_1",  FieldDescription="")
    private Integer width1;

    /**
     * 是否主键；1是；0否
     */
    @ColumnAnnotation(FieldName = "IS_PK",  FieldDescription="是否主键；1是；0否")
    private String isPk;

    /**
     * 是否任免表外：1-是；0-否
     */
    @ColumnAnnotation(FieldName = "IS_RMB_OUT",  FieldDescription="是否任免表外：1-是；0-否")
    private String isRmbOut;

    /**
     * 联动信息项
     */
    @ColumnAnnotation(FieldName = "LINK_ITEM",  FieldDescription="联动信息项")
    private String linkItem;

    /**
     * 是否是批量维护字段 ture/false
     */
    @ColumnAnnotation(FieldName = "IS_BATCH",  FieldDescription="是否是批量维护字段 ture/false")
    private String isBatch;

    /**
     * 是否在人员信息项显示1:显示，0:不显示
     */
    @ColumnAnnotation(FieldName = "IS_SHOW_AT_PERSONITEM",  FieldDescription="是否在人员信息项显示1:显示，0:不显示")
    private String isShowAtPersonitem;

    /**
     * 数据来源表
     */
    @ColumnAnnotation(FieldName = "LINK_TABLE",  FieldDescription="数据来源表")
    private String linkTable;

    /**
     * 数据来源值字段
     */
    @ColumnAnnotation(FieldName = "LINK_VALUECOLUMN",  FieldDescription="数据来源值字段")
    private String linkValuecolumn;

    /**
     * 数据来源显示字段
     */
    @ColumnAnnotation(FieldName = "LINK_LABELCOLUMN",  FieldDescription="数据来源显示字段")
    private String linkLabelcolumn;

    /**
     * 数据来源上级字段
     */
    @ColumnAnnotation(FieldName = "LINK_PARENTCOLUMN",  FieldDescription="数据来源上级字段")
    private String linkParentcolumn;

    public DataTableCol(String id, String tabCode, String colCode, String colName, String colNameShow, String isSystemField, String isSystemFieldReadonly, String dataType, String decimalPlace, String isCalculateField, String formulas, String isShow, String controlType, String showFormat, String dicCode, String defaultValue, String timeStamp, String isDeleted, String modifyUser, Date modifyTime, Integer orderIndex, String a01Mapping, String isShowAtForm, String colspan, String isShowAtList, String align, String sortAble, String isSystem, String isNecessary, Integer length1, Integer width1, String isPk, String isRmbOut, String linkItem, String isBatch, String isShowAtPersonitem, String linkTable, String linkValuecolumn, String linkLabelcolumn, String linkParentcolumn) {
        this.id = id;
        this.tabCode = tabCode;
        this.colCode = colCode;
        this.colName = colName;
        this.colNameShow = colNameShow;
        this.isSystemField = isSystemField;
        this.isSystemFieldReadonly = isSystemFieldReadonly;
        this.dataType = dataType;
        this.decimalPlace = decimalPlace;
        this.isCalculateField = isCalculateField;
        this.formulas = formulas;
        this.isShow = isShow;
        this.controlType = controlType;
        this.showFormat = showFormat;
        this.dicCode = dicCode;
        this.defaultValue = defaultValue;
        this.timeStamp = timeStamp;
        this.isDeleted = isDeleted;
        this.modifyUser = modifyUser;
        this.modifyTime = modifyTime;
        this.orderIndex = orderIndex;
        this.a01Mapping = a01Mapping;
        this.isShowAtForm = isShowAtForm;
        this.colspan = colspan;
        this.isShowAtList = isShowAtList;
        this.align = align;
        this.sortAble = sortAble;
        this.isSystem = isSystem;
        this.isNecessary = isNecessary;
        this.length1 = length1;
        this.width1 = width1;
        this.isPk = isPk;
        this.isRmbOut = isRmbOut;
        this.linkItem = linkItem;
        this.isBatch = isBatch;
        this.isShowAtPersonitem = isShowAtPersonitem;
        this.linkTable = linkTable;
        this.linkValuecolumn = linkValuecolumn;
        this.linkLabelcolumn = linkLabelcolumn;
        this.linkParentcolumn = linkParentcolumn;
    }

    public DataTableCol() {
        super();
    }

    /**
     * 主键唯一标识
     * @return ID 主键唯一标识
     */
    public String getId() {
        return id;
    }

    /**
     * 主键唯一标识
     * @param id 主键唯一标识
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 表编码
     * @return TAB_CODE 表编码
     */
    public String getTabCode() {
        return tabCode;
    }

    /**
     * 表编码
     * @param tabCode 表编码
     */
    public void setTabCode(String tabCode) {
        this.tabCode = tabCode == null ? null : tabCode.trim();
    }

    /**
     * 列编码
     * @return COL_CODE 列编码
     */
    public String getColCode() {
        return colCode;
    }

    /**
     * 列编码
     * @param colCode 列编码
     */
    public void setColCode(String colCode) {
        this.colCode = colCode == null ? null : colCode.trim();
    }

    /**
     * 名称
     * @return COL_NAME 名称
     */
    public String getColName() {
        return colName;
    }

    /**
     * 名称
     * @param colName 名称
     */
    public void setColName(String colName) {
        this.colName = colName == null ? null : colName.trim();
    }

    /**
     * 另显示名
     * @return COL_NAME_SHOW 另显示名
     */
    public String getColNameShow() {
        return colNameShow;
    }

    /**
     * 另显示名
     * @param colNameShow 另显示名
     */
    public void setColNameShow(String colNameShow) {
        this.colNameShow = colNameShow == null ? null : colNameShow.trim();
    }

    /**
     * 是否系统字段,0-是系统字段;1-不是系统字段
     * @return IS_SYSTEM_FIELD 是否系统字段,0-是系统字段;1-不是系统字段
     */
    public String getIsSystemField() {
        return isSystemField;
    }

    /**
     * 是否系统字段,0-是系统字段;1-不是系统字段
     * @param isSystemField 是否系统字段,0-是系统字段;1-不是系统字段
     */
    public void setIsSystemField(String isSystemField) {
        this.isSystemField = isSystemField == null ? null : isSystemField.trim();
    }

    /**
     * 是否可编辑,0-可编辑;1-不可编辑
     * @return IS_SYSTEM_FIELD_READONLY 是否可编辑,0-可编辑;1-不可编辑
     */
    public String getIsSystemFieldReadonly() {
        return isSystemFieldReadonly;
    }

    /**
     * 是否可编辑,0-可编辑;1-不可编辑
     * @param isSystemFieldReadonly 是否可编辑,0-可编辑;1-不可编辑
     */
    public void setIsSystemFieldReadonly(String isSystemFieldReadonly) {
        this.isSystemFieldReadonly = isSystemFieldReadonly == null ? null : isSystemFieldReadonly.trim();
    }

    /**
     * 数据类型
     * @return DATA_TYPE 数据类型
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * 数据类型
     * @param dataType 数据类型
     */
    public void setDataType(String dataType) {
        this.dataType = dataType == null ? null : dataType.trim();
    }

    /**
     * 小数位
     * @return DECIMAL_PLACE 小数位
     */
    public String getDecimalPlace() {
        return decimalPlace;
    }

    /**
     * 小数位
     * @param decimalPlace 小数位
     */
    public void setDecimalPlace(String decimalPlace) {
        this.decimalPlace = decimalPlace == null ? null : decimalPlace.trim();
    }

    /**
     * 是否计算列,0是计算列,1-不是计算列
     * @return IS_CALCULATE_FIELD 是否计算列,0是计算列,1-不是计算列
     */
    public String getIsCalculateField() {
        return isCalculateField;
    }

    /**
     * 是否计算列,0是计算列,1-不是计算列
     * @param isCalculateField 是否计算列,0是计算列,1-不是计算列
     */
    public void setIsCalculateField(String isCalculateField) {
        this.isCalculateField = isCalculateField == null ? null : isCalculateField.trim();
    }

    /**
     * 计算公式
     * @return FORMULAS 计算公式
     */
    public String getFormulas() {
        return formulas;
    }

    /**
     * 计算公式
     * @param formulas 计算公式
     */
    public void setFormulas(String formulas) {
        this.formulas = formulas == null ? null : formulas.trim();
    }

    /**
     * 可作为查询项
     * @return IS_SHOW 可作为查询项
     */
    public String getIsShow() {
        return isShow;
    }

    /**
     * 可作为查询项
     * @param isShow 可作为查询项
     */
    public void setIsShow(String isShow) {
        this.isShow = isShow == null ? null : isShow.trim();
    }

    /**
     * 控件类型
     * @return CONTROL_TYPE 控件类型
     */
    public String getControlType() {
        return controlType;
    }

    /**
     * 控件类型
     * @param controlType 控件类型
     */
    public void setControlType(String controlType) {
        this.controlType = controlType == null ? null : controlType.trim();
    }

    /**
     * 显示格式  1=年.月  2=年.月.日  3=年
     * @return SHOW_FORMAT 显示格式  1=年.月  2=年.月.日  3=年
     */
    public String getShowFormat() {
        return showFormat;
    }

    /**
     * 显示格式  1=年.月  2=年.月.日  3=年
     * @param showFormat 显示格式  1=年.月  2=年.月.日  3=年
     */
    public void setShowFormat(String showFormat) {
        this.showFormat = showFormat == null ? null : showFormat.trim();
    }

    /**
     * 关联字典
     * @return DIC_CODE 关联字典
     */
    public String getDicCode() {
        return dicCode;
    }

    /**
     * 关联字典
     * @param dicCode 关联字典
     */
    public void setDicCode(String dicCode) {
        this.dicCode = dicCode == null ? null : dicCode.trim();
    }

    /**
     * 默认值
     * @return DEFAULT_VALUE 默认值
     */
    public String getDefaultValue() {
        return defaultValue;
    }

    /**
     * 默认值
     * @param defaultValue 默认值
     */
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue == null ? null : defaultValue.trim();
    }

    /**
     * 时间戳
     * @return TIME_STAMP 时间戳
     */
    public String getTimeStamp() {
        return timeStamp;
    }

    /**
     * 时间戳
     * @param timeStamp 时间戳
     */
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp == null ? null : timeStamp.trim();
    }

    /**
     * 逻辑删除,0-未删除,1-已删除
     * @return IS_DELETED 逻辑删除,0-未删除,1-已删除
     */
    public String getIsDeleted() {
        return isDeleted;
    }

    /**
     * 逻辑删除,0-未删除,1-已删除
     * @param isDeleted 逻辑删除,0-未删除,1-已删除
     */
    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted == null ? null : isDeleted.trim();
    }

    /**
     * 修改人
     * @return MODIFY_USER 修改人
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
     * @return MODIFY_TIME 修改时间
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
     * 排序
     * @return ORDER_INDEX 排序
     */
    public Integer getOrderIndex() {
        return orderIndex;
    }

    /**
     * 排序
     * @param orderIndex 排序
     */
    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }

    /**
     * 
     * @return A01_MAPPING 
     */
    public String getA01Mapping() {
        return a01Mapping;
    }

    /**
     * 
     * @param a01Mapping 
     */
    public void setA01Mapping(String a01Mapping) {
        this.a01Mapping = a01Mapping == null ? null : a01Mapping.trim();
    }

    /**
     * 表单：是否在表单中显示
     * @return IS_SHOW_AT_FORM 表单：是否在表单中显示
     */
    public String getIsShowAtForm() {
        return isShowAtForm;
    }

    /**
     * 表单：是否在表单中显示
     * @param isShowAtForm 表单：是否在表单中显示
     */
    public void setIsShowAtForm(String isShowAtForm) {
        this.isShowAtForm = isShowAtForm == null ? null : isShowAtForm.trim();
    }

    /**
     * 表单：跨列
     * @return COLSPAN 表单：跨列
     */
    public String getColspan() {
        return colspan;
    }

    /**
     * 表单：跨列
     * @param colspan 表单：跨列
     */
    public void setColspan(String colspan) {
        this.colspan = colspan == null ? null : colspan.trim();
    }

    /**
     * 列表：是否在列表中显示
     * @return IS_SHOW_AT_LIST 列表：是否在列表中显示
     */
    public String getIsShowAtList() {
        return isShowAtList;
    }

    /**
     * 列表：是否在列表中显示
     * @param isShowAtList 列表：是否在列表中显示
     */
    public void setIsShowAtList(String isShowAtList) {
        this.isShowAtList = isShowAtList == null ? null : isShowAtList.trim();
    }

    /**
     * 列表：对齐方式 1居中 2居左 3居右
     * @return ALIGN 列表：对齐方式 1居中 2居左 3居右
     */
    public String getAlign() {
        return align;
    }

    /**
     * 列表：对齐方式 1居中 2居左 3居右
     * @param align 列表：对齐方式 1居中 2居左 3居右
     */
    public void setAlign(String align) {
        this.align = align == null ? null : align.trim();
    }

    /**
     * 列表：是否可排序
     * @return SORT_ABLE 列表：是否可排序
     */
    public String getSortAble() {
        return sortAble;
    }

    /**
     * 列表：是否可排序
     * @param sortAble 列表：是否可排序
     */
    public void setSortAble(String sortAble) {
        this.sortAble = sortAble == null ? null : sortAble.trim();
    }

    /**
     * 是否是系统字段
     * @return IS_SYSTEM 是否是系统字段
     */
    public String getIsSystem() {
        return isSystem;
    }

    /**
     * 是否是系统字段
     * @param isSystem 是否是系统字段
     */
    public void setIsSystem(String isSystem) {
        this.isSystem = isSystem == null ? null : isSystem.trim();
    }

    /**
     * 是否必填;0-为空;1-不为空
     * @return IS_NECESSARY 是否必填;0-为空;1-不为空
     */
    public String getIsNecessary() {
        return isNecessary;
    }

    /**
     * 是否必填;0-为空;1-不为空
     * @param isNecessary 是否必填;0-为空;1-不为空
     */
    public void setIsNecessary(String isNecessary) {
        this.isNecessary = isNecessary == null ? null : isNecessary.trim();
    }

    /**
     * 
     * @return LENGTH_1 
     */
    public Integer getLength1() {
        return length1;
    }

    /**
     * 
     * @param length1 
     */
    public void setLength1(Integer length1) {
        this.length1 = length1;
    }

    /**
     * 
     * @return WIDTH_1 
     */
    public Integer getWidth1() {
        return width1;
    }

    /**
     * 
     * @param width1 
     */
    public void setWidth1(Integer width1) {
        this.width1 = width1;
    }

    /**
     * 是否主键；1是；0否
     * @return IS_PK 是否主键；1是；0否
     */
    public String getIsPk() {
        return isPk;
    }

    /**
     * 是否主键；1是；0否
     * @param isPk 是否主键；1是；0否
     */
    public void setIsPk(String isPk) {
        this.isPk = isPk == null ? null : isPk.trim();
    }

    /**
     * 是否任免表外：1-是；0-否
     * @return IS_RMB_OUT 是否任免表外：1-是；0-否
     */
    public String getIsRmbOut() {
        return isRmbOut;
    }

    /**
     * 是否任免表外：1-是；0-否
     * @param isRmbOut 是否任免表外：1-是；0-否
     */
    public void setIsRmbOut(String isRmbOut) {
        this.isRmbOut = isRmbOut == null ? null : isRmbOut.trim();
    }

    /**
     * 联动信息项
     * @return LINK_ITEM 联动信息项
     */
    public String getLinkItem() {
        return linkItem;
    }

    /**
     * 联动信息项
     * @param linkItem 联动信息项
     */
    public void setLinkItem(String linkItem) {
        this.linkItem = linkItem == null ? null : linkItem.trim();
    }

    /**
     * 是否是批量维护字段 ture/false
     * @return IS_BATCH 是否是批量维护字段 ture/false
     */
    public String getIsBatch() {
        return isBatch;
    }

    /**
     * 是否是批量维护字段 ture/false
     * @param isBatch 是否是批量维护字段 ture/false
     */
    public void setIsBatch(String isBatch) {
        this.isBatch = isBatch == null ? null : isBatch.trim();
    }

    /**
     * 是否在人员信息项显示1:显示，0:不显示
     * @return IS_SHOW_AT_PERSONITEM 是否在人员信息项显示1:显示，0:不显示
     */
    public String getIsShowAtPersonitem() {
        return isShowAtPersonitem;
    }

    /**
     * 是否在人员信息项显示1:显示，0:不显示
     * @param isShowAtPersonitem 是否在人员信息项显示1:显示，0:不显示
     */
    public void setIsShowAtPersonitem(String isShowAtPersonitem) {
        this.isShowAtPersonitem = isShowAtPersonitem == null ? null : isShowAtPersonitem.trim();
    }

    /**
     * 数据来源表
     * @return LINK_TABLE 数据来源表
     */
    public String getLinkTable() {
        return linkTable;
    }

    /**
     * 数据来源表
     * @param linkTable 数据来源表
     */
    public void setLinkTable(String linkTable) {
        this.linkTable = linkTable == null ? null : linkTable.trim();
    }

    /**
     * 数据来源值字段
     * @return LINK_VALUECOLUMN 数据来源值字段
     */
    public String getLinkValuecolumn() {
        return linkValuecolumn;
    }

    /**
     * 数据来源值字段
     * @param linkValuecolumn 数据来源值字段
     */
    public void setLinkValuecolumn(String linkValuecolumn) {
        this.linkValuecolumn = linkValuecolumn == null ? null : linkValuecolumn.trim();
    }

    /**
     * 数据来源显示字段
     * @return LINK_LABELCOLUMN 数据来源显示字段
     */
    public String getLinkLabelcolumn() {
        return linkLabelcolumn;
    }

    /**
     * 数据来源显示字段
     * @param linkLabelcolumn 数据来源显示字段
     */
    public void setLinkLabelcolumn(String linkLabelcolumn) {
        this.linkLabelcolumn = linkLabelcolumn == null ? null : linkLabelcolumn.trim();
    }

    /**
     * 数据来源上级字段
     * @return LINK_PARENTCOLUMN 数据来源上级字段
     */
    public String getLinkParentcolumn() {
        return linkParentcolumn;
    }

    /**
     * 数据来源上级字段
     * @param linkParentcolumn 数据来源上级字段
     */
    public void setLinkParentcolumn(String linkParentcolumn) {
        this.linkParentcolumn = linkParentcolumn == null ? null : linkParentcolumn.trim();
    }
    //旧列名
    private String oldColCode;
    public void setOldColCode(String oldEnglishName) {
        this.oldColCode = oldEnglishName;
    }
    public String getOldColCode() {
        return oldColCode;
    }
}