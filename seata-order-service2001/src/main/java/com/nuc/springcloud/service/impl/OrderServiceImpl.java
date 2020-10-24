package com.nuc.springcloud.service.impl;

import com.nuc.springcloud.dao.OrderDao;
import com.nuc.springcloud.domain.Order;
import com.nuc.springcloud.service.AccountService;
import com.nuc.springcloud.service.OrderService;
import com.nuc.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author mobiw
 * @email mobiwusihuan288@163.com
 * @date 2020-10-23 15:14
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;

    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
     * @param order
     */
    @Override
    @GlobalTransactional(name = "mobiw-create-order",rollbackFor = Exception.class)
    public void create(Order order) {
        //1. 新建订单
        log.info("----->开始新建订单");
        orderDao.create(order);

        //2. 扣减库存
        log.info("----->订单微服务开始调用库存，做扣减");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("----->订单微服务开始调用库存，做扣减end");

        //3. 扣减账户
        log.info("----->订单微服务开始调用账户，做扣减");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("----->订单微服务开始调用账户，做扣减end");


        //4. 修改订单的状态 从0到1   1代表完成
        log.info("----->修改订单状态开始");
        orderDao.update(order.getUserId(),0);
        log.info("----->修改订单状态完成");

        log.info("----->下订单结束了，O(∩_∩)O哈哈~");
    }
}
