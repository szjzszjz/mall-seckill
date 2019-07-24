package com.szjz.mallseckill.integration.redis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * author:szjz
 * date:2019/7/23
 */
@Data
@Component
@ConfigurationProperties(prefix = "redis")
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
    private Integer poolMaxActive;

    /** jedis-pool-max-idle */
    private Integer poolMaxIdle;

    /** jedis-pool-max-wait unit:second*/
    private Integer poolMaxWait;

}
