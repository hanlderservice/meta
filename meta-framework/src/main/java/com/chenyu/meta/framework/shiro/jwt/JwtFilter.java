package com.chenyu.meta.framework.shiro.jwt;

import com.chenyu.meta.common.util.ApiCode;
import com.chenyu.meta.common.util.ApiResult;
import com.chenyu.meta.common.util.HttpServletResponseUtil;
import com.chenyu.meta.config.properties.JwtProperties;
import com.chenyu.meta.framework.shiro.service.LoginRedisService;
import com.chenyu.meta.framework.shiro.service.ShiroLoginService;
import com.chenyu.meta.framework.shiro.util.JwtUtil;
import com.chenyu.meta.framework.util.JwtTokenUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description: Shiro JWT授权过滤器
 */
public class JwtFilter extends AuthenticatingFilter {

    private Logger logger = LoggerFactory.getLogger(JwtFilter.class);
    private ShiroLoginService shiroLoginService;

    private LoginRedisService loginRedisService;
    private JwtProperties jwtProperties;

    public JwtFilter(ShiroLoginService shiroLoginService, LoginRedisService loginRedisService, JwtProperties jwtProperties) {
        this.shiroLoginService = shiroLoginService;
        this.loginRedisService = loginRedisService;
        this.jwtProperties = jwtProperties;
    }

    /**
     * 将JWT Token包装成AuthenticationToken
     *
     * @param servletRequest
     * @param servletResponse
     * @return
     * @throws Exception
     */
    @Override
    protected AuthenticationToken createToken(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {

        String token = JwtTokenUtil.getToken();
        if (StringUtils.isEmpty(token)) {
            throw new AuthenticationException(" token不能为空！");
        }
        if (JwtUtil.isExpired(token)) {
            throw new AuthenticationException(" JWT Token 已过期，token:" + token);
        }
        //如果开启Redis二次校验，或者设置为单个用户token登录，则先在Redis中判断token是否存在
        if (jwtProperties.isRedisCheck() || jwtProperties.isSingleLogin()) {
            boolean exists = loginRedisService.exists(token);
            if (!exists) {
                throw new AuthenticationException("Redis Token 不存在，Token：" + token);
            }

        }
        String username = JwtUtil.getUsername(token);
        String salt = "";
        if (jwtProperties.isSaltCheck()) {
            salt = loginRedisService.getSalt(username);
        } else {
            salt = jwtProperties.getSecret();
        }


        return JwtToken.build(token, username, salt, jwtProperties.getExpireSecond());
    }

    /**
     * 访问失败处理
     *
     * @param servletRequest
     * @param servletResponse
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        HttpServletRequest httpServletRequest = WebUtils.toHttp(servletRequest);
        HttpServletResponse httpServletResponse = WebUtils.toHttp(servletResponse);
        //返回码
        httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        //设置响应码为401 或者直接输出 消息
        String requestURI = httpServletRequest.getRequestURI();
        logger.error("onAccessDenied url：{}", requestURI);
        ApiResult<Boolean> apiResult = ApiResult.fail(ApiCode.UNAUTHORIZED);
        HttpServletResponseUtil.printJson(httpServletResponse, apiResult);

        return false;
    }

    /**
     * 判断是否允许访问
     *
     * @param request
     * @param response
     * @param mappedValue
     * @return
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        String requestURI = WebUtils.toHttp(request).getRequestURI();
        logger.info(">>>>>>>>isAccessAllowed url:{} ", requestURI);

        if (this.isLoginRequest(request, response)) {
            return true;
        }
        boolean allowed = false;

        try {
            allowed = executeLogin(request, response);


        } catch (Exception e) {
            logger.error(">>>>>>>访问错误：", e);
            e.printStackTrace();
        }


        return allowed || super.isPermissive(mappedValue);

    }

    /**
     * 登录成功处理
     *
     * @param token
     * @param subject
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        String requestURI = WebUtils.toHttp(request).getRequestURI();
        logger.info(">>>>>>鉴权成功,token:{},url:{}", token, requestURI);
//刷新token
        JwtToken jwtToken = (JwtToken) token;
        HttpServletResponse httpServletResponse
                = WebUtils.toHttp(response);
        shiroLoginService.refreshToken(jwtToken, httpServletResponse);

        return true;
    }

    /**
     * 登录失败处理
     *
     * @param token
     * @param e
     * @param request
     * @param response
     * @return
     */
    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        logger.error(">>>>>>登录失败！，token" + token + ",error info:" + e.getMessage(), e);


        return super.onLoginFailure(token, e, request, response);
    }
}
