package com.zh.springcloud.service;

import com.zh.springcloud.enetites.CommonResult;
import com.zh.springcloud.enetites.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> getPayment(Long id) {
        return new  CommonResult<Payment>(444,"挂了----PaymentFallbackService",
                new Payment(id,null));
    }
}
