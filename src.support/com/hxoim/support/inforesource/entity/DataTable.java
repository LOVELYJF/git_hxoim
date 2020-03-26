package com.hxoim.support.inforesource.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.IdAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * data_table
 */
@TableAnnotation(TableName = "data_table", TableDescription="")
public class DataTable {
    /**
     * 主键
     */
    @IdAnnotation
    @ColumnAnnotation(FieldName = "ID",  FieldDescription="主键")
    private String id;

    /**
     * 信息资源目录
     */
    @ColumnAnnotation(FieldName = "CatalogId",  FieldDescription="信息资源目录")
    private String catalogid;

    /**
     * 编码
     */
    @ColumnAnnotation(FieldName = "TAB_CODE",  FieldDescription="编码")
    private String tabCode;

    /**
     * 名称
     */
    @ColumnAnnotation(FieldName = "TAB_NAME",  FieldDescription="名称")
    private String tabName;

    /**
     * 描述
     */
    @ColumnAnnotation(FieldName = "DESCRIPTION",  FieldDescription="描述")
    private String description;

    /**
     * 多当前记录
     */
    @ColumnAnnotation(FieldName = "IS_MULTILY",  FieldDescription="多当前记录")
    private String isMultily;

    /**
     * 信息采集页面
     */
    @ColumnAnnotation(FieldName = "LOAD_PAGE_METHOD",  FieldDescription="信息采集页面")
    private String loadPageMethod;

    /**
     * 父节点
     */
    @ColumnAnnotation(FieldName = "PID",  FieldDescription="父节点")
    private String pid;

    /**
     * 备注
     */
    @ColumnAnnotation(FieldName = "COMMENTS",  FieldDescription="备注")
    private String comments;

    /**
     * 排序
     */
    @ColumnAnnotation(FieldName = "ORDER_INDEX",  FieldDescription="排序")
    private Integer orderIndex;

    /**
     * URL地址，与信息采集页面系统内置时使用
     */
    @ColumnAnnotation(FieldName = "URL",  FieldDescription="URL地址，与信息采集页面系统内置时使用")
    private String url;

    /**
     * 权限编号
     */
    @ColumnAnnotation(FieldName = "RIGHT_CODE",  FieldDescription="权限编号")
    private String rightCode;

    /**
     * 命名空间
     */
    @ColumnAnnotation(FieldName = "NAME_SPACE",  FieldDescription="命名空间")
    private String nameSpace;

    /**
     * 关联模型
     */
    @ColumnAnnotation(FieldName = "CLASS_NAME",  FieldDescription="关联模型")
    private String className;

    /**
     * 时间戳
     */
    @ColumnAnnotation(FieldName = "TIME_STAMP",  FieldDescription="时间戳")
    private String timeStamp;

    /**
     * 逻辑删除
     */
    @ColumnAnnotation(FieldName = "IS_DELETED",  FieldDescription="逻辑删除")
    private String isDeleted;

    /**
     * 修改人
     */
    @ColumnAnnotation(FieldName = "MODIFY_USER",  FieldDescription="修改人")
    private String modifyUser;

    /**
     * 修改时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ColumnAnnotation(FieldName = "MODIFY_TIME",  FieldDescription="修改时间")
    private Date modifyTime;

    /**
     * 列表UI设置：是否可多选
     */
    @ColumnAnnotation(FieldName = "LIST_SETTING",  FieldDescription="列表UI设置：是否可多选")
    private String listSetting;

    /**
     * 表单UI设置：三纵列
     */
    @ColumnAnnotation(FieldName = "FORM_SETTING",  FieldDescription="表单UI设置：三纵列")
    private String formSetting;

    /**
     * 另用基础表，只要该字段不为空，那么就要以该语句作为基础的表
     */
    @ColumnAnnotation(FieldName = "TABLE_SAME_SQL",  FieldDescription="另用基础表，只要该字段不为空，那么就要以该语句作为基础的表")
    private String tableSameSql;

    /**
     * 批量维护地址
     */
    @ColumnAnnotation(FieldName = "BATCH_URL",  FieldDescription="批量维护地址")
    private String batchUrl;

    /**
     * 1、表2、视图
     */
    @ColumnAnnotation(FieldName = "TABLE_TYPE",  FieldDescription="1、表2、视图")
    private String tableType;

    /**
     * 是否可做查询 1 是 0 否
     */
    @ColumnAnnotation(FieldName = "IS_FOR_QUERY",  FieldDescription="是否可做查询 1 是 0 否")
    private String isForQuery;

