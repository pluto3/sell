package com.pluto.sell.service.impl;

import com.pluto.sell.dataobject.SellerInfo;
import com.pluto.sell.repository.SellerInfoRepository;
import com.pluto.sell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangkai
 * @date 2018/6/14
 */
@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    private SellerInfoRepository repository;
    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }
}
