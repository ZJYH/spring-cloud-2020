package com.zh.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class FlowLimitCtrl {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/testA")
    public String testA(){
        String s =restTemplate.getForObject("http://localhost:8401/testC",String.class);
        return "-----testA"+s ;
    }

    @GetMapping("/testB")
    public String testB(){
        log.info("nnnnnn");
        return "-----testB";
    }

    @GetMapping("/testC")
    public String testC(){
        return "我的c";
    }

    @GetMapping("/testD")
    public String testD(){
        log.info("testD: 异常比例");
        int s =10/0;
        return "我的d";
    }

    @GetMapping("/testE")
    public String testE(){
        log.info("testE: 异常数");
        int s =10/0;
        return "我的E";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam (value = "p1",required = false)String p1,
                             @RequestParam (value = "p2",required = false)String p2){
        log.info("testE: 异常数");
        int s =10/0;
        return "我的p1,p2: "+p1+"-----"+p2;
    }

    public String deal_testHotKey(String p1, String p2, BlockException ex){
        return "deal_testHotKey,难受";
    }

}
