package com.chenyu.meta.system.param;

import com.chenyu.meta.common.param.BaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Create by 10296 on 2023/3/10
 *
 * @Description:
 */
@ApiModel("角色管理参数")
public class SysRoleParam extends BaseParam {


    @ApiModelProperty(value = "角色唯一编码")
    private String code;
    @ApiModelProperty(value = "角色类型")
    private String type;
    @ApiModelProperty(value = "角色状态，0：禁用，1：启用")
    private String state;
    @ApiModelProperty(value = "顺序")
    private String roleSort;
    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "创建人")
    private String username;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRoleSort() {
        return roleSort;
    }

    public void setRoleSort(String roleSort) {
        this.roleSort = roleSort;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
