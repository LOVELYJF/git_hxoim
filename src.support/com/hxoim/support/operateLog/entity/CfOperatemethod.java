package com.hxoim.support.operateLog.entity;

import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.IdAnnotation;
import com.hxoim.common.hxannotation.IgnoreLogAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;

/**
 * cf_operatemethod
 */
@TableAnnotation(TableName = "cf_operatemethod", TableDescription="")
public class CfOperatemethod {
    /**
     * 主键
     */
    @IdAnnotation
    @ColumnAnnotation(FieldName = "id",  FieldDescription="主键")
    private String id;

    /**
     * 序号（用于排序）
     */
    @ColumnAnnotation(FieldName = "sequence",  FieldDescription="序号（用于排序）")
    private Integer sequence;

    /**
     * 编号（用于唯一标识）
     */
    @ColumnAnnotation(FieldName = "code",  FieldDescription="编号（用于唯一标识）")
    private String code;

    /**
     * 名称
     */
    @ColumnAnnotation(FieldName = "name",  FieldDescription="名称")
    private String name;

    public CfOperatemethod(String id, Integer sequence, String code, String name) {
        this.id = id;
        this.sequence = sequence;
        this.code = code;
        this.name = name;
    }

    public CfOperatemethod() {
        super();
    }

    /**
     * 主键
     * @return id 主键
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
     * 序号（用于排序）
     * @return sequence 序号（用于排序）
     */
    public Integer getSequence() {
        return sequence;
    }

    /**
     * 序号（用于排序）
     * @param sequence 序号（用于排序）
     */
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    /**
     * 编号（用于唯一标识）
     * @return code 编号（用于唯一标识）
     */
    public String getCode() {
        return code;
    }

    /**
     * 编号（用于唯一标识）
     * @param code 编号（用于唯一标识）
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 名称
     * @return name 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 名称
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}