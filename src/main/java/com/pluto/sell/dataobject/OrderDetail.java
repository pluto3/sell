package com.pluto.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * 订单详情表
 * Create By wangkai
 * 2017/11/23 21:34
 */
@Entity
@Data
public class OrderDetail {
    @Id
    private String detailId;
    /** 订单id. */
    private String orderId;
    /** 商品id. */
    private String productId;
    /** 商品名称. */
    private String productName;
    /** 商品价格. */
    private BigDecimal productPrice;
    /** 商品数量. */
    private Integer productQuantity;
    /** 商品小图. */
    private String productIcon;

}
