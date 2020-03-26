package com.hxoim.notice.column.mapper;

import com.hxoim.common.tree.Tree;
import com.hxoim.notice.column.entity.NoticeColumn;

import java.util.List;

/**
 * 栏目设置mapper接口
 * 
 * @author sunqian
 * @date 2019/9/12 10:52
 */
public interface NoticeColumnMapper {
    int deleteByPrimaryKey(String id);

    int insert(NoticeColumn record);

    int insertSelective(NoticeColumn record);

    NoticeColumn selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(NoticeColumn record);

    int updateByPrimaryKey(NoticeColumn record);
    /**
     * 获取最大的排序
     *
     * @author sunqian
     * @date 2019/9/12 13:49
     */
    Integer selectMaxSortId();
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
     * 保存排序
     *
     * @author sunqian
     * @date 2019/9/16 17:59
     */
    void saveTableSort(List<NoticeColumn> list);

    /**
     * 获取除栏目设置以外的所有栏目(树结构)
     *
     * @author sunqian
     * @date 2019/9/19 10:52
     */
    List<Tree> selectColumnTypeTree();

    /**
     * 获取除栏目设置以外的所有栏目(列表结构)
     *
     * @author sunqian
     * @date 2019/9/19 10:52
     */
    List<NoticeColumn> selectColumnTypeList();
}