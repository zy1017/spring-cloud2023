package com.zy.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @BelongsProject: spring-cloud2023
 * @BelongsPackage: com.zy.springcloud.config
 * @Author: zuoyu
 * @CreateTime: 2023-04-20  17:16
 * @Description: TODO
 * @Version: 1.0
 */
@Configuration
public class GatewayConfig {
    /*
    * 配置了一个id 为 path_route_payment 的路由规则
    * 当访问地址 http://localhost:9627/guonei 的时候 会转发到 http://news.baodu.com/guonei
    * */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_payment", r -> r.path("/guonei")
                .uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }

    @Bean
    public RouteLocator customRouteLocator2(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_payment1", r -> r.path("/zzz")
                .uri("http://baidu.com")).build();
        return routes.build();
    }
}
