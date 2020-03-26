package com.hxoim.common.tree;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author
 */
public class ZTreeBuild {
    public static void main(String[] args) {
        String date = "1992/02/30";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        try {
            String newDate = simpleDateFormat.format(simpleDateFormat.parse(date));
            if (newDate.equals(date)) {
                System.out.println("日期格式正确!!!");
            } else {
                System.out.println("日期格式错误!!!");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    /**
     * mapList转换为List<Node> 其他字段值放入Node的otherAttributes属性中
     *
     * @param mapList
     * @return
     */
    public List<Node> ConvertNodeList(List<Map<String, String>> mapList) {
        List<Node> nodeList = null;
        if (mapList != null && mapList.size() > 0) {
            for (int i = 0; i < mapList.size(); i++) {
                Map<String, String> thisMap = mapList.get(i);
                Node ztreeNode = new Node();
                for (String key : thisMap.keySet()) {

                    if (key.equals("id"))
                        ztreeNode.setId(thisMap.get(key));
                    else if (key.equals("pId"))
                        ztreeNode.setpId(thisMap.get(key));
                    else if (key.equals("name"))
                        ztreeNode.setName(thisMap.get(key));
                    else if (key.equals("open"))
                        ztreeNode.setOpen(thisMap.get(key));
                    else if (key.equals("checked"))
                        ztreeNode.setChecked(thisMap.get(key));
                    else if (key.equals("isParent"))
                        ztreeNode.setIsParent(thisMap.get(key));
                    else if (key.equals("type"))
                        ztreeNode.setType(thisMap.get(key));
                    else {
                        if (ztreeNode.getOtherAttributes() == null) {
                            Map<String, String> otherAttributeMap = new HashMap<String, String>();
                            ztreeNode.setOtherAttributes(otherAttributeMap);
                        }
                        //将不在属性内的值添加至otherAttributes
                        ztreeNode.getOtherAttributes().put(key, thisMap.get(key));

                    }
                }
            }
        }
        return nodeList;
    }


    /**
     * @param nodes   包含根节点的所有节点集合
     * @param rootPId 根节点 父ID(可以为0、null、"")
     * @return
     * @author: sq
     * @date: 2018年8月1日 上午11:58:40
     */
    public List<Node> resultTree(List<Node> nodes, String rootPId) {
        List<Node> treeList = new ArrayList<Node>();
        for (Node node : nodes) {// 找到根节点
            if ("".equals(node.getpId()) || "0".equals(node.getpId()) || node.getpId() == null) {
                node.setIsParent("true");
                node.setOpen("true");
                treeList.add(node);
                break;
            }
        }
        if (treeList.isEmpty()) {
            return null;
        }
        List<Node> allChild = getAllChild(nodes, treeList.get(0).getId());
        if (!allChild.isEmpty()) {
            treeList.get(0).setChildren(allChild);
        }
        return treeList;
    }

    /**
     * 根节点以下的所有节点
     *
     * @param pId
     * @return
     * @author: sq
     * @date: 2018年8月1日 下午1:42:24
     */
    private List<Node> getAllChild(List<Node> nodes, String pId) {
        List<Node> list = new ArrayList<>();
        List<Node> children = getChildren(nodes, pId);
        if (!children.isEmpty()) {
            for (Node node : children) {
                List<Node> allChild = getAllChild(nodes, node.getId());
                node.setChildren(allChild);
                list.add(node);
            }
        } else {
            for (Node node : nodes) {
                if (node.getId().equals(pId)) {
                    node.setIsParent("false");
                    break;
                }
            }
        }
        return list;
    }

    /**
     * 查询子节点
     *
     * @param allModuleTree
     * @param pId
     * @return
     * @author: sq
     * @date: 2018年8月1日 下午1:43:25
     */
    private List<Node> getChildren(List<Node> nodes, String pId) {
        List<Node> childList = new ArrayList<>();
        for (Node node : nodes) {
            if (node.getpId().equals(pId)) {
                childList.add(node);
            }
        }
        return childList;
    }

    /**
     * 用map集合作为树节点,比较灵活
     *
     * @param nodes   包含根节点的节点集合(map中必须包含id,pId,name树结构的基本属性)
     * @param rootPId 根节点的pId
     * @return 树形集合
     * <p>
     * 2018年8月13日下午3:23:07
     */
    public List<Map<String, Object>> getMapZTree(List<Map<String, Object>> nodes, String rootPId) {
        List<Map<String, Object>> treeList = new ArrayList<>();
        if (nodes == null||nodes.isEmpty()) {
            return null;
        }
        // 找到根节点
        for (Map<String, Object> node : nodes) {
            if ("".equals(node.get("pId")) || "0".equals(node.get("pId")) || node.get("pId") == null) {
                if (node.get("isParent") == null) {
                    node.put("isParent", true);
                }
                node.put("open", false);
                treeList.add(node);
                // break;
            }
        }
        if (treeList.isEmpty()) {
            return null;
        }
        for (Map<String, Object> map : treeList) {
            List<Map<String, Object>> allChild = getAllChildByMap(nodes, map.get("id").toString());
            if (!allChild.isEmpty()) {
                map.put("children", allChild);
            }
        }
        return treeList;
    }


	/**
	 * @desc 不需要传入Root的pId
	 * @param nodes
	 * @return
	 */
	public List<Map<String,Object>> getZtreeMutify(List<Map<String, Object>> nodes){
		List<Map<String, Object>> treeList = new ArrayList<>();
		if (nodes.isEmpty() || nodes == null) {
			return null;
		}
		for (Map<String, Object> node : nodes) {// 找到根节点
			Boolean flag = true;

			for (int i = 0; i < nodes.size(); i++) {
				Map<String, Object> map = nodes.get(i);
				if (((String) node.get("pId")).equals(((String) map.get("id")))) {
					flag = false;
					break;
				}
			}
			if (flag) {
				if (node.get("isParent") == null) {
					node.put("isParent", true);
				}
				node.put("open", true);
				treeList.add(node);
			}
		}
		if (treeList.isEmpty()) {
			return null;
		}
		for (Map<String, Object> map : treeList) {
			List<Map<String, Object>> allChild = getAllChildByMap(nodes, map.get("id").toString());
			if (!allChild.isEmpty()) {
				map.put("children", allChild);
			}
		}
		return treeList;
	}

    /**
     * 根节点以下的所有节点
     *
     * @param allModuleTree
     * @param pId
     * @return
     * @author: sq
     * @date: 2018年8月13日15:35:40
     */
    private List<Map<String, Object>> getAllChildByMap(List<Map<String, Object>> nodes, String pId) {
        List<Map<String, Object>> list = new ArrayList<>();
        List<Map<String, Object>> children = getChildrenByMap(nodes, pId);
        if (!children.isEmpty()) {
            for (Map<String, Object> node : children) {
                List<Map<String, Object>> allChild = getAllChildByMap(nodes, node.get("id").toString());
                node.put("children", allChild);
                list.add(node);
            }
        } else {
            for (Map<String, Object> node : nodes) {
                if (node.get("id").equals(pId)) {
                    if (node.get("isParent") == null) {
                        node.put("isParent", false);
                    }
                    break;
                }
            }
        }
        return list;
    }

    /**
     * 查询子节点
     *
     * @param nodes allModuleTree
     * @param pId
     * @return
     * @author: sq
     * @date: 2018年8月13日15:35:30
     */
    private List<Map<String, Object>> getChildrenByMap(List<Map<String, Object>> nodes, String pId) {
        List<Map<String, Object>> childList = new ArrayList<>();
        for (Map<String, Object> node : nodes) {
            if (node.get("pId").equals(pId)) {
                childList.add(node);
            }
        }
        return childList;
    }
}
