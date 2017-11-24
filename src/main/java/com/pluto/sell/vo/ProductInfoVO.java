package com.pluto.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 商品详情
 * Create By wangkai
 * 2017/11/21 19:33
 */
@Data
public class ProductInfoVO {
    @JsonProperty("id")
    private String productId;
    @JsonProperty("name")
    private String productName;
    @JsonProperty("price")
    private BigDecimal productPrice;
    @JsonProperty("description")
    private  String procuctDescription;
    @JsonProperty("icon")
    private String productIcon;

}
