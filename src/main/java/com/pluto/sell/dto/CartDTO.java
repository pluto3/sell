package com.pluto.sell.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 购物车 传输对象
 * @author wangkai
 * @date 2017/11/26 21:57
 */
@Data
@AllArgsConstructor
public class CartDTO {
    //商品id
    private String productId;
    //数量
    private Integer productQuantity;
}
