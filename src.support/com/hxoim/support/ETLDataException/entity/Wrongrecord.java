package com.hxoim.support.ETLDataException.entity;

import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.IdAnnotation;
import com.hxoim.common.hxannotation.IgnoreLogAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;
import java.util.Date;

/**
 * wrongrecord
 */
@TableAnnotation(TableName = "wrongrecord", TableDescription="")
public class Wrongrecord {
    /**
     * 
     */
    @IdAnnotation
    @ColumnAnnotation(FieldName = "Id",  FieldDescription="")
    private Integer id;

    /**
     * 系统名称
     */
    @ColumnAnnotation(FieldName = "SystemName",  FieldDescription="系统名称")
    private String systemname;

    /**
     * 系统标识
     */
    @ColumnAnnotation(FieldName = "ApplicationId",  FieldDescription="系统标识")
    private String applicationid;

    /**
     * 表编码
     */
    @ColumnAnnotation(FieldName = "TableId",  FieldDescription="表编码")
    private String tableid;

    /**
     * 表名称
     */
    @ColumnAnnotation(FieldName = "TableName",  FieldDescription="表名称")
    private String tablename;

    /**
     * 字段名称
     */
    @ColumnAnnotation(FieldName = "FieldName",  FieldDescription="字段名称")
    private String fieldname;

    /**
     * 触发时间
     */
    @ColumnAnnotation(FieldName = "OccurDate",  FieldDescription="触发时间")
    private Date occurdate;

    /**
     * 状态0新异常1已发消息2已处理
     */
    @ColumnAnnotation(FieldName = "State",  FieldDescription="状态0新异常1已发消息2已处理")
    private Integer state;

    /**
     * 处理部门
     */
    @ColumnAnnotation(FieldName = "DealDepartment",  FieldDescription="处理部门")
    private String dealdepartment;

    /**
     * 处理人
     */
    @ColumnAnnotation(FieldName = "DealStaff",  FieldDescription="处理人")
    private String dealstaff;

    /**
     * 处理日期
     */
    @ColumnAnnotation(FieldName = "DealDate",  FieldDescription="处理日期")
    private Date dealdate;

    /**
     * 处理信息
     */
    @ColumnAnnotation(FieldName = "DealInfo",  FieldDescription="处理信息")
    private String dealinfo;

    /**
     * 错误产生步骤
     */
    @ColumnAnnotation(FieldName = "ErrorStep",  FieldDescription="错误产生步骤")
    private String errorstep;

    /**
     * 错误信息
     */
    @IgnoreLogAnnotation
    @ColumnAnnotation(FieldName = "ErrorInfo",  FieldDescription="错误信息")
    private String errorinfo;

    public Wrongrecord(Integer id, String systemname, String applicationid, String tableid, String tablename, String fieldname, Date occurdate, Integer state, String dealdepartment, String dealstaff, Date dealdate, String dealinfo, String errorstep) {
        this.id = id;
        this.systemname = systemname;
        this.applicationid = applicationid;
        this.tableid = tableid;
        this.tablename = tablename;
        this.fieldname = fieldname;
        this.occurdate = occurdate;
        this.state = state;
        this.dealdepartment = dealdepartment;
        this.dealstaff = dealstaff;
        this.dealdate = dealdate;
        this.dealinfo = dealinfo;
        this.errorstep = errorstep;
    }

    public Wrongrecord(Integer id, String systemname, String applicationid, String tableid, String tablename, String fieldname, Date occurdate, Integer state, String dealdepartment, String dealstaff, Date dealdate, String dealinfo, String errorstep, String errorinfo) {
        this.id = id;
        this.systemname = systemname;
        this.applicationid = applicationid;
        this.tableid = tableid;
        this.tablename = tablename;
        this.fieldname = fieldname;
        this.occurdate = occurdate;
        this.state = state;
        this.dealdepartment = dealdepartment;
        this.dealstaff = dealstaff;
        this.dealdate = dealdate;
        this.dealinfo = dealinfo;
        this.errorstep = errorstep;
        this.errorinfo = errorinfo;
    }

    public Wrongrecord() {
        super();
    }

