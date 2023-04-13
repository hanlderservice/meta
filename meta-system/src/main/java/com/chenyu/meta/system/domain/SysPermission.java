package com.chenyu.meta.system.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by 10296 on 2023/4/7
 *
 * @Description:
 */
public class SysPermission {

    /**
     * 权限ID
     */
    private Long menuId;
    /**
     * 权限名称
     */
    private String menuName;
    /**
     * 父ID
     */
    private Long parentId;
    /**
     * 路径
     */
    private String url;
    /**
     * 权限编码
     */
    private String code;
    /**
     * 组件路径
     */
    private String components;
    /**
     * 图标
     */
    private String icon;
    /**
     * 类型 1.菜单
     */
    private String type;
    /**
     * 层级
     */
    private String level;
    /**
     * 菜单状态：1.隐藏，0.显示
     */
    private String visible;
    /**
     * 状态：0：禁用，1.启用
     */
    private String state;
    /**
     * 排序
     */
    private String sort;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 修改人
     */
    private String updateBy;
    /**
     * 修改时间
     */
    private String updateTime;


    /**
     * 子菜单
     */
    private List<SysPermission> children = new ArrayList<>();

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getComponents() {
        return components;
    }

    public void setComponents(String components) {
        this.components = components;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public List<SysPermission> getChildren() {
        return children;
    }

    public void setChildren(List<SysPermission> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "SysPermission{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", parentId=" + parentId +
                ", url='" + url + '\'' +
                ", code='" + code + '\'' +
                ", component='" + components + '\'' +
                ", icon='" + icon + '\'' +
                ", type='" + type + '\'' +
                ", level='" + level + '\'' +
                ", visible='" + visible + '\'' +
                ", state='" + state + '\'' +
                ", sort='" + sort + '\'' +
                ", remark='" + remark + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", children=" + children +
                '}';
    }

}
