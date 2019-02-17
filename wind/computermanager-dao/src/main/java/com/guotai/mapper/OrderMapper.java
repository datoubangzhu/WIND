package com.guotai.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.guotai.entity.PurchasedInfo;

public interface OrderMapper extends BaseMapper<PurchasedInfo> {


    /**
     * 下单
     *
     * @param purchasedInfo 信息
     */
    void insertOrder(PurchasedInfo purchasedInfo);

}
