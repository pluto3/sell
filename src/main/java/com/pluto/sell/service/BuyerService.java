package com.pluto.sell.service;

import com.pluto.sell.dto.OrderDTO;

/**
 * @author wangkai
 * @date 2017/12/5 10:44
 */
public interface BuyerService {
    //查询一个订单
    OrderDTO findOrderOne(String openid,String orderId);
    //取消一个订单
    OrderDTO cancelOrder(String openid,String orderId);

}
