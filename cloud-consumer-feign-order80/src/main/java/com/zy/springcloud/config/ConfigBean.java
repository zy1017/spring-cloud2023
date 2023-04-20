package com.zy.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @BelongsProject: spring-cloud2023
 * @BelongsPackage: com.zy.springcloud.config
 * @Author: zuoyu
 * @CreateTime: 2023-02-27  20:57
 * @Description: TODO
 * @Version: 1.0
 *
 * Feign 日志增强
 */
@Configuration
public class ConfigBean {
    @Bean
    Logger.Level feginLoggerLevel(){
        return Logger.Level.FULL;
    }
}
