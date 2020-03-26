package com.hxoim.support.b01.entity;

/**
 * @ description：机构关联附件实体类
 * @ author：张乾
 * @ createString ： 2019/6/10 9:31
 */
public class B01Attachment {

    //主键id
    private String id;
    //机构id
    private String b0111;
    //文件名称
    private String fileName;
    //文件大小
    private String fileSize;
    //摘要
    private String remark;
    //上传时间
    private String uploadTime;
    //修改人
    private String modifyUser;
    //修改时间
    private String modifyTime;
    //文件路径
    private String fileUrl;

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getB0111() {
        return b0111;
    }

    public void setB0111(String b0111) {
        this.b0111 = b0111;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }
}
