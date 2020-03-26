package com.hxoim.person.markedcadre.service;
/*
 * @description:我的名单
 * @author 杨波
 * @date:2019-07-03
 */

import com.github.pagehelper.PageInfo;
import com.hxoim.common.tree.Tree;
import com.hxoim.person.markedcadre.entity.McA01;
import com.hxoim.person.markedcadre.entity.McMarkedcadre;
import com.hxoim.support.leaderInfo.entity.A01;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface McMarkedCadreService {
    /**
    * @description:通过主键删除名单
    * @author:杨波
    * @date:2019-07-03
    *  * @param id
    * @return:
    **/
    int deleteByPrimaryKey(String id);

    /**
    * @description:插入名单
    * @author:杨波
    * @date:2019-07-03
    *  * @param record
    * @return:
    **/
    int insert(com.hxoim.person.markedcadre.entity.McMarkedcadre record);

    /**
    * @description:给名单的部分字段插入值
    * @author:杨波
    * @date:2019-07-03
    *  * @param record
    * @return:
    **/
    int insertSelective(com.hxoim.person.markedcadre.entity.McMarkedcadre record);

    /**
    * @description:查询名单
    * @author:杨波
    * @date:2019-07-03
    *  * @param example
    * @return:
    **/
    List<com.hxoim.person.markedcadre.entity.McMarkedcadre> selectByExample(com.hxoim.person.markedcadre.entity.McMarkedcadreExample example);

    /**
    * @description:通过主键获取名单
    * @author:杨波
    * @date:2019-07-03
    *  * @param id
    * @return:
    **/
    com.hxoim.person.markedcadre.entity.McMarkedcadre selectByPrimaryKey(String id);
    /**
    * @description:查询当前登录用户的名单，以网页树要求的格式返回
    * @author:杨波
    * @date:2019-07-05
    *  * @param null
    * @return:
    **/
    public List<Tree> selectTree();
    /**
    * @description:通过主键修改名单部分字段
    * @author:杨波
    * @date:2019-07-03
    *  * @param record
    * @return:
    **/
    int updateByPrimaryKeySelective(com.hxoim.person.markedcadre.entity.McMarkedcadre record);

    /**
    * @description:通过主键修改名单
    * @author:杨波
    * @date:2019-07-03
    *  * @param record
    * @return:
    **/
    int updateByPrimaryKey(com.hxoim.person.markedcadre.entity.McMarkedcadre record);
    /**
    * @description:获取指定名单分类下名单序号的最大值
    * @author:杨波
    * @date:2019-07-06
    *  * @param id 要获取下级名单最大序号的名单主键值
    * @return:
    **/
    int getMaxSequence(com.hxoim.person.markedcadre.entity.McMarkedcadre id);

    /**
     * description: 通过父级查询下级映射信息
     * create by: sundeng
     * createDate: 2019/8/19
     */
    List<McMarkedcadre> selectMcByPid(McMarkedcadre mcMarkedcadre);

    /**
     * description:同级排序
     * create by: sundeng
     * createDate: 2019/8/19
     */
    void sortBySequence(String ids);

    /**
     * description:根据id查询列表
     * create by: sundeng
     * createDate: 2019/8/19
     */
    Map<String,Object> selectInfoByNodeId(Integer pageNum, Integer pageSize,String id);

    /**
     * description:添加至名单
     * create by: sundeng
     * createDate: 2019/8/20
     */
    void insertToList(List<McA01> list);

    /**
     * description:从名单中删除
     * create by: sundeng
     * createDate: 2019/8/19
     */
    void deleteForList(String ids);

    /**
     * description:根据id查询人员详细信息
     * create by: sundeng
     * createDate: 2019/8/19
     */
    Map<String,Object> selectDetailedInfo(String id);

    /**
     * description:查询任免表内容
     * create by: sundeng
     * createDate: 2019/8/19
     */
    Map<String,Object> rmTableExportWord(Map<String, Object> paramMap, int tableNum) throws Exception;
}
