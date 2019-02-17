package com.guotai.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.guotai.entity.PCInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PCInfoMapper extends BaseMapper<PCInfo> {

    /**
     * 根据name查找
     *
     * @return 电脑信息
     */
     List<PCInfo> listByName(@Param("param") String param);

    /**
     * 新增电脑信息数据
     *
     * @param pcInfo 信息
     */
     void insertPC(PCInfo pcInfo);
    /**
     * 更新电脑信息数据
     *
     * @param pcInfo 信息
     */
     void updatePC(PCInfo pcInfo);
    /**
     * 删除电脑信息
     *
     * @param pcId id
     */
     void deletePC(@Param("pcId") String pcId);
}
