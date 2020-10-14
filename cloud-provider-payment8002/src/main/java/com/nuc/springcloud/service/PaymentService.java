package com.nuc.springcloud.service;

import com.nuc.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author mobiw
 * @email mobiwusihuan288@163.com
 * @date 2020-10-05 17:05
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

}
