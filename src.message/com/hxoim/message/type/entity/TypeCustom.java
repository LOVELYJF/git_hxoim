package com.hxoim.message.type.entity;

import java.util.List;

/**
 * @author lijing
 * @desc 消息分类实体类扩展
 * @date 2019/5/27
 */
public class TypeCustom extends Type{

    /**
     * 消息分类子节点集合
     */
    private List<TypeCustom> typeLists;

    /**
     * 树结构复选框不可选
     */
    private boolean disabled = true;

    public List<TypeCustom> getTypeLists() {
        return typeLists;
    }

    public void setTypeLists(List<TypeCustom> typeLists) {
        this.typeLists = typeLists;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }
}
