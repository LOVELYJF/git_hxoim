package com.hxoim.kettle.jobscheduler.service.impl;
/*
 * @description:定时作业
 * @author 杨波
 * @date:2019-07-28
 */

import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.common.utils.StringUilt;
import com.hxoim.common.utils.UUIDGenerator;
import com.hxoim.kettle.jobandtrans.service.impl.JobServiceImpl;
import com.hxoim.kettle.jobscheduler.entity.KJobscheduler;
import com.hxoim.kettle.jobscheduler.entity.KJobschedulerExample;
import com.hxoim.kettle.jobscheduler.mapper.KJobschedulerMapper;
import com.hxoim.kettle.jobscheduler.service.KJobschedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class KJobschedulerServiceImpl implements KJobschedulerService {
    @Autowired
    private KJobschedulerMapper mapper;

    /**
     * @description:通过主键删除定时作业
     * @author:杨波
     * @date:2019-07-28 * @param String id 主键
     * @return:
     **/
    @Override
    public int deleteByPrimaryKey(String id) {
        if (StringUilt.stringIsNullOrEmpty(id)) {
            throw new ParameterNullException("参数不能为空！");
        }
        KJobscheduler jobscheduler=mapper.selectByPrimaryKey(id);
        if(jobscheduler==null)
        {
            throw new ParameterNullException("该定时计划已经被删除");
        }

        JobServiceImpl.Instance().RemoveJob(jobscheduler);
        return mapper.deleteByPrimaryKey(id);
    }

    /**
     * @description:检定必输项及重复验证
     * @author:杨波
     * @date:2019-07-28 * @param record
     * @return:void
     **/
    private void CheckInput(KJobscheduler record) {
        if (record == null) {
            throw new ParameterNullException("参数不能为空！");
        }
        if (record.getJobid() <= 0) {
            throw new ParameterNullException("作业主键不能小于等于0！");
        }
        if (StringUilt.stringIsNullOrEmpty(record.getJobname())) {
            throw new ParameterNullException("作业名称不能为空！");
        }
        if (StringUilt.stringIsNullOrEmpty(record.getSeconds()) &&
                StringUilt.stringIsNullOrEmpty(record.getMinutes()) &&
                StringUilt.stringIsNullOrEmpty(record.getHours())) {
            throw new ParameterNullException("时分秒不能同时为空！");
        }

        int count = mapper.doubleScheduler(record);
        if (count > 0) {
            throw new ParameterNullException("此作业已经有定时计划，不能再设置新的！");
        }
    }

    /**
     * @description:插入新的定时作业
     * @author:杨波
     * @date:2019-07-28 * @param KJobscheduler record 定时作业
     * @return:
     **/
    @Override
    public int insert(KJobscheduler record) {
        record.setId(UUIDGenerator.getPrimaryKey());
        CheckInput(record);
        int r = mapper.insert(record);
        JobServiceImpl.Instance().InsertJob(record);
        return r;
    }

    /**
     * @description:插入新的定时作业
     * @author:杨波
     * @date:2019-07-28 * @param KJobscheduler record 定时作业
     * @return:
     **/
    @Override
    public int insertSelective(KJobscheduler record) {
        record.setId(UUIDGenerator.getPrimaryKey());
        CheckInput(record);
        int r = mapper.insertSelective(record);
        JobServiceImpl.Instance().InsertJob(record);
        return r;
    }

    /**
     * @description:通过通用查询条件查询
     * @author:杨波
     * @date:2019-07-28 * @param KJobschedulerExample example 通用查询条件
     * @return:
     **/
    @Override
    public List<KJobscheduler> selectByExample(KJobschedulerExample example) {
        return mapper.selectByExample(example);
    }

    /**
     * @description:通过主键获取定时作业
     * @author:杨波
     * @date:2019-07-28 * @param String id 主键
     * @return:
     **/
    @Override
    public KJobscheduler selectByPrimaryKey(String id) {
        return mapper.selectByPrimaryKey(id);
    }

    /**
     * @description:修改定时作业
     * @author:杨波
     * @date:2019-07-28 * @param KJobscheduler record 定时作业
     * @return:
     **/
    @Override
    public int updateByPrimaryKeySelective(KJobscheduler record) {
        CheckInput(record);
        int r = mapper.updateByPrimaryKeySelective(record);
        JobServiceImpl.Instance().UpdateJob(record);
        return r;
    }

    /**
     * @description:修改定时作业
     * @author:杨波
     * @date:2019-07-28 * @param KJobscheduler record 定时作业
     * @return:
     **/
    @Override
    public int updateByPrimaryKey(KJobscheduler record) {
        CheckInput(record);
        int r = mapper.updateByPrimaryKey(record);
        JobServiceImpl.Instance().UpdateJob(record);
        return r;
    }

    /**
     * @description:同一个作业只能有一个定时计划
     * @author:杨波
     * @date:2019-07-28 * @param KJobscheduler record 定时作业
     * @return:
     **/
    @Override
    public int doubleScheduler(KJobscheduler record) {
        return mapper.doubleScheduler(record);
    }

    @Override
    public List<KJobscheduler> selectSchedulerList(String dirID, String name) {
        //参数
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("idDirectory", dirID);
        List<KJobscheduler> jobschedulers = mapper.selectSchedulerList(params);
        return jobschedulers;
    }
}
