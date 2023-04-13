package com.chenyu.meta.framework.util;

import com.chenyu.meta.framework.constant.CommonRedisKey;
import com.chenyu.meta.framework.shiro.util.JwtUtil;
import com.chenyu.meta.framework.shiro.vo.LoginSysUserRedisVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description:
 */
@Component
public class LoginUtil {


    private static RedisTemplate redisTemplate;

    public LoginUtil(RedisTemplate redisTemplate) {
        LoginUtil.redisTemplate = redisTemplate;
    }


    /**
     * 获取当前登录用户对象
     *
     * @return
     */
    public static LoginSysUserRedisVo getLoginSysUserRedisVo() {
        // 获取当前登录用户
        String token = JwtTokenUtil.getToken();
        String username = JwtUtil.getUsername(token);
        if (StringUtils.isBlank(username)) {
            return null;
        }
        return (LoginSysUserRedisVo) redisTemplate.opsForValue().get(String.format(CommonRedisKey.LOGIN_USER, username));
    }

    /**
     * 获取当前登录用户的ID
     *
     * @return
     */
    public static Long getUserId() {
        LoginSysUserRedisVo loginSysUserRedisVo = getLoginSysUserRedisVo();
        if (loginSysUserRedisVo == null) {
            return null;
        }
        return loginSysUserRedisVo.getId();
    }

    /**
     * 获取当前登录用户的账号
     *
     * @return
     */
    public static String getUsername() {
        LoginSysUserRedisVo loginSysUserRedisVo = getLoginSysUserRedisVo();
        if (loginSysUserRedisVo == null) {
            return null;
        }
        return loginSysUserRedisVo.getUsername();
    }



}
