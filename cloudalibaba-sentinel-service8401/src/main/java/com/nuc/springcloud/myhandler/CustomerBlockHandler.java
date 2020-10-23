package com.nuc.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.nuc.springcloud.entities.CommonResult;

/**
 * @author mobiw
 * @email mobiwusihuan288@163.com
 * @date 2020-10-22 20:18
 */
public class CustomerBlockHandler {
    public static CommonResult handlerException1(BlockException exception) {
        return new CommonResult(4444, "按客戶自定义,global handlerException----1");
    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(4444, "按客戶自定义,global handlerException----2");
    }
}