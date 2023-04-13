package com.chenyu.meta.system.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Create by 10296 on 2023/3/10
 *
 * @Description:
 */


@ApiModel("用户信息")
public class SysUser {
    @ApiModelProperty("用户Id")
    private Long userId;
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("姓名")
    private String nickname;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("盐值")
    private String salt;
    @ApiModelProperty("是否系统用户")
    private String userType;
    @ApiModelProperty("电话")
    private String phone;
    @ApiModelProperty("邮箱")
    private String email;
    @ApiModelProperty("性别")
    private String gender;
    @ApiModelProperty("头像")
    private String head;
    @ApiModelProperty("备注")
    private String remark;
    @ApiModelProperty("状态")
    private String state;
    @ApiModelProperty("部门")
    private Long departmentId;
    @ApiModelProperty("角色")
    private Long roleId;
    @ApiModelProperty("是否删除")
    private String deleted;
    @ApiModelProperty("创建时间")
    private String createDate;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

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

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
