package com.hxoim.support.sysdict.entity;

import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.IdAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;

import java.util.Date;

/**
 * @description：字典管理映射类实体
 * @author ：张乾
 * @createDate ： 2019/5/27 16:22
 * sys_dict_item
 */

@TableAnnotation(TableName = "sys_dict_item", TableDescription="")
public class SysDictItem {
    /**
     *
     */
    @IdAnnotation
    @ColumnAnnotation(FieldName = "id",  FieldDescription="")
    private String id;

    /**
     * 数据字典
     */
    @ColumnAnnotation(FieldName = "dict_code",  FieldDescription="数据字典")
    private String dictCode;

    /**
     * 数据字典项编码
     */
    @ColumnAnnotation(FieldName = "item_code",  FieldDescription="数据字典项编码")
    private String itemCode;

    /**
     * 数据字典项名称
     */
    @ColumnAnnotation(FieldName = "item_name",  FieldDescription="数据字典项名称")
    private String itemName;

    /**
     * ITEM_NUM
     */
    @ColumnAnnotation(FieldName = "item_num",  FieldDescription="ITEM_NUM")
    private Integer itemNum;

    /**
     * ITEM_LEVELCODE
     */
    @ColumnAnnotation(FieldName = "item_levelcode",  FieldDescription="ITEM_LEVELCODE")
    private String itemLevelcode;

    /**
     * SHORT_NAME
     */
    @ColumnAnnotation(FieldName = "short_name",  FieldDescription="SHORT_NAME")
    private String shortName;

    /**
     * ITEM_DESC
     */
    @ColumnAnnotation(FieldName = "item_desc",  FieldDescription="ITEM_DESC")
    private String itemDesc;

    /**
     * COMP_SPELL
     */
    @ColumnAnnotation(FieldName = "comp_spell",  FieldDescription="COMP_SPELL")
    private String compSpell;

    /**
     * LOGO_SPELL
     */
    @ColumnAnnotation(FieldName = "logo_spell",  FieldDescription="LOGO_SPELL")
    private String logoSpell;

    /**
     * IS_USE
     */
    @ColumnAnnotation(FieldName = "is_use",  FieldDescription="IS_USE")
    private String isUse;

    /**
     * IS_LEAF
     */
    @ColumnAnnotation(FieldName = "is_leaf",  FieldDescription="IS_LEAF")
    private String isLeaf;

    /**
     * ORDERINDEX
     */
    @ColumnAnnotation(FieldName = "orderindex",  FieldDescription="ORDERINDEX")
    private Integer orderindex;

    /**
     * TIME_STAMP
     */
    @ColumnAnnotation(FieldName = "time_stamp",  FieldDescription="TIME_STAMP")
    private String timeStamp;

    /**
     * MODIFY_USER
     */
    @ColumnAnnotation(FieldName = "modify_user",  FieldDescription="MODIFY_USER")
    private String modifyUser;

    /**
     * MODIFY_TIME
     */
    @ColumnAnnotation(FieldName = "modify_time",  FieldDescription="MODIFY_TIME")
    private Date modifyTime;

    /**
     * SECURITYLEVEL
     */
    @ColumnAnnotation(FieldName = "securitylevel",  FieldDescription="SECURITYLEVEL")
    private String securitylevel;

    /**
     * ITEM_LEVEL
     */
    @ColumnAnnotation(FieldName = "item_level",  FieldDescription="ITEM_LEVEL")
    private String itemLevel;

    /**
     * PARENT_ITEM_CODE
     */
    @ColumnAnnotation(FieldName = "parent_item_code",  FieldDescription="PARENT_ITEM_CODE")
    private String parentItemCode;

    public SysDictItem(String id, String dictCode, String itemCode, String itemName, Integer itemNum, String itemLevelcode, String shortName, String itemDesc, String compSpell, String logoSpell, String isUse, String isLeaf, Integer orderindex, String timeStamp, String modifyUser, Date modifyTime, String securitylevel, String itemLevel, String parentItemCode) {
        this.id = id;
        this.dictCode = dictCode;
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.itemNum = itemNum;
        this.itemLevelcode = itemLevelcode;
        this.shortName = shortName;
        this.itemDesc = itemDesc;
        this.compSpell = compSpell;
        this.logoSpell = logoSpell;
        this.isUse = isUse;
        this.isLeaf = isLeaf;
        this.orderindex = orderindex;
        this.timeStamp = timeStamp;
        this.modifyUser = modifyUser;
        this.modifyTime = modifyTime;
        this.securitylevel = securitylevel;
        this.itemLevel = itemLevel;
        this.parentItemCode = parentItemCode;
    }

