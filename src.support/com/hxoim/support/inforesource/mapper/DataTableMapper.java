package com.hxoim.support.inforesource.mapper;

import com.hxoim.common.tree.Tree;
import com.hxoim.support.inforesource.entity.DataTable;
import com.hxoim.support.inforesource.entity.DataTableExample;
import com.hxoim.support.leadertype.entity.LeaderTypeInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DataTableMapper {
    int deleteByPrimaryKey(String id);

    int insert(DataTable record);

    int insertSelective(DataTable record);

    List<DataTable> selectByExample(DataTableExample example);

    DataTable selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DataTable record);

    int updateByPrimaryKey(DataTable record);

    /**
    * @description:在数据库中创建该表
    * @author:杨波
    * @date:2019-07-18
    *  * @param DataTable record
    * @return:
    **/
    void createTable(DataTable record);

    /**
    * @description:从数据库中删除该表
    * @author:杨波
    * @date:2019-07-18
    *  * @param DataTable record
    * @return:
    **/
    void deleteTable(DataTable record);

    /**
    * @description:在数据库中查找该表
    * @author:杨波
    * @date:2019-07-18
    *  * @param DataTable record
    * @return:
    **/
    int selectTableName(DataTable record);
    /**
     * @description:保存表的排序
     * @author:杨波
     * @date:2019-07-22
     *  * @param ids
     * @return:void
     **/
    void sortOrderIndex(DataTable record);
    /**
     * @description:获取指定分类下数据库表序号的最大值
     * @author:杨波
     * @date:2019-07-19
     *  * @param id 要获取数据库表最大序号的分类主键值
     * @return:
     **/
    int getMaxSequence(DataTable record);

    /**
     *  查询数据列表
     * @return
     * @author:zb
     * @date:2019-07-25
     */
    List<DataTable> selectDataTable();

    /**
     * 查询侧边列表
     * @return
     * @author:孙登
     * @date:2019-08-05
     */
    List<Map<String, String>> selectTableTree();

    /**
     * 查询表列表
     * @return
     * @author:孙登
     * @date:2019-08-05
     */
    List<Map<String, String>> selectByCatalogId();

    /**
     * 根据id查询表名
     * @return
     * @author:孙登
     * @date:2019-08-06
     */
    List<Map<String,Object>> selectById(String id);

    /**
     * @desc: 通过code查询表
     * @author: lijing
     * @date: 2019/8/7
     */
    DataTable selectByCode(String tabCode);

    List<Tree> selectDataTableTree(String resourceCode);

    /**
     * 根据机构id和干部类别id获取信息集
     * 
     * @author sunqian
     * @date 2019/8/21 16:41
     */
    List<DataTable> selectGrantLeaderTypeInfo(@Param("orgId")String orgId, @Param("leaderTypeId")String leaderTypeId);

    /**
     * 根据用户id和干部类别查询信息集权限
     * 
     * @author sunqian
     * @date 2019/8/21 16:57
     */
    List<DataTable> selectUserGrantLeaderTypeInfo(@Param("userId") String userId, @Param("leaderTypeId") String leaderTypeId);
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

    /**
     * 根据resourceCode获取表信息集合
     * 
     * @author sunqian
     * @date 2019/8/27 14:57
     */
    List<DataTable> selectDataTableByResourceCode(String personInfo);
}