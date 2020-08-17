package com.zh.springcloud.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zh.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDao extends BaseMapper<Order> {

}
