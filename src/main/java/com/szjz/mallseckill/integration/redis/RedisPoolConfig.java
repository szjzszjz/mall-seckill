package com.szjz.mallseckill.integration.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * author:szjz
 * date:2019/7/23
 */
@Configuration
public class RedisPoolConfig {

    @Autowired
    private RedisProperties redisProperties;


    @Bean("jedisPool")
    public JedisPool jedisPoolFactory(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(redisProperties.getPoolMaxActive());
        jedisPoolConfig.setMaxIdle(redisProperties.getPoolMaxIdle());
        jedisPoolConfig.setMaxWaitMillis(redisProperties.getPoolMaxWait() * 1000);
        JedisPool jedisPool = new JedisPool(
                jedisPoolConfig,
                redisProperties.getHost(),
                redisProperties.getPort(),
                redisProperties.getTimeout(),
                redisProperties.getPassword(),
                0);
        System.err.println(redisProperties.getPassword());
        return jedisPool;
    }
}
