package com.zy.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @BelongsProject: spring-cloud2023
 * @BelongsPackage: com.zy.springcloud.service
 * @Author: zuoyu
 * @CreateTime: 2023-04-10  23:14
 * @Description: TODO
 * @Version: 1.0
 *
 * Hystrix 服务降级
 * 解耦回退逻辑
 */
//该类必须以组件的形式添加 Spring 容器中才能生效，最常用的方式就是在类上标注 @Component 注解。
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "--PaymentFallbackService fall back paymentInfo_OK /(ㄒoㄒ)/~~--";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "--paymentFallbackService fall back-payment_Timeout， /(ㄒoㄒ)/~~";
    }
}
