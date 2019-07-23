package com.szjz.mallseckill.integration.redis;

import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * author:szjz
 * date:2019/7/23
 */
@Service
public class RedisService {

    @Autowired
    private RedisProperties redisProperties;

    @Autowired
    JedisPool jedisPool;

    @Bean("jedisPool")
    public JedisPool jedisPoolFactory(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(redisProperties.getJedisPoolMaxActive());
        jedisPoolConfig.setMaxIdle(redisProperties.getJedisPoolMaxIdle());
        jedisPoolConfig.setMaxWaitMillis(redisProperties.getJedisPoolMaxWait() * 1000);
        JedisPool jedisPool = new JedisPool(
                jedisPoolConfig,
                redisProperties.getHost(),
                redisProperties.getPort(),
                redisProperties.getTimeout(),
                redisProperties.getPassword(),
                0);
        return jedisPool;
    }
}
