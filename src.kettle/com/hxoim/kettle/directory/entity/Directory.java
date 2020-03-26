package com.hxoim.kettle.directory.entity;

public class Directory {
    private Long idDirectory;

    private Integer idDirectoryParent;

    private String directoryName;

    public Long getIdDirectory() {
        return idDirectory;
    }

    public void setIdDirectory(Long idDirectory) {
        this.idDirectory = idDirectory;
    }

    public Integer getIdDirectoryParent() {
        return idDirectoryParent;
    }

    public void setIdDirectoryParent(Integer idDirectoryParent) {
        this.idDirectoryParent = idDirectoryParent;
    }

    public String getDirectoryName() {
        return directoryName;
    }

    public void setDirectoryName(String directoryName) {
        this.directoryName = directoryName;
    }
}