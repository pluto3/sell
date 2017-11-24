package com.pluto.sell.repository;

import com.pluto.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void findOne() {
        ProductCategory productCategory = productCategoryRepository.findOne(1);
        //System.out.println(productCategory.toString());
        Assert.assertEquals(new Integer(1),productCategory.getCategoryId());
    }

    @Test
    @Transactional//数据库不保留数据
    public void save(){
        ProductCategory productCategory =productCategoryRepository.findOne(2);
        productCategory.setCategoryId(2);
        productCategory.setCategoryName("消淤化痰");
        productCategory.setCategoryType(3);
        ProductCategory result = productCategoryRepository.save(productCategory);
        //Assert.assertNotEquals(null,result);
        Assert.assertNotNull(result);
    }
    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> list = Arrays.asList(2,3,4);
        List<ProductCategory> result = productCategoryRepository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());
    }
}