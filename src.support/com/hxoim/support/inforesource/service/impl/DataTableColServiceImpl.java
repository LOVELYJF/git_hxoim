package com.hxoim.support.inforesource.service.impl;

import com.hxoim.common.Reflector.ReflectHelpper;
import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.common.utils.Result;
import com.hxoim.common.utils.StringUilt;
import com.hxoim.common.utils.UUIDGenerator;
import com.hxoim.support.inforesource.entity.DataTableCol;
import com.hxoim.support.inforesource.entity.DataTableColExample;
import com.hxoim.support.inforesource.mapper.DataTableColMapper;
import com.hxoim.support.inforesource.service.DataTableColService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * @description:信息资源项
 * @author 杨波
 * @date:2019-07-17
 */
@Service
public class DataTableColServiceImpl implements DataTableColService {
    @Autowired
    private DataTableColMapper mapper = null;

    /**
     * @description:通过主键删除信息资源项
     * @author:杨波
     * @date:2019-07-17 * @param String id
     * @return:
     **/
    @Override
    public int deleteByPrimaryKey(String id) {
        if (StringUilt.stringIsNullOrEmpty(id)) {
            throw new ParameterNullException("参数不能为空");
        }

        DataTableCol dataTableCol = mapper.selectByPrimaryKey(id);
        if (dataTableCol == null) {
            throw new ParameterNullException("该字段已经被删除！");
        }
        if (dataTableCol.getIsSystem().equals("1")) {
            throw new ParameterNullException("系统字段不能被删除！");
        }
        int result = mapper.deleteByPrimaryKey(id);
        mapper.dropColumn(dataTableCol);

        return result;
    }

    /**
     * @description:通过表名删除所有字段，删除表时使用
     * @author:杨波
     * @date:2019-07-22 * @param String tabCode 表名
     * @return:
     **/
    @Override
    public int deleteByTabCode(String tabCode) {
        return mapper.deleteByTabCode(tabCode);
    }

    /**
     * @description:清加信息资源项
     * @author:杨波
     * @date:2019-07-17 * @param DataTableCol record
     * @return:
     **/
    @Override
    public int insert(DataTableCol record) {
        CheckInput(record);

        record = InitialDataTableCol(record);
        int result = mapper.insert(record);
        mapper.insertColumn(record);
        return result;
    }

    /**
     * @description:添加信息资源项，部分字段可为空
     * @author:杨波
     * @date:2019-07-17 * @param DataTableCol record
     * @return:
     **/
    @Override
    public int insertSelective(DataTableCol record) {
        CheckInput(record);
        record = InitialDataTableCol(record);
        int result = mapper.insertSelective(record);
        mapper.insertColumn(record);
        return result;
    }

    private DataTableCol InitialDataTableCol(DataTableCol record) {
        Integer max = mapper.selectMaxOrderindex(record);
        if (max == null) {
            record.setOrderIndex(1);
        } else {
            record.setOrderIndex(max + 1);
        }
        record.setId(UUIDGenerator.getPrimaryKey());
        ReflectHelpper.setModifyFields(record);

        return record;
    }

    /**
     * @description:按自定义条件查询信息资源项
     * @author:杨波
     * @date:2019-07-17 * @param DataTableColExample example
     * @return:
     **/
    @Override
    public List<DataTableCol> selectByExample(DataTableColExample example) {
        return mapper.selectByExample(example);
    }
    /**
     * @description:返回指定表的所有字段
     * @author:杨波
     * @date:2019-09-04
     *  * @param tableCode
     * @return:java.util.List<com.hxoim.support.inforesource.entity.DataTableCol>
     **/
    @Override
    public List<DataTableCol> selectByTabCode(String tableCode) {
        List<DataTableCol> dtc = mapper.selectByTabCode(tableCode);
        return dtc;
    }

    /**
     * @description:通过主键查找信息资源项
     * @author:杨波
     * @date:2019-07-17 * @param String id
     * @return:
     **/
    @Override
    public DataTableCol selectByPrimaryKey(String id) {
        DataTableCol dtc = mapper.selectByPrimaryKey(id);
        return dtc;
    }

    /**
     * @description:修改信息资源项，部分字段可为空
     * @author:杨波
     * @date:2019-07-17 * @param DataTableCol record
     * @return:
     **/
    @Override
    public int updateByPrimaryKeySelective(DataTableCol record) {
        DataTableCol oldEnglisnName = mapper.selectByPrimaryKey(record.getId());
        record.setOldColCode(oldEnglisnName.getColCode());

        CheckInput(record);

        ReflectHelpper.setModifyFields(record);
        int result = mapper.updateByPrimaryKeySelective(record);
        mapper.updateColumn(record);

        return result;
    }

    /**
     * @description:修改信息资源项
     * @author:杨波
     * @date:2019-07-17 * @param DataTableCol record
     * @return:
     **/
    @Override
    public int updateByPrimaryKey(DataTableCol record) {
        DataTableCol oldEnglisnName = mapper.selectByPrimaryKey(record.getId());
        record.setOldColCode(oldEnglisnName.getColCode());

        CheckInput(record);

        ReflectHelpper.setModifyFields(record);
        int result = mapper.updateByPrimaryKey(record);
        mapper.updateColumn(record);

        return result;
    }

    /**
     * @description:对字段排序
     * @author:杨波
     * @date:2019-07-18 * @param String[] ids
     * @return:
     **/
    @Override
    public void sortCols(String[] ids) {
        if (ids == null || ids.length == 0) {
            throw new ParameterNullException("排序字段不能为空");
        }
        for (int i = 0; i < ids.length; i++) {
            DataTableCol information = new DataTableCol();
            information.setId(ids[i]);
            information.setOrderIndex(i + 1);
            mapper.sortInformations(information);
        }
    }

    private void CheckInput(DataTableCol record) {
        if (record == null) {
            throw new ParameterNullException("参数不能为空");
        }
        if (StringUilt.stringIsNullOrEmpty(record.getTabCode())) {
            throw new ParameterNullException("表名不能为空");
        }
        if (StringUilt.stringIsNullOrEmpty(record.getColCode())) {
            throw new ParameterNullException("字段名不能为空");
        }
        if (StringUilt.stringIsNullOrEmpty(record.getColName())) {
            throw new ParameterNullException("字段中文名不能为空");
        }

        int count = mapper.selectColumnName(record);
        if (count > 0) {
            throw new ParameterNullException(record.getColName() + "列名已存在");
        }
        if (record.getDataType() == "varchar" && record.getLength1() == 0) {
            record.setLength1(50);
        }
    }
}
