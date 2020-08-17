package com.zh.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String getOk(Integer id) {
        return "---id："+id+"----PaymentFallbackService,ok炸了555";
    }

    @Override
    public String getTimeOut(Integer id) {
        return "---id："+id+"----PaymentFallbackService,TimeOut炸了555";
    }
}
