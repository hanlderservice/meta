package com.chenyu.meta.common.util;

import com.chenyu.meta.common.node.TreeNode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by 10296 on 2023/3/10
 *
 * @Description: 树形结构工具类
 */
public class TreeNodeUtils {


    /**
     * 根据Pid，构建树节点
     *
     * @param treeNodes
     * @param pid
     * @param <T>
     * @return
     */
    public static <T extends TreeNode> List<T> build(List<T> treeNodes, Long pid) {

        List<T> treeList = new ArrayList<>();
        for (T treeNode : treeNodes) {
            if (pid.equals(treeNode.getpId())) {
                treeList.add(findChildren(treeNodes, treeNode));
            }
        }


        return treeList;
    }

    /**
     * 查找子节点
     *
     * @param treeNodes
     * @param rootNode
     * @param <T>
     * @return
     */
    private static <T extends TreeNode> T findChildren(List<T> treeNodes, T rootNode) {

        for (T treeNode : treeNodes) {

            if (rootNode.getId().equals(treeNode.getpId())) {
                rootNode.getChildren().add(findChildren(treeNodes, treeNode));
            }

        }

        return rootNode;
    }

    /**
     * 构建树节点
     *
     * @param treeNodes
     * @param <T>
     * @return
     */
    public static <T extends TreeNode> List<T> build(List<T> treeNodes) {
        List<T> resultList = new ArrayList<>();
        //List 转map
        Map<Long, T> nodeMap = new LinkedHashMap<>(treeNodes.size());
        for (T treeNode : treeNodes) {
            nodeMap.put(treeNode.getId(), treeNode);
        }
        for (T node : nodeMap.values()) {
            T parent = nodeMap.get(node.getpId());
            if (parent != null && !(node.getId()).equals(parent.getId())) {
                parent.getChildren().add(node);
                continue;
            }
            resultList.add(node);
        }

        return resultList;
    }


}
