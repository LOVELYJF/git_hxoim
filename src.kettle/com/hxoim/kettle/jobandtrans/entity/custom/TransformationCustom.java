package com.hxoim.kettle.jobandtrans.entity.custom;

import com.hxoim.kettle.jobandtrans.entity.Transformation;

import java.util.Date;

/**
 * @desc: 转换扩展实体类
 * @author: lijing
 * @date: 2019/7/12
 */
public class TransformationCustom extends Transformation {
    //成功数
    private Integer successNum;
    //执行过数
    private Integer finishTransNum;
    //最后执行时间
    private Date transLogDate;

    public String getTransLogStatus() {
        return transLogStatus;
    }

    public void setTransLogStatus(String transLogStatus) {
        this.transLogStatus = transLogStatus;
    }

    public Date getTransLogDate() {
        return transLogDate;
    }

    public void setTransLogDate(Date transLogDate) {
        this.transLogDate = transLogDate;
    }

    //状态
    private String transLogStatus;

    public Integer getFinishTransNum() {
        return finishTransNum;
    }

    public void setFinishTransNum(Integer finishTransNum) {
        this.finishTransNum = finishTransNum;
    }

    public Integer getSuccessNum() {
        return successNum;
    }

    public void setSuccessNum(Integer successNum) {
        this.successNum = successNum;
    }
}
