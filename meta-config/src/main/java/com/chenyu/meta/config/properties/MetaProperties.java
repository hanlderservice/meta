package com.chenyu.meta.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description:
 */
@Component
@ConfigurationProperties(prefix = "meta")
public class MetaProperties {

    /**
     * 是否启用验证码
     */
    private boolean enableVerifyCode;

    /**
     * 新建登录用户初始化盐值
     */
    private String loginInitSalt;

    /**
     * 新建登录用户初始化密码
     */
    private String loginInitPassword;

    /**
     * 新建用户初始化头像
     */
    private String loginInitHead;

    @NestedConfigurationProperty
    private ShiroProperties shiro = new ShiroProperties();



    public boolean isEnableVerifyCode() {
        return enableVerifyCode;
    }

    public void setEnableVerifyCode(boolean enableVerifyCode) {
        this.enableVerifyCode = enableVerifyCode;
    }

    public String getLoginInitSalt() {
        return loginInitSalt;
    }

    public void setLoginInitSalt(String loginInitSalt) {
        this.loginInitSalt = loginInitSalt;
    }

    public String getLoginInitPassword() {
        return loginInitPassword;
    }

    public void setLoginInitPassword(String loginInitPassword) {
        this.loginInitPassword = loginInitPassword;
    }

    public String getLoginInitHead() {
        return loginInitHead;
    }

    public void setLoginInitHead(String loginInitHead) {
        this.loginInitHead = loginInitHead;
    }

    public ShiroProperties getShiro() {
        return shiro;
    }

    public void setShiro(ShiroProperties shiro) {
        this.shiro = shiro;
    }
}
