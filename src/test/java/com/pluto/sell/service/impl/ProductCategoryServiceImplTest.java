package com.pluto.sell.service.impl;

import com.pluto.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * Create By wangkai
 * 2017/11/20 20:24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceImplTest {
    @Autowired
    private CategoryServiceImpl productCategoryService;
    @Test
    public void findOne() throws Exception {
        ProductCategory productCategory = productCategoryService.findOne(5);
        Assert.assertEquals(new Integer(5),productCategory.getCategoryId());
    }

    @Test
    public void findAll() throws Exception {
        List<ProductCategory> productCategoryList = productCategoryService.findAll();
        Assert.assertNotEquals(0,productCategoryList.size());
    }

    @Test
    public void findByCategoryTypeIn() throws Exception {
        List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(Arrays.asList(1,2,3,4));
        Assert.assertNotEquals(0,productCategoryList.size());
    }

    @Test
    @Transactional
    public void save() throws Exception {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryType(23);
        productCategory.setCategoryName("冷菜");
        ProductCategory result = productCategoryService.save(productCategory);
        Assert.assertNotNull(result);
    }

}