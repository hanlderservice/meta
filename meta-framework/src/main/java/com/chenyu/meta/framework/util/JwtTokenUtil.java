package com.chenyu.meta.framework.util;

import com.chenyu.meta.common.util.HttpServletRequestUtil;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description: JwtToken 工具类
 */
public class JwtTokenUtil {



    private static String tokenName = "accessToken";

    /**
     * 获取token名称
     *
     * @return
     */
    public static String getTokenName() {
        return tokenName;
    }

    public static String getToken() {
        return getToken(HttpServletRequestUtil.getServletRequest());
    }

    /**
     * 从请求头中获取请求参数
     *
     * @param request
     * @return
     */
    public static String getToken(HttpServletRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("request不能为空!");
        }
        String token = request.getHeader(tokenName);
        if (StringUtils.isBlank(token)) {
            token = request.getParameter(tokenName);
        }
        return token;
    }



}
