package com.pluto.sell.repository;

import com.pluto.sell.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wangkai
 * @date 2018/6/14
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {
    /**
     * 查询卖家信息
     * @param openid
     * @return
     */
    SellerInfo findByOpenid(String openid);


}
