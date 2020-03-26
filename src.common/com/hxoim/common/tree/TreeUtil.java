package com.hxoim.common.tree;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author sunqian
 * @Description 递归树工具
 * @Date 14:22 2019/6/6
 */
public class TreeUtil {

    public static void main(String[] args) {
        List<Tree> list = new ArrayList<>();
        Tree tree = new Tree();
        tree.setId("111");
        tree.setpId("0");
        tree.setLabel("一级节点");
        list.add(tree);

        Tree tree1 = new Tree();
        tree1.setId("222");
        tree1.setpId("0");
        tree1.setLabel("一级节点");
        list.add(tree1);

        Tree tree2 = new Tree();
        tree2.setId("333");
        tree2.setpId("111");
        tree2.setLabel("二级节点");
        list.add(tree2);

        List<Tree> trees = TreeUtil.listToTreeJson(list);
        String s = JSONObject.toJSONString(trees);
        System.out.println(s);
    }

    /**
     * @author: sunqian
     * @desc: 将集合转为前端需要的数据结构
     * @date: 2019/5/28 17:00
     */
    public static List<Tree> listToTreeJson(List<Tree> list) {
        List<Tree> treeList = new ArrayList<>();
        if (list == null || list.isEmpty()) {
            return null;
        }
        //找到所有的父节点
        Iterator<Tree> iterator = list.iterator();
        List<String> idList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Tree tree = list.get(i);
            idList.add(tree.getId());
        }
        while (iterator.hasNext()) {
            Tree next = iterator.next();
            if (!idList.contains(next.getpId())) {
                treeList.add(next);
                iterator.remove();
            }
        }
        //递归查询子节点
        getChildByRootNode(list, treeList);
        return treeList;
    }

    /**
     * @Author sunqian
     * @Desc 一个根节点查询子节点
     * @Date 2019/6/22 18:08
     */
    public static void getKidsByRootNode(List<Tree> list, Tree rootNode) {
        List<Tree> ls = new ArrayList<>();
        ls.add(rootNode);
        getChildByRootNode(list, ls);
    }

    /**
     * @Author sunqian
     * @Desc 多个根节点查找子节点
     * @Date 2019/6/22 18:04
     */
    public static void getKidsByRootNodes(List<Tree> list, List<Tree> rootList) {
        getChildByRootNode(list, rootList);
    }

    /**
     * @param list     所有的树节点
     * @param rootList 所有的根节点
     * @Author sunqian
     * @Desc 递归查询所有子节点
     * @Date 2019/6/22 18:00
     */
    private static void getChildByRootNode(List<Tree> list, List<Tree> rootList) {
        //递归查询子节点
        if (rootList != null && !rootList.isEmpty()) {
            for (int i = 0; i < rootList.size(); i++) {
                Tree tree = rootList.get(i);
                List<Tree> childrenList = selectTreeList(tree, list);
                tree.setChildren(childrenList);
            }
        }
    }

    /**
     * @author: sunqian
     * @desc: 递归查找子节点
     * @date: 2019/5/28 17:22
     */
    private static List<Tree> selectTreeList(Tree tree, List<Tree> list) {
        List<Tree> resultList = null;
        List<Tree> children = findChildrenList(tree, list);
        if (!children.isEmpty()) {
            resultList = new ArrayList<>();
            for (Tree child : children) {
                child.setChildren(selectTreeList(child, list));
                resultList.add(child);
            }
        }
        return resultList;
    }

    /**
     * @author: sunqian
     * @desc: 查找子节点
     * @date: 2019/5/28 17:22
     */
    private static List<Tree> findChildrenList(Tree tree, List<Tree> list) {
        List<Tree> children = new ArrayList<>();
        Iterator<Tree> iterator = list.iterator();
        while (iterator.hasNext()) {
            Tree next = iterator.next();
            if (tree.getId().equals(next.getpId())) {
                children.add(next);
                iterator.remove();
            }
        }
        return children;
    }
}
