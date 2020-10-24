package com.nuc.springcloud.controller;

import com.nuc.springcloud.domain.CommonResult;
import com.nuc.springcloud.domain.Order;
import com.nuc.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author mobiw
 * @email mobiwusihuan288@163.com
 * @date 2020-10-23 15:34
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200, "订单创建成功");
    }
}
