package com.hxoim.full.search.controller;

import com.hxoim.common.tree.Tree;
import com.hxoim.common.utils.PageUtil;
import com.hxoim.common.utils.RequestList;
import com.hxoim.common.utils.Result;
import com.hxoim.full.search.entity.PersonInfoResult;
import com.hxoim.full.search.service.FullTextSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 全文检索
 *
 * @author sunqian
 * @date 2019/11/5 14:15
 */
@RestController
@RequestMapping("/fullTextSearch")
public class FullTextSearchController {

    @Autowired
    private FullTextSearchService fullTextSearchService;

    /**
     * 信息集列表
     *
     * @author sunqian
     * @date 2019/11/6 11:08
     */
    @RequestMapping("/selectPersonTableTree")
    public Result selectPersonTableTree() {
        List<Tree> list = fullTextSearchService.selectPersonTableTree();
        return Result.success(list);
    }

    /**
     * 根据表编码查询列
     *
     * @author sunqian
     * @date 2019/11/6 11:08
     */
    @RequestMapping("/selectColumnListByTabCode")
    public Result selectColumnListByTabCode(String tabCode) {
        Map<String, Object> map = fullTextSearchService.selectColumnListByTabCode(tabCode);
        return Result.success(map);
    }

    /**
     * 保存索引列
     *
     * @author sunqian
     * @date 2019/11/7 10:34
     */
    @RequestMapping("/saveSearchIndexColumn")
    public Result saveSearchIndexColumn(String tabCode, RequestList<String> list) {
        List<String> colList = list.getList(String.class);
        fullTextSearchService.saveSearchIndexColumn(tabCode, colList);
        return Result.success();
    }

    /**
     * 重建索引
     *
     * @author sunqian
     * @date 2019/11/7 10:35
     */
    @RequestMapping("/creatSearcherIndex")
    public Result creatSearcherIndex(String tabCode) {
        fullTextSearchService.creatSearcherIndex(tabCode);
        return Result.success();
    }

    /**
     * 全文检索
     *
     * @author sunqian
     * @date 2019/11/7 15:36
     */
    @RequestMapping("/queryKeyword")
    public Result queryKeyword(String keyword, PageUtil<PersonInfoResult> pageUtil) {
        Map<String,Object> map = new HashMap<>();
        List<PersonInfoResult> list = fullTextSearchService.queryKeyword(keyword, pageUtil);
        map.put("personList",list);
        map.put("total",pageUtil.getTotal());
        return Result.success(map);
    }
}
