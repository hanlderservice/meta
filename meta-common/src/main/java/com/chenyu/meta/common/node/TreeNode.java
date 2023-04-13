package com.chenyu.meta.common.node;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Create by 10296 on 2023/3/10
 *
 * @Description:
 */
public class TreeNode<T> implements Serializable {

    /**
     * 节点ID
     */
    private Long id;
    /**
     * 父节点
     */
    private Long pId;
    /**
     * 节点名称
     */
    private String name;
    /**
     * 子节点列表
     */
    private List<TreeNode<T>> children = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TreeNode<T>> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode<T>> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "id=" + id +
                ", pId=" + pId +
                ", name='" + name + '\'' +
                ", children=" + children +
                '}';
    }

}
