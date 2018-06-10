package com.pluto.sell.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pluto.sell.dataobject.OrderDetail;
import com.pluto.sell.enums.OrderStatusEnum;
import com.pluto.sell.enums.PayStatusEnum;
import com.pluto.sell.utils.EnumUtil;
import com.pluto.sell.utils.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 订单 传输对象
 * @author wangkai
 * @date 2017/11/26 20:50
 */
@Data
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)过时
//@JsonInclude(JsonInclude.Include.NON_NULL)可以全局配置

public class OrderDTO {
    /**
     * 订单id.
     */
    private String orderId;
    /**
     * 买家名字.
     */
    private String buyerName;
    /**
     * 买家电话.
     */
    private String buyerPhone;
    /**
     * 买家地址.
     */
    private String buyerAddress;
    /**
     * 买家微信openid.
     */
    private String buyerOpenid;
    /**
     * 订单总金额.
     */
    private BigDecimal orderAmount;
    /**
     * 订单状态，默认0新下单.
     */
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();
    /**
     * 支付状态，默认0未支付.
     */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();
    /**
     * 创建时间.
     */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;
    /**
     * 修改时间.
     */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;
    /**
     * 订单详情集合 .
     */
    private List<OrderDetail> orderDetailList;

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum() {
        return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum() {
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);

    }
}
