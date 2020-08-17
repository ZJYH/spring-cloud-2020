package com.zh.springcloud.controller;


import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zh.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class OrderHyrixController {


    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping(value = "/consumer/payment/hystrix/ok")
    public String getOk(@RequestParam("id") Integer id) {
        log.info("请求ok");
        return paymentHystrixService.getOk(id);
    }


    @GetMapping(value = "/consumer/payment/hystrix/timeOut/{id}")
    public String getTimeOut(@PathVariable("id") Integer id) {
        log.info("进到消费者80了");
        return paymentHystrixService.getTimeOut(id);
    }


}
