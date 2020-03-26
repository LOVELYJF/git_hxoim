package com.hxoim.support.indexTemp.service;

import com.hxoim.common.tree.Tree;
import com.hxoim.support.indexTemp.entity.IndexTemp;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface IndexTempService {
    public abstract boolean insertBatchSelective(IndexTemp record[]);

    public abstract void deleteIndexTempById(String id);

    public abstract List<IndexTemp> selectIndexTempByOrg();

    public abstract List<LinkedHashMap<String,Object>> selectSysModule(String tableName,String ids[]);

    public abstract void executeSysModule(String params);

    public abstract List selectSysTempModule();

    public abstract boolean insertSysTempModule(IndexTemp record[]);

    public abstract boolean updateSysTempModule(IndexTemp record[]);

    public abstract List<LinkedHashMap<String, Object>> selectIndexTempTable();

    public abstract Map selectTree(String tableName,String tempId);

    public abstract List<Tree> selectTree(String tableName);

    public abstract List selectSystemInfo();

    public abstract List<Tree> selectSystemModule();

    /**
     * @desc: 查询数据列表
     * @author: lijing
     * @date: 2019/9/5
     */
    Map selectTableList(Integer pageSize, Integer pageNum, String tableName);
}
