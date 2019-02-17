package com.guotai.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.guotai.IPurchaseService;
import com.guotai.entity.PurchasedInfo;
import com.guotai.mapper.OrderMapper;
import org.springframework.stereotype.Service;

/**
 * 下单接口实现类
 */
@Service
public class PurchaseServiceImpl extends ServiceImpl<OrderMapper,PurchasedInfo> implements IPurchaseService {
    @Override
    public void submit(PurchasedInfo purchasedInfo) {
        baseMapper.insertOrder(purchasedInfo);
    }
}
