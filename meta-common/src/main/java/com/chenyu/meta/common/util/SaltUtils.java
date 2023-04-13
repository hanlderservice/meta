package com.chenyu.meta.common.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;

/**
 * Create by 10296 on 2023/3/10
 *
 * @Description: 盐值工具类
 */
public class SaltUtils {


    /**
     * 盐值包装
     *
     * @param secret 配置文件中配置的附加盐值
     * @param salt   数据库中保存的盐值
     * @return
     */
    public static String getSalt(String secret, String salt) {
        if (StringUtils.isBlank(secret) && StringUtils.isBlank(salt)) {
            return null;
        }
        // 加密方法
        String newSalt = DigestUtils.sha256Hex(secret + salt);
        return newSalt;
    }

    /**
     * 生成32位随机盐
     *
     * @return
     */
    public static String generateSalt() {
        return new SecureRandomNumberGenerator().nextBytes(16).toHex();
    }

    /**
     * 获取盐值 并加工
     *
     * @param salt
     * @param secret
     * @param saltCheck
     * @return
     */
    public static String getSalt(String salt, String secret, boolean saltCheck) {
        String newSalt;
        if (saltCheck) {
            // 包装盐值
            newSalt = SaltUtils.getSalt(secret, salt);
        } else {
            newSalt = secret;
        }
        return newSalt;
    }

}
