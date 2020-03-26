package com.hxoim.work.workinfo.controller;

import com.hxoim.common.utils.Result;
import com.hxoim.work.workinfo.entity.WorkInfo;
import com.hxoim.work.workinfo.service.WorkInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 工作安排-我的工作
 * @author gaozhenyuan
 * @date 2019/12/25 14:22
 */
@RestController
@RequestMapping("/workInfo")
public class WorkInfoController {

    @Resource
    private WorkInfoService workInfoService;

    /**
     * 新增
     * @author gaozhenyuan
     * @date 2019/12/25 14:23
     */
    @RequestMapping("/insertWorkInfo")
    public Result insertWorkInfo(WorkInfo workInfo) {
        String id= "";
        id=workInfoService.insertWorkInfo(workInfo);
        return Result.success(id);
    }

    /**
     * 根据主键删除
     * @author gaozhenyuan
     * @date 2019/12/25 14:23
     */
    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(String id) {
        workInfoService.deleteByPrimaryKey(id);
        return Result.success();
    }

    /**
     * 修改我的工作
     * @author gaozhenyuan
     * @date 2019/12/25 14:23
     */
    @RequestMapping("/updateWorkInfo")
    public Result updateWorkInfo(WorkInfo workInfo){
        workInfoService.updateWorkInfo(workInfo);
        return Result.success();
    }

    /**
     * 修改我的工作
     * @author gaozhenyuan
     * @date 2019/12/25 14:23
     */
    @RequestMapping("/updateByPrimaryKeySelective")
    public Result updateByPrimaryKeySelective(WorkInfo workInfo){
        workInfoService.updateByPrimaryKeySelective(workInfo);
        return Result.success();
    }

    /**
     * 根据列表
     * @author gaozhenyuan
     * @date 2019/12/25 14:23
     */
    @RequestMapping("/selectWorkInfoList")
    public Result selectWorkInfoList(Integer pageNum, Integer pageSize,String workTitle,String startTime,String status) {
        Map<String,Object> map = workInfoService.selectWorkInfoList(pageNum, pageSize,workTitle,startTime,status);
        return Result.success(map);
    }

    /**
     * 查询我的工作详情
     * @author gaozhenyuan
     * @date 2019/12/25 14:23
     */
    @RequestMapping("/selectWorkInfoById")
    public Result selectWorkInfoById(String id) {
        WorkInfo workInfo = workInfoService.selectWorkInfoById(id);
        return Result.success(workInfo);
    }

}
