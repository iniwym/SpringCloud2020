package com.nuc.springcloud.service.impl;

import com.nuc.springcloud.dao.PaymentDao;
import com.nuc.springcloud.entities.Payment;
import com.nuc.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author mobiw
 * @email mobiwusihuan288@163.com
 * @date 2020-10-05 17:06
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
