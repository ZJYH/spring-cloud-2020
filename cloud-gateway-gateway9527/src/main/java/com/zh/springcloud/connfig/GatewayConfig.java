package com.zh.springcloud.connfig;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder rotes =builder.routes();
        rotes.route("path_route_nice",
                r->r.path("/guonei")
                        .uri("http://news.baidu.com/guonei")).build();
        return rotes.build();
    }

    @Bean
    public RouteLocator customRouteLocator2(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder rotes =builder.routes();
        rotes.route("path_route_good",r->r.path("/good").uri("http://fanyi.youdao.com/")).build();
        return rotes.build();
    }
}
