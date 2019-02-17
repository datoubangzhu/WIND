package com.guotai.controller;

import com.guotai.IPCService;
import com.guotai.entity.PCInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 电脑信息管理列表
 *
 * @author 赵贵明
 */
@RestController
@Slf4j
@RequestMapping("pc")
public class PCController {

    private final IPCService pcService;

    @Autowired
    public PCController(IPCService pcService) {
        this.pcService = pcService;
    }

    /**
     * 新增或更新电脑信息
     *
     * @return 电脑信息列表
     */
    @RequestMapping("save")
    public ResponseEntity add(@RequestBody PCInfo pcInfo) throws Exception {
        pcService.save(pcInfo);
        return ResponseEntity.ok().build();
    }


    /**
     * 获取电脑信息列表
     *
     * @return 电脑信息列表
     */
    @RequestMapping("list")
    public ResponseEntity listComputerGoods(@RequestParam String param){
       List<PCInfo> list = pcService.list(param);
       log.info("请求数据"+list.toString());
       return ResponseEntity.ok(list);
    }

    /**
     * 删除电脑信息
     *
     * @param pcId pcid
     * @return 是否删除成功
     */
    @GetMapping("delete")
    public ResponseEntity delete(@RequestParam String pcId){
        pcService.deletePC(pcId);
        return ResponseEntity.ok().build();
    }

}
