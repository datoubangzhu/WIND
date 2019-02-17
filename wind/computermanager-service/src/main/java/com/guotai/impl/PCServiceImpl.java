package com.guotai.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.guotai.IPCService;
import com.guotai.entity.PCInfo;
import com.guotai.mapper.PCInfoMapper;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PCServiceImpl extends ServiceImpl<PCInfoMapper,PCInfo> implements IPCService {

    @Override
    public void save(PCInfo pcInfo) throws Exception {
        final String pcId = pcInfo.getPcId();
        if(StringUtils.isNotEmpty(pcId)){
            updatePC(pcInfo);
            return;
        }
        List<PCInfo> list = this.list(null);
        Set<String> pcName = new HashSet<>();
        for(PCInfo pc : list){
            pcName.add(pc.getPcName());
        }
        boolean ok = pcName.contains(pcInfo.getPcName());
        if(ok){
            throw new Exception("商品名称重复！");
        }
        pcInfo.setPcId(getUuid());
        baseMapper.insertPC(pcInfo);
    }

    /**
     * 更新电脑信息
     *
     * @param pcInfo 信息
     */
    private void updatePC(PCInfo pcInfo){
         baseMapper.updatePC(pcInfo);
    }

    @Override
    public List<PCInfo> list(String param) {
        String paramValue = param;
        int value = overrideFromBrandName(param);
        if(value!=0){
               paramValue = String.valueOf(value);
        }
        return baseMapper.listByName(paramValue);
    }

    @Override
    public void deletePC(String pcId) {
        //判断是否有送递中的数据
        baseMapper.deletePC(pcId);
    }

    /**
     * 获取唯一主键
     *
     * @return 主键序列号
     */
    private static String getUuid() {
        return  UUID.randomUUID().toString().replaceAll("-", "");
    }

    private int overrideFromBrandName(String param){
        int value = 0;
        if(StringUtils.isEmpty(param)){
            return value;
        }
        switch (param){
            case "华为" : value = 1;
            break;
            case "华硕": value = 2;
            break;
            case "戴尔" :value = 3;
            break;
            case "小米" :value = 4;
            default:
        }
        return value;
    }

}
