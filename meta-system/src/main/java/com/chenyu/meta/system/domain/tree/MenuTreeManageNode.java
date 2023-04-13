package com.chenyu.meta.system.domain.tree;

/**
 * Create by 10296 on 2023/4/7
 *
 * @Description:
 */
public class MenuTreeManageNode extends MenuTreeNode {

    private String url;
    private String type;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
