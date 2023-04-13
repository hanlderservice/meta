package com.chenyu.meta.framework.constant;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description:
 */
public interface CommonConstant {


    /**
     * 用户浏览器代理
     */
    String USER_AGENT = "User-Agent";
    /**
     * JWT 用户名
     */
    String JWT_USERNAME = "username";
    /**
     * JWT刷新新token响应状态码，
     * Redis中不存在，但jwt未过期，不生成新的token，返回361状态码
     */
    int JWT_INVALID_TOKEN_CODE = 461;
    /**
     * JWT刷新新token响应状态码
     */
    int JWT_REFRESH_TOKEN_CODE = 460;

    /**
     * 请求头中的token配置
     */
    String HEADER_ACCESS_TOKEN = "accessToken";


}
