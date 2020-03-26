package com.hxoim.person.markedcadre.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.IdAnnotation;
import com.hxoim.common.hxannotation.IgnoreLogAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * mc_markedcadre
 */
@TableAnnotation(TableName = "mc_markedcadre", TableDescription="")
public class McMarkedcadre {
    /**
     * 名单主键
     */
    @IdAnnotation
    @ColumnAnnotation(FieldName = "id",  FieldDescription="名单主键")
    private String id;

    /**
     * 用户主键
     */
    @ColumnAnnotation(FieldName = "userId",  FieldDescription="用户主键")
    private String userid;

    /**
     * 修改用户
     */
    @ColumnAnnotation(FieldName = "modify_user",  FieldDescription="修改用户")
    private String modifyUser;

    /**
     * 修改时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ColumnAnnotation(FieldName = "modify_time",  FieldDescription="修改时间")
    private Date modifyTime;

    /**
     * 序号
     */
    @ColumnAnnotation(FieldName = "sequence",  FieldDescription="序号")
    private Integer sequence;

    /**
     * 名称
     */
    @ColumnAnnotation(FieldName = "name",  FieldDescription="名称")
    private String name;

    /**
     * 上级名单
     */
    @ColumnAnnotation(FieldName = "parentId",  FieldDescription="上级名单")
    private String parentid;

    public McMarkedcadre(String id, String userid, String modifyUser, Date modifyTime, Integer sequence, String name, String parentid) {
        this.id = id;
        this.userid = userid;
        this.modifyUser = modifyUser;
        this.modifyTime = modifyTime;
        this.sequence = sequence;
        this.name = name;
        this.parentid = parentid;
    }

    public McMarkedcadre() {
        super();
    }

    /**
     * 名单主键
     * @return id 名单主键
     */
    public String getId() {
        return id;
    }

    /**
     * 名单主键
     * @param id 名单主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 用户主键
     * @return userId 用户主键
     */
    public String getUserid() {
        return userid;
    }

    /**
     * 用户主键
     * @param userid 用户主键
     */
    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    /**
     * 修改用户
     * @return modify_user 修改用户
     */
    public String getModifyUser() {
        return modifyUser;
    }

    /**
     * 修改用户
     * @param modifyUser 修改用户
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
     * 序号
     * @return sequence 序号
     */
    public Integer getSequence() {
        return sequence;
    }

    /**
     * 序号
     * @param sequence 序号
     */
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
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
     * 上级名单
     * @return parentId 上级名单
     */
    public String getParentid() {
        return parentid;
    }

    /**
     * 上级名单
     * @param parentid 上级名单
     */
    public void setParentid(String parentid) {
        this.parentid = parentid == null ? null : parentid.trim();
    }
}