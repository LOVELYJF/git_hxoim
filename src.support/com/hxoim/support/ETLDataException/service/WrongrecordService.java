package com.hxoim.support.ETLDataException.service;
/*
 * @description:ETL数据异常日志
 * @author 杨波
 * @date:2019-07-17
 */

import com.hxoim.support.ETLDataException.entity.Wrongrecord;
import com.hxoim.support.ETLDataException.entity.WrongrecordExample;

import java.util.List;

public interface WrongrecordService {
    /**
    * @description:通过主键删除日志
    * @author:杨波
    * @date:2019-07-17
    *  * @param id
    * @return:
    **/
    int deleteByPrimaryKey(Integer id);
    /**
    * @description:插入数据异常日志
    * @author:杨波
    * @date:2019-07-17
    *  * @param record
    * @return:
    **/

    int insert(Wrongrecord record);
    /**
    * @description:插入数据异常日志，部分字段可为空
    * @author:杨波
    * @date:2019-07-17
    *  * @param null
    * @return:
    **/

    int insertSelective(Wrongrecord record);
    /**
    * @description:获取数据异常日志，带长文本字段
    * @author:杨波
    * @date:2019-07-17
    *  * @param WrongrecordExample
    * @return:
    **/

    List<Wrongrecord> selectByExampleWithBLOBs(WrongrecordExample example);
    /**
    * @description:获取数据异常日志，无长文本字段
    * @author:杨波
    * @date:2019-07-17
    *  * @param WrongrecordExample
    * @return:
    **/

    List<Wrongrecord> selectByExample(WrongrecordExample example);
    /**
    * @description:获取指定ID的数据异常日志
    * @author:杨波
    * @date:2019-07-17
    *  * @param id
    * @return:
    **/

    Wrongrecord selectByPrimaryKey(Integer id);
    /**
    * @description:修改数据异常日志,无长文本字段
    * @author:杨波
    * @date:2019-07-17
    *  * @param null
    * @return:
    **/

    int updateByPrimaryKeySelective(Wrongrecord record);
    /**
    * @description:修改数据异常日志,带长文本字段
    * @author:杨波
    * @date:2019-07-17
    *  * @param null
    * @return:
    **/

    int updateByPrimaryKeyWithBLOBs(Wrongrecord record);
    /**
    * @description:通过主键修改数据异常日志
    * @author:杨波
    * @date:2019-07-17
    *  * @param null
    * @return:
    **/

    int updateByPrimaryKey(Wrongrecord record);
}
