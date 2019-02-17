package com.guotai.controller;

import com.guotai.IPurchaseService;
import com.guotai.entity.PurchasedInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {

public final IPurchaseService purchaseService;

    @Autowired
    public OrderController(IPurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    /**
     * 下单接口
     *
     * @param purchasedInfo 信息
     * @return 是否成功
     */
    @RequestMapping("submit")
    public ResponseEntity submit(PurchasedInfo purchasedInfo){
        purchaseService.submit(purchasedInfo);
        return ResponseEntity.ok().build();
    }

}
