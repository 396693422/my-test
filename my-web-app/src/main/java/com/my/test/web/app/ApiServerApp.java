package com.my.test.web.app;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @author huangjianwen
 * @email huangjianwen@niiwoo.com
 * @date 2018年2月27日 下午2:58:09
 * @Copyright Copyright (c) 2018 Niiwoo Inc. All Rights Reserved.
 * @desc app api 服务端微服务
 *
 */
@ComponentScan(basePackages = "com.my.test")
@SpringBootApplication
@MapperScan(basePackages = {"com.my.test.dao.mapper","com.my.test.web.app.mapper"})
public class ApiServerApp {

	private static final Logger logger = LoggerFactory.getLogger(ApiServerApp.class);

	public static void main(String[] args) {
		logger.info(">>> 启动 ApiServerApp 开始<<<");
		new SpringApplicationBuilder(ApiServerApp.class).web(true).run(args);
		logger.info(">>> 启动ApiServerApp 结束 <<<");
	}

}
