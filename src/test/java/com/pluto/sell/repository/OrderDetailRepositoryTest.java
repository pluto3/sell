package com.pluto.sell.repository;

import com.pluto.sell.dataobject.OrderDetail;
import com.pluto.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.AccessibleObject;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Create By wangkai
 * 2017/11/26 20:30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {
    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest(){
        OrderDetail orderDetail = new  OrderDetail();
        orderDetail.setDetailId("1234348");
        orderDetail.setOrderId("111334");
        orderDetail.setProductIcon("https://xxxx.jpg");
        orderDetail.setProductId("13422341");
        orderDetail.setProductName("油条");
        orderDetail.setProductPrice(new BigDecimal(4.5));
        orderDetail.setProductQuantity(2);

        OrderDetail result = repository.save(orderDetail);

        Assert.assertNotNull(result);
    }
    @Test
    public void findByOrderId() throws Exception {
        List<OrderDetail> orderDetails = repository.findByOrderId("111334");
        Assert.assertNotEquals(0,orderDetails.size());
    }

}