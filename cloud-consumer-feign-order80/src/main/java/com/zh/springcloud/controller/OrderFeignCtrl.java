package com.zh.springcloud.controller;


import com.zh.springcloud.enetites.CommonResult;
import com.zh.springcloud.enetites.Payment;
import com.zh.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderFeignCtrl {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")long id){

        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/timeOut")
    public String  PaymentTimeOut(){
        //openfeign 底层ribbon 默认处理业务1秒

        return paymentFeignService.PaymentTimeOut();
    }
}
