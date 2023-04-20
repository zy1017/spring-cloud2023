package com.zy.springcloud.controller;

import com.zy.springcloud.entities.CommonResult;
import com.zy.springcloud.entities.Payment;
import com.zy.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @BelongsProject: spring-cloud2023
 * @BelongsPackage: com.zy.springcloud.controller
 * @Author: zuoyu
 * @CreateTime: 2023-02-20  22:05
 * @Description: TODO
 * @Version: 1.0
 */
@Slf4j
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("***插入结果:" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功,serverPort:" + serverPort, result);
        }
        return new CommonResult(444, "插入数据库失败", null);
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (null != payment) {
            return new CommonResult(200, "查询成功,serverPort:" + serverPort, payment);
        }
        return new CommonResult(444, "没有对应记录,查询Id：" + id, null);
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }


    //OpenFeign 客户端 超时测试，默认超时时间为 1 秒钟,该服务的响应时间为 5 秒
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout() {
        //暂停 5 秒
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "超时测试";
    }
}
