package com.zy.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @BelongsProject: spring-cloud2023
 * @BelongsPackage: com.zy.springcloud.config
 * @Author: zuoyu
 * @CreateTime: 2023-02-21  17:40
 * @Description: TODO
 * @Version: 1.0
 */
@Configuration
public class ApplicationContextConfig {
    //@LoadBalanced // 赋予RestTemplate 负载均衡的能力
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
