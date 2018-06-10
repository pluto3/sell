package com.pluto.sell.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author wangkai
 * @date 2017/12/3 10:37
 */
@Data
public class OrderForm {
    /**
     * 卖家姓名
     */
    @NotEmpty(message = "姓名必填")
    private String name;
    /**
     * 卖家手机号
     */
    @NotEmpty(message = "手机号必填")
    private String phone;
    /**
     * 卖家地址
     */
    @NotEmpty(message = "地址必填")
    private String address;
    /**
     * 卖家微信openid
     */
    @NotEmpty(message = "openid必填")
    private String openid;
    /**
     * 买家购物车
     */
    @NotEmpty(message = "购物车不能为空")
    private String items;
}
