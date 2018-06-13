package com.pluto.sell.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


/**
 * @author wangkai
 * @date 2018/6/13 22:39
 */
@Data
public class CategoryForm {
    /**
     * 类目id
     */
    private Integer categoryId;
    /**
     * 类目名字.
     */
    @NotEmpty(message = "类目名字不能为空")
    private String categoryName;
    /**
     * 类目编号.
     */
    @NotNull(message = "类目编号不能为空")
    private Integer categoryType;
}
