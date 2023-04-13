package com.chenyu.meta.framework.shiro.service;

import com.chenyu.meta.framework.shiro.jwt.JwtToken;
import com.chenyu.meta.framework.shiro.vo.LoginSysUserRedisVo;
import com.chenyu.meta.framework.shiro.vo.LoginSysUserVo;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description: 登录信息 Redis缓存
 */
public interface LoginRedisService {


    /**
     * 缓存登录信息
     *
     * @param jwtToken
     * @param loginSysUserVo
     */
    void cacheLoginInfo(JwtToken jwtToken, LoginSysUserVo loginSysUserVo);

    /**
     * 刷新登录信息
     *
     * @param oldToken
     * @param username
     * @param newJwtToken
     */
    void refreshLoginInfo(String oldToken, String username, JwtToken newJwtToken);

    /**
     * 通过用户名，从缓存中获取登录用户LoginSysUserRedisVo
     *
     * @param username
     * @return
     */
    LoginSysUserRedisVo getLoginSysUserRedisVo(String username);

    /**
     * 根据token获取用户信息
     *
     * @param token
     * @return
     */
    LoginSysUserRedisVo getLoginSysUserByToken(String token);

    /**
     * 通过用户ID，从缓存中获取用户信息
     *
     * @param username
     * @return
     */
    LoginSysUserRedisVo getLoginSysUserByUserIdRedisVo(String username);

    /**
     * 获取登录用户对象
     *
     * @param username
     * @return
     */
    LoginSysUserVo getLoginSysUserVo(String username);

    /**
     * 通过用户名称获取盐值
     *
     * @param username
     * @return
     */
    String getSalt(String username);

    /**
     * 删除对应用户的Redis缓存
     *
     * @param token
     * @param username
     */
    void deleteLoginInfo(String token, String username);

    /**
     * 判断token在redis中是否存在
     *
     * @param token
     * @return
     */
    boolean exists(String token);


    /**
     * 删除用户所有登录缓存
     *
     * @param username
     */
    void deleteUserAllCache(String username);



}
