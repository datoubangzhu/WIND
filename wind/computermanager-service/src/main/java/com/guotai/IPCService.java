package com.guotai;

import com.baomidou.mybatisplus.service.IService;
import com.guotai.entity.PCInfo;

import java.util.List;

/**
 * 电脑商品接口
 */
public interface IPCService extends IService<PCInfo> {

    /**
     * 新增电脑商品
     *
     */
    void save(PCInfo pcInfo) throws Exception;

    /**
     * 获取电脑商品列表
     *
     * @return 电脑商品列表
     */
    List<PCInfo> list(String param);

    /**
     *  根据id删除
     */
    void deletePC(String pcId);
}
