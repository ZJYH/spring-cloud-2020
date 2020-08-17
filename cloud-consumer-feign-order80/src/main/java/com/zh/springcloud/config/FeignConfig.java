package com.zh.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 *
 * <p>
 * Description:
 * </p>
 *
 * @author ZH
 * @version v1.0.0
 * @since 2020-07-09 22:16:30
 * @see com.zh.springcloud.config
 *
 */
@Configuration
public class FeignConfig {

    @Bean
    public Logger.Level feignLoggerLevel() {
        // 请求和响应的头信息,请求和响应的正文及元数据
        return Logger.Level.FULL;
    }
}
