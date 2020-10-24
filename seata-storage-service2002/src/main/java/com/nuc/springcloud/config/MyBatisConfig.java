package com.nuc.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author mobiw
 * @email mobiwusihuan288@163.com
 * @date 2020-10-23 15:38
 */
@Configuration
@MapperScan({"com.nuc.springcloud.dao"})
public class MyBatisConfig {

}
