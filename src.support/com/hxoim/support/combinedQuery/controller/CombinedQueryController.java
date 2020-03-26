package com.hxoim.support.combinedQuery.controller;

import com.hxoim.common.utils.RequestList;
import com.hxoim.common.utils.Result;
import com.hxoim.support.combinedQuery.entity.CombinedQuery;
import com.hxoim.support.combinedQuery.service.CombinedQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 组合查询
 *
 * @author sunqian
 * @date 2019/8/26 10:22
 */
@RestController
@RequestMapping("/combinedQuery")
public class CombinedQueryController {

    @Autowired
    private CombinedQueryService combinedQueryService;

    /**
     * 获取组合查询条件列表
     *
     * @author sunqian
     * @date 2019/8/26 13:58
     */
    @RequestMapping("/selectCombinedQuery")
    public Result selectCombinedQueryList() {
        List<CombinedQuery> combinedQueryList = combinedQueryService.selectCombinedQueryList();
        return Result.success(combinedQueryList);
    }

    /**
     * 获取组合查询条件列表
     *
     * @author sunqian
     * @date 2019/9/5 17:22
     */
    @RequestMapping("/selectCombinedQueryAllList")
    public Result selectCombinedQueryAllList() {
        List<CombinedQuery> list = combinedQueryService.selectCombinedQueryAllList();
        return Result.success(list);
    }

    /**
     * 保存排序
     *
     * @author sunqian
     * @date 2019/9/6 14:11
     */
    @RequestMapping("/updateListOrderIndex")
    public Result updateListOrderIndex(RequestList<CombinedQuery> requestList) {
        List<CombinedQuery> list = requestList.getList(CombinedQuery.class);
        if (list == null || list.isEmpty()) {
            Result.success();
        }
        for (int i = 0; i < list.size(); i++) {
            CombinedQuery combinedQuery = list.get(i);
            combinedQuery.setOrderIndex(i + 1);
        }
        combinedQueryService.updateListOrderIndex(list);
        return Result.success();
    }

    /**
     * 根据主键查询
     * 
     * @author sunqian
     * @date 2019/9/9 14:33
     */
    @RequestMapping("/selectCombinedPrimaryKey")
    public Result selectCombinedPrimaryKey(String id) {
        CombinedQuery combinedQuery = combinedQueryService.selectCombinedPrimaryKey(id);
        return Result.success(combinedQuery);
    }
    /**
     * 根据标记新增或者修改
     *
     * @author sunqian
     * @date 2019/9/9 14:33
     */
    @RequestMapping("/insertOrUpdateCombinedQuery")
    public Result insertOrUpdateCombinedQuery(CombinedQuery combinedQuery, boolean isInsert) {
        combinedQueryService.insertOrUpdateCombinedQuery(combinedQuery, isInsert);
        return Result.success(combinedQuery);
    }

    /**
     * 删除条件模版
     * 
     * @author sunqian
     * @date 2019/9/9 15:37
     */
    @RequestMapping("/deleteCombinedQuery")
    public Result deleteCombinedQuery(String id) {
        combinedQueryService.deleteCombinedQuery(id);
        return Result.success();
    }
}
