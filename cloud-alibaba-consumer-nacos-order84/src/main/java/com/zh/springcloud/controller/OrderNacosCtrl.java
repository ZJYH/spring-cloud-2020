package com.zh.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zh.springcloud.enetites.CommonResult;
import com.zh.springcloud.enetites.Payment;
import com.zh.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@Slf4j
public class OrderNacosCtrl {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverUrl;

    @GetMapping("/consumer/sentinel/{id}")
   // @SentinelResource(value = "fallback",fallback = "handlerFallback")
    //@SentinelResource(value = "byResource",blockHandler = "deal_byResource")
    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "deal_byResource",
    exceptionsToIgnore = IllegalArgumentException.class)//忽略非法参数的异常
    public CommonResult<Payment> paymentInfo(@PathVariable("id") Long id) {
        CommonResult<Payment> result = restTemplate.getForObject(serverUrl + "/payment/Sentinel/" + id, CommonResult.class);
        if(4==id){
            throw new IllegalArgumentException("非法参数");
        }else if(result.getData()==null){
            throw new NullPointerException("查询不存在");
        }
        return result;
    }

    //fallback的回调方法
    public CommonResult<Payment> handlerFallback(@PathVariable("id") Long id,Throwable e) {
        Payment payment =new Payment(id,null);
        return new CommonResult<>(502,"程序异常："+e.getMessage(),payment);
    }

    //Sentinel的限流回调方法，必须要带一个参数BlockException
    public CommonResult<String> deal_byResource(@PathVariable("id") Long id, BlockException b){

        return new CommonResult<String>(433, "调用失败,data:"+b.getClass().getCanonicalName());
    }

    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/paymentService/{id}")
    public CommonResult<Payment> paymentService(@PathVariable("id") Long id){

        return paymentService.getPayment(id);
    }
}
