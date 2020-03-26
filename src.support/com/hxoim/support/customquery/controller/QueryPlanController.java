package com.hxoim.support.customquery.controller;

import com.hxoim.common.utils.Result;
import com.hxoim.support.customquery.entity.QueryPlanWithBLOBs;
import com.hxoim.support.customquery.entity.custom.QueryPlanCustom;
import com.hxoim.support.customquery.service.QueryPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @desc: 方案
 * @author: lijing
 * @date: 2019/8/9
 */
@RestController
@RequestMapping("/queryPlan")
public class QueryPlanController {
    @Autowired
    private QueryPlanService queryPlanService;

    /**
     * @desc: 插入方案
     * @author: lijing
     * @date: 2019/8/10
     */
    @RequestMapping("/insertorUpdateQuery")
    public Result insertorUpdateQuery(QueryPlanWithBLOBs queryPlanWithBLOBs){
        queryPlanService.insertorUpdateQuery(queryPlanWithBLOBs);
        return Result.success();
    }

    /**
     * @desc: 通过id查询方案
     * @author: lijing
     * @date: 2019/8/10
     */
    @RequestMapping("/selectQueryPlanById")
    public Result selectQueryPlanById(String id){
        QueryPlanWithBLOBs queryPlanWithBLOBs = queryPlanService.selectQueryPlanById(id);
        return Result.success(queryPlanWithBLOBs);
    }

    /**
     * @desc: 方案列表
     * @author: lijing
     * @date: 2019/8/10
     */
    @RequestMapping("selectQueryList")
    public Result selectQueryList(){
        List<QueryPlanCustom> queryPlanWithBLOBsList = queryPlanService.selectQueryList();
        return Result.success(queryPlanWithBLOBsList);
    }
}
