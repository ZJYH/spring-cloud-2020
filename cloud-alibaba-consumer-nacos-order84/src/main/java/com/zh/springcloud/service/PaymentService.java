package com.zh.springcloud.service;

import com.zh.springcloud.enetites.CommonResult;
import com.zh.springcloud.enetites.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)
public interface PaymentService {
    @GetMapping(value = "/payment/Sentinel/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id")Long id);
}
