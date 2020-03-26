package com.hxoim.general.select.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hxoim.general.select.mapper.SelectMapper;
import com.hxoim.general.select.entity.SqlVo;
import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.common.utils.*;
import com.hxoim.support.inforesource.entity.DataTableCol;
import com.hxoim.support.inforesource.mapper.DataTableColMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;

/*
 * @description:
 * @author 杨波
 * @date:2019-08-20
 */
@RestController
@RequestMapping("/select")
public class SelectController {
    @Autowired
    private SelectMapper mapper;
    @Autowired
    private DataTableColMapper dataTableColMapper;

    /**
     * @param id 主键值
     * @description:获取指定表，指定主键的一条数据
     * @author:杨波
     * @date:2019-09-04 * @param tableCode 表名
     * @return:com.hxoim.common.utils.Result
     **/
    @RequestMapping("/selectOne")
    public Result selectData(String tableCode, String id) {

        if (StringUilt.stringIsNullOrEmpty(tableCode) ||
                StringUilt.stringIsNullOrEmpty(id)) {
            throw new ParameterNullException("参数不能为空");
        }
        String sql = "select * from " + tableCode + " where id='" + id + "'";
        SqlVo sqlVo = SqlVo.getInstance(sql);

        List<LinkedHashMap<String, Object>> r = mapper.select(sqlVo);

        return Result.success(r);
    }

    /**
     * @param json json格式的字符串数据
     * @description:插入指定表的数据
     * @author:杨波
     * @date:2019-09-04 * @param tableCode 表名
     * @return:com.hxoim.common.utils.Result
     **/
    @RequestMapping("/insert")
    public Result insert(String tableCode, String json) {

        CheckInput(tableCode, json);
        List<DataTableCol> cols = dataTableColMapper.selectByTabCode(tableCode);
        JSONObject data = JSON.parseObject(json);
        String sqlFields = "insert into " + tableCode + "(";
        String sqlValues = "values(";
        for (DataTableCol col : cols
        ) {
            String value = data.getString(col.getColCode().toLowerCase());
            if (StringUilt.stringIsNullOrEmpty(value)) {
                if ("id".equals(col.getColCode().toLowerCase())) {
                    value = UUIDGenerator.getPrimaryKey();
                } else if (!"modify_user".equals(col.getColCode().toLowerCase()) &&
                        !"modify_time".equals(col.getColCode().toLowerCase())) {
                    continue;
                }
            }
            if ("modify_user".equals(col.getColCode().toLowerCase())) {
                value = UserInfoUtil.getUserInfo().getUserName();
            } else if ("modify_time".equals(col.getColCode().toLowerCase())) {
                value = UtilDateTime.nowDateTime();
            }
            sqlFields += col.getColCode() + ",";
            if (col.getDataType() == "int") {
                sqlValues += value + ",";
            } else {
                sqlValues += "'" + value.replaceAll("'", "''") + "',";
            }
        }
        sqlFields = sqlFields.substring(0, sqlFields.length() - 1) + ") ";
        sqlValues = sqlValues.substring(0, sqlValues.length() - 1) + ") ";

        SqlVo sql = SqlVo.getInstance(sqlFields + sqlValues);
        mapper.insert(sql);
        return Result.success();
    }

    /**
     * @param json json格式的字符串数据
     * @description:修改指定表的数据
     * @author:杨波
     * @date:2019-09-04 * @param tableCode 表名
     * @return:com.hxoim.common.utils.Result
     **/
    @RequestMapping("/update")
    public Result update(String tableCode, String json) {

        CheckInput(tableCode, json);
        List<DataTableCol> cols = dataTableColMapper.selectByTabCode(tableCode);
        JSONObject data = JSON.parseObject(json);
        String sqlFields = "update " + tableCode + " set ";
        for (DataTableCol col : cols
        ) {
            String value = data.getString(col.getColCode().toLowerCase());
            if (StringUilt.stringIsNullOrEmpty(value)) {
                if (!"id".equals(col.getColCode().toLowerCase()) &&
                        !"modify_user".equals(col.getColCode().toLowerCase()) &&
                        !"modify_time".equals(col.getColCode().toLowerCase())) {
                    continue;
                }
            }
            if ("modify_user".equals(col.getColCode().toLowerCase())) {
                value = UserInfoUtil.getUserInfo().getUserName();
            } else if ("modify_time".equals(col.getColCode().toLowerCase())) {
                value = UtilDateTime.nowDateTime();
            }
            if (col.getDataType() == "int") {
                sqlFields += col.getColCode() + "=" + value + ",";
            } else {
                sqlFields += col.getColCode() + "='" + value.replaceAll("'", "''") + "',";
            }
        }
        sqlFields = sqlFields.substring(0, sqlFields.length() - 1) + " where id='" + data.getString("id") + "'";

        SqlVo sql = SqlVo.getInstance(sqlFields);
        mapper.update(sql);
        return Result.success();
    }

    @RequestMapping("/del")
    public Result delete(String tableCode, String id) {
        if (StringUilt.stringIsNullOrEmpty(tableCode) ||
                StringUilt.stringIsNullOrEmpty(id)) {
            throw new ParameterNullException("参数不能为空");
        }

        SqlVo sql=SqlVo.getInstance("delete from "+tableCode+" where id='"+id+"'");
        mapper.delete(sql);

        return Result.success();
    }


