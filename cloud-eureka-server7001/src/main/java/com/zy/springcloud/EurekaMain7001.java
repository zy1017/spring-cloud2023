package com.zy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @BelongsProject: spring-cloud2023
 * @BelongsPackage: com.zy.springcloud.entities
 * @Author: zuoyu
 * @CreateTime: 2023-02-22  17:06
 * @Description: todo
 * @Version: 1.0
 */
@SpringBootApplication
//开启 Eureka server,接受其他微服务的注册
@EnableEurekaServer
public class EurekaMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class, args);
    }
}
