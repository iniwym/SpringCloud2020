package com.nuc.springcloud.dao;

import com.nuc.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author mobiw
 * @email mobiwusihuan288@163.com
 * @date 2020-10-23 14:52
 */
@Mapper
public interface OrderDao {

    //1 新建订单
    void create(Order order);

    //2 修改订单状态，从0到1
    void update(@Param("userId") Long userId, @Param("status")Integer status);
}
