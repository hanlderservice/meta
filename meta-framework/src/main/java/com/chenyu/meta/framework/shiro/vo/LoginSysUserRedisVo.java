package com.chenyu.meta.framework.shiro.vo;

import com.chenyu.meta.framework.domain.ClientInfo;

import java.io.Serializable;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description:
 */
public class LoginSysUserRedisVo extends LoginSysUserVo implements Serializable {

    private String salt;
    private ClientInfo clientInfo;

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public ClientInfo getClientInfo() {
        return clientInfo;
    }

    public void setClientInfo(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
    }
}
