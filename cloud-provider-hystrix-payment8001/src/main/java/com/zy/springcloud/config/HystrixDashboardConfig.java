package com.zy.springcloud.config;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @BelongsProject: spring-cloud2023
 * @BelongsPackage: com.zy.config
 * @Author: zuoyu
 * @CreateTime: 2023-04-12  17:55
 * @Description: TODO
 * @Version: 1.0
 */
@Configuration
public class HystrixDashboardConfig {
    /**
     *  Hystrix dashboard 监控界面必须配置
     * @return
     */
    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");//访问路径
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}