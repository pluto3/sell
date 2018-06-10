package com.pluto.sell.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 结果异常状态
 * @author wangkai
 * @date 2017/11/26 21:06
 */
@Getter
@AllArgsConstructor
public enum ResultEnum {
    SUCCESS(0,"成功"),
    PARAM_ERROR(1,"参数不正确"),
    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_STOCK_ERROR(11,"商品库存不正确"),
    ORDER_NOT_EXIST(12,"订单不存在"),
    ORDERDETIAL_NOT_EXIST(13,"订单详情不存在"),
    ORDER_STATUS_ERROR(14,"订单状态不正确"),
    ORDER_UPDATE_FAIL(15,"订单更新失败"),
    ORDER_DETAIL_EMPTY(16,"订单详情为空"),
    ORDER_PAY_STATUS_ERROR(17,"订单支付状态不正确"),
    CART_EMPTY(18,"购物车为空"),
    ORDER_OWENR_ERROR(19,"该订单不属于当前用户"),
    ORDER_CANCLE_SUCCESS(22,"订单取消成功"),
    ;
    private Integer code;
    private String msg;
}
