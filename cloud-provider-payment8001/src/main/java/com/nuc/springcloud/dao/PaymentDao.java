package com.nuc.springcloud.dao;

import com.nuc.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author mobiw
 * @email mobiwusihuan288@163.com
 * @date 2020-10-05 16:47
 */
@Mapper
public interface PaymentDao {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
