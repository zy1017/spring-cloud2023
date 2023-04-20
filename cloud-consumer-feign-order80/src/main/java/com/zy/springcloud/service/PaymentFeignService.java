package com.zy.springcloud.service;

import com.zy.springcloud.entities.CommonResult;
import com.zy.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @BelongsProject: spring-cloud2023
 * @BelongsPackage: com.zy.springcloud
 * @Author: zuoyu
 * @CreateTime: 2023-02-24  21:23
 * @Description: TODO
 * @Version: 1.0
 */
//添加为容器内的一个组件
@Component
// 服务提供者提供的服务名称，即 application.name
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    //对应服务提供者（8001、8002）Controller 中定义的方法
    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/feign/timeout")
    String paymentFeignTimeout();
}
