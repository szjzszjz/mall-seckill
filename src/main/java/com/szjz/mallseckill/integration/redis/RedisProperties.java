package com.szjz.mallseckill.integration.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * author:szjz
 * date:2019/7/23
 */

@Component
@ConfigurationProperties(prefix = "spring.redis")
public class RedisProperties {

    /** host */
    private String host;

    /** port */
    private Integer port;

    /** password */
    private String password;

    /** timeout */
    private Integer timeout;

    /** jedis-pool-max-active */
    private Integer jedisPoolMaxActive;

    /** jedis-pool-max-idle */
    private Integer jedisPoolMaxIdle;

    /** jedis-pool-max-wait */
    private Integer jedisPoolMaxWait;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public Integer getJedisPoolMaxActive() {
        return jedisPoolMaxActive;
    }

    public void setJedisPoolMaxActive(Integer jedisPoolMaxActive) {
        this.jedisPoolMaxActive = jedisPoolMaxActive;
    }

    public Integer getJedisPoolMaxIdle() {
        return jedisPoolMaxIdle;
    }

    public void setJedisPoolMaxIdle(Integer jedisPoolMaxIdle) {
        this.jedisPoolMaxIdle = jedisPoolMaxIdle;
    }

    public Integer getJedisPoolMaxWait() {
        return jedisPoolMaxWait;
    }

    public void setJedisPoolMaxWait(Integer jedisPoolMaxWait) {
        this.jedisPoolMaxWait = jedisPoolMaxWait;
    }
}
