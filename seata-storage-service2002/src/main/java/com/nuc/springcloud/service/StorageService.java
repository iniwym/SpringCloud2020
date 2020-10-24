package com.nuc.springcloud.service;

/**
 * @author mobiw
 * @email mobiwusihuan288@163.com
 * @date 2020-10-24 11:21
 */
public interface StorageService {
    // 扣减库存
    void decrease(Long productId, Integer count);
}

