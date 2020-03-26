package com.hxoim.support.inforesource.service.impl;
/*
 * @description:信息资源管理处室
 * @author 杨波
 * @date:2019-07-17
 */

import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.common.utils.StringUilt;
import com.hxoim.support.inforesource.entity.DataTableManager;
import com.hxoim.support.inforesource.entity.DataTableManagerExample;
import com.hxoim.support.inforesource.mapper.DataTableManagerMapper;
import com.hxoim.support.inforesource.service.DataTableManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataTableManagerServiceImpl implements DataTableManagerService {
    @Autowired
    private DataTableManagerMapper mapper=null;

    @Override
    public int deleteByPrimaryKey(String id) {
        if(StringUilt.stringIsNullOrEmpty(id)){
            throw new ParameterNullException("参数不能为空");
        }
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(DataTableManager record) {
        CheckInput(record);
        return mapper.insert(record);
    }

    @Override
    public List<DataTableManager> selectByExample(DataTableManagerExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public DataTableManager selectByPrimaryKey(String id) {
        if(StringUilt.stringIsNullOrEmpty(id)){
            throw new ParameterNullException("参数不能为空");
        }
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(DataTableManager record)
    {
        CheckInput(record);
        return mapper.updateByPrimaryKey(record);
    }
    private void CheckInput(DataTableManager record)
    {
        if(record==null){
            throw new ParameterNullException("参数不能为空");
        }
        if(StringUilt.stringIsNullOrEmpty(record.getTableid())){
            throw new ParameterNullException("表不能为空");
        }
        if(StringUilt.stringIsNullOrEmpty(record.getSysid())){
            throw new ParameterNullException("系统不能为空");
        }
    }
}
