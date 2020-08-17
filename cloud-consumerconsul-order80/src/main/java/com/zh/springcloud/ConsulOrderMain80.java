package com.zh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsulOrderMain80 {
    public static void main(String[] args){
        SpringApplication.run(ConsulOrderMain80.class,args);
    }
}
