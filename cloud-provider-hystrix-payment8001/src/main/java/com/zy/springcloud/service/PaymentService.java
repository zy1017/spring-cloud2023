package com.zy.springcloud.service;

import org.springframework.stereotype.Service;

/**
 * @BelongsProject: spring-cloud2023
 * @BelongsPackage: com.zy.service
 * @Author: zuoyu
 * @CreateTime: 2023-02-28  19:36
 * @Description: TODO
 * @Version: 1.0
 */

public interface PaymentService {

    String paymentInfo_OK(Integer id);

    String paymentInfo_TimeOut(Integer id);
    // Hystrix 熔断机制案例
    String paymentInfo_CircuitBreaker(Integer id);
}
