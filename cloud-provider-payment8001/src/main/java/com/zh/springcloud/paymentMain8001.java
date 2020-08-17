package com.zh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 *
 * <p>
 * Description:
 * </p>
 *
 * @author ZH
 * @version v1.0.0
 * @since 2020-07-07 10:15:04
 * @see com.zh.springcloud
 *
 */
@SpringBootApplication
@EnableEurekaClient //Eureka自己拥有服务保护机制，当有心跳包发送不及时的时候，
                    // 不会马上将服务清掉，会将其保留一段时间，然后再做决策
@EnableDiscoveryClient
public class paymentMain8001 {
    public static void main(String[] args){
        SpringApplication.run(paymentMain8001.class,args);
    }
}
