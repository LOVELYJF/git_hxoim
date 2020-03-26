package com.hxoim.notice.column.controller;

import com.hxoim.common.tree.Tree;
import com.hxoim.common.utils.RequestList;
import com.hxoim.common.utils.Result;
import com.hxoim.notice.column.entity.NoticeColumn;
import com.hxoim.notice.column.service.NoticeColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 栏目设置
 *
 * @author sunqian
 * @date 2019/9/12 10:52
 */
@RestController
@RequestMapping("/noticeColumn")
public class NoticeColumnController {

    @Autowired
    private NoticeColumnService noticeColumnService;

    /**
     * 栏目新增或者修改
     *
     * @author sunqian
     * @date 2019/9/12 10:58
     */
    @RequestMapping("/inertOrUpdateColumn")
    public Result inertOrUpdateColumn(NoticeColumn noticeColumn, boolean isInsert) {
        noticeColumnService.inertOrUpdateColumn(noticeColumn, isInsert);
        return Result.success();
    }

    /**
     * 获取栏目树
     * 
     * @author sunqian
     * @date 2019/9/16 11:29
     */
    @RequestMapping("/selectColumnTree")
    public Result selectColumnTree() {
        List<Tree> list = noticeColumnService.selectColumnTree();
        return Result.success(list);
    }

    /**
     * 查询所有子节点
     *
     * @author sunqian
     * @date 2019/9/16 14:28
     */
    @RequestMapping("/selectColumnListByPId")
    public Result selectColumnListByPId(String pId){
        List<NoticeColumn> list = noticeColumnService.selectColumnListByPId(pId);
        return Result.success(list);
    }

    /**
     * 根据主键查询
     * 
     * @author sunqian
     * @date 2019/9/16 14:55
     */
    @RequestMapping("/selectPrimaryKey")
    public Result selectPrimaryKey(String id){
        NoticeColumn noticeColumn = noticeColumnService.selectPrimaryKey(id);
        return Result.success(noticeColumn);
    }
    /**
     * 根据主键删除数据
     * 
     * @author sunqian
     * @date 2019/9/16 15:16
     */
    @RequestMapping("/deletePrimaryKey")
    public Result deletePrimaryKey(String id){
        noticeColumnService.deletePrimaryKey(id);
        return Result.success();
    }

    /**
     * 保存排序
     * 
     * @author sunqian
     * @date 2019/9/16 17:59
     */
    @RequestMapping("/saveTableSort")
    public Result saveTableSort(RequestList<NoticeColumn> list){
        noticeColumnService.saveTableSort(list.getList(NoticeColumn.class));
        return Result.success();
    }

    /**
     * 获取除栏目设置以外的所有栏目(树结构)
     * 
     * @author sunqian
     * @date 2019/9/19 10:52
     */
    @RequestMapping("/selectColumnTypeTree")
    public Result selectColumnTypeTree() {
       List<Tree> list = noticeColumnService.selectColumnTypeTree();
        return Result.success(list);
    }

    /**
     * 获取除栏目设置以外的所有栏目(列表结构)
     *
     * @author sunqian
     * @date 2019/9/19 10:52
     */
    @RequestMapping("/selectColumnTypeList")
    public Result selectColumnTypeList() {
        List<NoticeColumn> list = noticeColumnService.selectColumnTypeList();
        return Result.success(list);
    }
}
