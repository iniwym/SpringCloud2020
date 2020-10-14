package com.nuc.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author mobiw
 * @email mobiwusihuan288@163.com
 * @date 2020-10-12 15:19
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_OK , (┬＿┬)";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut , (┬＿┬)";
    }
}