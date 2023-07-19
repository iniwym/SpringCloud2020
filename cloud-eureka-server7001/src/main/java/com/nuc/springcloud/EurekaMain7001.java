package com.nuc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author mobiw
 * @email mobiwusihuan288@163.com
 * @date 2020-10-06 16:30
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class,args);
    }

    @EnableWebSecurity
    public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            // 方法1：关闭csrf
            http.csrf().disable();
            // 方法2：忽略/eureka/** 所有请求
            // http.csrf().ignoringAntMatchers("/eureka/**");
            // 访问eureka控制台和actuator控制台时能做安全控制
            super.configure(http);
        }
    }
}
