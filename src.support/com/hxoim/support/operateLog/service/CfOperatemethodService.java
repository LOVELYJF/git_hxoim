package com.hxoim.support.operateLog.service;
/*
 * @description:操作方式维护
 * @author 杨波
 * @date:2019-08-09
 */

import com.hxoim.support.operateLog.entity.CfOperatemethod;
import com.hxoim.support.operateLog.entity.CfOperatemethodExample;

import java.util.List;

public interface CfOperatemethodService {
    /**
    * @description:按主键删除操作方式
    * @author:杨波
    * @date:2019-08-09
    *  * @param String id
    * @return:
    **/
    int deleteByPrimaryKey(String id);
    /**
    * @description:插入操作方式
    * @author:杨波
    * @date:2019-08-09
    *  * @param CfOperatemethod record
    * @return:
    **/

    int insert(CfOperatemethod record);
    /**
     * @description:插入操作方式
     * @author:杨波
     * @date:2019-08-09
     *  * @param CfOperatemethod record
     * @return:
     **/
    int insertSelective(CfOperatemethod record);
    /**
     * @description:查询操作方式
     * @author:杨波
     * @date:2019-08-09
     *  * @param CfOperatemethodExample example
     * @return:
     **/
    List<CfOperatemethod> selectByExample(CfOperatemethodExample example);
    /**
     * @description:查询操作方式,根据编号或名字查询
     * @author:杨波
     * @date:2019-08-09 * @param CfOperatemethodExample example
     * @return:
     **/
    List<CfOperatemethod> selectByExample(CfOperatemethod record);
    /**
     * @description:按主键查询操作方式
     * @author:杨波
     * @date:2019-08-09
     *  * @param String id
     * @return:
     **/
    CfOperatemethod selectByPrimaryKey(String id);
    /**
     * @description:更新操作方式
     * @author:杨波
     * @date:2019-08-09
     *  * @param CfOperatemethod record
     * @return:
     **/
    int updateByPrimaryKeySelective(CfOperatemethod record);
    /**
     * @description:更新操作方式
     * @author:杨波
     * @date:2019-08-09
     *  * @param CfOperatemethod record
     * @return:
     **/
    int updateByPrimaryKey(CfOperatemethod record);
}
