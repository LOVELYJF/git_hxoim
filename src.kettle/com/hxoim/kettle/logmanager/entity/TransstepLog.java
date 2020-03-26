package com.hxoim.kettle.logmanager.entity;

import java.util.Date;

public class TransstepLog {
    private Integer idBatch;

    private String channelId;

    private Date logDate;

    private String transname;

    private String stepname;

    private Integer stepCopy;

    private Long linesRead;

    private Long linesWritten;

    private Long linesUpdated;

    private Long linesInput;

    private Long linesOutput;

    private Long linesRejected;

    private Long errors;

    public Integer getIdBatch() {
        return idBatch;
    }

    public void setIdBatch(Integer idBatch) {
        this.idBatch = idBatch;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public String getTransname() {
        return transname;
    }

    public void setTransname(String transname) {
        this.transname = transname;
    }

    public String getStepname() {
        return stepname;
    }

    public void setStepname(String stepname) {
        this.stepname = stepname;
    }

    public Integer getStepCopy() {
        return stepCopy;
    }

    public void setStepCopy(Integer stepCopy) {
        this.stepCopy = stepCopy;
    }

    public Long getLinesRead() {
        return linesRead;
    }

    public void setLinesRead(Long linesRead) {
        this.linesRead = linesRead;
    }

    public Long getLinesWritten() {
        return linesWritten;
    }

    public void setLinesWritten(Long linesWritten) {
        this.linesWritten = linesWritten;
    }

    public Long getLinesUpdated() {
        return linesUpdated;
    }

    public void setLinesUpdated(Long linesUpdated) {
        this.linesUpdated = linesUpdated;
    }

    public Long getLinesInput() {
        return linesInput;
    }

    public void setLinesInput(Long linesInput) {
        this.linesInput = linesInput;
    }

    public Long getLinesOutput() {
        return linesOutput;
    }

    public void setLinesOutput(Long linesOutput) {
        this.linesOutput = linesOutput;
    }

    public Long getLinesRejected() {
        return linesRejected;
    }

    public void setLinesRejected(Long linesRejected) {
        this.linesRejected = linesRejected;
    }

    public Long getErrors() {
        return errors;
    }

    public void setErrors(Long errors) {
        this.errors = errors;
    }
}