package com.zy.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @BelongsProject: spring-cloud2023
 * @BelongsPackage: com.zy.lb
 * @Author: zuoyu
 * @CreateTime: 2023-02-24  20:41
 * @Description: TODO
 * @Version: 1.0
 */
public interface LoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
