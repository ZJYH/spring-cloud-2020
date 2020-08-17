package com.zh.springcloud.service;

import com.zh.springcloud.enetites.CommonResult;
import com.zh.springcloud.enetites.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "cloud-payment-service")
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")long id);

    @GetMapping(value = "/payment/timeOut")
    public String  PaymentTimeOut();
}
