package com.hxoim.notice.content.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.IgnoreLogAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 通知内容
 * 
 * @author sunqian
 * @date 2019/9/12 10:45
 */
@TableAnnotation(TableName = "notice_content", TableDescription="通知内容")
public class NoticeContent {
    /**
     * 主键
     */
    @ColumnAnnotation(FieldName = "id",  FieldDescription="主键")
    private String id;

    /**
     * 修改人
     */
    @ColumnAnnotation(FieldName = "modify_user",  FieldDescription="修改人")
    private String modifyUser;

    /**
     * 修改人姓名
     */
    @ColumnAnnotation(FieldName = "user_name",  FieldDescription="修改人姓名")
    private String userName;

    /**
     * 修改时间
     */
    @ColumnAnnotation(FieldName = "modify_time",  FieldDescription="修改时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date modifyTime;

    /**
     * 栏目分类id
     */
    @ColumnAnnotation(FieldName = "column_id",  FieldDescription="栏目分类id")
    private String columnId;

    /**
     * 是否置顶(1-是,0-否)
     */
    @ColumnAnnotation(FieldName = "is_topping",  FieldDescription="是否置顶(1-是,0-否)")
    private String isTopping;

    /**
     * 是否发布(1-是,0-否)
     */
    @ColumnAnnotation(FieldName = "is_publish",  FieldDescription="是否发布(1-是,0-否)")
    private String isPublish;

    /**
     * 是否共享(1-是,0-否)
     */
    @ColumnAnnotation(FieldName = "is_share",  FieldDescription="是否共享(1-是,0-否)")
    private String isShare;

    /**
     * 显示开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ColumnAnnotation(FieldName = "start_time",  FieldDescription="显示开始时间")
    private Date startTime;

    /**
     * 显示结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ColumnAnnotation(FieldName = "end_time",  FieldDescription="显示结束时间")
    private Date endTime;

    /**
     * 发布时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ColumnAnnotation(FieldName = "publish_time",  FieldDescription="发布时间")
    private Date publishTime;

    /**
     * 发布时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ColumnAnnotation(FieldName = "publish_date",  FieldDescription="发布时间")
    private Date publishDate;

    /**
     * 公告名称
     */
    @ColumnAnnotation(FieldName = "notice_name",  FieldDescription="公告名称")
    private String noticeName;

    /**
     * 公告标题
     */
    @ColumnAnnotation(FieldName = "notice_title",  FieldDescription="公告标题")
    private String noticeTitle;

    /**
     * 链接地址
     */
    @ColumnAnnotation(FieldName = "report_url",  FieldDescription="链接地址")
    private String reportUrl;

    /**
     * 排序
     */
    @ColumnAnnotation(FieldName = "sort_id",  FieldDescription="排序")
    private Integer sortId;

    /**
     * 公告内容
     */
    @IgnoreLogAnnotation
    @ColumnAnnotation(FieldName = "notice_content",  FieldDescription="公告内容")
    private String noticeContent;

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
     * 修改人姓名
     * @return user_name 修改人姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 修改人姓名
     * @return user_name 修改人姓名
     */
    public void setUserName(String userName) {
        this.userName = userName;
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
     * 栏目分类id
     * @return column_id 栏目分类id
     */
    public String getColumnId() {
        return columnId;
    }

    /**
     * 栏目分类id
     * @param columnId 栏目分类id
     */
    public void setColumnId(String columnId) {
        this.columnId = columnId == null ? null : columnId.trim();
    }

    /**
     * 是否置顶(1-是,0-否)
     * @return is_topping 是否置顶(1-是,0-否)
     */
    public String getIsTopping() {
        return isTopping;
    }

    /**
     * 是否置顶(1-是,0-否)
     * @param isTopping 是否置顶(1-是,0-否)
     */
    public void setIsTopping(String isTopping) {
        this.isTopping = isTopping == null ? null : isTopping.trim();
    }

    /**
     * 是否发布(1-是,0-否)
     * @return is_publish 是否发布(1-是,0-否)
     */
    public String getIsPublish() {
        return isPublish;
    }

    /**
     * 是否发布(1-是,0-否)
     * @param isPublish 是否发布(1-是,0-否)
     */
    public void setIsPublish(String isPublish) {
        this.isPublish = isPublish == null ? null : isPublish.trim();
    }

    /**
     * 是否共享(1-是,0-否)
     * @return is_share 是否共享(1-是,0-否)
     */
    public String getIsShare() {
        return isShare;
    }

    /**
     * 是否共享(1-是,0-否)
     * @param isShare 是否共享(1-是,0-否)
     */
    public void setIsShare(String isShare) {
        this.isShare = isShare == null ? null : isShare.trim();
    }

    /**
     * 显示开始时间
     * @return start_time 显示开始时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 显示开始时间
     * @param startTime 显示开始时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 显示结束时间
     * @return end_time 显示结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 显示结束时间
     * @param endTime 显示结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 发布时间
     * @return publish_time 发布时间
     */
    public Date getPublishTime() {
        return publishTime;
    }

    /**
     * 发布时间
     * @param publishTime 发布时间
     */
    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    /**
     * 公告名称
     * @return notice_name 公告名称
     */
    public String getNoticeName() {
        return noticeName;
    }

    /**
     * 公告名称
     * @param noticeName 公告名称
     */
    public void setNoticeName(String noticeName) {
        this.noticeName = noticeName == null ? null : noticeName.trim();
    }

    /**
     * 公告标题
     * @return notice_title 公告标题
     */
    public String getNoticeTitle() {
        return noticeTitle;
    }

    /**
     * 公告标题
     * @param noticeTitle 公告标题
     */
    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle == null ? null : noticeTitle.trim();
    }

    /**
     * 链接地址
     * @return report_url 链接地址
     */
    public String getReportUrl() {
        return reportUrl;
    }

    /**
     * 链接地址
     * @param reportUrl 链接地址
     */
    public void setReportUrl(String reportUrl) {
        this.reportUrl = reportUrl == null ? null : reportUrl.trim();
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

    /**
     * 公告内容
     * @return notice_content 公告内容
     */
    public String getNoticeContent() {
        return noticeContent;
    }

    /**
     * 公告内容
     * @param noticeContent 公告内容
     */
    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent == null ? null : noticeContent.trim();
    }
}