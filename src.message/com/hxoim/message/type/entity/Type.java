package com.hxoim.message.type.entity;

import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.IdAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;

import java.util.Date;

/**
 * m_type
 */
@TableAnnotation(TableName = "m_type", TableDescription="消息分类")
public class Type {
    /**
     * 分类ID
     */
    @IdAnnotation
    @ColumnAnnotation(FieldName = "id",  FieldDescription="分类ID")
    private String Id;

    /**
     * 分类名称
     */
    @ColumnAnnotation(FieldName = "name",  FieldDescription="分类名称")
    private String name;

    /**
     * 父级ID
     */
    @ColumnAnnotation(FieldName = "par_id",  FieldDescription="父级ID",
            ForeignTable = "m_type",ForeignColumn = "id",ForeignDescriptionColumn = "name")
    private String parId;

    /**
     * 创建时间
     */
    @ColumnAnnotation(FieldName = "create_time",  FieldDescription="创建时间")
    private Date createTime;

    /**
     * 是否是根节点(1是0否)
     */
    @ColumnAnnotation(FieldName = "is_root",  FieldDescription="是否是根节点(1是0否)")
    private String isRoot;

    public Type(String id, String name, String parId, Date createTime, String isRoot) {
        this.Id = id;
        this.name = name;
        this.parId = parId;
        this.createTime = createTime;
        this.isRoot = isRoot;
    }

    public Type() {
        super();
    }

    /**
     * 分类ID
     * @return id 分类ID
     */
    public String getId() {
        return Id;
    }

    /**
     * 分类ID
     * @param id 分类ID
     */
    public void setId(String id) {
        this.Id = id == null ? null : id.trim();
    }

    /**
     * 分类名称
     * @return name 分类名称
     */
    public String getName() {
        return name;
    }

    /**
     * 分类名称
     * @param name 分类名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 父级ID
     * @return par_id 父级ID
     */
    public String getParId() {
        return parId;
    }

    /**
     * 父级ID
     * @param parId 父级ID
     */
    public void setParId(String parId) {
        this.parId = parId == null ? null : parId.trim();
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 是否是根节点(1是0否)
     * @return is_root 是否是根节点(1是0否)
     */
    public String getIsRoot() {
        return isRoot;
    }

    /**
     * 是否是根节点(1是0否)
     * @param isRoot 是否是根节点(1是0否)
     */
    public void setIsRoot(String isRoot) {
        this.isRoot = isRoot == null ? null : isRoot.trim();
    }
}