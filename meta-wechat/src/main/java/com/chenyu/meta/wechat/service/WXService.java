package com.chenyu.meta.wechat.service;

/**
 * Create by 10296 on 2023/3/11
 *
 * @Description:
 */
public interface WXService {



    /**
     * 验证消息的确来自微信服务器.
     *
     * @param timestamp 随机串
     * @param nonce     签名
     * @param signature 时间戳
     * @return 是否验证通过
     */
    boolean checkSignature(String timestamp, String nonce, String signature);

    /**
     * 获取access_token, 不强制刷新access_token.
     *
     * @return token
     */
    String getAccessToken();

    /**
     * 获取微信 Access_Token
     *
     * @param forceRefresh 是否强制刷新
     * @return token
     */
    String getAccessToken(boolean forceRefresh);

    /**
     * 根据appId 获取access_token,不强制刷新access_token
     *
     * @param appId
     * @return
     */
    String getAccessToken(String appId);

    /**
     * 获取微信 Access_Token
     *
     * @param forceRefresh 是否强制刷新
     * @param appId        appId
     * @return
     */
    String getAccessToken(boolean forceRefresh, String appId);


}
