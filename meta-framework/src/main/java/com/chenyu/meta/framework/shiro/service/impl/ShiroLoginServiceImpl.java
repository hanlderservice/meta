package com.chenyu.meta.framework.shiro.service.impl;

import com.chenyu.meta.config.properties.JwtProperties;
import com.chenyu.meta.framework.constant.CommonConstant;
import com.chenyu.meta.framework.shiro.jwt.JwtToken;
import com.chenyu.meta.framework.shiro.service.LoginRedisService;
import com.chenyu.meta.framework.shiro.service.ShiroLoginService;
import com.chenyu.meta.framework.shiro.util.JwtUtil;
import com.chenyu.meta.framework.util.JwtTokenUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.time.Duration;
import java.util.Date;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description:
 */
@Service
public class ShiroLoginServiceImpl implements ShiroLoginService {


    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private LoginRedisService loginRedisService;

    @Autowired
    private JwtProperties jwtProperties;


    @Override
    public void refreshToken(JwtToken jwtToken, HttpServletResponse httpServletResponse) {

        if (null == jwtToken) {
            return;
        }
        String token = jwtToken.getToken();
        if (StringUtils.isEmpty(token)) {
            return;
        }
        // 判断是否刷新token
        boolean refreshToken = jwtProperties.isRefreshToken();
        if (!refreshToken) {
            return;
        }
        //获取过期时间
        Date expireDate = JwtUtil.getExpireDate(token);
        //获取倒计时
        Integer countDown = jwtProperties.getRefreshTokenCountDown();
        boolean refresh = DateUtils.addSeconds(new Date(), countDown).after(expireDate);
        if (!refresh) {
            return;
        }
        //如果token继续往后台发送，则给出提示，此token已经失效，请重新获取token，且不在返回新token，状态码为 6461
        //如果Redis 环迅中没有，JwtToken 没有过期，则说明，已经刷新token
        boolean exists = loginRedisService.exists(token);
        if (!exists) {
            httpServletResponse.setStatus(CommonConstant.JWT_INVALID_TOKEN_CODE);
            throw new AuthenticationException("Token已经失效，请使用新的token");
        }
        String name = jwtToken.getName();
        String salt = jwtToken.getSalt();
        Long expireSecond = jwtProperties.getExpireSecond();
        //生成新token 字符串
        String newToken = JwtUtil.generateToken(name, salt, Duration.ofSeconds(expireSecond));
        //生成新JwtToken对象
        JwtToken newJwtToken = JwtToken.build(newToken, name, salt, expireSecond);
        //更新redis缓存
        loginRedisService.refreshLoginInfo(token, name, newJwtToken);
        logger.info(">>>>>>>>>刷新token成功，原token:{}，新token:{}", token, newToken);
        //设置响应头  刷新token
        httpServletResponse.setStatus(CommonConstant.JWT_REFRESH_TOKEN_CODE);
        httpServletResponse.setHeader(JwtTokenUtil.getTokenName(), newToken);

    }
}
