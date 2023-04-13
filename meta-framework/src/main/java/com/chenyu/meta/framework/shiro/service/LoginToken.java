package com.chenyu.meta.framework.shiro.service;

import java.io.Serializable;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description: 获取当前登录的token
 */
public interface LoginToken extends Serializable {

    /**
     * 获取登录token
     *
     * @return
     */
    String getToken();

}