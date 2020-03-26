package com.hxoim.kettle.jobscheduler.service;
/*
 * @description:定时作业
 * @author 杨波
 * @date:2019-07-28
 */

import com.hxoim.kettle.jobscheduler.entity.KJobscheduler;
import com.hxoim.kettle.jobscheduler.entity.KJobschedulerExample;

import java.util.List;

public interface KJobschedulerService {
    /**
     * @description:通过主键删除定时作业
     * @author:杨波
     * @date:2019-07-28
     *  * @param String id 主键
     * @return:
     **/
    int deleteByPrimaryKey(String id);

    /**
     * @description:插入新的定时作业
     * @author:杨波
     * @date:2019-07-28
     *  * @param KJobscheduler record 定时作业
     * @return:
     **/
    int insert(KJobscheduler record);

    /**
     * @description:插入新的定时作业
     * @author:杨波
     * @date:2019-07-28
     *  * @param KJobscheduler record 定时作业
     * @return:
     **/
    int insertSelective(KJobscheduler record);

    /**
     * @description:通过通用查询条件查询
     * @author:杨波
     * @date:2019-07-28
     *  * @param KJobschedulerExample example 通用查询条件
     * @return:
     **/
    List<KJobscheduler> selectByExample(KJobschedulerExample example);

    /**
     * @description:通过主键获取定时作业
     * @author:杨波
     * @date:2019-07-28
     *  * @param String id 主键
     * @return:
     **/
    KJobscheduler selectByPrimaryKey(String id);

    /**
     * @description:修改定时作业
     * @author:杨波
     * @date:2019-07-28
     *  * @param KJobscheduler record 定时作业
     * @return:
     **/
    int updateByPrimaryKeySelective(KJobscheduler record);
    /**
     * @description:修改定时作业
     * @author:杨波
     * @date:2019-07-28
     *  * @param KJobscheduler record 定时作业
     * @return:
     **/
    int updateByPrimaryKey(KJobscheduler record);

    /**
     * @description:同一个作业只能有一个定时计划
     * @author:杨波
     * @date:2019-07-28
     *  * @param KJobscheduler record 定时作业
     * @return:
     **/
    int doubleScheduler(KJobscheduler record);

    /**
     * @desc: 定时任务列表
     * @author: lijing
     * @param dirID 目录id
     * @param name 任务名字
     * @date: 2019/7/29
     */
    List<KJobscheduler> selectSchedulerList(String dirID, String name) ;
}
