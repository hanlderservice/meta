package com.chenyu.meta.wechat.util;

import com.chenyu.meta.common.util.Sha1Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Create by 10296 on 2023/3/11
 *
 * @Description:
 */
@Component
public class WxUtils {



    private static final String TOKEN = "xhcljjj";


    /**
     * 验证签名
     *
     * @param signature 微信加密签名
     * @param timestamp 时间戳
     * @param nonce     随机数
     * @return
     */
    public static boolean checkSignature(String signature, String timestamp, String nonce) {
        //1）将token、timestamp、nonce三个参数进行字典序排序
        String[] str = new String[]{TOKEN, timestamp, nonce};
        Arrays.sort(str);
        // 2）将三个参数字符串拼接成一个字符串进行sha1加密

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            builder.append(str[i]);
        }
        String encode = Sha1Util.encode(builder.toString());

        // 3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信

        return signature.equals(encode);
    }

    /**
     * 验证签名
     *
     * @param signature 微信加密签名
     * @param timestamp 时间戳
     * @param nonce     随机数
     * @param token
     * @return
     */
    public static boolean checkSignature(String signature, String timestamp, String nonce, String token) {
        //1）将token、timestamp、nonce三个参数进行字典序排序
        String[] str;
        if (StringUtils.isNotEmpty(token)) {
            str = new String[]{token, timestamp, nonce};
        } else {
            str = new String[]{TOKEN, timestamp, nonce};
        }
        Arrays.sort(str);
        // 2）将三个参数字符串拼接成一个字符串进行sha1加密

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            builder.append(str[i]);
        }
        String encode = Sha1Util.encode(builder.toString());

        // 3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信

        return signature.equals(encode);
    }


}
