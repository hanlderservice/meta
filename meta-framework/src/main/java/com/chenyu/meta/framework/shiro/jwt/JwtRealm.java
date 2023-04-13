package com.chenyu.meta.framework.shiro.jwt;

import com.chenyu.meta.framework.shiro.service.LoginRedisService;
import com.chenyu.meta.framework.shiro.vo.LoginSysUserRedisVo;
import org.apache.commons.collections4.SetUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description: shiro 授权认证
 */
public class JwtRealm extends AuthorizingRealm {

    private Logger logger = LoggerFactory.getLogger(JwtRealm.class);

    private LoginRedisService loginRedisService;

    public JwtRealm(LoginRedisService loginRedisService) {
        this.loginRedisService = loginRedisService;
    }


    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;

    }

    /**
     * 授权认证，设置角色/权限信息
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info(">>>>>>>>>>>doGetAuthorizationInfo principalCollection  start ... ");
        //set role/auth info
        JwtToken jwtToken = (JwtToken) principalCollection.getPrimaryPrincipal();

        // get  username
        String name = jwtToken.getName();
        //get  login user info role auth info
        LoginSysUserRedisVo loginSysUserRedisVo = loginRedisService.getLoginSysUserRedisVo(name);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        // set role
        authorizationInfo.setRoles(SetUtils.hashSet(loginSysUserRedisVo.getRoleCode()));
        //set  auth
        authorizationInfo.setStringPermissions(loginSysUserRedisVo.getPermissionCodes());

        return authorizationInfo;
    }

    /**
     * 登录认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info(">>>>>>>>>doGetAuthenticationInfo authenticationToken start.... ");
// auth token
        JwtToken jwtToken = (JwtToken) authenticationToken;

        if (null == jwtToken) {
            throw new AuthenticationException(" jwtToken 不能为空！");
        }
        String salt = jwtToken.getSalt();
        if (StringUtils.isEmpty(salt)) {
            throw new AuthenticationException("jwtToken 不能为空!");
        }
        return new SimpleAuthenticationInfo(jwtToken, salt, getName());

    }
}
