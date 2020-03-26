package com.hxoim.notice.column.service;

import com.hxoim.common.tree.Tree;
import com.hxoim.notice.column.entity.NoticeColumn;

import java.util.List;

/**
 * 栏目设置服务层接口
 * 
 * @author sunqian
 * @date 2019/9/12 10:55
 */
public interface NoticeColumnService {
    /**
     * 栏目新增或者修改
     *
     * @author sunqian
     * @date 2019/9/12 10:58
     */
    void inertOrUpdateColumn(NoticeColumn noticeColumn, boolean isInsert);
    /**
     * 获取栏目树
     *
     * @author sunqian
     * @date 2019/9/16 11:29
     */
    List<Tree> selectColumnTree();
    /**
     * 查询所有子节点
     *
     * @author sunqian
     * @date 2019/9/16 14:28
     */
    List<NoticeColumn> selectColumnListByPId(String pId);

    /**
     * 根据主键查询
     *
     * @author sunqian
     * @date 2019/9/16 14:55
     */
    NoticeColumn selectPrimaryKey(String id);

    /**
     * 根据主键删除记录
     * 
     * @author sunqian
     * @date 2019/9/16 15:16
     */
    void deletePrimaryKey(String id);

    /**
     * 保存排序
     *
     * @author sunqian
     * @date 2019/9/16 17:59
     */
    void saveTableSort(List<NoticeColumn> list);

    /**
     * 获取除栏目设置以外的所有栏目(列表结构)
     *
     * @author sunqian
     * @date 2019/9/19 10:52
     */
    List<NoticeColumn> selectColumnTypeList();

    /**
     * 获取除栏目设置以外的所有栏目(树结构)
     *
     * @author sunqian
     * @date 2019/9/19 10:52
     */
    List<Tree> selectColumnTypeTree();
}
