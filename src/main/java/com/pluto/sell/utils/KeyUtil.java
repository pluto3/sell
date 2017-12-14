package com.pluto.sell.utils;

import java.util.Random;

/**
 * Create By wangkai
 * 2017/11/26 21:33
 */
public class KeyUtil {
    /**
     * 生成唯一的主键
     * 格式：时间+随机数
     * @return
     */
    public static String genUniqueKey(){
        Random randow = new Random();
        Integer number = randow.nextInt(900000) + 100000;
        return System.currentTimeMillis()+String.valueOf(number);

    }
}
