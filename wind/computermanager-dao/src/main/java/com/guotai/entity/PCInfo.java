package com.guotai.entity;

import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("pcinfo")
public class PCInfo implements Serializable {

    private static final long serialVersionUID = -4425183612757154440L;
    /**
     * 电脑编号iid
     */

    private String pcId;

    /**
     * 电脑品牌
     */
    private int brand;

    /**
     * 电脑名称
     */
    private String pcName;

    /**
     * 操作系统
     */
    private int os;

    /**
     * 价格
     */
    private int price;

    /**
     * 已购数量
     */
    private int amount;

    public String getPcId() {
        return pcId;
    }

    public void setPcId(String pcId) {
        this.pcId = pcId;
    }

    public int getBrand() {
        return brand;
    }

    public void setBrand(int brand) {
        this.brand = brand;
    }

    public String getPcName() {
        return pcName;
    }

    public void setPcName(String pcName) {
        this.pcName = pcName;
    }

    public int getOs() {
        return os;
    }

    public void setOs(int os) {
        this.os = os;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PCInfo{" +
                "pcId='" + pcId + '\'' +
                ", brand=" + brand +
                ", pcName='" + pcName + '\'' +
                ", os=" + os +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
