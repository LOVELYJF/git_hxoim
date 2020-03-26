package com.hxoim.kettle.jobandtrans.entity;

public class JobWithBLOBs extends Job {
    private String description;

    private String extendedDescription;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExtendedDescription() {
        return extendedDescription;
    }

    public void setExtendedDescription(String extendedDescription) {
        this.extendedDescription = extendedDescription;
    }
}