    /**
     * 是否是树形结构
     */
    @ColumnAnnotation(FieldName = "IS_TREE",  FieldDescription="是否是树形结构 1 是 0 否")
    private String isTree;
    /**
     * 是否是首页定制
     */
    @ColumnAnnotation(FieldName = "IS_INDEX_TEMP",  FieldDescription="是否是首页定制 1 是 0 否")
    private String isIndexTemp;

    public DataTable(String id, String catalogid, String tabCode, String tabName, String description, String isMultily, String loadPageMethod, String pid, String comments, Integer orderIndex, String url, String rightCode, String nameSpace, String className, String timeStamp, String isDeleted, String modifyUser, Date modifyTime, String listSetting, String formSetting, String tableSameSql, String batchUrl, String tableType, String isForQuery,String isTree,String isIndexTemp) {
        this.id = id;
        this.catalogid = catalogid;
        this.tabCode = tabCode;
        this.tabName = tabName;
        this.description = description;
        this.isMultily = isMultily;
        this.loadPageMethod = loadPageMethod;
        this.pid = pid;
        this.comments = comments;
        this.orderIndex = orderIndex;
        this.url = url;
        this.rightCode = rightCode;
        this.nameSpace = nameSpace;
        this.className = className;
        this.timeStamp = timeStamp;
        this.isDeleted = isDeleted;
        this.modifyUser = modifyUser;
        this.modifyTime = modifyTime;
        this.listSetting = listSetting;
        this.formSetting = formSetting;
        this.tableSameSql = tableSameSql;
        this.batchUrl = batchUrl;
        this.tableType = tableType;
        this.isForQuery = isForQuery;
        this.isTree = isTree;
        this.isIndexTemp=isIndexTemp;
    }

    public DataTable() {
        super();
    }

    /**
     * 主键
     * @return ID 主键
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
     * 信息资源目录
     * @return CatalogId 信息资源目录
     */
    public String getCatalogid() {
        return catalogid;
    }

    /**
     * 信息资源目录
     * @param catalogid 信息资源目录
     */
    public void setCatalogid(String catalogid) {
        this.catalogid = catalogid == null ? null : catalogid.trim();
    }

    /**
     * 编码
     * @return TAB_CODE 编码
     */
    public String getTabCode() {
        return tabCode;
    }

    /**
     * 编码
     * @param tabCode 编码
     */
    public void setTabCode(String tabCode) {
        this.tabCode = tabCode == null ? null : tabCode.trim();
    }

    /**
     * 名称
     * @return TAB_NAME 名称
     */
    public String getTabName() {
        return tabName;
    }

    /**
     * 名称
     * @param tabName 名称
     */
    public void setTabName(String tabName) {
        this.tabName = tabName == null ? null : tabName.trim();
    }

    /**
     * 描述
     * @return DESCRIPTION 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 描述
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 多当前记录
     * @return IS_MULTILY 多当前记录
     */
    public String getIsMultily() {
        return isMultily;
    }

    /**
     * 多当前记录
     * @param isMultily 多当前记录
     */
    public void setIsMultily(String isMultily) {
        this.isMultily = isMultily == null ? null : isMultily.trim();
    }

    /**
     * 信息采集页面
     * @return LOAD_PAGE_METHOD 信息采集页面
     */
    public String getLoadPageMethod() {
        return loadPageMethod;
    }

    /**
     * 信息采集页面
     * @param loadPageMethod 信息采集页面
     */
    public void setLoadPageMethod(String loadPageMethod) {
        this.loadPageMethod = loadPageMethod == null ? null : loadPageMethod.trim();
    }

    /**
     * 父节点
     * @return PID 父节点
     */
    public String getPid() {
        return pid;
    }

    /**
     * 父节点
     * @param pid 父节点
     */
    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    /**
     * 备注
     * @return COMMENTS 备注
     */
    public String getComments() {
        return comments;
    }

