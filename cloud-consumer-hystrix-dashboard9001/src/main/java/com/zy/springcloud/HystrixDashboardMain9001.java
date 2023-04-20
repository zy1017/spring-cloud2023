package com.zy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @BelongsProject: spring-cloud2023
 * @BelongsPackage: com.zy.springcloud
 * @Author: zuoyu
 * @CreateTime: 2023-04-12  17:40
 * @Description: TODO
 * @Version: 1.0
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain9001.class, args);
    }
}
