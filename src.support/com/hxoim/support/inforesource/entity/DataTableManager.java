package com.hxoim.support.inforesource.entity;

import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.IdAnnotation;
import com.hxoim.common.hxannotation.IgnoreLogAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;

/**
 * data_table_manager
 */
@TableAnnotation(TableName = "data_table_manager", TableDescription="")
public class DataTableManager {
    /**
     * 主键
     */
    @IdAnnotation
    @ColumnAnnotation(FieldName = "Id",  FieldDescription="主键")
    private String id;

    /**
     * 表
     */
    @ColumnAnnotation(FieldName = "tableid",  FieldDescription="表")
    private String tableid;

    /**
     * 系统
     */
    @ColumnAnnotation(FieldName = "sysid",  FieldDescription="系统")
    private String sysid;

    public DataTableManager(String id, String tableid, String sysid) {
        this.id = id;
        this.tableid = tableid;
        this.sysid = sysid;
    }

    public DataTableManager() {
        super();
    }

    /**
     * 主键
     * @return Id 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 主键
     * @param id 主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 表
     * @return tableid 表
     */
    public String getTableid() {
        return tableid;
    }

    /**
     * 表
     * @param tableid 表
     */
    public void setTableid(String tableid) {
        this.tableid = tableid == null ? null : tableid.trim();
    }

    /**
     * 系统
     * @return sysid 系统
     */
    public String getSysid() {
        return sysid;
    }

    /**
     * 系统
     * @param sysid 系统
     */
    public void setSysid(String sysid) {
        this.sysid = sysid == null ? null : sysid.trim();
    }
}