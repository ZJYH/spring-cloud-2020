package com.zh.springcloud.service;

import com.zh.springcloud.domain.Order;
import org.apache.ibatis.annotations.Param;


public interface OrderService {

    //1.创建订单
    int create(Order order);

    //2. 修改订单状态
    int update(Order order);
}
