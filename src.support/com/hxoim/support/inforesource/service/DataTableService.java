package com.hxoim.support.inforesource.service;
/*
 * @description:信息资源表
 * @author 杨波
 * @date:2019-07-17
 */

import com.hxoim.common.tree.Tree;
import com.hxoim.support.inforesource.entity.DataTable;
import com.hxoim.support.inforesource.entity.DataTableExample;

import java.util.List;
import java.util.Map;

public interface DataTableService {
    /**
     * @description:通过主键删除信息资源表
     * @author:杨波
     * @date:2019-07-17
     *  * @param String id
     * @return:
     **/
    int deleteByPrimaryKey(String id);

    /**
     * @description:插入信息资源表
     * @author:杨波
     * @date:2019-07-17
     *  * @param DataTable record
     * @return:
     **/
    int insert(DataTable record);

    /**
     * @description:插入信息资源表，部分字段可为空
     * @author:杨波
     * @date:2019-07-17
     *  * @param DataTable record
     * @return:
     **/
    int insertSelective(DataTable record);

    /**
     * @description:查找信息资源表
     * @author:杨波
     * @date:2019-07-17
     *  * @param DataTableExample example
     * @return:
     **/
    List<DataTable> selectByExample(DataTableExample example);

    /**
     * @description:通过主键查找信息资源表
     * @author:杨波
     * @date:2019-07-17
     *  * @param DataTableExample example
     * @return:
     **/
    DataTable selectByPrimaryKey(String id);
    /**
     * @description:通过表名查找信息资源表
     * @author:杨波
     * @date:2019-07-17
     *  * @param String tableCode
     * @return:
     **/
    DataTable selectByTableCode(String tableCode);
    /**
     * @description:修改信息资源表，部分字段可为空
     * @author:杨波
     * @date:2019-07-17
     *  * @param DataTable record
     * @return:
     **/
    int updateByPrimaryKeySelective(DataTable record);

    /**
     * @description:通过主键修改信息资源表
     * @author:杨波
     * @date:2019-07-17
     *  * @param DataTable record
     * @return:
     **/
    int updateByPrimaryKey(DataTable record);
    /**
     * @description:保存表的排序
     * @author:杨波
     * @date:2019-07-22
     *  * @param ids
     * @return:void
     **/
    void sortOrderIndex(String[] ids);
    /**
     * @description:获取指定分类下数据库表序号的最大值
     * @author:杨波
     * @date:2019-07-19
     *  * @param id 要获取数据库表最大序号的分类主键值
     * @return:
     **/
    int getMaxSequence(DataTable record);

    /**
     * 查询表
     * @return
     */
    public abstract List<DataTable> selectDataTable();

    /**
     * 查询侧边列表
     * @return
     */
    List selectTableTree();

    /**
     * 根据id查询表名
     * @return
     * @param id
     */
    List<Map<String,Object>> selectById(String id);

    /**
     * 查询元数据表的树
     *
     * @author sunqian
     * @date 2019/8/20 10:21
     * @return 树集合
     */
    List<Tree> selectDataTableTree();
    /**
     * @desc: 查询表信息，因为前端按照孙登的方式获取数据绘制页面，没时间改，先沿用，后续再优化
     * @author: 杨波
     * @date: 2019/8/1
     */
    List<Map<String,Object>> selectTableInfo(String tablecode);

    /**
     * @desc: 查询表列名，因为前端按照孙登的方式获取数据绘制页面，没时间改，先沿用，后续再优化
     * @author: 杨波
     * @date: 2019/8/1
     */
    List<Map<String,Object>> selectTableCol(String tablecode);
}