    /**
     * 备注
     * @param comments 备注
     */
    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }

    /**
     * 排序
     * @return ORDER_INDEX 排序
     */
    public Integer getOrderIndex() {
        return orderIndex;
    }

    /**
     * 排序
     * @param orderIndex 排序
     */
    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }

    /**
     * URL地址，与信息采集页面系统内置时使用
     * @return URL URL地址，与信息采集页面系统内置时使用
     */
    public String getUrl() {
        return url;
    }

    /**
     * URL地址，与信息采集页面系统内置时使用
     * @param url URL地址，与信息采集页面系统内置时使用
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 权限编号
     * @return RIGHT_CODE 权限编号
     */
    public String getRightCode() {
        return rightCode;
    }

    /**
     * 权限编号
     * @param rightCode 权限编号
     */
    public void setRightCode(String rightCode) {
        this.rightCode = rightCode == null ? null : rightCode.trim();
    }

    /**
     * 命名空间
     * @return NAME_SPACE 命名空间
     */
    public String getNameSpace() {
        return nameSpace;
    }

    /**
     * 命名空间
     * @param nameSpace 命名空间
     */
    public void setNameSpace(String nameSpace) {
        this.nameSpace = nameSpace == null ? null : nameSpace.trim();
    }

    /**
     * 关联模型
     * @return CLASS_NAME 关联模型
     */
    public String getClassName() {
        return className;
    }

    /**
     * 关联模型
     * @param className 关联模型
     */
    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    /**
     * 时间戳
     * @return TIME_STAMP 时间戳
     */
    public String getTimeStamp() {
        return timeStamp;
    }

    /**
     * 时间戳
     * @param timeStamp 时间戳
     */
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp == null ? null : timeStamp.trim();
    }

    /**
     * 逻辑删除
     * @return IS_DELETED 逻辑删除
     */
    public String getIsDeleted() {
        return isDeleted;
    }

    /**
     * 逻辑删除
     * @param isDeleted 逻辑删除
     */
    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted == null ? null : isDeleted.trim();
    }

    /**
     * 修改人
     * @return MODIFY_USER 修改人
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
     * @return MODIFY_TIME 修改时间
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
     * 列表UI设置：是否可多选
     * @return LIST_SETTING 列表UI设置：是否可多选
     */
    public String getListSetting() {
        return listSetting;
    }

    /**
     * 列表UI设置：是否可多选
     * @param listSetting 列表UI设置：是否可多选
     */
    public void setListSetting(String listSetting) {
        this.listSetting = listSetting == null ? null : listSetting.trim();
    }

    /**
     * 表单UI设置：三纵列
     * @return FORM_SETTING 表单UI设置：三纵列
     */
    public String getFormSetting() {
        return formSetting;
    }

    /**
     * 表单UI设置：三纵列
     * @param formSetting 表单UI设置：三纵列
     */
    public void setFormSetting(String formSetting) {
        this.formSetting = formSetting == null ? null : formSetting.trim();
    }

    /**
     * 另用基础表，只要该字段不为空，那么就要以该语句作为基础的表
     * @return TABLE_SAME_SQL 另用基础表，只要该字段不为空，那么就要以该语句作为基础的表
     */
    public String getTableSameSql() {
        return tableSameSql;
    }

    /**
     * 另用基础表，只要该字段不为空，那么就要以该语句作为基础的表
     * @param tableSameSql 另用基础表，只要该字段不为空，那么就要以该语句作为基础的表
     */
    public void setTableSameSql(String tableSameSql) {
        this.tableSameSql = tableSameSql == null ? null : tableSameSql.trim();
    }

    /**
     * 批量维护地址
     * @return BATCH_URL 批量维护地址
     */
    public String getBatchUrl() {
        return batchUrl;
    }

    /**
     * 批量维护地址
     * @param batchUrl 批量维护地址
     */
    public void setBatchUrl(String batchUrl) {
        this.batchUrl = batchUrl == null ? null : batchUrl.trim();
    }

    /**
     * 1、表2、视图
     * @return TABLE_TYPE 1、表2、视图
     */
    public String getTableType() {
        return tableType;
    }

    /**
     * 1、表2、视图
     * @param tableType 1、表2、视图
     */
    public void setTableType(String tableType) {
        this.tableType = tableType == null ? null : tableType.trim();
    }

    /**
     * 是否可做查询 1 是 0 否
     * @return IS_FOR_QUERY 是否可做查询 1 是 0 否
     */
    public String getIsForQuery() {
        return isForQuery;
    }

    /**
     * 是否可做查询 1 是 0 否
     * @param isForQuery 是否可做查询 1 是 0 否
     */
    public void setIsForQuery(String isForQuery) {
        this.isForQuery = isForQuery == null ? null : isForQuery.trim();
    }

    public String getIsTree() {
        return isTree;
    }

    public void setIsTree(String isTree) {
        this.isTree = isTree;
    }

    public String getIsIndexTemp() {
        return isIndexTemp;
    }

    public void setIsIndexTemp(String isIndexTemp) {
        this.isIndexTemp = isIndexTemp;
    }
}