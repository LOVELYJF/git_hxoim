package com.hxoim.common.tree;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * @Author sunqian
 * @Description 树实体类
 * @Date 14:22 2019/6/6
 */
public class Tree {

    private String id;//树id，节点的唯一标识
    private String label;//树节点的名称
    private String pId;//树节点的父id

    @JsonInclude(value= JsonInclude.Include.NON_NULL)
    private List<Tree> children;//子节点

    @JsonInclude(value= JsonInclude.Include.NON_NULL)
    private String tableId;//查询树时以其他字段作为id，tableId为原来的表id

    @JsonInclude(value= JsonInclude.Include.NON_NULL)
    private String type; //节点类型

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public List<Tree> getChildren() {
        return children;
    }

    public void setChildren(List<Tree> children) {
        this.children = children;
    }
}
