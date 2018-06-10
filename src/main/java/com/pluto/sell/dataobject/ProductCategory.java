package com.pluto.sell.dataobject;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 * 种类
 * @author wangkai
 * @date 2017/11/20 20:47
 */
@Entity
@Data
public class ProductCategory {
    /**
     * 类目id.
     */
    @Id
    @GeneratedValue//主键
    private Integer categoryId;
    /**
     * 类目名字.
     */
    private String categoryName;
    /**
     * 类目编号.
     */
    private Integer categoryType;


}
