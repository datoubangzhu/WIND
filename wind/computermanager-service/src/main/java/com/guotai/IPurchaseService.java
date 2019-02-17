package com.guotai;

import com.baomidou.mybatisplus.service.IService;
import com.guotai.entity.PurchasedInfo;

/**
 * 下单接口
 */
public interface IPurchaseService extends IService<PurchasedInfo> {

    /**
     * 下单接口
     *
     * @param purchasedInfo 下单信息
     */
    void submit(PurchasedInfo purchasedInfo);

}