    /**
     * @desc: 通过表名，指定主键编码获取信息
     * @author: lijing
     * @date: 2019/9/6
     */
    @RequestMapping("/selectOneByPrimaryKey")
    public Result selectOneByPrimaryKey(String tableCode, String id, String primaryKeyCode) {
        if (StringUilt.stringIsNullOrEmpty(tableCode) ||
                StringUilt.stringIsNullOrEmpty(id)) {
            throw new ParameterNullException("参数不能为空");
        }
        if (StringUtils.isEmpty(primaryKeyCode)){
            throw new ParameterNullException("参数错误");
        }
        String sql = "select * from " + tableCode + " where "+ primaryKeyCode + " = '" + id + "'";
        SqlVo sqlVo = SqlVo.getInstance(sql);

        List<LinkedHashMap<String, Object>> r = mapper.select(sqlVo);

        return Result.success(r);
    }

    /**
     * @desc: 插入数据，传入主键编码
     * @author: lijing
     * @date: 2019/9/6
     */
    @RequestMapping("/insertByPrimaryKey")
    public Result insertByPrimaryKey(String tableCode, String json, String primaryKeyCode) {
        CheckInput(tableCode, json);
        if (StringUtils.isEmpty(primaryKeyCode)){
            throw new ParameterNullException("参数错误");
        }
        List<DataTableCol> cols = dataTableColMapper.selectByTabCode(tableCode);
        JSONObject data = JSON.parseObject(json);
        String sqlFields = "insert into " + tableCode + "(";
        String sqlValues = "values(";
        for (DataTableCol col : cols
        ) {
            String value = data.getString(col.getColCode().toLowerCase());
            if (StringUilt.stringIsNullOrEmpty(value)) {
                if (primaryKeyCode.equals(col.getColCode().toLowerCase())) {
                    value = UUIDGenerator.getPrimaryKey();
                } else if (!"modify_user".equals(col.getColCode().toLowerCase()) &&
                        !"modify_time".equals(col.getColCode().toLowerCase())) {
                    continue;
                }
            }
            if ("modify_user".equals(col.getColCode().toLowerCase())) {
                value = UserInfoUtil.getUserInfo().getUserName();
            } else if ("modify_time".equals(col.getColCode().toLowerCase())) {
                value = UtilDateTime.nowDateTime();
            }
            sqlFields += col.getColCode() + ",";
            if (col.getDataType() == "int") {
                sqlValues += value + ",";
            } else {
                sqlValues += "'" + value.replaceAll("'", "''") + "',";
            }
        }
        sqlFields = sqlFields.substring(0, sqlFields.length() - 1) + ") ";
        sqlValues = sqlValues.substring(0, sqlValues.length() - 1) + ") ";

        SqlVo sql = SqlVo.getInstance(sqlFields + sqlValues);
        mapper.insert(sql);
        return Result.success();
    }

    /**
     * @desc: 修改数据，传入主键编码
     * @author: lijing
     * @date: 2019/9/6
     */
    @RequestMapping("/updateByPrimaryKey")
    public Result updateByPrimaryKey(String tableCode, String json, String primaryKeyCode) {
        if (StringUtils.isEmpty(primaryKeyCode)){
            throw new ParameterNullException("参数错误");
        }
        CheckInput(tableCode, json);
        List<DataTableCol> cols = dataTableColMapper.selectByTabCode(tableCode);
        JSONObject data = JSON.parseObject(json);
        String sqlFields = "update " + tableCode + " set ";
        for (DataTableCol col : cols
        ) {
            String value = data.getString(col.getColCode().toLowerCase());
            if (StringUilt.stringIsNullOrEmpty(value)) {
                if (!primaryKeyCode.equals(col.getColCode().toLowerCase()) &&
                        !"modify_user".equals(col.getColCode().toLowerCase()) &&
                        !"modify_time".equals(col.getColCode().toLowerCase())) {
                    continue;
                }
            }
            if ("modify_user".equals(col.getColCode().toLowerCase())) {
                value = UserInfoUtil.getUserInfo().getUserName();
            } else if ("modify_time".equals(col.getColCode().toLowerCase())) {
                value = UtilDateTime.nowDateTime();
            }
            if (col.getDataType() == "int") {
                sqlFields += col.getColCode() + "=" + value + ",";
            } else {
                sqlFields += col.getColCode() + "='" + value.replaceAll("'", "''") + "',";
            }
        }
        sqlFields = sqlFields.substring(0, sqlFields.length() - 1) + " where id='" + data.getString("id") + "'";

        SqlVo sql = SqlVo.getInstance(sqlFields);
        mapper.update(sql);
        return Result.success();
    }

    /**
     * @desc: 删除数据，传入主键编码
     * @author: lijing
     * @date: 2019/9/6
     */
    @RequestMapping("/delByPrimaryKey")
    public Result deleteByPrimaryKey(String tableCode, String id, String primaryKeyCode) {
        if (StringUtils.isEmpty(primaryKeyCode)){
            throw new ParameterNullException("参数错误");
        }
        if (StringUilt.stringIsNullOrEmpty(tableCode) ||
                StringUilt.stringIsNullOrEmpty(id)) {
            throw new ParameterNullException("参数不能为空");
        }

        SqlVo sql=SqlVo.getInstance("delete from "+tableCode+" where " + primaryKeyCode + " = '"+id+"'");
        mapper.delete(sql);

        return Result.success();
    }

    private void CheckInput(String tableCode, String json) {
        if (StringUilt.stringIsNullOrEmpty(tableCode)) {
            throw new ParameterNullException("表名不能为空！");
        }
        if (StringUilt.stringIsNullOrEmpty(json)) {
            throw new ParameterNullException("数据不能为空！");
        }
    }
}
