package com.chenyu.meta.wechat.domain;

/**
 * Create by 10296 on 2023/3/11
 *
 * @Description:
 */
public class WxAccessToken {


    private String accessToken;
    private long expiresTime;

    public WxAccessToken(String accessToken, int expiresIn) {
        this.accessToken = accessToken;
        this.expiresTime = System.currentTimeMillis() + (expiresIn) * 1000L;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public long getExpiresTime() {
        return expiresTime;
    }

    public void setExpiresTime(long expiresTime) {
        this.expiresTime = expiresTime;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > expiresTime;
    }



}
