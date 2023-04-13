package com.chenyu.meta.framework.shiro.jwt;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.chenyu.meta.common.util.IPUtils;
import com.chenyu.meta.framework.shiro.util.JwtUtil;
import org.apache.shiro.authc.HostAuthenticationToken;

import java.util.Date;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description:
 */
public class JwtToken implements HostAuthenticationToken {


    private static final long serialVersionUID = 7105826727901115883L;
    /**
     * 登录IP
     */
    private String host;
    /**
     * 登录用户名
     */
    private String name;
    /**
     * 登录盐值
     */
    private String salt;
    /**
     * 登录token
     */
    private String token;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 过期时长，默认1小时
     */
    private long expireSecond;
    /**
     * 过期日期
     */
    private Date expireDate;

    private String principal;

    private String credentials;


    @Override
    public String getHost() {
        return host;
    }


    public void setHost(String host) {
        this.host = host;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public long getExpireSecond() {
        return expireSecond;
    }

    public void setExpireSecond(long expireSecond) {
        this.expireSecond = expireSecond;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    public static JwtToken build(String token, String username, String salt, long expireSecond) {
        DecodedJWT decodedJWT = JwtUtil.getJwtInfo(token);
        Date createDate = decodedJWT.getIssuedAt();
        Date expiresDate = decodedJWT.getExpiresAt();
        JwtToken jwtToken = new JwtToken();
        jwtToken.setToken(token);
        jwtToken.setName(username);
        jwtToken.setHost(IPUtils.getRequestIP());
        jwtToken.setSalt(salt);
        jwtToken.setExpireDate(expiresDate);
        jwtToken.setCreateDate(createDate);
        jwtToken.setExpireSecond(expireSecond);
        return jwtToken;
    }


}