    public SysDictItem() {
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
     * 数据字典
     * @return dict_code 数据字典
     */
    public String getDictCode() {
        return dictCode;
    }

    /**
     * 数据字典
     * @param dictCode 数据字典
     */
    public void setDictCode(String dictCode) {
        this.dictCode = dictCode == null ? null : dictCode.trim();
    }

    /**
     * 数据字典项编码
     * @return item_code 数据字典项编码
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * 数据字典项编码
     * @param itemCode 数据字典项编码
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode == null ? null : itemCode.trim();
    }

    /**
     * 数据字典项名称
     * @return item_name 数据字典项名称
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * 数据字典项名称
     * @param itemName 数据字典项名称
     */
    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    /**
     * ITEM_NUM
     * @return item_num ITEM_NUM
     */
    public Integer getItemNum() {
        return itemNum;
    }

    /**
     * ITEM_NUM
     * @param itemNum ITEM_NUM
     */
    public void setItemNum(Integer itemNum) {
        this.itemNum = itemNum;
    }

    /**
     * ITEM_LEVELCODE
     * @return item_levelcode ITEM_LEVELCODE
     */
    public String getItemLevelcode() {
        return itemLevelcode;
    }

    /**
     * ITEM_LEVELCODE
     * @param itemLevelcode ITEM_LEVELCODE
     */
    public void setItemLevelcode(String itemLevelcode) {
        this.itemLevelcode = itemLevelcode == null ? null : itemLevelcode.trim();
    }

    /**
     * SHORT_NAME
     * @return short_name SHORT_NAME
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * SHORT_NAME
     * @param shortName SHORT_NAME
     */
    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }

    /**
     * ITEM_DESC
     * @return item_desc ITEM_DESC
     */
    public String getItemDesc() {
        return itemDesc;
    }

    /**
     * ITEM_DESC
     * @param itemDesc ITEM_DESC
     */
    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc == null ? null : itemDesc.trim();
    }

    /**
     * COMP_SPELL
     * @return comp_spell COMP_SPELL
     */
    public String getCompSpell() {
        return compSpell;
    }

    /**
     * COMP_SPELL
     * @param compSpell COMP_SPELL
     */
    public void setCompSpell(String compSpell) {
        this.compSpell = compSpell == null ? null : compSpell.trim();
    }

    /**
     * LOGO_SPELL
     * @return logo_spell LOGO_SPELL
     */
    public String getLogoSpell() {
        return logoSpell;
    }

    /**
     * LOGO_SPELL
     * @param logoSpell LOGO_SPELL
     */
    public void setLogoSpell(String logoSpell) {
        this.logoSpell = logoSpell == null ? null : logoSpell.trim();
    }

    /**
     * IS_USE
     * @return is_use IS_USE
     */
    public String getIsUse() {
        return isUse;
    }

    /**
     * IS_USE
     * @param isUse IS_USE
     */
    public void setIsUse(String isUse) {
        this.isUse = isUse == null ? null : isUse.trim();
    }

    /**
     * IS_LEAF
     * @return is_leaf IS_LEAF
     */
    public String getIsLeaf() {
        return isLeaf;
    }

    /**
     * IS_LEAF
     * @param isLeaf IS_LEAF
     */
    public void setIsLeaf(String isLeaf) {
        this.isLeaf = isLeaf == null ? null : isLeaf.trim();
    }

    /**
     * ORDERINDEX
     * @return orderindex ORDERINDEX
     */
    public Integer getOrderindex() {
        return orderindex;
    }

    /**
     * ORDERINDEX
     * @param orderindex ORDERINDEX
     */
    public void setOrderindex(Integer orderindex) {
        this.orderindex = orderindex;
    }

    /**
     * TIME_STAMP
     * @return time_stamp TIME_STAMP
     */
    public String getTimeStamp() {
        return timeStamp;
    }

    /**
     * TIME_STAMP
     * @param timeStamp TIME_STAMP
     */
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp == null ? null : timeStamp.trim();
    }

    /**
     * MODIFY_USER
     * @return modify_user MODIFY_USER
     */
    public String getModifyUser() {
        return modifyUser;
    }

    /**
     * MODIFY_USER
     * @param modifyUser MODIFY_USER
     */
    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser == null ? null : modifyUser.trim();
    }

    /**
     * MODIFY_TIME
     * @return modify_time MODIFY_TIME
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * MODIFY_TIME
     * @param modifyTime MODIFY_TIME
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * SECURITYLEVEL
     * @return securitylevel SECURITYLEVEL
     */
    public String getSecuritylevel() {
        return securitylevel;
    }

    /**
     * SECURITYLEVEL
     * @param securitylevel SECURITYLEVEL
     */
    public void setSecuritylevel(String securitylevel) {
        this.securitylevel = securitylevel == null ? null : securitylevel.trim();
    }

    /**
     * ITEM_LEVEL
     * @return item_level ITEM_LEVEL
     */
    public String getItemLevel() {
        return itemLevel;
    }

    /**
     * ITEM_LEVEL
     * @param itemLevel ITEM_LEVEL
     */
    public void setItemLevel(String itemLevel) {
        this.itemLevel = itemLevel == null ? null : itemLevel.trim();
    }

    /**
     * PARENT_ITEM_CODE
     * @return parent_item_code PARENT_ITEM_CODE
     */
    public String getParentItemCode() {
        return parentItemCode;
    }

    /**
     * PARENT_ITEM_CODE
     * @param parentItemCode PARENT_ITEM_CODE
     */
    public void setParentItemCode(String parentItemCode) {
        this.parentItemCode = parentItemCode == null ? null : parentItemCode.trim();
    }
}
