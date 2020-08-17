package com.zh.springcloud.controller;

import com.netflix.discovery.DiscoveryClient;
import com.zh.springcloud.enetites.CommonResult;
import com.zh.springcloud.enetites.Payment;
import com.zh.springcloud.service.PaymentService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Resource
    EurekaDiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String port;

    @PostMapping(value = "/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment){
        int rsult =paymentService.create(payment);
        log.info("接收数据为:"+payment);
        if(rsult>0){
            return new CommonResult<Integer>(200,"插入成功,port:"+port,rsult);
        }else {
            return new CommonResult<Integer>(444,"插入失败,port:"+port,rsult);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")long id){
        Payment payment =paymentService.getPaymentById(id);
        if(payment != null){
            return new CommonResult<Payment>(200,"查询成功, port:"+port,payment);
        }else {
            return new CommonResult<Payment>(444,"没有对应记录，id="+id+ ",port:"+port,null);
        }
    }
    @GetMapping("/discovery")
    public void discovery() {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("element:\t" + element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
    }

    @GetMapping(value = "/payment/lb")
    public String  getPaymentLB() {

        return port;
    }

    @GetMapping(value = "/payment/timeOut")
    public String PaymentTimeOut() {


        return port;
    }
}
