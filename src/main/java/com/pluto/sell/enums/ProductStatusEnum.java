package com.pluto.sell.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 商品状态
 * Create By wangkai
 * 2017/11/20 22:08
 */
@Getter
@AllArgsConstructor
public enum ProductStatusEnum {
    UP(0,"在线"),
    DOWN(1,"下架")
    ;
    private Integer code;
    private String message;

}
