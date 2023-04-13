package com.chenyu.meta.common.util;

import java.util.UUID;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description:
 */
public class UUIDUtil {

    /**
     * 获取UUID
     *
     * @return
     */
    public static String getUuid() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid;

    }

}
