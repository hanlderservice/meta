package com.chenyu.meta.system.service;

import com.chenyu.meta.common.param.BaseParam;
import com.chenyu.meta.common.util.ApiResult;
import com.chenyu.meta.system.param.LoginParam;
import com.chenyu.meta.system.param.ResetPwdParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Create by 10296 on 2023/3/3
 *
 * @Description:
 */
public interface LoginService {

    /**
     * 用户登录
     *
     * @param loginParam
     * @param response
     * @return
     */
    ApiResult login(LoginParam loginParam, HttpServletResponse response);

    /**
     * 获取用户信息
     *
     * @param request
     * @param param
     * @param response
     * @return
     */
    ApiResult getUserInfo(HttpServletRequest request, BaseParam param, HttpServletResponse response);

    /**
     * 校验token
     *
     * @param token
     * @return
     */
    ApiResult verifyAuthToken(String token);

    /**
     * 重置密码
     *
     * @param resetPwdParam
     * @return
     */
    ApiResult resetPassword(ResetPwdParam resetPwdParam);

    /**
     * 忘记密码
     *
     * @param loginParam
     * @return
     */
    ApiResult forgetPassword(LoginParam loginParam);

    /**
     * 退出登录
     *
     * @param request
     * @return
     */
    ApiResult logout(HttpServletRequest request);


}
