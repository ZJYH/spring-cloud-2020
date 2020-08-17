package com.zh.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zh.springcloud.enetites.CommonResult;
import com.zh.springcloud.enetites.Payment;
import com.zh.springcloud.myhandler.CustomerBlocker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.java2d.loops.CustomComponent;

@RestController
public class RateLimitController {
    @GetMapping(value = "/byResource")
    @SentinelResource(value = "byResource",blockHandler = "deal_byResource")
    public CommonResult<String> byResource(String s) {

            return new CommonResult<String>(200, "调用成功,data:" +s);
    }

    //必须要带一个参数BlockException
    public CommonResult<String> deal_byResource(String s, BlockException b){

        return new CommonResult<String>(444, "调用失败,data:"+b.getClass().getCanonicalName(),s);
    }

    @GetMapping(value = "/api/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult<String> byUrl(String s) {

        return new CommonResult<String>(200, "调用成功,data:" +s);
    }

    @GetMapping(value = "/api/customerBlocker")
    @SentinelResource(value = "customerBlocker",blockHandlerClass = CustomerBlocker.class, blockHandler ="handlerException2")
    public CommonResult<String> customerBlocker(String s) {
        return new CommonResult<String>(200, "调用成功,data:" +s);
    }
}
