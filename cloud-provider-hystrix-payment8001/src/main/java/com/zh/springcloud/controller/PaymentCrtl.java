package com.zh.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zh.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
@Slf4j
@RestController
public class PaymentCrtl {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;


    @GetMapping(value = "/payment/hystrix/ok")
    public String getOk(@RequestParam("id") Integer id) {
        log.info("请求ok");
        return paymentService.getOk(id);
    }

    @GetMapping(value = "/payment/hystrix/timeOut/{id}")
    public String getTimeOut(@PathVariable("id") Integer id) {
        log.info("等待1秒");
        return paymentService.getTimeOut(id);
    }

    /**
     * 服务熔断
     * http://localhost:8001/payment/circuit/1
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/circuit/{id}")
    @HystrixCommand
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("***result:" + result);
        return result;
    }
}
