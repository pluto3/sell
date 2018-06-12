package com.pluto.sell.service.impl;

import com.pluto.sell.dataobject.OrderDetail;
import com.pluto.sell.dto.OrderDTO;
import com.pluto.sell.enums.OrderStatusEnum;
import com.pluto.sell.enums.PayStatusEnum;
import com.pluto.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Create By wangkai
 * 2017/11/27 21:58
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    private final String BUYER_OPENID = "12341234";
    private final String ORDER_ID = "1512266134270439087";
    @Autowired
    private OrderService orderService;

    @Test
    public void create() throws Exception {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("小秦");
        orderDTO.setBuyerAddress("丰台");
        orderDTO.setBuyerPhone("1342134");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("123456");
        orderDetail.setProductQuantity(2);
        orderDetailList.add(orderDetail);

        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);
        log.info("【创建订单】result{}", result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() throws Exception {
        OrderDTO result = orderService.findOne(ORDER_ID);
        log.info("【查询单个订单】result{}", result);
        Assert.assertEquals(ORDER_ID, result.getOrderId());
    }

    @Test
    public void findList() throws Exception {
        PageRequest request = new PageRequest(0, 2);
        Page<OrderDTO> result = orderService.findList(BUYER_OPENID, request);
        Assert.assertNotEquals(0, result.getTotalElements());
    }

    @Test
    public void cancel() throws Exception {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCEl.getCode(), result.getOrderStatus());
    }

    @Test
    public void finish() throws Exception {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(), result.getOrderStatus());
    }

    @Test
    public void paid() throws Exception {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.paid(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(), result.getPayStatus());
    }

    @Test
    public void list() {
        PageRequest request = new PageRequest(0, 2);
        Page<OrderDTO> result = orderService.findList(request);
        //Assert.assertNotEquals(0, result.getTotalElements());
        Assert.assertTrue("查询所有订单列表", result.getTotalElements() < 0);
    }

}