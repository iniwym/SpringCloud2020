package com.nuc.springcloud.service;


import com.nuc.springcloud.util.IdGeneratorSnowflake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author mobiw
 * @email mobiwusihuan288@163.com
 * @date 2020-10-25 18:26
 */
@Service
public class OrderService {
    @Autowired
    private IdGeneratorSnowflake idGenerator;

    public String getIDBySnowFlake() {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 20; i++) {
            threadPool.submit(() -> {
                System.out.println(idGenerator.snowflake());
            });
        }
        threadPool.shutdown();
        return "hello snowflake";
    }
}
