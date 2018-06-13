package com.pluto.sell.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author wangkai
 * @date 2018/6/12
 */
@Data
public class ProductForm {
    /**
     * 商品id
     */
    private String productId;

    /**
     * 名字.
     */
    @NotEmpty(message = "名字不能为空")
    private String productName;

    /**
     * 单价.
     */
    @NotNull(message = "单价不能为空")
    private BigDecimal productPrice;

    /**
     * 库存.
     */
    @NotNull(message = "库存不能为空")
    private Integer productStock;

    /**
     * 描述.
     */
    private String productDescription;

    /**
     * 小图.
     */
    private String productIcon;

    /**
     * 类目编号.
     */
    @NotNull(message = "类目编号不能为空")
    private Integer categoryType;
}
