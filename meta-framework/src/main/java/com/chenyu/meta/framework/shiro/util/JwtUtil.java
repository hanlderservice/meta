package com.chenyu.meta.framework.shiro.util;

import com.alibaba.fastjson2.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.chenyu.meta.common.util.UUIDUtil;
import com.chenyu.meta.config.properties.JwtProperties;
import com.chenyu.meta.framework.constant.CommonConstant;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Date;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description:
 */
@Component
public class JwtUtil {


    private static Logger logger = LoggerFactory.getLogger(JwtUtil.class);


    private static JwtProperties jwtProperties;


    public JwtUtil(JwtProperties jwtProperties) {
        JwtUtil.jwtProperties = jwtProperties;
        logger.info("初始化 jwtProperties：：： " + JSONObject.toJSONString(jwtProperties));
    }

    /**
     * 生成 JWT Token
     *
     * @param userName       用户名
     * @param salt           盐值
     * @param expireDuration 过期时间和单位
     * @return token
     */
    public static String generateToken(String userName, String salt, Duration expireDuration) {
        try {
            if (StringUtils.isEmpty(userName)) {
                logger.error("username 不能为空！");
                return null;
            }
            logger.info("username:{}", userName);
            if (StringUtils.isEmpty(salt)) {
                salt = jwtProperties.getSecret();
            }
            logger.info("salt:{}", salt);
            Long expireSecond;
            if (expireDuration == null) {
                expireSecond = jwtProperties.getExpireSecond();
            } else {
                expireSecond = expireDuration.getSeconds();
            }
            logger.info("expireSecond:{}", expireSecond);
            Date expireDate = DateUtils.addSeconds(new Date(), expireSecond.intValue());
            logger.info("expireDate:{}", expireDate);
            Algorithm algorithm = Algorithm.HMAC256(salt);
            String token = JWT.create()
                    .withClaim(CommonConstant.JWT_USERNAME, userName)
                    //jwt 唯一id
                    .withJWTId(UUIDUtil.getUuid())
                    // 签发人
                    .withIssuer(jwtProperties.getIssuer())
                    // 主题
                    .withSubject(jwtProperties.getSubject())
                    //签发目标
                    .withAudience(jwtProperties.getAudience())
                    //签名时间
                    .withIssuedAt(new Date())
                    //token过期时间
                    .withExpiresAt(expireDate)
                    //签名
                    .sign(algorithm);
            return token;
        } catch (Exception e) {
            logger.error(">>>>>>generate Token Exception", e);
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 校验 Token
     *
     * @param token token
     * @param salt  盐值
     * @return b
     */
    public static boolean verifyToken(String token, String salt) {
        logger.info(jwtProperties + "<<<<<<<<<verifyToken>>>>>>>>>>>>>>");
        try {
            Algorithm algorithm = Algorithm.HMAC256(salt);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(jwtProperties.getIssuer())
                    .withSubject(jwtProperties.getSubject())
                    .withAudience(jwtProperties.getAudience())
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            if (jwt != null) {
                return true;
            }
        } catch (IllegalArgumentException e) {
            logger.error("verify  Token IllegalArgumentException", e);
            e.printStackTrace();
        } catch (Exception e) {
            logger.error("verify  Token Exception", e);
            e.printStackTrace();
        }

        return false;
    }

    /**
     * 解析token，获取token 数据
     *
     * @param token
     * @return
     */
    public static DecodedJWT getJwtInfo(String token) {
        logger.info(">>>>>>>>>>>>{}", token);
        return JWT.decode(token);
    }

    /**
     * 获取用户名
     *
     * @param token
     * @return
     */
    public static String getUsername(String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        DecodedJWT decodedJWT = getJwtInfo(token);
        if (decodedJWT == null) {
            return null;
        }
        String username = decodedJWT.getClaim("username").asString();
        return username;
    }

    /**
     * 获取创建时间
     *
     * @param token
     * @return
     */
    public static Date getIssuedAt(String token) {
        DecodedJWT decodedJWT = getJwtInfo(token);
        if (decodedJWT == null) {
            return null;
        }
        return decodedJWT.getIssuedAt();
    }

    /**
     * 获取过期时间
     *
     * @param token
     * @return
     */
    public static Date getExpireDate(String token) {
        DecodedJWT decodedJWT = getJwtInfo(token);
        if (decodedJWT == null) {
            return null;
        }
        return decodedJWT.getExpiresAt();
    }

    /**
     * 判断token是否已过期
     *
     * @param token
     * @return
     */
    public static boolean isExpired(String token) {
        Date expireDate = getExpireDate(token);
        if (expireDate == null) {
            return true;
        }
        return expireDate.before(new Date());
    }


}
