package com.pluto.sell.service.impl;

import com.pluto.sell.dataobject.ProductInfo;
import com.pluto.sell.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * Create By wangkai
 * 2017/11/20 22:17
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Autowired
    private ProductServiceImpl productInfoService;

    @Test
    public void findOne() throws Exception {
        ProductInfo productInfo = productInfoService.findOne("123456");
        Assert.assertEquals("123456", productInfo.getProductId());
    }

    @Test
    public void findAll() throws Exception {
        PageRequest pageRequest = new PageRequest(0, 3);
        Page<ProductInfo> productInfoPage = productInfoService.findAll(pageRequest);
        //System.out.println(productInfoPage.getTotalElements());
        Assert.assertNotEquals(0,productInfoPage.getSize());
    }

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> productInfoList = productInfoService.findUpAll();
        Assert.assertNotEquals(0, productInfoList.size());
    }

    @Test
    public void save() throws Exception {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123457");
        productInfo.setProductName("豆腐脑");
        productInfo.setProductPrice(new BigDecimal(4.5));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("好喝的豆腐脑");
        productInfo.setProductIcon("http://*****.png");
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
        productInfo.setCategoryType(2);
        ProductInfo result = productInfoService.save(productInfo);
        Assert.assertNotNull(result);
    }

}