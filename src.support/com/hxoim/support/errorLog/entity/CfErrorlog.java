package com.hxoim.support.errorLog.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.IdAnnotation;
import com.hxoim.common.hxannotation.IgnoreLogAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * cf_errorlog
 */
@TableAnnotation(TableName = "cf_errorlog", TableDescription="")
public class CfErrorlog {
    /**
     * 主键
     */
    @IdAnnotation
    @ColumnAnnotation(FieldName = "id",  FieldDescription="主键")
    private String id;

    /**
     * 发生日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ColumnAnnotation(FieldName = "occur_date",  FieldDescription="发生日期")
    private Date occurDate;

    public CfErrorlog(String id, Date occurDate) {
        this.id = id;
        this.occurDate = occurDate;
    }

    public CfErrorlog() {
        super();
    }

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
     * 发生日期
     * @return occur_date 发生日期
     */
    public Date getOccurDate() {
        return occurDate;
    }

    /**
     * 发生日期
     * @param occurDate 发生日期
     */
    public void setOccurDate(Date occurDate) {
        this.occurDate = occurDate;
    }
}