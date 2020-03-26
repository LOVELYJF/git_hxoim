package com.hxoim.support.inforesource.entity;
/*
 * @description:扩展表的处室管理，用于返回处室名称和从前端批量插入管理处室
 * @author 杨波
 * @date:2019-07-20
 */

public class DataTableManagerExtend extends DataTableManager {
    //用于从前端批量接受表
    private String[] tableids;

    public String[] getTableids() {
        return tableids;
    }

    public void setTableids(String[] Ids) {
        this.tableids = Ids;
    }

    //用于从前端批量接受使用系统
    private String[] sysids;

    public String[] getSysids() {
        return sysids;
    }

    public void setSysids(String[] Ids) {
        this.sysids = Ids;
    }

    //系统的名字
    private String syName;

    public String getSyName() {
        return syName;
    }

    public void setSyName(String name) {
        this.syName = name;
    }

    //表的名字
    private String tabName;

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String name) {
        this.tabName = name;
    }

    public DataTableManagerExtend(String id, String tableid,
                                  String sysid, String syName, String tabName) {
        this.setId(id);
        this.setTableid(tableid);
        this.setSysid(sysid);
        this.syName = syName;
        this.tabName = tabName;
    }
}
