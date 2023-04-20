package com.zy.springcloud.lb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @BelongsProject: spring-cloud2023
 * @BelongsPackage: com.zy.lb
 * @Author: zuoyu
 * @CreateTime: 2023-02-24  20:47
 * @Description: TODO
 * @Version: 1.0
 *
 * 手写轮询算法
 */
@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("****当前访问是第几次，次数:next:" + next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        // 当前请求的次数 % 服务器的台数   余数为当前服务器组的下标  得到请求的是哪台服务器
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
