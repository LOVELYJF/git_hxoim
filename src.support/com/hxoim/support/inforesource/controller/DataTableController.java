package com.hxoim.support.inforesource.controller;

import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.common.utils.Result;
import com.hxoim.common.utils.StringUilt;
import com.hxoim.support.inforesource.entity.DataTable;
import com.hxoim.support.inforesource.entity.DataTableExample;
import com.hxoim.support.inforesource.service.DataTableService;
import com.hxoim.support.parameter.service.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/*
 * @description:信息资源表
 * @author 杨波
 * @date:2019-07-17
 */
@RestController
@RequestMapping("/DataTable")
public class DataTableController {
    @Autowired
    private DataTableService service = null;
    @Autowired
    private ParameterService parameterService=null;

    /**
     * @description:通过主键删除信息资源表
     * @author:杨波
     * @date:2019-07-17
     *  * @param String id
     * @return:
     **/
    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(DataTable dataTable) {

        service.deleteByPrimaryKey(dataTable.getId());
        return Result.success();
    }
    /**
     * @description:插入信息资源表
     * @author:杨波
     * @date:2019-07-17
     *  * @param DataTable record
     * @return:
     **/
    @RequestMapping("/insert")
    public Result insert(DataTable record) {
        service.insert(record);
        return Result.success();
    }
    /**
     * @description:插入信息资源表，部分字段可为空
     * @author:杨波
     * @date:2019-07-17
     *  * @param DataTable record
     * @return:
     **/
    @RequestMapping("/insertSelective")
    public Result insertSelective(DataTable record) {

        service.insertSelective(record);
        return Result.success();
    }
    /**
     * @description:查找信息资源表
     * @author:杨波
     * @date:2019-07-17
     *  * @param DataTableExample example
     * @return:
     **/
    @RequestMapping("/select")
    public Result selectByExample(String infoid,String tablecode) {

        DataTableExample example=new DataTableExample();
        DataTableExample.Criteria criteria = example.createCriteria();
        if(StringUilt.stringIsNullOrEmpty(infoid)==false)
        {
            criteria.andCatalogidEqualTo(infoid);
        }
        if(StringUilt.stringIsNullOrEmpty(tablecode)==false)
        {
            criteria.andTabCodeEqualTo(tablecode);
        }
        example.setOrderByClause("CatalogId asc,ORDER_INDEX asc");

        List<DataTable> dt= service.selectByExample(example);
        return Result.success(dt);
    }
    /**
     * @description:获取参数设置的系统内部资源的ID
     * @author:杨波
     * @date:2019-09-02
     *  * @param
     * @return:com.hxoim.common.utils.Result
     **/
    @RequestMapping("/selectSystemInfoTable")
    public Result selectSystemInfoTable(){

        String param=parameterService.selectPValueByCode("01");
        if(StringUilt.stringIsNullOrEmpty(param))
        {
            param="AAA5012A-9BFF-4054-BAD2-81EB3C58961B";
        }

        return selectByExample(param,"");
    }
    /**
     * @description:通过主键查找信息资源表
     * @author:杨波
     * @date:2019-07-17
     *  * @param DataTableExample example
     * @return:
     **/
    @RequestMapping("/selectByPrimaryKey")
    public Result selectByPrimaryKey(DataTable dataTable) {

        DataTable dt= service.selectByPrimaryKey(dataTable.getId());
        return Result.success(dt);
    }
    /**
     * @description:修改信息资源表，部分字段可为空
     * @author:杨波
     * @date:2019-07-17
     *  * @param DataTable record
     * @return:
     **/
    @RequestMapping("/updateByPrimaryKeySelective")
    public Result updateByPrimaryKeySelective(DataTable record) {

        service.updateByPrimaryKeySelective(record);
        return Result.success();
    }
    /**
     * @description:通过主键修改信息资源表
     * @author:杨波
     * @date:2019-07-17
     *  * @param DataTable record
     * @return:
     **/
    @RequestMapping("/updateByPrimaryKey")
    public Result updateByPrimaryKey(DataTable record) {
        service.updateByPrimaryKey(record);
        return Result.success();
    }
    /**
     * 方法实现说明   验证数据库表名是否存在
     * @author      张乾
     * @date        2019/5/24 8:58
     */
    @RequestMapping("/selectTableName")
    public Result selectTableName(DataTable record){
        DataTable dataTable = service.selectByTableCode(record.getTabCode());
        if(dataTable!=null)
        {
            throw new ParameterNullException("该表已经存在！");
        }
        return Result.success();
    }
    /**
     * @description:保存表的排序
     * @author:杨波
     * @date:2019-07-22
     *  * @param ids
     * @return:void
     **/
    @RequestMapping("/sortOrderIndex")
    public Result sortOrderIndex(String[] ids) {
        service.sortOrderIndex(ids);
        return Result.success();
    }
    /**
     * @description:获取指定分类下数据库表序号的最大值
     * @author:杨波
     * @date:2019-07-19
     *  * @param id 要获取数据库表最大序号的分类主键值
     * @return:
     **/
    @RequestMapping("/maxseq")
    public Result getMaxSequence(DataTable record)
    {

        return Result.success(service.getMaxSequence(record));
    }

    /**
     * 查询表列表
     * @return
     * @author:zb
     * @date:2019-07-25
     */
    @RequestMapping("/selectDataTable")
    public Result selectDataTable(){
        List<DataTable> list = service.selectDataTable();
        return Result.success(list);
    }

    /**
     * 查询侧边列表
     * @return
     * @author:孙登
     * @date:2019-08-05
     */
    @RequestMapping("/selectTableTree")
    public Result selectTableTree(){
        List list = service.selectTableTree();
        return Result.success(list);
    }

    /**
     * 根据id查询表名
     * @return
     * @author:孙登
     * @date:2019-08-06
     */
    @RequestMapping("/selectById")
    public Result selectById(String id){
        List<Map<String, Object>> list = service.selectById(id);
        return Result.success(list);
    }
    /**
     * @desc: 查询表信息，因为前端按照孙登的方式获取数据绘制页面，没时间改，先沿用，后续再优化
     * @author: 杨波
     * @date: 2019/8/1
     */
    @RequestMapping("/selectMap")
    public Result selectTableInfo(String tablecode){
        List<Map<String,Object>> r= service.selectTableInfo(tablecode);
        return Result.success(r);
    }

    /**
     * @desc: 查询表列名，因为前端按照孙登的方式获取数据绘制页面，没时间改，先沿用，后续再优化
     * @author: 杨波
     * @date: 2019/8/1
     */
    @RequestMapping("/selectColMap")
    public Result selectTableCol(String tablecode){
        List<Map<String,Object>> r= service.selectTableCol(tablecode);
        return Result.success(r);
    }
}
