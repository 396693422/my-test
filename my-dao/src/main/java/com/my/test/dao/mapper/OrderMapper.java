package com.my.test.dao.mapper;

import com.my.test.dao.entity.Order;
import org.springframework.stereotype.Component;

@Component
public interface OrderMapper {
    int deleteByPrimaryKey(Long orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}