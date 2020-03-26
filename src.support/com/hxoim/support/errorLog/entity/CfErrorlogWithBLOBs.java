package com.hxoim.support.errorLog.entity;

import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.IdAnnotation;
import com.hxoim.common.hxannotation.IgnoreLogAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;
import java.util.Date;

/**
 * cf_errorlog
 */
@TableAnnotation(TableName = "cf_errorlog", TableDescription="")
public class CfErrorlogWithBLOBs extends CfErrorlog {
    /**
     * 错误消息
     */
    @IgnoreLogAnnotation
    @ColumnAnnotation(FieldName = "error_info",  FieldDescription="错误消息")
    private String errorInfo;

    /**
     * 堆栈
     */
    @IgnoreLogAnnotation
    @ColumnAnnotation(FieldName = "error_trace",  FieldDescription="堆栈")
    private String errorTrace;

    public CfErrorlogWithBLOBs(String id, Date occurDate, String errorInfo, String errorTrace) {
        super(id, occurDate);
        this.errorInfo = errorInfo;
        this.errorTrace = errorTrace;
    }

    public CfErrorlogWithBLOBs() {
        super();
    }

    /**
     * 错误消息
     * @return error_info 错误消息
     */
    public String getErrorInfo() {
        return errorInfo;
    }

    /**
     * 错误消息
     * @param errorInfo 错误消息
     */
    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo == null ? null : errorInfo.trim();
    }

    /**
     * 堆栈
     * @return error_trace 堆栈
     */
    public String getErrorTrace() {
        return errorTrace;
    }

    /**
     * 堆栈
     * @param errorTrace 堆栈
     */
    public void setErrorTrace(String errorTrace) {
        this.errorTrace = errorTrace == null ? null : errorTrace.trim();
    }
}