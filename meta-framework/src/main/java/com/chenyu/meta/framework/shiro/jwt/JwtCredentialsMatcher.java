package com.chenyu.meta.framework.shiro.jwt;

import com.chenyu.meta.framework.shiro.util.JwtUtil;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description: JWT证书匹配
 */
public class JwtCredentialsMatcher implements CredentialsMatcher {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean doCredentialsMatch(AuthenticationToken authenticationToken, AuthenticationInfo authenticationInfo) {
        try {
            String token = authenticationToken.getCredentials().toString();
            String salt = authenticationInfo.getCredentials().toString();
            return JwtUtil.verifyToken(token, salt);
        } catch (Exception e) {
            logger.error(">>>>>>>>>JWT Token CredentialsMatch Exception:" + e.getMessage(), e);
            e.printStackTrace();
        }

        return false;
    }
}
