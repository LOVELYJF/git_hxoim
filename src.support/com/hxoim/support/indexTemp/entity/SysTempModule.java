package com.hxoim.support.indexTemp.entity;

import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.IdAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;

/**
 * sys_temp_module
 */
@TableAnnotation(TableName = "sys_temp_module", TableDescription="")
public class SysTempModule {
    /**
     * 
     */
    @IdAnnotation
    @ColumnAnnotation(FieldName = "id",  FieldDescription="")
    private String id;

    /**
     * 模板ID
     */
    @ColumnAnnotation(FieldName = "temp_id",  FieldDescription="模板ID")
    private String tempId;

    /**
     * 模块ID
     */
    @ColumnAnnotation(FieldName = "module_id",  FieldDescription="模块ID")
    private String moduleId;
    /**
     * 模块名称
     */
    @ColumnAnnotation(FieldName = "module_name",  FieldDescription="模块名称")
    private String moduleName;

    /**
     * 模块样式
     */
    @ColumnAnnotation(FieldName = "module_style",  FieldDescription="")
    private String moduleStyle;

    public SysTempModule(String id, String tempId, String moduleId, String moduleName, String moduleStyle) {
        this.id = id;
        this.tempId = tempId;
        this.moduleId = moduleId;
        this.moduleName = moduleName;
        this.moduleStyle = moduleStyle;
    }

    public SysTempModule() {
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
     * 模板ID
     * @return temp_id 模板ID
     */
    public String getTempId() {
        return tempId;
    }

    /**
     * 模板ID
     * @param tempId 模板ID
     */
    public void setTempId(String tempId) {
        this.tempId = tempId == null ? null : tempId.trim();
    }

    /**
     * 模块ID
     * @return module_id 模块ID
     */
    public String getModuleId() {
        return moduleId;
    }

    /**
     * 模块ID
     * @param moduleId 模块ID
     */
    public void setModuleId(String moduleId) {
        this.moduleId = moduleId == null ? null : moduleId.trim();
    }

    public String getModuleStyle() {
        return moduleStyle;
    }

    public void setModuleStyle(String moduleStyle) {
        this.moduleStyle = moduleStyle;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
}