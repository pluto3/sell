package com.pluto.sell.utils;

import com.pluto.sell.enums.CodeEnum;

/**
 * Create By wangkai
 * 2017/12/25 11:50
 */
public class EnumUtil {
    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
