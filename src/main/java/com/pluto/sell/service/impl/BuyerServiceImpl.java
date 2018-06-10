package com.pluto.sell.service.impl;

import com.pluto.sell.dto.OrderDTO;
import com.pluto.sell.enums.ResultEnum;
import com.pluto.sell.exception.SellException;
import com.pluto.sell.service.BuyerService;
import com.pluto.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangkai
 * @date 2017/12/5 10:47
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
      return checkOrderOwner(openid,orderId);
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openid, orderId);
        if(orderDTO==null){
            log.error("【取消订单】orderId{}",orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }

    private OrderDTO checkOrderOwner(String openid, String orderId){
        OrderDTO orderDTO = orderService.findOne(orderId);
        if(orderDTO==null){
            return null;
        }
        if(!orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)){
            log.error("【查询订单】订单openid不一致.openid{},orderDTO",openid,orderDTO);
            throw new SellException(ResultEnum.ORDER_OWENR_ERROR);
        }
        return orderDTO;
    }
}
