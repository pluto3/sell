package com.pluto.sell.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 订单状态
 * @author wangkai
 * @date 2017/11/23 21:23
 */
@Getter
@AllArgsConstructor
public enum OrderStatusEnum implements CodeEnum {
    NEW(0,"新订单"),
    FINISHED(1,"完结"),
    CANCLE(2,"已取消"),
    ;
    private Integer code;
    private String msg;

}
