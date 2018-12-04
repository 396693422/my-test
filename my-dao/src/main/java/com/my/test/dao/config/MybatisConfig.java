package com.my.test.dao.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * 
 * mybatis配置
 * 
 * @author huangjianwen
 * @version 1.0
 * @since 2017-04-10
 */
@Configuration
@EnableTransactionManagement(order = 1)
public class MybatisConfig {
	
	@Autowired
	@Qualifier("shardingDataSource")
	private DataSource dataSource;

	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactoryBean() {
		try {
			SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
			sessionFactoryBean.setDataSource(dataSource);
			sessionFactoryBean.setTypeAliasesPackage("com.eagle.dao.entity");
			Resource[] resources = new PathMatchingResourcePatternResolver().getResources("classpath*:com/eagle/**/mapping/*.xml");
			sessionFactoryBean.setMapperLocations(resources);
			sessionFactoryBean.setConfigLocation(new DefaultResourceLoader().getResource("classpath:mybatis/mybatis-config.xml"));
			return sessionFactoryBean.getObject();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Bean(name = "transactionManager")
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource);
	}

}