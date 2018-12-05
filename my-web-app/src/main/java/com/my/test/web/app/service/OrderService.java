package com.my.test.web.app.service;

import com.my.test.dao.entity.Order;
import com.my.test.dao.mapper.OrderMapper;
import com.my.test.web.app.mapper.OrderExtMapper;
import io.shardingsphere.core.keygen.DefaultKeyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    private static DefaultKeyGenerator defaultKeyGenerator = new DefaultKeyGenerator();

    @Autowired
    private OrderExtMapper orderExtMapper;

    @Transactional
    public int insertOrder(){
        Order order = new Order();
        long val = defaultKeyGenerator.generateKey().longValue();
        System.out.println(val);
        order.setOrderId(val);
        order.setAddress("广东省深圳市");
        Date now = new Date();
        order.setCreateTime(now);
        order.setUpdateTime(now);
        order.setUserId(111L);
        order.setPrice(BigDecimal.TEN);


        Order order1 = new Order();
        long val1 = defaultKeyGenerator.generateKey().longValue();
        System.out.println(val1);
        order1.setOrderId(val1);
        order1.setAddress("广东省深圳市");
        order1.setCreateTime(now);
        order1.setUpdateTime(now);
        order1.setUserId(111L);
        order1.setPrice(BigDecimal.TEN);

        List<Order> list = new ArrayList<Order>();
        list.add(order);
        list.add(order1);
        orderExtMapper.insertBatch(list);

        orderExtMapper.batchDelete(111L, Arrays.asList(val1,val));
        //int i = 1/0;
        return 1;
    }
}
