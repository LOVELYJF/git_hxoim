package com.hxoim.common.tree;

import java.util.List;
import java.util.Map;

public class Node {

	private String id;// 节点id
	private String pId;// 节点父id
	private String name;// 节点名称
	private String open = "false";// 是否展开,默认不展开
	private String checked = "false";// 节点是否选择
	private String isParent;// 节点是否是叶子节点
	private String type;//节点类型
	private String b0114;

	private Map<String, String> otherAttributes;
	private List<Node> children;

	public String getB0114() {
		return b0114;
	}

	public void setB0114(String b0114) {
		this.b0114 = b0114;
	}

	public Map<String, String> getOtherAttributes() {
		return otherAttributes;
	}

	public void setOtherAttributes(Map<String, String> otherAttributes) {
		this.otherAttributes = otherAttributes;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Node> getChildren() {
		return children;
	}

	public void setChildren(List<Node> children) {
		this.children = children;
	}

	public String getId() {
		return id;
	}

	public String getpId() {
		return pId;
	}

	public String getName() {
		return name;
	}

	public String getOpen() {
		return open;
	}

	public String getChecked() {
		return checked;
	}

	public String getIsParent() {
		return isParent;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public void setIsParent(String isParent) {
		this.isParent = isParent;
	}


}
