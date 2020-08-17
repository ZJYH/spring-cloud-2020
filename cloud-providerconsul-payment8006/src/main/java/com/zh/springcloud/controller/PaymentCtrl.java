package com.zh.springcloud.controller;

import com.zh.springcloud.enetites.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class PaymentCtrl {

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/payment/consul")
    public CommonResult<Integer> consul(){
        log.info("接收数据为:");
        return new CommonResult<Integer>(1123,"consul接受成功,port:"+port+" --- "+ UUID.randomUUID().toString());
    }

}
