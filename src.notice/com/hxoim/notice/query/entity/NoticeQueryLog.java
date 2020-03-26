package com.hxoim.notice.query.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 通知公告权限
 * 
 * @author gaozhenyuan
 * @date 2019/12/19 10:45
 */
@TableAnnotation(TableName = "notice_query_log", TableDescription="通知公告浏览记录")
public class NoticeQueryLog {
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
     * 用户Id
     */
    @ColumnAnnotation(FieldName = "user_id",  FieldDescription="用户id")
    private String userId;

    /**
     * 用户名称
     */
    @ColumnAnnotation(FieldName = "user_name",  FieldDescription="用户名称")
    private String userName;

    /**
     * 显示开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ColumnAnnotation(FieldName = "query_time",  FieldDescription="浏览时间")
    private Date queryTime;

    /**
     * 浏览人ip
     */
    @ColumnAnnotation(FieldName = "ip",  FieldDescription="浏览人ip")
    private String ip;

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

    public Date getQueryTime() {
        return queryTime;
    }

    public void setQueryTime(Date queryTime) {
        this.queryTime = queryTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}