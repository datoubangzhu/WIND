package com.guotai.entity;

import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

@TableName("purchasedinfo")
public class PurchasedInfo implements Serializable {
    private static final long serialVersionUID = -7040531624274313951L;

    /**
     * 购买编号
     */
    private String purchaseId;

    /**
     * 电脑编号
     */
    private String pcId;

    /**
     * 购买数量
     */
    private int num;

    /**
     * 订单总价
     */
    private int totalMoney;

    /**
     * 下单时间
     */
    private Date purchaseTime;

    /**
     * 物流状态
     */
    private String status;


    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getPcId() {
        return pcId;
    }

    public void setPcId(String pcId) {
        this.pcId = pcId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Date getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Date purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PurchasedInfo{" +
                "purchaseId='" + purchaseId + '\'' +
                ", pcId='" + pcId + '\'' +
                ", num=" + num +
                ", totalMoney=" + totalMoney +
                ", purchaseTime=" + purchaseTime +
                ", status='" + status + '\'' +
                '}';
    }
}

