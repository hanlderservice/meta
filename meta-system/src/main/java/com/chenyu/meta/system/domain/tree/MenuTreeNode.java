package com.chenyu.meta.system.domain.tree;

import com.chenyu.meta.common.node.TreeNode;

/**
 * Create by 10296 on 2023/4/7
 *
 * @Description:
 */
public class MenuTreeNode  extends TreeNode {

    /**
     * 节点标题
     */
    private String title;
    /**
     * 图标
     */
    private String icon;
    /**
     * url
     */
    private String components;
    /**
     *
     */
    private String key;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getComponents() {
        return components;
    }

    public void setComponents(String components) {
        this.components = components;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "MenuTreeNode{" +
                "title='" + title + '\'' +
                ", icon='" + icon + '\'' +
                ", components='" + components + '\'' +
                ", key='" + key + '\'' +
                '}';
    }
}
