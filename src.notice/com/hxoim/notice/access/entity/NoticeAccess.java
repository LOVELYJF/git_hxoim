package com.hxoim.notice.access.entity;

import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;

/**
 * 通知公告权限
 * 
 * @author gaozhenyuan
 * @date 2019/12/19 10:45
 */
@TableAnnotation(TableName = "notice_content_role", TableDescription="通知公告权限")
public class NoticeAccess {
    /**
     * 主键
     */
    @ColumnAnnotation(FieldName = "id",  FieldDescription="主键")
    private String id;

    /**
     * 公告内容Id
     */
    @ColumnAnnotation(FieldName = "content_id",  FieldDescription="公告内容Id")
    private String contentId;

    /**
     * 机构Id
     */
    @ColumnAnnotation(FieldName = "org_id",  FieldDescription="机构id")
    private String orgId;

    /**
     * 机构名称
     */
    @ColumnAnnotation(FieldName = "org_name",  FieldDescription="机构名称")
    private String orgName;

    /**
     * 用户Id
     */
    @ColumnAnnotation(FieldName = "user_id",  FieldDescription="用户Id")
    private String userId;

    /**
     * 用户名称
     */
    @ColumnAnnotation(FieldName = "user_name",  FieldDescription="用户名称")
    private String userName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}