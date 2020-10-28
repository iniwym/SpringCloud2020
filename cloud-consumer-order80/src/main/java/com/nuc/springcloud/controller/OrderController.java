package com.nuc.springcloud.controller;


import com.nuc.springcloud.entities.CommonResult;
import com.nuc.springcloud.entities.Payment;
import com.nuc.springcloud.lb.LoadBalancer;
import com.nuc.springcloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author mobiw
 * @email mobiwusihuan288@163.com
 * @date 2020-10-06 11:25
 */
@RestController
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;

    //    public static final String PATHMENT_URL = "http://localhost:8001";
    public static final String PATHMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
//        return restTemplate.postForObject(PATHMENT_URL + "/payment/create", payment, CommonResult.class);
        return restTemplate.postForEntity(PATHMENT_URL + "/payment/create", payment, CommonResult.class).getBody();
    }

    //返回对象为响应体中数据转化成的对象，基本上可以理解为Json
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PATHMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    //返回对象为ResponseEntity对象，包含响应中的一些重要信息，比如响应头、响应状态码、响应体等
    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PATHMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return new CommonResult(444, "操作失败");
        }
    }

    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0) {
            return null;
        }

        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();

        return restTemplate.getForObject(uri + "/payment/lb", String.class);

    }

    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin() {
        String result = restTemplate.getForObject("http://localhost:8001" + "/payment/zipkin/", String.class);
        return result;
    }

    @RequestMapping("/snowflake")
    public String index() {
        return orderService.getIDBySnowFlake();
    }

}

