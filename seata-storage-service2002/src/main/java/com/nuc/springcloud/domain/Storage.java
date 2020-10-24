package com.nuc.springcloud.domain;

import lombok.Data;

/**
 * @author mobiw
 * @email mobiwusihuan288@163.com
 * @date 2020-10-24 11:27
 */
@Data
public class Storage {

    private Long id;

    // 产品id
    private Long productId;

    //总库存
    private Integer total;


    //已用库存
    private Integer used;


    //剩余库存
    private Integer residue;
}
