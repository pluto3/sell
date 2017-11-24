package com.pluto.sell.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Create By wangkai
 * 2017/11/23 21:28
 */
@Getter
@AllArgsConstructor
public enum PayStatusEnum {
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),
    ;
    private Integer code;
    private String msg;
}
