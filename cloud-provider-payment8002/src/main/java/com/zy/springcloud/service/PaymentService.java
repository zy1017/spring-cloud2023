package com.zy.springcloud.service;

import com.zy.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @BelongsProject: spring-cloud2023
 * @BelongsPackage: com.zy.springcloud.service
 * @Author: zuoyu
 * @CreateTime: 2023-02-20  22:01
 * @Description: TODO
 * @Version: 1.0
 * <p>
 * 支付业务接口
 */

public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
