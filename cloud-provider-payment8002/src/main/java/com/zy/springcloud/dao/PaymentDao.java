package com.zy.springcloud.dao;

import com.zy.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @BelongsProject: spring-cloud2023
 * @BelongsPackage: com.zy.springcloud.dao
 * @Author: zuoyu
 * @CreateTime: 2023-02-20  20:56
 * @Description: TODO
 * @Version: 1.0
 * <p>
 * 支付接口
 */
@Mapper
public interface PaymentDao {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
