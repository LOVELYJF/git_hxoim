package com.hxoim.support.b01.entity;

import com.hxoim.common.tree.Tree;

import java.util.List;

/**
 * 机构授权
 *
 * @author sunqian
 * @date 2019/6/29 14:41
 */
public class OrgGrant {
    private List<Tree> treeList;
    private List<String> checkList;

    private String id;
    private String orgId;
    private String leaderTypeId;
    private String checkId;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getLeaderTypeId() {
        return leaderTypeId;
    }

    public void setLeaderTypeId(String leaderTypeId) {
        this.leaderTypeId = leaderTypeId;
    }

    public String getCheckId() {
        return checkId;
    }

    public void setCheckId(String checkId) {
        this.checkId = checkId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Tree> getTreeList() {
        return treeList;
    }

    public void setTreeList(List<Tree> treeList) {
        this.treeList = treeList;
    }

    public List<String> getCheckList() {
        return checkList;
    }

    public void setCheckList(List<String> checkList) {
        this.checkList = checkList;
    }

}
