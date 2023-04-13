package com.chenyu.meta.system.param;

import com.chenyu.meta.common.param.BaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Create by 10296 on 2023/4/7
 *
 * @Description:
 */
@ApiModel("系统权限菜单参数")
public class SysPermissionParam extends BaseParam {

    @ApiModelProperty("父ID")
    private String parentId;
    @ApiModelProperty("url")
    private String url;
    @ApiModelProperty("权限编码")
    private String code;
    @ApiModelProperty("路径")
    private String components;
    @ApiModelProperty("图标")
    private String icon;
    @ApiModelProperty("类型")
    private String type;
    @ApiModelProperty("层级")
    private String level;
    @ApiModelProperty("状态")
    private String state;
    @ApiModelProperty("排序")
    private String sort;
    @ApiModelProperty("备注")
    private String remark;
    @ApiModelProperty("版本号")
    private String version;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "SysPermissionParam{" +
                "parentId='" + parentId + '\'' +
                ", url='" + url + '\'' +
                ", code='" + code + '\'' +
                ", components='" + components + '\'' +
                ", icon='" + icon + '\'' +
                ", type='" + type + '\'' +
                ", level='" + level + '\'' +
                ", state='" + state + '\'' +
                ", sort='" + sort + '\'' +
                ", remark='" + remark + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}

