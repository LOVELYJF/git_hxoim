package com.hxoim.support.ETLDataException.controller;

import com.hxoim.common.utils.Result;
import com.hxoim.support.ETLDataException.entity.Wrongrecord;
import com.hxoim.support.ETLDataException.entity.WrongrecordExample;
import com.hxoim.support.ETLDataException.service.WrongrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 * @description:ETL数据异常日志
 * @author 杨波
 * @date:2019-07-17
 */
@RestController
@RequestMapping("/wrongrecord")
public class WrongrecordController {
    @Autowired
    private WrongrecordService service=null;
    /**
     * @description:通过主键删除日志
     * @author:杨波
     * @date:2019-07-17
     *  * @param id
     * @return:
     **/
    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(Integer id)
    {
        service.deleteByPrimaryKey(id);
        return Result.success();
    }
    /**
     * @description:插入数据异常日志
     * @author:杨波
     * @date:2019-07-17
     *  * @param record
     * @return:
     **/

    public Result insert(Wrongrecord record){
        int r = service.insert(record);
        return Result.success(r);
    }
    /**
     * @description:插入数据异常日志，部分字段可为空
     * @author:杨波
     * @date:2019-07-17
     *  * @param null
     * @return:
     **/

    public Result insertSelective(Wrongrecord record){
        int r = service.insertSelective(record);
        return Result.success(r);
    }
    /**
     * @description:获取数据异常日志，带长文本字段
     * @author:杨波
     * @date:2019-07-17
     *  * @param WrongrecordExample
     * @return:
     **/

    public Result selectByExampleWithBLOBs(WrongrecordExample example){
        List<Wrongrecord> wr = service.selectByExampleWithBLOBs(example);
        return Result.success(wr);
    }
    /**
     * @description:获取数据异常日志，无长文本字段
     * @author:杨波
     * @date:2019-07-17
     *  * @param WrongrecordExample
     * @return:
     **/

    public Result selectByExample(WrongrecordExample example){
        List<Wrongrecord> wr = service.selectByExample(example);
        return Result.success(wr);
    }
    /**
     * @description:获取指定ID的数据异常日志
     * @author:杨波
     * @date:2019-07-17
     *  * @param id
     * @return:
     **/

    public Result selectByPrimaryKey(Integer id){
        Wrongrecord wr = service.selectByPrimaryKey(id);
        return Result.success(wr);
    }
    /**
     * @description:修改数据异常日志,无长文本字段
     * @author:杨波
     * @date:2019-07-17
     *  * @param null
     * @return:
     **/

    public Result updateByPrimaryKeySelective(Wrongrecord record){
        service.updateByPrimaryKeySelective(record);
        return Result.success();
    }
    /**
     * @description:修改数据异常日志,带长文本字段
     * @author:杨波
     * @date:2019-07-17
     *  * @param null
     * @return:
     **/

    public Result updateByPrimaryKeyWithBLOBs(Wrongrecord record){
        service.updateByPrimaryKeyWithBLOBs(record);
        return Result.success();
    }
    /**
     * @description:通过主键修改数据异常日志
     * @author:杨波
     * @date:2019-07-17
     *  * @param null
     * @return:
     **/
    @RequestMapping("/updateByPrimaryKey")
    public Result updateByPrimaryKey(Wrongrecord record){
        service.updateByPrimaryKey(record);
        return Result.success();
    }
}
