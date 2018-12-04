package com.my.test.dao.mapper;

import com.my.test.dao.entity.OrderItem;

public interface OrderItemMapper {
    int insert(OrderItem record);

    int insertSelective(OrderItem record);
}