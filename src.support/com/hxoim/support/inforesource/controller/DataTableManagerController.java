package com.hxoim.support.inforesource.controller;

import com.hxoim.common.utils.Result;
import com.hxoim.common.utils.StringUilt;
import com.hxoim.common.utils.UUIDGenerator;
import com.hxoim.support.inforesource.entity.DataTableManager;
import com.hxoim.support.inforesource.entity.DataTableManagerExample;
import com.hxoim.support.inforesource.entity.DataTableManagerExtend;
import com.hxoim.support.inforesource.service.DataTableManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/*
 * @description:信息资源管理处室
 * @author 杨波
 * @date:2019-07-17
 */
@RestController
@RequestMapping("/DataTableManager")
public class DataTableManagerController {
    @Autowired
    private DataTableManagerService service = null;

    /**
     * @description:通过主键删除
     * @author:杨波
     * @date:2019-07-17 * @param String id
     * @return:int
     **/
    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(String id) {
        service.deleteByPrimaryKey(id);
        return Result.success();
    }

    /**
     * @description:插入信息资源表的使用系统
     * @author:杨波
     * @date:2019-07-17 * @param DataTable record
     * @return:
     **/
    @RequestMapping("/insert")
    public Result insert(DataTableManager record) {
        service.insert(record);
        return Result.success();
    }

    /**
     * @description:插入信息资源表的使用系统
     * @author:杨波
     * @date:2019-07-17 * @param DataTable record
     * @return:
     **/
    @RequestMapping("/batchinsert")
    public Result batchInsert(DataTableManagerExtend record) {
        if (record.getTableids()==null||record.getSysids()==null||
                record.getTableids().length == 0 || record.getSysids().length == 0)
            return Result.error("参数错误,表或者系统没有设置！");

        for (String tableId : record.getTableids()) {
            for (String userGroupId : record.getSysids()) {
                DataTableManager dataTableManager = new DataTableManager(UUIDGenerator.getPrimaryKey(),
                        tableId, userGroupId);

                try {
                    //该表的表和处室两个字段有唯一性索引，重复插入会报错，
                    // 通过这种方式保存每张表的使用系统唯一，
                    // 如果不唯一，请检查唯一性索引是否被删除了
                    service.insert(dataTableManager);
                } catch (Exception ep) {
                }
            }
        }
        return Result.success();
    }

    /**
     * @description:查找信息资源表的使用系统
     * @author:杨波
     * @date:2019-07-17 * @param DataTableExample example
     * @return:
     **/
    @RequestMapping("/select")
    public Result selectByExample(String tableid, String userGroupId) {
        DataTableManagerExample example = new DataTableManagerExample();
        DataTableManagerExample.Criteria criteria = example.createCriteria();
        if (StringUilt.stringIsNullOrEmpty(tableid) == false) {
            criteria.andTableidEqualTo(tableid);
        }
        if (StringUilt.stringIsNullOrEmpty(userGroupId) == false) {
            criteria.andSysidEqualTo(userGroupId);
        }
        example.setOrderByClause("tableid asc");
        List<DataTableManager> dt = service.selectByExample(example);
        return Result.success(dt);
    }

    /**
     * @description:查询一批表使用的系统
     * @author:杨波
     * @date:2019-07-20 * @param ids
     * @return:com.hxoim.common.utils.Result
     **/
    @RequestMapping("/selectByTableIds")
    public Result selectByTableIds(DataTableManagerExtend record) {
        if (record == null || record.getTableids().length == 0) {
            return Result.error("参数不能为空!");
        }

        List<String> idsList=new ArrayList<>();
        for(String id:record.getTableids())
        {
            idsList.add(id);
        }

        DataTableManagerExample example = new DataTableManagerExample();
        DataTableManagerExample.Criteria criteria = example.createCriteria();
        criteria.andTableidIn(idsList);
        example.setOrderByClause("tableid asc");

        List<DataTableManager> dt = service.selectByExample(example);
        return Result.success(dt);
    }

    /**
     * @description:通过主键查找信息资源表的使用系统
     * @author:杨波
     * @date:2019-07-17 * @param String id
     * @return:
     **/
    @RequestMapping("/selectByPrimaryKey")
    public Result selectByPrimaryKey(String id) {
        DataTableManager dt = service.selectByPrimaryKey(id);
        return Result.success(dt);
    }

    /**
     * @description:修改信息资源表的使用系统
     * @author:杨波
     * @date:2019-07-17 * @param DataTableManager record
     * @return:
     **/
    @RequestMapping("/updateByPrimaryKey")
    public Result updateByPrimaryKey(DataTableManager record) {
        service.updateByPrimaryKey(record);
        return Result.success();
    }
}
