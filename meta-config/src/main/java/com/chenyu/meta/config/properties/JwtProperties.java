package com.chenyu.meta.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description:
 */
@Component
@ConfigurationProperties(prefix = "meta.jwt")
public class JwtProperties {


    /*token名称，默认名称为：token*/
    private String tokenName;
    /*密码*/
    private String secret;
    /*签发人*/
    private String issuer;
    /*主题*/
    private String subject;
    /*签发目标*/
    private String audience;
    /*token 失效时间，token默认有效时间 1天*/
    private Long expireSecond;
    /*是否刷新token，默认true*/
    private boolean refreshToken;
    /*刷新token倒计时，默认10分钟*/
    private Integer refreshTokenCountDown;
    /*redis校验jwt，token是否存在*/
    private boolean redisCheck;
    /*单用户登录，一个用户只能有一个有效的token*/
    private boolean singleLogin;
    /*是否进行盐值校验*/
    private boolean saltCheck;

    public String getTokenName() {
        return tokenName;
    }

    public void setTokenName(String tokenName) {
        this.tokenName = tokenName;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public Long getExpireSecond() {
        return expireSecond;
    }

    public void setExpireSecond(Long expireSecond) {
        this.expireSecond = expireSecond;
    }

    public boolean isRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(boolean refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Integer getRefreshTokenCountDown() {
        return refreshTokenCountDown;
    }

    public void setRefreshTokenCountDown(Integer refreshTokenCountDown) {
        this.refreshTokenCountDown = refreshTokenCountDown;
    }

    public boolean isRedisCheck() {
        return redisCheck;
    }

    public void setRedisCheck(boolean redisCheck) {
        this.redisCheck = redisCheck;
    }

    public boolean isSingleLogin() {
        return singleLogin;
    }

    public void setSingleLogin(boolean singleLogin) {
        this.singleLogin = singleLogin;
    }

    public boolean isSaltCheck() {
        return saltCheck;
    }

    public void setSaltCheck(boolean saltCheck) {
        this.saltCheck = saltCheck;
    }
}
