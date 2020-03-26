package com.hxoim.support.role.entity;

import com.hxoim.common.tree.Tree;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author sunqian
 * @Desc 授权模块数据
 * @Date 2019/6/24 16:46
 */
public class RoleGrant {
    private List<Tree> treeList;
    private List<String> checkList;
    private List<Map<String,String>> infoList;

    private String id;
    private String roleId;
    private String leaderTypeId;
    private String checkId;
    private String modifyUser;
    private String checked;
    private Date modifyTime;
    private String datatableId;
    private String datacolId;
    private String readwrite;

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

    public List<Map<String, String>> getInfoList() {
        return infoList;
    }

    public void setInfoList(List<Map<String, String>> infoList) {
        this.infoList = infoList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
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

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getDatatableId() {
        return datatableId;
    }

    public void setDatatableId(String datatableId) {
        this.datatableId = datatableId;
    }

    public String getReadwrite() {
        return readwrite;
    }

    public void setReadwrite(String readwrite) {
        this.readwrite = readwrite;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    public String getDatacolId() {
        return datacolId;
    }

    public void setDatacolId(String datacolId) {
        this.datacolId = datacolId;
    }
}
