package com.hxoim.kettle.jobandtrans.entity;

import java.util.Date;

public class Transformation {
    private Long idTransformation;

    private Integer idDirectory;

    private String name;

    private String transVersion;

    private Integer transStatus;

    private Integer idStepRead;

    private Integer idStepWrite;

    private Integer idStepInput;

    private Integer idStepOutput;

    private Integer idStepUpdate;

    private Integer idDatabaseLog;

    private String tableNameLog;

    private Boolean useBatchid;

    private Boolean useLogfield;

    private Integer idDatabaseMaxdate;

    private String tableNameMaxdate;

    private String fieldNameMaxdate;

    private Double offsetMaxdate;

    private Double diffMaxdate;

    private String createdUser;

    private Date createdDate;

    private String modifiedUser;

    private Date modifiedDate;

    private Integer sizeRowset;

    public Long getIdTransformation() {
        return idTransformation;
    }

    public void setIdTransformation(Long idTransformation) {
        this.idTransformation = idTransformation;
    }

    public Integer getIdDirectory() {
        return idDirectory;
    }

    public void setIdDirectory(Integer idDirectory) {
        this.idDirectory = idDirectory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTransVersion() {
        return transVersion;
    }

    public void setTransVersion(String transVersion) {
        this.transVersion = transVersion;
    }

    public Integer getTransStatus() {
        return transStatus;
    }

    public void setTransStatus(Integer transStatus) {
        this.transStatus = transStatus;
    }

    public Integer getIdStepRead() {
        return idStepRead;
    }

    public void setIdStepRead(Integer idStepRead) {
        this.idStepRead = idStepRead;
    }

    public Integer getIdStepWrite() {
        return idStepWrite;
    }

    public void setIdStepWrite(Integer idStepWrite) {
        this.idStepWrite = idStepWrite;
    }

    public Integer getIdStepInput() {
        return idStepInput;
    }

    public void setIdStepInput(Integer idStepInput) {
        this.idStepInput = idStepInput;
    }

    public Integer getIdStepOutput() {
        return idStepOutput;
    }

    public void setIdStepOutput(Integer idStepOutput) {
        this.idStepOutput = idStepOutput;
    }

    public Integer getIdStepUpdate() {
        return idStepUpdate;
    }

    public void setIdStepUpdate(Integer idStepUpdate) {
        this.idStepUpdate = idStepUpdate;
    }

    public Integer getIdDatabaseLog() {
        return idDatabaseLog;
    }

    public void setIdDatabaseLog(Integer idDatabaseLog) {
        this.idDatabaseLog = idDatabaseLog;
    }

    public String getTableNameLog() {
        return tableNameLog;
    }

    public void setTableNameLog(String tableNameLog) {
        this.tableNameLog = tableNameLog;
    }

    public Boolean getUseBatchid() {
        return useBatchid;
    }

    public void setUseBatchid(Boolean useBatchid) {
        this.useBatchid = useBatchid;
    }

    public Boolean getUseLogfield() {
        return useLogfield;
    }

    public void setUseLogfield(Boolean useLogfield) {
        this.useLogfield = useLogfield;
    }

    public Integer getIdDatabaseMaxdate() {
        return idDatabaseMaxdate;
    }

    public void setIdDatabaseMaxdate(Integer idDatabaseMaxdate) {
        this.idDatabaseMaxdate = idDatabaseMaxdate;
    }

    public String getTableNameMaxdate() {
        return tableNameMaxdate;
    }

    public void setTableNameMaxdate(String tableNameMaxdate) {
        this.tableNameMaxdate = tableNameMaxdate;
    }

    public String getFieldNameMaxdate() {
        return fieldNameMaxdate;
    }

    public void setFieldNameMaxdate(String fieldNameMaxdate) {
        this.fieldNameMaxdate = fieldNameMaxdate;
    }

    public Double getOffsetMaxdate() {
        return offsetMaxdate;
    }

    public void setOffsetMaxdate(Double offsetMaxdate) {
        this.offsetMaxdate = offsetMaxdate;
    }

    public Double getDiffMaxdate() {
        return diffMaxdate;
    }

    public void setDiffMaxdate(Double diffMaxdate) {
        this.diffMaxdate = diffMaxdate;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Integer getSizeRowset() {
        return sizeRowset;
    }

    public void setSizeRowset(Integer sizeRowset) {
        this.sizeRowset = sizeRowset;
    }
}