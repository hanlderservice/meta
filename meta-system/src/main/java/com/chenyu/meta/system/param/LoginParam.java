package com.chenyu.meta.system.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Create by 10296 on 2023/3/3
 *
 * @Description:
 */
@ApiModel("登录参数")
public class LoginParam {



    @ApiModelProperty(value = "账号", example = "admin")
    private String username;


    @ApiModelProperty(value = "密码", example = "123456")
    private String password;

    @ApiModelProperty("验证码Token")
    private String verifyToken;

    @ApiModelProperty("验证码")
    private String code;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifyToken() {
        return verifyToken;
    }

    public void setVerifyToken(String verifyToken) {
        this.verifyToken = verifyToken;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "LoginParam{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", verifyToken='" + verifyToken + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
