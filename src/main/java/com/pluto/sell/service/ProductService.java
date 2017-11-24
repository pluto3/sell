package com.pluto.sell.service;

import com.pluto.sell.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create By wangkai
 * 2017/11/20 21:49
 */
@Service
public interface ProductService {

    ProductInfo findOne(String productId);

    /**
     * 查询所有所有在架商品列表
     * @return
     */
    Page<ProductInfo> findAll(Pageable pageable);

    List<ProductInfo> findUpAll();

    ProductInfo save(ProductInfo productInfo);

    //加库存
    //减库存
}
