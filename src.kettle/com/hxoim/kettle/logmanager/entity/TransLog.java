package com.hxoim.kettle.logmanager.entity;

import java.util.Date;

public class TransLog {
    private Integer idBatch;

    private String channelId;

    private String transname;

    private String status;

    private Long linesRead;

    private Long linesWritten;

    private Long linesUpdated;

    private Long linesInput;

    private Long linesOutput;

    private Long linesRejected;

    private Long errors;

    private Date startdate;

    private Date enddate;

    private Date logdate;

    private Date depdate;

    private Date replaydate;

    private String logField;

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

    public String getTransname() {
        return transname;
    }

    public void setTransname(String transname) {
        this.transname = transname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Date getLogdate() {
        return logdate;
    }

    public void setLogdate(Date logdate) {
        this.logdate = logdate;
    }

    public Date getDepdate() {
        return depdate;
    }

    public void setDepdate(Date depdate) {
        this.depdate = depdate;
    }

    public Date getReplaydate() {
        return replaydate;
    }

    public void setReplaydate(Date replaydate) {
        this.replaydate = replaydate;
    }

    public String getLogField() {
        return logField;
    }

    public void setLogField(String logField) {
        this.logField = logField;
    }
}