package com.chenyu.meta.common.util;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description: 判断 mapper中条件传入是否为空
 */
public class Ognl {


    private static boolean isEmpty(Object o) throws IllegalArgumentException {
        if (o == null) {
            return true;
        }
        if (o instanceof String) {
            return StringUtils.isBlank((String) o);
        } else if (o instanceof Collection) {
            return ((Collection) o).isEmpty();
        } else if (o.getClass().isArray()) {
            return Array.getLength(o) == 0;
        } else if (o instanceof Map) {
            return ((Map) o).isEmpty();
        } else {
            return false;
        }

    }

    /**
     * 判断不为空
     *
     * @param o 传入参数
     * @return true 不为空；false 为空
     */
    public static boolean isNotEmpty(Object o) {
        return !isEmpty(o);
    }



}
