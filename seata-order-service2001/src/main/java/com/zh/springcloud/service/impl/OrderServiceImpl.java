package com.zh.springcloud.service.impl;

import com.zh.springcloud.dao.OrderDao;
import com.zh.springcloud.domain.Order;
import com.zh.springcloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public int create(Order order) {
        int i =orderDao.insert(order);
        return i;
    }

    @Override
    public int update(Order order) {
        int i = orderDao.updateById(order);
        return i;
    }
}
