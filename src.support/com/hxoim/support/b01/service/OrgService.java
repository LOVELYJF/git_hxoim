package com.hxoim.support.b01.service;

import com.hxoim.common.tree.Tree;
import com.hxoim.support.b01.entity.B01;

import java.util.List;

public interface OrgService {

    /**
     * @author: sunqian
     * @desc: 查询权限内的树节点
     * @date: 2019/5/28 17:33
     */
    List<Tree> selectOrgTree();

    void updateOrg(B01 b01);

    void insertOrg(B01 b01);

    List<B01> selectOrg(B01 b01);

    void deleteOrg(String b0111);

    void sortOrg(String b0111s);

    /**
     * @ description: 查询下级机构列表
     * @ create by: 张乾
     * @ createDate: 2019/6/5 16:34
     */
    List<B01> selectOrgById(B01 b01);

    B01 selectOrgByB0111(String b0111);

    /**
     * @desc: 所有机构列表
     * @author: lijing
     * @date: 2019/7/24
     */
    List<B01> selectOrgAllList();
}