    /**
     * 
     * @return Id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 系统名称
     * @return SystemName 系统名称
     */
    public String getSystemname() {
        return systemname;
    }

    /**
     * 系统名称
     * @param systemname 系统名称
     */
    public void setSystemname(String systemname) {
        this.systemname = systemname == null ? null : systemname.trim();
    }

    /**
     * 系统标识
     * @return ApplicationId 系统标识
     */
    public String getApplicationid() {
        return applicationid;
    }

    /**
     * 系统标识
     * @param applicationid 系统标识
     */
    public void setApplicationid(String applicationid) {
        this.applicationid = applicationid == null ? null : applicationid.trim();
    }

    /**
     * 表编码
     * @return TableId 表编码
     */
    public String getTableid() {
        return tableid;
    }

    /**
     * 表编码
     * @param tableid 表编码
     */
    public void setTableid(String tableid) {
        this.tableid = tableid == null ? null : tableid.trim();
    }

    /**
     * 表名称
     * @return TableName 表名称
     */
    public String getTablename() {
        return tablename;
    }

    /**
     * 表名称
     * @param tablename 表名称
     */
    public void setTablename(String tablename) {
        this.tablename = tablename == null ? null : tablename.trim();
    }

    /**
     * 字段名称
     * @return FieldName 字段名称
     */
    public String getFieldname() {
        return fieldname;
    }

    /**
     * 字段名称
     * @param fieldname 字段名称
     */
    public void setFieldname(String fieldname) {
        this.fieldname = fieldname == null ? null : fieldname.trim();
    }

    /**
     * 触发时间
     * @return OccurDate 触发时间
     */
    public Date getOccurdate() {
        return occurdate;
    }

    /**
     * 触发时间
     * @param occurdate 触发时间
     */
    public void setOccurdate(Date occurdate) {
        this.occurdate = occurdate;
    }

    /**
     * 状态0新异常1已发消息2已处理
     * @return State 状态0新异常1已发消息2已处理
     */
    public Integer getState() {
        return state;
    }

    /**
     * 状态0新异常1已发消息2已处理
     * @param state 状态0新异常1已发消息2已处理
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 处理部门
     * @return DealDepartment 处理部门
     */
    public String getDealdepartment() {
        return dealdepartment;
    }

    /**
     * 处理部门
     * @param dealdepartment 处理部门
     */
    public void setDealdepartment(String dealdepartment) {
        this.dealdepartment = dealdepartment == null ? null : dealdepartment.trim();
    }

    /**
     * 处理人
     * @return DealStaff 处理人
     */
    public String getDealstaff() {
        return dealstaff;
    }

    /**
     * 处理人
     * @param dealstaff 处理人
     */
    public void setDealstaff(String dealstaff) {
        this.dealstaff = dealstaff == null ? null : dealstaff.trim();
    }

    /**
     * 处理日期
     * @return DealDate 处理日期
     */
    public Date getDealdate() {
        return dealdate;
    }

    /**
     * 处理日期
     * @param dealdate 处理日期
     */
    public void setDealdate(Date dealdate) {
        this.dealdate = dealdate;
    }

    /**
     * 处理信息
     * @return DealInfo 处理信息
     */
    public String getDealinfo() {
        return dealinfo;
    }

    /**
     * 处理信息
     * @param dealinfo 处理信息
     */
    public void setDealinfo(String dealinfo) {
        this.dealinfo = dealinfo == null ? null : dealinfo.trim();
    }

    /**
     * 错误产生步骤
     * @return ErrorStep 错误产生步骤
     */
    public String getErrorstep() {
        return errorstep;
    }

    /**
     * 错误产生步骤
     * @param errorstep 错误产生步骤
     */
    public void setErrorstep(String errorstep) {
        this.errorstep = errorstep == null ? null : errorstep.trim();
    }

    /**
     * 错误信息
     * @return ErrorInfo 错误信息
     */
    public String getErrorinfo() {
        return errorinfo;
    }

    /**
     * 错误信息
     * @param errorinfo 错误信息
     */
    public void setErrorinfo(String errorinfo) {
        this.errorinfo = errorinfo == null ? null : errorinfo.trim();
    }
}