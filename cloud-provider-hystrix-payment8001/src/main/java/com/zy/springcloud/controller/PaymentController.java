package com.zy.springcloud.controller;

import com.zy.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: spring-cloud2023
 * @BelongsPackage: com.zy.springcloud.controller
 * @Author: zuoyu
 * @CreateTime: 2023-02-28  19:42
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {

        String result = paymentService.paymentInfo_OK(id);
        log.info("****result:" + result);
        return result;
    }

    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_TimeOut(id);
        log.info("****result:" + result);
        return result;
    }

    // Hystrix 服务熔断
    @GetMapping(value = "/payment/hystrix/circuit/{id}")
    public String deptCircuitBreaker(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_CircuitBreaker(id);
        log.info("result:" + result);
        return result;
    }
}
