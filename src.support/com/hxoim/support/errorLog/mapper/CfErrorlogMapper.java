package com.hxoim.support.errorLog.mapper;

import com.hxoim.support.errorLog.entity.CfErrorlog;
import com.hxoim.support.errorLog.entity.CfErrorlogExample;
import com.hxoim.support.errorLog.entity.CfErrorlogWithBLOBs;
import java.util.List;

public interface CfErrorlogMapper {
    /**
    * @description:按主键删除错误日志
    * @author:杨波
    * @date:2019-08-13
    *  * @param String id 错误日志主键
    * @return:
    **/
    int deleteByPrimaryKey(String id);

    /**
    * @description:保存错误日志，包含二进制字段
    * @author:杨波
    * @date:2019-08-13
    *  * @param CfErrorlogWithBLOBs record 要保存的错误日志
    * @return:
    **/
    int insert(CfErrorlogWithBLOBs record);
    /**
     * @description:保存错误日志，包含二进制字段
     * @author:杨波
     * @date:2019-08-13
     *  * @param CfErrorlogWithBLOBs record 要保存的错误日志
     * @return:
     **/
    int insertSelective(CfErrorlogWithBLOBs record);

    /**
    * @description:按自定义条件查询，同时返回二进制字段
    * @author:杨波
    * @date:2019-08-13
    *  * @param CfErrorlogExample example 自定义查询条件
    * @return:
    **/
    List<CfErrorlogWithBLOBs> selectByExampleWithBLOBs(CfErrorlogExample example);
    /**
     * @description:按自定义条件查询，不返回二进制字段
     * @author:杨波
     * @date:2019-08-13
     *  * @param CfErrorlogExample example 自定义查询条件
     * @return:
     **/
    List<CfErrorlog> selectByExample(CfErrorlogExample example);
    /**
     * @description:按主键查询错误日志
     * @author:杨波
     * @date:2019-08-13
     *  * @param String id 错误日志主键
     * @return:
     **/
    CfErrorlogWithBLOBs selectByPrimaryKey(String id);
    /**
     * @description:修改错误日志，包含二进制字段
     * @author:杨波
     * @date:2019-08-13
     *  * @param CfErrorlogWithBLOBs record 要保存的错误日志
     * @return:
     **/
    int updateByPrimaryKeySelective(CfErrorlogWithBLOBs record);
    /**
     * @description:修改错误日志，包含二进制字段
     * @author:杨波
     * @date:2019-08-13
     *  * @param CfErrorlogWithBLOBs record 要保存的错误日志
     * @return:
     **/
    int updateByPrimaryKeyWithBLOBs(CfErrorlogWithBLOBs record);
    /**
     * @description:修改错误日志，不更新二进制字段
     * @author:杨波
     * @date:2019-08-13
     *  * @param CfErrorlogWithBLOBs record 要保存的错误日志
     * @return:
     **/
    int updateByPrimaryKey(CfErrorlog record);
}