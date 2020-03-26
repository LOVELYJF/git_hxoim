package com.hxoim.notice.column.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.IdAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 栏目设置
 * 
 * @author sunqian
 * @date 2019/9/12 10:45
 */
@TableAnnotation(TableName = "notice_column", TableDescription="")
public class NoticeColumn {
    /**
     * 主键
     */
    @IdAnnotation
    @ColumnAnnotation(FieldName = "id",  FieldDescription="主键")
    private String id;

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
     * 父节点
     */
    @ColumnAnnotation(FieldName = "p_id",  FieldDescription="父节点")
    private String pId;

    /**
     * 栏目名称
     */
    @ColumnAnnotation(FieldName = "column_name",  FieldDescription="栏目名称")
    private String columnName;

    /**
     * 是否显示(1-显示,0-不显示)
     */
    @ColumnAnnotation(FieldName = "is_display",  FieldDescription="是否显示(1-显示,0-不显示)")
    private String isDisplay;

    /**
     * 是否系统栏目(1-系统栏目,0-不是系统栏目)
     */
    @ColumnAnnotation(FieldName = "is_system",  FieldDescription="是否系统栏目(1-系统栏目,0-不是系统栏目)")
    private String isSystem;

    /**
     * 是否共享
     */
    @ColumnAnnotation(FieldName = "is_share",  FieldDescription="是否共享")
    private String isShare;

    /**
     * 排序
     */
    @ColumnAnnotation(FieldName = "sort_id",  FieldDescription="排序")
    private Integer sortId;

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
     * 父节点
     * @return p_id 父节点
     */
    public String getpId() {
        return pId;
    }

    /**
     * 父节点
     * @param pId 父节点
     */
    public void setpId(String pId) {
        this.pId = pId == null ? null : pId.trim();
    }

    /**
     * 栏目名称
     * @return column_name 栏目名称
     */
    public String getColumnName() {
        return columnName;
    }

    /**
     * 栏目名称
     * @param columnName 栏目名称
     */
    public void setColumnName(String columnName) {
        this.columnName = columnName == null ? null : columnName.trim();
    }

    /**
     * 是否显示(1-显示,0-不显示)
     * @return is_display 是否显示(1-显示,0-不显示)
     */
    public String getIsDisplay() {
        return isDisplay;
    }

    /**
     * 是否显示(1-显示,0-不显示)
     * @param isDisplay 是否显示(1-显示,0-不显示)
     */
    public void setIsDisplay(String isDisplay) {
        this.isDisplay = isDisplay == null ? null : isDisplay.trim();
    }

    /**
     * 是否系统栏目(1-系统栏目,0-不是系统栏目)
     * @return is_system 是否系统栏目(1-系统栏目,0-不是系统栏目)
     */
    public String getIsSystem() {
        return isSystem;
    }

    /**
     * 是否系统栏目(1-系统栏目,0-不是系统栏目)
     * @param isSystem 是否系统栏目(1-系统栏目,0-不是系统栏目)
     */
    public void setIsSystem(String isSystem) {
        this.isSystem = isSystem == null ? null : isSystem.trim();
    }

    /**
     * 是否共享
     * @return is_share 是否共享
     */
    public String getIsShare() {
        return isShare;
    }

    /**
     * 是否共享
     * @param isShare 是否共享
     */
    public void setIsShare(String isShare) {
        this.isShare = isShare == null ? null : isShare.trim();
    }

    /**
     * 排序
     * @return sort_id 排序
     */
    public Integer getSortId() {
        return sortId;
    }

    /**
     * 排序
     * @param sortId 排序
     */
    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }
}