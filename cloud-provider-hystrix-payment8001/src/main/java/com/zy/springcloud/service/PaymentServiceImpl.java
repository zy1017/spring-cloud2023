package com.zy.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @BelongsProject: spring-cloud2023
 * @BelongsPackage: com.zy.service
 * @Author: zuoyu
 * @CreateTime: 2023-02-28  19:39
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    /*
     * 正常访问
     * */
    public String paymentInfo_OK(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + "paymentInfo_Ok,id" + id + "\t" + "O(∩_∩)O哈哈";
    }

    //一旦该方法失败并抛出了异常信息后，会自动调用  @HystrixCommand 注解标注的 fallbackMethod 指定的方法
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            //规定 3 秒钟以内就不报错，正常运行，超过 5 秒就报错，调用指定的方法
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_TimeOut(Integer id) {
        int timeNumber = id;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:" + Thread.currentThread().getName() + "paymentInfo_TimeOut,id" + id + "\t" + "耗时：" + timeNumber;
    }

    // 熔断案例
    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            // 以下参数在 HystrixCommandProperties 类中有默认配置
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //是否开启熔断器
            //@HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "1000"), //统计时间窗
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //统计时间窗内请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //休眠时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"), //在统计时间窗口期以内，请求失败率达到 60% 时进入熔断状态
    })
    public String paymentInfo_CircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("id不能是负数");
        }
        String serialNum = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "调用成功,流水号" + serialNum;
    }

    // 当服务出现故障以后，调用该方法给出友好提示
    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + "\t" + "8001系统繁忙,(ㄒoㄒ)/~~";
    }

    //deptCircuitBreaker 的降级方法
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "c语言中文网提醒您，id 不能是负数,请稍后重试!\t id:" + id;
    }
}
