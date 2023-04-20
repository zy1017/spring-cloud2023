package com.zy.springcloud.service;

import com.zy.springcloud.dao.PaymentDao;
import com.zy.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @BelongsProject: spring-cloud2023
 * @BelongsPackage: com.zy.springcloud.service
 * @Author: zuoyu
 * @CreateTime: 2023-02-20  22:02
 * @Description: TODO
 * @Version: 1.0
 * <p>
 * 支付业务实现类
 */
@Service
public class PaymentServiceImpl implements PaymentService{

    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
