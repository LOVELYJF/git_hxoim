package com.hxoim.support.dicitemmap.entity;

import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.IdAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;

/**
 * dict_item_mapping
 */
@TableAnnotation(TableName = "dict_item_mapping", TableDescription="")
public class DictItemMapping {
    /**
     * 
     */
    @IdAnnotation
    @ColumnAnnotation(FieldName = "id",  FieldDescription="")
    private String id;

    /**
     * 
     */
    @ColumnAnnotation(FieldName = "dict_code",  FieldDescription="")
    private String dictCode;

    /**
     * 
     */
    @ColumnAnnotation(FieldName = "item_code",  FieldDescription="")
    private String itemCode;

    /**
     * 
     */
    @ColumnAnnotation(FieldName = "item_Name",  FieldDescription="")
    private String itemName;

    /**
     * 
     */
    @ColumnAnnotation(FieldName = "system_parent_code",  FieldDescription="")
    private String systemParentCode;

    /**
     * 
     */
    @ColumnAnnotation(FieldName = "mapping_item_code",  FieldDescription="")
    private String mappingItemCode;

    /**
     * 
     */
    @ColumnAnnotation(FieldName = "mapping_item_name1",  FieldDescription="")
    private String mappingItemName1;

    /**
     * 
     */
    @ColumnAnnotation(FieldName = "mapping_item_name3",  FieldDescription="")
    private String mappingItemName3;

    /**
     * 
     */
    @ColumnAnnotation(FieldName = "mapping_identifying",  FieldDescription="")
    private String mappingIdentifying;

    /**
     * 
     */
    @ColumnAnnotation(FieldName = "applicationId",  FieldDescription="")
    private String applicationid;

    /**
     * 
     */
    @ColumnAnnotation(FieldName = "systemName",  FieldDescription="")
    private String systemname;

    /**
     * 
     */
    @ColumnAnnotation(FieldName = "system_id",  FieldDescription="")
    private String systemId;

    public DictItemMapping(String id, String dictCode, String itemCode, String itemName, String systemParentCode, String mappingItemCode, String mappingItemName1, String mappingItemName3, String mappingIdentifying, String applicationid, String systemname, String systemId) {
        this.id = id;
        this.dictCode = dictCode;
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.systemParentCode = systemParentCode;
        this.mappingItemCode = mappingItemCode;
        this.mappingItemName1 = mappingItemName1;
        this.mappingItemName3 = mappingItemName3;
        this.mappingIdentifying = mappingIdentifying;
        this.applicationid = applicationid;
        this.systemname = systemname;
        this.systemId = systemId;
    }

    public DictItemMapping() {
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
     * 
     * @return dict_code 
     */
    public String getDictCode() {
        return dictCode;
    }

    /**
     * 
     * @param dictCode 
     */
    public void setDictCode(String dictCode) {
        this.dictCode = dictCode == null ? null : dictCode.trim();
    }

    /**
     * 
     * @return item_code 
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * 
     * @param itemCode 
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode == null ? null : itemCode.trim();
    }

    /**
     * 
     * @return item_Name 
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * 
     * @param itemName 
     */
    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    /**
     * 
     * @return system_parent_code 
     */
    public String getSystemParentCode() {
        return systemParentCode;
    }

    /**
     * 
     * @param systemParentCode 
     */
    public void setSystemParentCode(String systemParentCode) {
        this.systemParentCode = systemParentCode == null ? null : systemParentCode.trim();
    }

    /**
     * 
     * @return mapping_item_code 
     */
    public String getMappingItemCode() {
        return mappingItemCode;
    }

    /**
     * 
     * @param mappingItemCode 
     */
    public void setMappingItemCode(String mappingItemCode) {
        this.mappingItemCode = mappingItemCode == null ? null : mappingItemCode.trim();
    }

    /**
     * 
     * @return mapping_item_name1 
     */
    public String getMappingItemName1() {
        return mappingItemName1;
    }

    /**
     * 
     * @param mappingItemName1 
     */
    public void setMappingItemName1(String mappingItemName1) {
        this.mappingItemName1 = mappingItemName1 == null ? null : mappingItemName1.trim();
    }

    /**
     * 
     * @return mapping_item_name3 
     */
    public String getMappingItemName3() {
        return mappingItemName3;
    }

    /**
     * 
     * @param mappingItemName3 
     */
    public void setMappingItemName3(String mappingItemName3) {
        this.mappingItemName3 = mappingItemName3 == null ? null : mappingItemName3.trim();
    }

    /**
     * 
     * @return mapping_identifying 
     */
    public String getMappingIdentifying() {
        return mappingIdentifying;
    }

    /**
     * 
     * @param mappingIdentifying 
     */
    public void setMappingIdentifying(String mappingIdentifying) {
        this.mappingIdentifying = mappingIdentifying == null ? null : mappingIdentifying.trim();
    }

    /**
     * 
     * @return applicationId 
     */
    public String getApplicationid() {
        return applicationid;
    }

    /**
     * 
     * @param applicationid 
     */
    public void setApplicationid(String applicationid) {
        this.applicationid = applicationid == null ? null : applicationid.trim();
    }

    /**
     * 
     * @return systemName 
     */
    public String getSystemname() {
        return systemname;
    }

    /**
     * 
     * @param systemname 
     */
    public void setSystemname(String systemname) {
        this.systemname = systemname == null ? null : systemname.trim();
    }

    /**
     * 
     * @return system_id 
     */
    public String getSystemId() {
        return systemId;
    }

    /**
     * 
     * @param systemId 
     */
    public void setSystemId(String systemId) {
        this.systemId = systemId == null ? null : systemId.trim();
    }
}