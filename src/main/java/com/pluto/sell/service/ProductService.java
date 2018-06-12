package com.pluto.sell.service;

import com.pluto.sell.dataobject.ProductInfo;
import com.pluto.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangkai
 * @date 2017/11/20 21:49
 */
@Service
public interface ProductService {

    /**
     * 查询单个商品
     * @param productId 商品id
     * @return 单个商品详情
     */
    ProductInfo findOne(String productId);

    /**
     * 查询所有所有在架商品列表
     * @param pageable 分页对象
     * @return page对象
     */
    Page<ProductInfo> findAll(Pageable pageable);

    /**
     * 查询所有下架商品立标
     * @return 商品集合
     */
    List<ProductInfo> findUpAll();

    /**
     * 保存或更新
     * @param productInfo
     * @return 单个商品
     */
    ProductInfo save(ProductInfo productInfo);

    /**
     * 加库存
     * @param cartDTOList 购物车集合
     */
    void increaseStock(List<CartDTO> cartDTOList);

    /**
     * 减库存
     * @param cartDTOList 购物车集合
     */
    void decreaseStock(List<CartDTO> cartDTOList);

    /**
     * 上架
     * @param productId 商品id
     * @return 单个商品
     */
    ProductInfo onSale(String productId);

    /**
     * 下架
     * @param productId 商品id
     * @return 单个商品
     */
    ProductInfo offSale(String productId);
}
