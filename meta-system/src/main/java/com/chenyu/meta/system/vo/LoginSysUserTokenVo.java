package com.chenyu.meta.system.vo;

import com.chenyu.meta.framework.shiro.service.LoginToken;
import com.chenyu.meta.framework.shiro.vo.LoginSysUserVo;

/**
 * Create by 10296 on 2023/3/10
 *
 * @Description:
 */
public class LoginSysUserTokenVo  implements LoginToken {

    private String token;
    private LoginSysUserVo userInfo;

    @Override
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LoginSysUserVo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(LoginSysUserVo userInfo) {
        this.userInfo = userInfo;
    }
}
