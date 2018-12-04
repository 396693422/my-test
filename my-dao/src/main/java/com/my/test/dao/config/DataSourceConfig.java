package com.my.test.dao.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.my.test.dao.properties.MyDataSourceProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 
 * 数据源配置
 * 
 * @author huangjianwen
 * @version 1.0
 * @since 2017-04-10
 */
@Configuration
@EnableConfigurationProperties(MyDataSourceProperties.class)
@Slf4j
public class DataSourceConfig {

	@Autowired
	private MyDataSourceProperties myDataSourceProperties;

	@Bean(name = "ds0")
	@Primary
	public DataSource dataSource0() {
		log.info(">>> 初始化数据库信息=>driverClassName：{}", myDataSourceProperties.getDriverClassName());
		log.info(">>> 初始化数据库信息=>url：{}", myDataSourceProperties.getUrl());
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(myDataSourceProperties.getDriverClassName());
		dataSource.setUrl(myDataSourceProperties.getUrl());
		dataSource.setUsername(myDataSourceProperties.getUsername());
		dataSource.setPassword(myDataSourceProperties.getPassword());
		return dataSource;
	}

}