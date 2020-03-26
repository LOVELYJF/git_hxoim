package com.hxoim.support.module.entity;

import com.hxoim.common.tree.Tree;

public class ModuleTree extends Tree {
    private String url;//路由地址
    private String icon;//图标

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
