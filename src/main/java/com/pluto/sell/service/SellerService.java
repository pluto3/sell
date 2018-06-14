package com.pluto.sell.service;

import com.pluto.sell.dataobject.SellerInfo;

/**
 * 卖家端
 * @author wangkai
 * @date 2018/6/14
 */
public interface SellerService {
    /**
     * 通过openid查询卖家段信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}

