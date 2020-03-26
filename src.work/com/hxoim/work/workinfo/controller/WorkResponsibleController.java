package com.hxoim.work.workinfo.controller;

import com.hxoim.common.utils.Result;
import com.hxoim.work.workinfo.entity.WorkInfo;
import com.hxoim.work.workinfo.entity.WorkProce;
import com.hxoim.work.workinfo.entity.WorkResponsible;
import com.hxoim.work.workinfo.service.WorkInfoService;
import com.hxoim.work.workinfo.service.WorkResponsibleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 工作安排-工作责任
 * @author gaozhenyuan
 * @date 2019/12/25 14:22
 */
@RestController
@RequestMapping("/workResponsible")
public class WorkResponsibleController {

    @Resource
    private WorkResponsibleService workResponsibleService;

    /**
     * 新增
     * @author gaozhenyuan
     * @date 2019/12/25 14:23
     */
    @RequestMapping("/insertWorkResponsible")
    public Result insertWorkResponsible(WorkResponsible workResponsible) {
        workResponsibleService.insertWorkResponsible(workResponsible);
        return Result.success();
    }

    /**
     * 根据主键删除
     * @author gaozhenyuan
     * @date 2019/12/25 14:23
     */
    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(String id) {
        workResponsibleService.deleteByPrimaryKey(id);
        return Result.success();
    }

    /**
     * 修改工作责任
     * @author gaozhenyuan
     * @date 2019/12/25 14:23
     */
    @RequestMapping("/updateWorkResponsible")
    public Result updateWorkResponsible(WorkResponsible workResponsible){
        workResponsibleService.updateWorkResponsible(workResponsible);
        return Result.success();
    }

    /**
     * 修改工作责任
     * @author gaozhenyuan
     * @date 2019/12/25 14:23
     */
    @RequestMapping("/updateByPrimaryKeySelective")
    public Result updateByPrimaryKeySelective(WorkResponsible workResponsible){
        workResponsibleService.updateByPrimaryKeySelective(workResponsible);
        return Result.success();
    }
    /**
    * @Author: jiayiwen
    * @Description:确认
    * @Date: 11:12 2020/1/15
     */
    @RequestMapping("/updateByStatusSelective")
    public Result updateByStatusSelective(WorkResponsible workResponsible){
        workResponsibleService.updateByStatusSelective(workResponsible);
        return Result.success();
    }

    /**
     * 根据我的工作id查询列表
     * @author gaozhenyuan
     * @date 2019/12/25 14:23
     */
    @RequestMapping("/selectListByWorkInfoId")
    public Result selectListByWorkInfoId(String id) {
        List<WorkResponsible> list = workResponsibleService.selectListByWorkInfoId(id);
        return Result.success(list);
    }

    /**
     * 根据我的工作id查询列表
     * @author gaozhenyuan
     * @date 2019/12/25 14:23
     */
    @RequestMapping("/selectAllListByWorkInfoId")
    public Result selectAllListByWorkInfoId(String id) {
        List<WorkResponsible> list = workResponsibleService.selectAllListByWorkInfoId(id);
        return Result.success(list);
    }

    /**
     * 查询我的工作详情
     * @author gaozhenyuan
     * @date 2019/12/25 14:23
     */
    @RequestMapping("/selectWorkResponsibleById")
    public Result selectWorkResponsibleById(String id) {
        WorkResponsible workResponsible = workResponsibleService.selectWorkResponsibleById(id);
        return Result.success(workResponsible);
    }


    @RequestMapping("/updateByworkResponsibleId")
    public  Result updateByworkResponsibleId(WorkProce workProce){
        workResponsibleService.updateStatusById(workProce.getId());
        workResponsibleService.insertWorkProce(workProce);
        return Result.success();
    }
    /**
    * @Author: jiayiwen
    * @Description:全部下发
    * @Date: 15:18 2020/1/10
     */
    @RequestMapping("/updateStatusByIds")
    public  Result updateStatusByIds(String ids){
        workResponsibleService.updateStatusByIds(ids);
        return Result.success();
    }

}
