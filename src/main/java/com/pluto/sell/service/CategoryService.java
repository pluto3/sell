package com.pluto.sell.service;

import com.pluto.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * @author wangkai
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
