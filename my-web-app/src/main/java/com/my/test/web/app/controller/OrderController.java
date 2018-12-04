package com.my.test.web.app.controller;

import com.my.test.dao.entity.Order;
import com.my.test.dao.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("order")
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;

    public int insertOrder(){
        Order order = new Order();
        return orderMapper.insertSelective(order);
    }
}
