package com.chenyu.meta.system.param;

import com.chenyu.meta.common.param.BaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Create by 10296 on 2023/3/10
 *
 * @Description:
 */
@ApiModel("系统用户列表查询")
public class SysUmsUserParam extends BaseParam {

    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "用户密码")
    private String password;
    @ApiModelProperty(value = "salt", example = "666")
    private String salt;
    @ApiModelProperty(value = "用户类型(0000系统用户)", example = "0001")
    private String userType;

    @ApiModelProperty(value = "电话号码")
    private String phone;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "性别，0：女，1：男，2:未知，默认2", example = "2")
    private String gender;
    @ApiModelProperty(value = "头像")
    private String head;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "状态，0：禁用，1：启用，2：锁定")
    private String state;
    @ApiModelProperty(value = "部门ID")
    private String departmentId;
    @ApiModelProperty(value = "角色ID")
    private String roleId;
    @ApiModelProperty(value = "是否删除 (0：未删除，1：已删除)", example = "0")
    private String deleted;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "SysUmsUserParam{" +
                "username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", userType='" + userType + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", head='" + head + '\'' +
                ", remark='" + remark + '\'' +
                ", state='" + state + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", roleId='" + roleId + '\'' +
                ", deleted='" + deleted + '\'' +
                '}';
    }
}
