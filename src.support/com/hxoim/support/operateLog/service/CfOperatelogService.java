package com.hxoim.support.operateLog.service;
/*
 * @description:
 * @author 杨波
 * @date:2019-08-02
 */

import com.github.pagehelper.PageInfo;
import com.hxoim.support.operateLog.entity.CfOperatelog;
import com.hxoim.support.operateLog.entity.CfOperatelogExample;
import com.hxoim.support.operateLog.entity.CfOperatelogExtend;

import java.text.ParseException;
import java.util.List;

public interface CfOperatelogService {
    /**
     * @description: 按主键删除日志
     * @author:杨波
     * @date:2019-08-02
     *  * @param String id
     * @return:
     **/
    int deleteByPrimaryKey(String id);

    /**
     * @description:插入操作日志
     * @author:杨波
     * @date:2019-08-02
     *  * @param CfOperatelog record
     * @return:
     **/
    int insert(CfOperatelog record);

    /**
     * @description:插入操作日志
     * @author:杨波
     * @date:2019-08-02
     *  * @param CfOperatelog record
     * @return:
     **/
    int insertSelective(CfOperatelog record);

    /**
     * @description:通用查询
     * @author:杨波
     * @date:2019-08-02
     *  * @param null
     * @return:
     **/
    List<CfOperatelog> selectByExample(CfOperatelogExample example);
    /**
     * @description:通用查询,会按模块、操作员、操作日期、IP查询、操作方式组合查询
     * @author:杨波
     * @date:2019-08-02
     * * @param null
     * @return:
     **/
    PageInfo<CfOperatelog> selectByExample(CfOperatelogExtend record) throws ParseException;
    /**
     * @description:按主键查询
     * @author:杨波
     * @date:2019-08-02
     *  * @param String id
     * @return:
     **/
    CfOperatelog selectByPrimaryKey(String id);

    /**
     * @description:修改日志
     * @author:杨波
     * @date:2019-08-02
     *  * @param CfOperatelog record
     * @return:
     **/
    int updateByPrimaryKeySelective(CfOperatelog record);

    /**
     * @description:修改日志
     * @author:杨波
     * @date:2019-08-02
     *  * @param CfOperatelog record
     * @return:
     **/
    int updateByPrimaryKey(CfOperatelog record);
}
