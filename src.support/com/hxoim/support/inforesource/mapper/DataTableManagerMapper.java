package com.hxoim.support.inforesource.mapper;

import com.hxoim.support.inforesource.entity.DataTableManager;
import com.hxoim.support.inforesource.entity.DataTableManagerExample;
import java.util.List;

public interface DataTableManagerMapper {
    /**
     * @description:通过主键删除
     * @author:杨波
     * @date:2019-07-17
     *  * @param String id
     * @return:int
     **/
    int deleteByPrimaryKey(String id);
    /**
     * @description:插入信息资源管理者
     * @author:杨波
     * @date:2019-07-17
     *  * @param DataTable record
     * @return:
     **/
    int insert(DataTableManager record);
    /**
     * @description:查找信息资源管理者
     * @author:杨波
     * @date:2019-07-17
     *  * @param DataTableExample example
     * @return:
     **/
    List<DataTableManager> selectByExample(DataTableManagerExample example);
    /**
     * @description:通过主键查找信息资源管理者
     * @author:杨波
     * @date:2019-07-17
     *  * @param String id
     * @return:
     **/
    DataTableManager selectByPrimaryKey(String id);
    /**
     * @description:修改信息资源管理者
     * @author:杨波
     * @date:2019-07-17
     *  * @param DataTable record
     * @return:
     **/
    int updateByPrimaryKey(DataTableManager record);
}