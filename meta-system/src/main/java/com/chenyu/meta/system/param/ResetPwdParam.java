package com.chenyu.meta.system.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Create by 10296 on 2023/3/3
 *
 * @Description:
 */
@ApiModel("重置密码")
public class ResetPwdParam {


    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("旧密码")
    private String oldPassword;
    @ApiModelProperty("新密码")
    private String newPassword;
    @ApiModelProperty("验证码")
    private String code;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ResetPwdParam{" +
                "username='" + username + '\'' +
                ", oldPassword='" + oldPassword + '\'' +
                ", newPassword='" + newPassword + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
