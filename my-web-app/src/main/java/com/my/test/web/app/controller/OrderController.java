package com.my.test.web.app.controller;

import com.my.test.web.app.service.OrderService;
import io.shardingsphere.core.keygen.DefaultKeyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {

    private static DefaultKeyGenerator defaultKeyGenerator = new DefaultKeyGenerator();

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "insertOrder", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int insertOrder(){
        return orderService.insertOrder();
    }
}
