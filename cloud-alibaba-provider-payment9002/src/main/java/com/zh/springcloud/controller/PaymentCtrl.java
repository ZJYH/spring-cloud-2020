package com.zh.springcloud.controller;

import com.zh.springcloud.enetites.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class PaymentCtrl {

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/payment/nacos/{id}")
    public String  create(@PathVariable("id")Integer id){
        log.info("接收数据id为:"+id);
        return "nacos get id:"+id+"port:"+port;
    }
}
