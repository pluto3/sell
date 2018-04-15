package com.pluto.sell.controller;

import com.pluto.sell.dataobject.ProductCategory;
import com.pluto.sell.dataobject.ProductInfo;
import com.pluto.sell.service.CategoryService;
import com.pluto.sell.service.ProductService;
import com.pluto.sell.utils.ResultVOUtil;
import com.pluto.sell.VO.ProductInfoVO;
import com.pluto.sell.VO.ProductVO;
import com.pluto.sell.VO.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品
 * @author Create By wangkai
 * @date 2017/11/21 18:43
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list() {
        //1.查询所有上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        //2.查询类目（一次性查询）
        //List<Integer> categoryTypeList = new ArrayList<>();
        //传统方法
        // for(ProductInfo productInfo :productInfoList){
        // categoryTypeList.add(productInfo.getCategoryType());
        //  }
        //lambda方法
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        List<ProductVO> productVOList = new ArrayList<>();
        //3.数据拼装
        for (ProductCategory productcategory : categoryList) {

            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productcategory.getCategoryName());
            productVO.setCategoryType(productcategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productcategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }
}
