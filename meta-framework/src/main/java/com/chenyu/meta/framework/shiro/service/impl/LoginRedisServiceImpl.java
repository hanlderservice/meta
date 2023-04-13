package com.chenyu.meta.framework.shiro.service.impl;

import com.chenyu.meta.common.util.HttpServletRequestUtil;
import com.chenyu.meta.config.properties.JwtProperties;
import com.chenyu.meta.framework.constant.CommonRedisKey;
import com.chenyu.meta.framework.domain.ClientInfo;
import com.chenyu.meta.framework.shiro.jwt.JwtToken;
import com.chenyu.meta.framework.shiro.service.LoginRedisService;
import com.chenyu.meta.framework.shiro.vo.LoginSysUserRedisVo;
import com.chenyu.meta.framework.shiro.vo.LoginSysUserVo;
import com.chenyu.meta.framework.util.ClientInfoUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.Set;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description:
 */
@Repository
@Service
public class LoginRedisServiceImpl implements LoginRedisService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JwtProperties jwtProperties;
    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    public void cacheLoginInfo(JwtToken jwtToken, LoginSysUserVo loginSysUserVo) {
        if (jwtToken == null) {
            throw new IllegalArgumentException("jwtToken不能为空");
        }
        if (loginSysUserVo == null) {
            throw new IllegalArgumentException("loginSysUserVo不能为空");
        }

        String token = jwtToken.getToken();
        String salt = jwtToken.getSalt();
        String username = loginSysUserVo.getUsername();
        String tokenMd5Hex = DigestUtils.md5Hex(token);

        ClientInfo clientInfo = ClientInfoUtil.get(HttpServletRequestUtil.getServletRequest());
        LoginSysUserRedisVo loginSysUserRedisVo = new LoginSysUserRedisVo();
        loginSysUserRedisVo.setClientInfo(clientInfo);
        loginSysUserRedisVo.setSalt(salt);
        loginSysUserRedisVo.setId(loginSysUserVo.getId());
        loginSysUserRedisVo.setUsername(loginSysUserVo.getUsername());
        loginSysUserRedisVo.setNickname(loginSysUserVo.getNickname());
        loginSysUserRedisVo.setGender(loginSysUserVo.getGender());
        loginSysUserRedisVo.setState(loginSysUserVo.getState());
        loginSysUserRedisVo.setDepartmentId(loginSysUserVo.getDepartmentId());
        loginSysUserRedisVo.setDepartmentName(loginSysUserVo.getDepartmentName());
        loginSysUserRedisVo.setRoleId(loginSysUserVo.getRoleId());
        loginSysUserRedisVo.setRoleName(loginSysUserVo.getRoleName());
        loginSysUserRedisVo.setRoleCode(loginSysUserVo.getRoleCode());
        loginSysUserRedisVo.setPermissionCodes(loginSysUserVo.getPermissionCodes());

        //Redis过期时间与JwtToken过期时间一致
        Duration duration = Duration.ofSeconds(jwtToken.getExpireSecond());
        //判断是否启用单点登录
        boolean singleLogin = jwtProperties.isSingleLogin();
        if (singleLogin) {
            deleteUserAllCache(username);
        }
        String tokenRedisKey = String.format(CommonRedisKey.LOGIN_TOKEN, tokenMd5Hex);
        redisTemplate.opsForValue().set(tokenRedisKey, jwtToken, duration);

        redisTemplate.opsForValue().set(String.format(CommonRedisKey.LOGIN_USER, username), loginSysUserRedisVo, duration);
        //根据token缓存用户信息
        redisTemplate.opsForValue().set(String.format(CommonRedisKey.LOGIN_TOKEN_USER, tokenMd5Hex), loginSysUserVo, duration);
        // 3. salt hash,方便获取盐值鉴权
        redisTemplate.opsForValue().set(String.format(CommonRedisKey.LOGIN_SALT, username), salt, duration);
        // 4. login user token
        redisTemplate.opsForValue().set(String.format(CommonRedisKey.LOGIN_USER_TOKEN, username, tokenMd5Hex), tokenRedisKey, duration);

    }

    @Override
    public void refreshLoginInfo(String oldToken, String username, JwtToken newJwtToken) {

        //获取缓存中的登录用户信息
        LoginSysUserRedisVo loginSysUserRedisVo = getLoginSysUserRedisVo(username);

        //删除之前的token
        deleteLoginInfo(oldToken, username);
        //缓存登录信息
        cacheLoginInfo(newJwtToken, loginSysUserRedisVo);
    }

    @Override
    public LoginSysUserRedisVo getLoginSysUserRedisVo(String username) {

        if (StringUtils.isEmpty(username)) {
            throw new IllegalArgumentException("username 不能为空!");
        }
        return (LoginSysUserRedisVo) redisTemplate.opsForValue().get(String.format(CommonRedisKey.LOGIN_USER, username));
    }

    @Override
    public LoginSysUserRedisVo getLoginSysUserByToken(String token) {
        if (StringUtils.isEmpty(token)) {
            throw new IllegalArgumentException("token 不能为空!");
        }
        String tokenMd5 = DigestUtils.md5Hex(token);
        return (LoginSysUserRedisVo) redisTemplate.opsForValue().get(String.format(CommonRedisKey.LOGIN_TOKEN_USER, tokenMd5));
    }

    @Override
    public LoginSysUserRedisVo getLoginSysUserByUserIdRedisVo(String username) {
        return null;
    }

    @Override
    public LoginSysUserVo getLoginSysUserVo(String username) {
        if (StringUtils.isEmpty(username)) {
            throw new IllegalArgumentException("username不能为空!");
        }
        return getLoginSysUserRedisVo(username);
    }

    @Override
    public String getSalt(String username) {
        if (StringUtils.isEmpty(username)) {
            throw new IllegalArgumentException("username 不能为空");
        }

        return (String) redisTemplate.opsForValue().get(String.format(CommonRedisKey.LOGIN_SALT, username));
    }

    @Override
    public void deleteLoginInfo(String token, String username) {
        if (StringUtils.isEmpty(token)) {
            throw new IllegalArgumentException("token 不能为空!");
        }
        if (StringUtils.isEmpty(username)) {
            throw new IllegalArgumentException("username 不能为空");
        }
        String tokenMd5 = DigestUtils.md5Hex(token);

        //1.delete tokenMd5
        redisTemplate.delete(String.format(CommonRedisKey.LOGIN_TOKEN, tokenMd5));
        // 2. delete username
        redisTemplate.delete(String.format(CommonRedisKey.LOGIN_USER, username));
        // 3. delete salt
        redisTemplate.delete(String.format(CommonRedisKey.LOGIN_SALT, username));
        // 4. delete user token
        redisTemplate.delete(String.format(CommonRedisKey.LOGIN_USER_TOKEN, username, tokenMd5));

    }

    @Override
    public boolean exists(String token) {
        if (StringUtils.isEmpty(token)) {
            throw new IllegalArgumentException(" token is Empty!");
        }
        String tokenMd5 = DigestUtils.md5Hex(token);
        Object o = redisTemplate.opsForValue().get(String.format(CommonRedisKey.LOGIN_TOKEN, tokenMd5));
        return o != null;
    }

    @Override
    public void deleteUserAllCache(String username) {

        Set keys = redisTemplate.keys(String.format(CommonRedisKey.LOGIN_USER_ALL_TOKEN, username));
        if (CollectionUtils.isEmpty(keys)) {
            return;
        }
        // 1. delete login user all token info
        List list = redisTemplate.opsForValue().multiGet(keys);

        redisTemplate.delete(list);
        // 2. delete all user user:token info
        redisTemplate.delete(keys);
        //3. delete login user info
        redisTemplate.delete(String.format(CommonRedisKey.LOGIN_USER, username));
        //4. delete login user salt info
        redisTemplate.delete(String.format(CommonRedisKey.LOGIN_SALT, username));


    }
}
