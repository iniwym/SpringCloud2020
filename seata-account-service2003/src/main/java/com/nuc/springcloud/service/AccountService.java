package com.nuc.springcloud.service;

import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author mobiw
 * @email mobiwusihuan288@163.com
 * @date 2020-10-24 11:32
 */
public interface AccountService {

    /**
     * 扣减账户余额
     */
    void decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}