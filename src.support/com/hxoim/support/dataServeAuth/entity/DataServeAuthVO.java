package com.hxoim.support.dataServeAuth.entity;

public class DataServeAuthVO {
    //数据服务权限id
    private String serveAuthId;
    //数据接口定义id
    private String dataInterfaceId;
    //数据服务申请id
    private String serveApplyId;
    //信息资源id
    private String resourceId;
    //数据服务IP
    private String serveIP;
    //信息资源名称
    private String resourceName;
    //元数据描述接口
    private String dataInterfaceDesc;
    //数据接口
    private String dataInterface;
    //数据权限分配接口说明
    private String authDesc;
    //数据接口状态
    private String dataInterfaceStatus;
    //数据接口sql
    private String dataSql;
    //元数据描述
    private String dataDesc;

    public String getServeAuthId() {
        return serveAuthId;
    }

    public void setServeAuthId(String serveAuthId) {
        this.serveAuthId = serveAuthId;
    }

    public String getDataInterfaceId() {
        return dataInterfaceId;
    }

    public void setDataInterfaceId(String dataInterfaceId) {
        this.dataInterfaceId = dataInterfaceId;
    }

    public String getServeApplyId() {
        return serveApplyId;
    }

    public void setServeApplyId(String serveApplyId) {
        this.serveApplyId = serveApplyId;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getServeIP() {
        return serveIP;
    }

    public void setServeIP(String serveIP) {
        this.serveIP = serveIP;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getDataInterfaceDesc() {
        return dataInterfaceDesc;
    }

    public void setDataInterfaceDesc(String dataInterfaceDesc) {
        this.dataInterfaceDesc = dataInterfaceDesc;
    }

    public String getDataInterface() {
        return dataInterface;
    }

    public void setDataInterface(String dataInterface) {
        this.dataInterface = dataInterface;
    }

    public String getAuthDesc() {
        return authDesc;
    }

    public void setAuthDesc(String authDesc) {
        this.authDesc = authDesc;
    }

    public String getDataInterfaceStatus() {
        return dataInterfaceStatus;
    }

    public void setDataInterfaceStatus(String dataInterfaceStatus) {
        this.dataInterfaceStatus = dataInterfaceStatus;
    }

    public String getDataSql() {
        return dataSql;
    }

    public void setDataSql(String dataSql) {
        this.dataSql = dataSql;
    }

    public String getDataDesc() {
        return dataDesc;
    }

    public void setDataDesc(String dataDesc) {
        this.dataDesc = dataDesc;
    }
}
