package com.zh.springcloud.controller;

import com.zh.springcloud.enetites.CommonResult;
import com.zh.springcloud.enetites.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    public static final  String PAYMENT_URL="http://cloud-providerconsul-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/get")
    public CommonResult<Payment> getPayment(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/consul",CommonResult.class);
    }
}
