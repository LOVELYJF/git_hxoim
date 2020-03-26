package com.hxoim.full.search.service;

import com.hxoim.common.tree.Tree;
import com.hxoim.common.utils.PageUtil;
import com.hxoim.full.search.entity.PersonInfoResult;

import java.util.List;
import java.util.Map;

/**
 * 全文检索
 *
 * @author sunqian
 * @date 2019/11/5 15:10
 */
public interface FullTextSearchService {
    /**
     * 获取信息集
     *
     * @author sunqian
     * @date 2019/11/5 15:12
     */
    List<Tree> selectPersonTableTree();

    /**
     * 穿梭框列表信息
     *
     * @author sunqian
     * @date 2019/11/6 11:08
     */
    Map<String, Object> selectColumnListByTabCode(String tabCode);

    void saveSearchIndexColumn(String tabCode, List<String> colList);

    void creatSearcherIndex(String tabCode);

    List<PersonInfoResult> queryKeyword(String keyword, PageUtil<PersonInfoResult> pageUtil);
}
