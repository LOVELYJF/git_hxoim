package com.hxoim.support.dataServeApply.service;

import com.hxoim.support.dataServeApply.entity.DataServeApply;

import java.util.List;
import java.util.Map;

public interface DataServeApplyService {

    public abstract List<DataServeApply> selectDataServeApply(Map<String,String> map);

    public abstract DataServeApply selectById(String id);

    public abstract int insertDataServeApply(DataServeApply dataServeApply);

    public abstract int updateDataServeApply(DataServeApply dataServeApply);

    public abstract int deleteDataServeApplyById(String id);

    public abstract List<DataServeApply> selectOtherDataServeApply(String id);

    public abstract DataServeApply selectValidateByParams(String serveIp,String serveUsername);
}
