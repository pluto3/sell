package com.pluto.sell.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 商品状态
 * @author wangkai
 * @date 2017/11/20 22:08
 */
@Getter
@AllArgsConstructor
public enum ProductStatusEnum implements CodeEnum{
    UP(0,"在架"),
    DOWN(1,"下架")
    ;
    private Integer code;
    private String msg;

}
