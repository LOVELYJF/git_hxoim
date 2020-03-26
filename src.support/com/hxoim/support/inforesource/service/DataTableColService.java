package com.hxoim.support.inforesource.service;
/*
 * @description:信息资源项
 * @author 杨波
 * @date:2019-07-17
 */

import com.hxoim.support.inforesource.entity.DataTableCol;
import com.hxoim.support.inforesource.entity.DataTableColExample;

import java.util.List;

public interface DataTableColService {
    /**
     * @description:通过主键删除信息资源项
     * @author:杨波
     * @date:2019-07-17
     *  * @param String id
     * @return:
     **/
    int deleteByPrimaryKey(String id);
    /**
     * @description:通过表名删除所有字段，删除表时使用
     * @author:杨波
     * @date:2019-07-22
     *  * @param String tabCode 表名
     * @return:
     **/
    int deleteByTabCode(String tabCode);
    /**
     * @description:清加信息资源项
     * @author:杨波
     * @date:2019-07-17
     *  * @param DataTableCol record
     * @return:
     **/

    int insert(DataTableCol record);

    /**
     * @description:添加信息资源项，部分字段可为空
     * @author:杨波
     * @date:2019-07-17
     *  * @param DataTableCol record
     * @return:
     **/
    int insertSelective(DataTableCol record);

    /**
     * @description:按自定义条件查询信息资源项
     * @author:杨波
     * @date:2019-07-17
     *  * @param DataTableColExample example
     * @return:
     **/
    List<DataTableCol> selectByExample(DataTableColExample example);
    /**
     * @description:返回指定表的所有字段
     * @author:杨波
     * @date:2019-09-04
     *  * @param tableCode
     * @return:java.util.List<com.hxoim.support.inforesource.entity.DataTableCol>
     **/
    List<DataTableCol> selectByTabCode(String tableCode);
    /**
     * @description:通过主键查找信息资源项
     * @author:杨波
     * @date:2019-07-17
     *  * @param String id
     * @return:
     **/
    DataTableCol selectByPrimaryKey(String id);

    /**
     * @description:修改信息资源项，部分字段可为空
     * @author:杨波
     * @date:2019-07-17
     *  * @param DataTableCol record
     * @return:
     **/
    int updateByPrimaryKeySelective(DataTableCol record);
    /**
     * @description:修改信息资源项
     * @author:杨波
     * @date:2019-07-17
     *  * @param DataTableCol record
     * @return:
     **/
    int updateByPrimaryKey(DataTableCol record);

    /**
    * @description:对字段排序
    * @author:杨波
    * @date:2019-07-18
    *  * @param String[] ids
    * @return:
    **/
    void sortCols(String[] ids);
}
