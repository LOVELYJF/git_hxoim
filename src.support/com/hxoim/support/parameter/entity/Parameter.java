package com.hxoim.support.parameter.entity;

import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;

import java.util.Date;

/**
 * @Description: 参数设置实体类
 * @Author: 张乾
 * @CreateDate: 2019/5/17$ 15:44$
 * cf_parameter
 */
@TableAnnotation(TableName = "cf_parameter", TableDescription="")
public class Parameter {
    /**
     *
     */
    @ColumnAnnotation(FieldName = "PM_ID",  FieldDescription="")
    private String pmId;

    /**
     *
     */
    @ColumnAnnotation(FieldName = "pm_code",  FieldDescription="")
    private String pmCode;

    /**
     *
     */
    @ColumnAnnotation(FieldName = "pm_name",  FieldDescription="")
    private String pmName;

    /**
     *
     */
    @ColumnAnnotation(FieldName = "pm_value",  FieldDescription="")
    private String pmValue;

    /**
     *
     */
    @ColumnAnnotation(FieldName = "orderno",  FieldDescription="")
    private Integer orderno;

    /**
     *
     */
    @ColumnAnnotation(FieldName = "modify_user",  FieldDescription="")
    private String modifyUser;

    /**
     *
     */
    @ColumnAnnotation(FieldName = "modify_time",  FieldDescription="")
    private Date modifyTime;

    public Parameter(String pmId, String pmCode, String pmName, String pmValue, Integer orderno, String modifyUser, Date modifyTime) {
        this.pmId = pmId;
        this.pmCode = pmCode;
        this.pmName = pmName;
        this.pmValue = pmValue;
        this.orderno = orderno;
        this.modifyUser = modifyUser;
        this.modifyTime = modifyTime;
    }

    public Parameter() {
        super();
    }

    public String getPmId() {
        return pmId;
    }

    public void setPmId(String pmId) {
        this.pmId = pmId;
    }

    /**
     *
     * @return pm_code
     */
    public String getPmCode() {
        return pmCode;
    }

    /**
     *
     * @param pmCode
     */
    public void setPmCode(String pmCode) {
        this.pmCode = pmCode == null ? null : pmCode.trim();
    }

    /**
     *
     * @return pm_name
     */
    public String getPmName() {
        return pmName;
    }

    /**
     *
     * @param pmName
     */
    public void setPmName(String pmName) {
        this.pmName = pmName == null ? null : pmName.trim();
    }

    /**
     *
     * @return pm_value
     */
    public String getPmValue() {
        return pmValue;
    }

    /**
     *
     * @param pmValue
     */
    public void setPmValue(String pmValue) {
        this.pmValue = pmValue == null ? null : pmValue.trim();
    }

    public Integer getOrderno() {
        return orderno;
    }

    public void setOrderno(Integer orderno) {
        this.orderno = orderno;
    }

    /**
     *
     * @return modify_user
     */
    public String getModifyUser() {
        return modifyUser;
    }

    /**
     *
     * @param modifyUser
     */
    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser == null ? null : modifyUser.trim();
    }

    /**
     *
     * @return modify_time
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     *
     * @param modifyTime
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
