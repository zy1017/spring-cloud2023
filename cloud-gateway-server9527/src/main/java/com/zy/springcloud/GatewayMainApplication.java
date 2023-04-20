package com.zy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @BelongsProject: spring-cloud2023
 * @BelongsPackage: PACKAGE_NAME
 * @Author: zuoyu
 * @CreateTime: 2023-04-20  15:50
 * @Description: TODO
 * @Version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayMainApplication.class, args);
    }
}
