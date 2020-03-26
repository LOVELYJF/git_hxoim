package com.hxoim.support.inforesource.mapper;

import com.hxoim.support.inforesource.entity.DataTableCol;
import com.hxoim.support.inforesource.entity.DataTableColExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DataTableColMapper {
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
     * @description:在数据库表中创建新的字段
     * @author:杨波
     * @date:2019-07-18
     *  * @param DataTableCol record
     * @return:
     **/
    void insertColumn(DataTableCol record);
    /**
     * @description:在数据库表中修改该字段
     * @author:杨波
     * @date:2019-07-18
     *  * @param DataTableCol record
     * @return:
     **/
    void updateColumn(DataTableCol record);
    /**
     * @description:从数据库表中删除该字段
     * @author:杨波
     * @date:2019-07-18
     *  * @param DataTableCol record
     * @return:
     **/
    void dropColumn(DataTableCol record);
    /**
     * @description:检查数据库中是否存在该字段
     * @author:杨波
     * @date:2019-07-18
     *  * @param DataTableCol record
     * @return:
     **/
    int selectColumnName(DataTableCol record) ;
    /**
     * @description:修改字段序号
     * @author:杨波
     * @date:2019-07-18
     *  * @param DataTableCol record
     * @return:
     **/
    void sortInformations(DataTableCol record);

    /**
     * @description:获取字段最大序号
     * @author:杨波
     * @date:2019-07-18
     *  * @param DataTableCol record
     * @return:
     **/
    Integer selectMaxOrderindex(DataTableCol record);

    /**
     * 查询字段数组信息集
     * @param ids
     * @return
     * @author:zb
     * @date:2019-07-25
     */
    List<DataTableCol> selectDataTableColByIds(@Param("ids") String ids[]);

    /**
     * @desc: 通过表code与字段code查询字段
     * @author: lijing
     * @date: 2019/8/6
     */
    DataTableCol selectDataByCodeAndTabCode(Map<String, String> params);

    /**
    * @description:返回指定表的所有字段
    * @author:杨波
    * @date:2019-09-04
    *  * @param null
    * @return:
    **/
    List<DataTableCol> selectByTabCode(String tabCode);
}