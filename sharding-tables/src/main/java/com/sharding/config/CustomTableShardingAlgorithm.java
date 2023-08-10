package com.sharding.config;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;


/**
 * 自定义 表分片方法
 */
@Configuration
public class CustomTableShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

    /**
     * 根据id 值 % 4后的值，指定表 名称
     * @param availableTargetNames
     * @param shardingValue
     * @return
     */
    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
        // PreciseShardingValue<Long> shardingValue 传值为id
        for (String tableName : availableTargetNames) {
            if (tableName.endsWith(shardingValue.getValue() % 4 + "")) {
                return tableName;
            }
        }
        throw new IllegalArgumentException();
    }
}
