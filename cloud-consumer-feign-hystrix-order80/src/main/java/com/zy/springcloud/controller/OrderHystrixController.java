package com.zy.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zy.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @BelongsProject: spring-cloud2023
 * @BelongsPackage: com.zy.springcloud.controller
 * @Author: zuoyu
 * @CreateTime: 2023-02-28  20:46
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "GlobalFallback")
public class OrderHystrixController {
    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    //@HystrixCommand
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfo_OK(id);
        log.info("****result:" + result);
        return result;
    }


    //一旦该方法失败并抛出了异常信息后，会自动调用  @HystrixCommand 注解标注的 fallbackMethod 指定的方法
/*    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {
            //规定 3 秒钟以内就不报错，正常运行，超过 5 秒就报错，调用指定的方法
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })*/
    @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        try {
            TimeUnit.SECONDS.sleep(id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        log.info("****result:" + result);
        return result;
    }

    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id) {
        return "我是消费者80,对方系统繁忙，请稍后再试。/(ㄒoㄒ)/~~";
    }

    // 全局服务异常处理兜底方法
    public String GlobalFallback() {
        return "消费者80,全局服务兜底方法 /(ㄒoㄒ)/~~";
    }
}
