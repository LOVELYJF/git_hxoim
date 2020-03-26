package com.hxoim.support.sysdict.entity;

import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.IdAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;

import java.util.Date;

/**
 * @description：字典管理实体类
 * @author ：张乾
 * @createDate ： 2019/5/27 16:22
 * sys_dict
 */
@TableAnnotation(TableName = "sys_dict", TableDescription="")
public class SysDict {
    /**
     *
     */
    @IdAnnotation
    @ColumnAnnotation(FieldName = "id",  FieldDescription="")
    private String id;

    /**
     * 字典编码
     */
    @ColumnAnnotation(FieldName = "dict_code",  FieldDescription="字典编码")
    private String dictCode;

    /**
     * 字典名称
     */
    @ColumnAnnotation(FieldName = "dict_name",  FieldDescription="字典名称")
    private String dictName;

    /**
     * 采用标准
     */
    @ColumnAnnotation(FieldName = "standard",  FieldDescription="采用标准")
    private String standard;

    /**
     * 序号
     */
    @ColumnAnnotation(FieldName = "order_index",  FieldDescription="序号")
    private Integer orderindex;

    /**
     * TIME_STAMP
     */
    @ColumnAnnotation(FieldName = "time_stamp",  FieldDescription="TIME_STAMP")
    private String timeStamp;

    /**
     * SECURITYLEVEL
     */
    @ColumnAnnotation(FieldName = "securitylevel",  FieldDescription="SECURITYLEVEL")
    private String securitylevel;

    /**
     * HX_DICT_CODE
     */
    @ColumnAnnotation(FieldName = "hx_dict_code",  FieldDescription="HX_DICT_CODE")
    private String hxDictCode;

    /**
     * REMARK
     */
    @ColumnAnnotation(FieldName = "remark",  FieldDescription="REMARK")
    private String remark;

    /**
     * 修改用户
     */
    @ColumnAnnotation(FieldName = "modify_user",  FieldDescription="修改用户")
    private String modifyUser;

    /**
     * 修改时间
     */
    @ColumnAnnotation(FieldName = "modify_time",  FieldDescription="修改时间")
    private Date modifyTime;

    private String codeName;       //名称+code

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public SysDict(String id, String dictCode, String dictName, String standard, Integer orderindex, String timeStamp, String securitylevel, String hxDictCode, String remark, String modifyUser, Date modifyTime) {
        this.id = id;
        this.dictCode = dictCode;
        this.dictName = dictName;
        this.standard = standard;
        this.orderindex = orderindex;
        this.timeStamp = timeStamp;
        this.securitylevel = securitylevel;
        this.hxDictCode = hxDictCode;
        this.remark = remark;
        this.modifyUser = modifyUser;
        this.modifyTime = modifyTime;
    }

    public SysDict() {
        super();
    }

    /**
     *
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 字典编码
     * @return dict_code 字典编码
     */
    public String getDictCode() {
        return dictCode;
    }

    /**
     * 字典编码
     * @param dictCode 字典编码
     */
    public void setDictCode(String dictCode) {
        this.dictCode = dictCode == null ? null : dictCode.trim();
    }

    /**
     * 字典名称
     * @return dict_name 字典名称
     */
    public String getDictName() {
        return dictName;
    }

    /**
     * 字典名称
     * @param dictName 字典名称
     */
    public void setDictName(String dictName) {
        this.dictName = dictName == null ? null : dictName.trim();
    }

    /**
     * 采用标准
     * @return standard 采用标准
     */
    public String getStandard() {
        return standard;
    }

    /**
     * 采用标准
     * @param standard 采用标准
     */
    public void setStandard(String standard) {
        this.standard = standard == null ? null : standard.trim();
    }

    public Integer getOrderindex() {
        return orderindex;
    }

    public void setOrderindex(Integer orderindex) {
        this.orderindex = orderindex;
    }

    /**
     * TIME_STAMP
     * @return time_stamp TIME_STAMP
     */
    public String getTimeStamp() {
        return timeStamp;
    }

    /**
     * TIME_STAMP
     * @param timeStamp TIME_STAMP
     */
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp == null ? null : timeStamp.trim();
    }

    /**
     * SECURITYLEVEL
     * @return securitylevel SECURITYLEVEL
     */
    public String getSecuritylevel() {
        return securitylevel;
    }

    /**
     * SECURITYLEVEL
     * @param securitylevel SECURITYLEVEL
     */
    public void setSecuritylevel(String securitylevel) {
        this.securitylevel = securitylevel == null ? null : securitylevel.trim();
    }

    /**
     * HX_DICT_CODE
     * @return hx_dict_code HX_DICT_CODE
     */
    public String getHxDictCode() {
        return hxDictCode;
    }

    /**
     * HX_DICT_CODE
     * @param hxDictCode HX_DICT_CODE
     */
    public void setHxDictCode(String hxDictCode) {
        this.hxDictCode = hxDictCode == null ? null : hxDictCode.trim();
    }

    /**
     * REMARK
     * @return remark REMARK
     */
    public String getRemark() {
        return remark;
    }

    /**
     * REMARK
     * @param remark REMARK
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
}
