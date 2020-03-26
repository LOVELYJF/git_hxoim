package com.hxoim.support.inforesource.controller;

import com.hxoim.common.utils.Result;
import com.hxoim.common.utils.StringUilt;
import com.hxoim.support.inforesource.entity.DataTableCol;
import com.hxoim.support.inforesource.entity.DataTableColExample;
import com.hxoim.support.inforesource.service.DataTableColService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/*
 * @description:信息资源项
 * @author 杨波
 * @date:2019-07-17
 */
@RestController
@RequestMapping("/DataTableCol")
public class DataTableColController {
    @Autowired
    private DataTableColService service=null;
    /**
     * @description:通过主键删除信息资源项
     * @author:杨波
     * @date:2019-07-17
     *  * @param String id
     * @return:
     **/
    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(String id) {
        service.deleteByPrimaryKey(id);
        return Result.success();
    }
    /**
     * @description:通过表名删除所有字段，删除表时使用
     * @author:杨波
     * @date:2019-07-22
     *  * @param String tabCode 表名
     * @return:
     **/
    @RequestMapping("/deleteByTabCode")
    public int deleteByTabCode(String tabCode){
        return service.deleteByTabCode(tabCode);
    }
    /**
     * @description:清加信息资源项
     * @author:杨波
     * @date:2019-07-17
     *  * @param DataTableCol record
     * @return:
     **/
    @RequestMapping("/insert")
    public Result insert(DataTableCol record) {
        service.insert(record);
        return Result.success();
    }
    /**
     * @description:添加信息资源项，部分字段可为空
     * @author:杨波
     * @date:2019-07-17
     *  * @param DataTableCol record
     * @return:
     **/
    @RequestMapping("/insertSelective")
    public Result insertSelective(DataTableCol record) {
        service.insertSelective(record);
        return Result.success();
    }
    /**
     * @description:按自定义条件查询信息资源项
     * @author:杨波
     * @date:2019-07-17
     *  * @param DataTableColExample example
     * @return:
     **/
    @RequestMapping("/select")
    public Result selectByExample(String tableCode,String colCode) {
        DataTableColExample example=new DataTableColExample();
        DataTableColExample.Criteria criteria=example.createCriteria();
        if(StringUilt.stringIsNullOrEmpty(tableCode)==false)
        {
            criteria.andTabCodeEqualTo(tableCode);
        }
        if(StringUilt.stringIsNullOrEmpty(colCode)==false)
        {
            criteria.andColCodeEqualTo(colCode);
        }
        example.setOrderByClause("ORDER_INDEX asc");
        List<DataTableCol> dtc = service.selectByExample(example);
        return Result.success(dtc);
    }
    /**
     * @description:通过主键查找信息资源项
     * @author:杨波
     * @date:2019-07-17
     *  * @param String id
     * @return:
     **/
    @RequestMapping("/selectByPrimaryKey")
    public Result selectByPrimaryKey(String id) {
        DataTableCol dtc = service.selectByPrimaryKey(id);
        return Result.success(dtc);
    }
    /**
     * @description:修改信息资源项，部分字段可为空
     * @author:杨波
     * @date:2019-07-17
     *  * @param DataTableCol record
     * @return:
     **/
    @RequestMapping("/updateByPrimaryKeySelective")
    public Result updateByPrimaryKeySelective(DataTableCol record) {
        service.updateByPrimaryKeySelective(record);
        return Result.success();
    }
    /**
     * @description:修改信息资源项
     * @author:杨波
     * @date:2019-07-17
     *  * @param DataTableCol record
     * @return:
     **/
    @RequestMapping("/updateByPrimaryKey")
    public Result updateByPrimaryKey(DataTableCol record) {
        service.updateByPrimaryKey(record);
        return Result.success();
    }
    /**
     * @ description: 排序
     * @ create by: 杨波
     * @ createDate: 2019-07-18
     */
    @RequestMapping("/sortCols")
    public Result sortCols(String[] ids){
        service.sortCols(ids);
        return Result.success();
    }

    /**
     *
     * @param tabCodes
     * @return
     * @author:zb
     * @date:2019-07-25
     */
    @RequestMapping("/selectDataTableColByTabCode")
    public Result selectDataTableColByTabCode(String tabCodes[]){
        if(tabCodes.length<1){
            return Result.error("参数异常");
        }
        List<String> strList = Arrays.asList(tabCodes);
        DataTableColExample example=new DataTableColExample();
        DataTableColExample.Criteria criteria=example.createCriteria();
        criteria.andTabCodeIn(strList);
        example.setOrderByClause("TAB_CODE asc,ORDER_INDEX asc");
        List<DataTableCol> list = service.selectByExample(example);
        return Result.success(list);
    }
}
