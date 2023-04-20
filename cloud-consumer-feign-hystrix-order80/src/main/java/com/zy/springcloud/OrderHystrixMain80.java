package com.zy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @BelongsProject: spring-cloud2023
 * @BelongsPackage: com.zy.springcloud
 * @Author: zuoyu
 * @CreateTime: 2023-02-28  20:52
 * @Description: TODO
 * @Version: 1.0
 */
@SpringBootApplication
//开启 OpenFeign 功能
@EnableFeignClients
@EnableEurekaClient
@EnableHystrix
public class OrderHystrixMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain80.class, args);
    }
}
