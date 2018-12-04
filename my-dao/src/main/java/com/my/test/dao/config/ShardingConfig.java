package com.my.test.dao.config;

import com.my.test.dao.algorithm.table.PreciseLongModuloShardingTableAlgorithm;
import io.shardingsphere.api.config.ShardingRuleConfiguration;
import io.shardingsphere.api.config.TableRuleConfiguration;
import io.shardingsphere.api.config.strategy.InlineShardingStrategyConfiguration;
import io.shardingsphere.api.config.strategy.StandardShardingStrategyConfiguration;
import io.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
public class ShardingConfig {

    @Autowired
    @Qualifier("ds0")
    private DataSource ds0;

    /**
     * 配置数据源策略和表策略
     *
     * @param
     * @return
     */
    ShardingRuleConfiguration ShardingRuleConfiguration() {
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.getTableRuleConfigs().add(getOrderTableRuleConfiguration());
        shardingRuleConfig.getTableRuleConfigs().add(getOrderItemTableRuleConfiguration());
        shardingRuleConfig.getBindingTableGroups().add("t_order, t_order_item");

        shardingRuleConfig.setDefaultDatabaseShardingStrategyConfig(new InlineShardingStrategyConfiguration("user_id", "ds0"));
        shardingRuleConfig.setDefaultTableShardingStrategyConfig(new StandardShardingStrategyConfiguration("user_id", new PreciseLongModuloShardingTableAlgorithm()));
        // 设置默认数据库
        shardingRuleConfig.setDefaultDataSourceName("ds0");
        return shardingRuleConfig;
    }

    TableRuleConfiguration getOrderTableRuleConfiguration() {
        TableRuleConfiguration result = new TableRuleConfiguration();
        result.setLogicTable("t_order");
        result.setActualDataNodes("ds0.t_order${0..1}");
        result.setKeyGeneratorColumnName("order_id");
        result.setDatabaseShardingStrategyConfig(new InlineShardingStrategyConfiguration("user_id", "ds0"));
        result.setTableShardingStrategyConfig(new StandardShardingStrategyConfiguration("order_id", new PreciseLongModuloShardingTableAlgorithm()));
        return result;
    }

    TableRuleConfiguration getOrderItemTableRuleConfiguration() {
        TableRuleConfiguration result = new TableRuleConfiguration();
        result.setLogicTable("t_order_item");
        result.setActualDataNodes("ds0.t_order_item${0..1}");
        return result;
    }

    Map<String, DataSource> createDataSourceMap() {
        Map<String, DataSource> result = new HashMap<>();
        result.put("ds0", ds0);
        return result;
    }

    /**
     * 创建sharding-jdbc的数据源DataSource
     *
     * @return
     * @throws SQLException
     */
    @Bean(name = "shardingDataSource")
    public DataSource shardingDataSource()
            throws SQLException {
        return ShardingDataSourceFactory.createDataSource(createDataSourceMap(), ShardingRuleConfiguration(), new LinkedHashMap<String, Object>(), new Properties());
    }
}
