package com.zy.murule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @BelongsProject: spring-cloud2023
 * @BelongsPackage: com.zy.murule
 * @Author: zuoyu
 * @CreateTime: 2023-02-24  20:43
 * @Description: TODO
 * @Version: 1.0
 * <p>
 * 自己实现轮询策略负载均衡
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule() {
        //   return new RandomRule(); // 负载均衡 定义为随机
        return new MyRandomRule(); // 使用自定义 负载均衡
    }
}
