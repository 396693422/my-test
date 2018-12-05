package com.my.test.web.app.mapper;

import com.my.test.dao.entity.Order;
import com.my.test.dao.mapper.OrderMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderExtMapper extends OrderMapper{

    int insertBatch(List<Order> orderList);

    int batchDelete(@Param("userId") Long userId, @Param("orderIdList") List<Long> orderIdList);
}
