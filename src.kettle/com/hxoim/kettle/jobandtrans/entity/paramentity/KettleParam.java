package com.hxoim.kettle.jobandtrans.entity.paramentity;

import java.util.Map;

/**
 * @desc: kettle参数entity
 * @author: lijing
 * @date: 2019/7/16
 */
public class KettleParam {
    private String name;
    private String transParam;
    private Map<String, String> jobParam;
    //资源目录
    private String dir;

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTransParam() {
        return transParam;
    }

    public void setTransParam(String transParam) {
        this.transParam = transParam;
    }

    public Map<String, String> getJobParam() {
        return jobParam;
    }

    public void setJobParam(Map<String, String> jobParam) {
        this.jobParam = jobParam;
    }
}
