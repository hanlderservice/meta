package com.chenyu.meta.common.enums;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description: 枚举类型父接口
 */
public interface BaseEnum {
    /**
     * 获取枚举标识
     *
     * @return
     */
    Integer getCode();

    /**
     * 获取枚举描述
     *
     * @return
     */
    String getDesc();

    /**
     * 通过枚举类型和code值获取对应的枚举类型
     *
     * @param enumType
     * @param code
     * @param <T>
     * @return
     */
    static <T extends BaseEnum> T valueOf(Class<? extends BaseEnum> enumType, Integer code) {
        if (enumType == null || code == null) {
            return null;
        }
        T[] enumConstants = (T[]) enumType.getEnumConstants();
        if (enumConstants == null) {
            return null;
        }
        for (T enumConstant : enumConstants) {
            int enumCode = enumConstant.getCode();
            if (code.equals(enumCode)) {
                return enumConstant;
            }
        }
        return null;
    }
}

