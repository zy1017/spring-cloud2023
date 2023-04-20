package com.zy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @BelongsProject: spring-cloud2023
 * @BelongsPackage: com.zy.springcloud
 * @Author: zuoyu
 * @CreateTime: 2023-02-20  20:36
 * @Description: TODO
 * @Version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class, args);
    }
}
