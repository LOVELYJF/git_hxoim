package com.hxoim.person.markedcadre.entity;

import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.IdAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;

/**
 * mc_a01
 */
@TableAnnotation(TableName = "mc_a01", TableDescription="")
public class McA01 {
    /**
     * 主键
     */
    @IdAnnotation
    @ColumnAnnotation(FieldName = "id",  FieldDescription="主键")
    private String id;

    /**
     * mc_markedcadre表id
     */
    @ColumnAnnotation(FieldName = "mc_id",  FieldDescription="mc_markedcadre表id")
    private String mcId;

    /**
     * a01表id
     */
    @ColumnAnnotation(FieldName = "a01_id",  FieldDescription="a01表id")
    private String a01Id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMcId() {
        return mcId;
    }

    public void setMcId(String mcId) {
        this.mcId = mcId;
    }

    public String getA01Id() {
        return a01Id;
    }

    public void setA01Id(String a01Id) {
        this.a01Id = a01Id;
    }
}
