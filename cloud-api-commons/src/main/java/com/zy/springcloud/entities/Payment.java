package com.zy.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @BelongsProject: spring-cloud2023
 * @BelongsPackage: com.zy.springcloud.entities
 * @Author: zuoyu
 * @CreateTime: 2023-02-20  20:49
 * @Description: TODO
 * @Version: 1.0
 *
 *  支付类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    // 支付id
    private Long id;
    // 流水号
    private String serial;
}
