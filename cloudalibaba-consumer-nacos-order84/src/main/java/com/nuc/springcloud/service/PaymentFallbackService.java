package com.nuc.springcloud.service;

import com.nuc.springcloud.entities.CommonResult;
import com.nuc.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author mobiw
 * @email mobiwusihuan288@163.com
 * @date 2020-10-22 22:09
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(44444, "服务降级返回,---PaymentFallbackService", new Payment(id, "errorSerial"));
    }
}
