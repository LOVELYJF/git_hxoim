package com.hxoim.message.discussiongroup.entity;

import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.IdAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;

import java.util.Date;
/**
 * m_discussion_group
 */
@TableAnnotation(TableName = "m_discussion_group", TableDescription="")
public class DiscussionGroup {
    /**
     * 讨论组ID
     */
    @IdAnnotation
    @ColumnAnnotation(FieldName = "id",  FieldDescription="讨论组ID")
    private String id;

    /**
     * 名称
     */
    @ColumnAnnotation(FieldName = "name",  FieldDescription="名称")
    private String name;

    /**
     * 创建时间
     */
    @ColumnAnnotation(FieldName = "create_time",  FieldDescription="创建时间")
    private Date createTime;

    public DiscussionGroup(String id, String name, Date createTime) {
        this.id = id;
        this.name = name;
        this.createTime = createTime;
    }

    public DiscussionGroup() {
        super();
    }

    /**
     * 讨论组ID
     * @return id 讨论组ID
     */
    public String getId() {
        return id;
    }

    /**
     * 讨论组ID
     * @param id 讨论组ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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
}