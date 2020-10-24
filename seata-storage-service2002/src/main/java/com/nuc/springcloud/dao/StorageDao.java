package com.nuc.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author mobiw
 * @email mobiwusihuan288@163.com
 * @date 2020-10-24 11:12
 */
@Mapper
public interface StorageDao {
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
