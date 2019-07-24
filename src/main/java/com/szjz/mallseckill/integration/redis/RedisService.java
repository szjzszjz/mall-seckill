package com.szjz.mallseckill.integration.redis;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * author:szjz
 * date:2019/7/24
 */

@Service
public class RedisService {

    @Autowired
    private JedisPool jedisPool;

    /**
     * get a single object
     */
    public <T> T get(KeyPrefix prefix, String key, Class<T> clazz) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String realKey = prefix.getPrefix() + key;
            String s = jedis.get(realKey);
            T t = stringToBean(s, clazz);
            return t;
        } finally {
            returnToPool(jedis);
        }
    }

    /**
     * have no prefix
     * get a single object
     */
    public <T> T get(String key, Class<T> clazz) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String realKey = key;
            String s = jedis.get(realKey);
            T t = stringToBean(s, clazz);
            return t;
        } finally {
            returnToPool(jedis);
        }
    }

    /**
     * cache object have prefix
     * default never expire
     * you can set expiration time in KeyPrefix's constructor
     */
    public <T> Boolean set(KeyPrefix prefix, String key, T bean) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String value = beanToString(bean);
            if (value == null || value.length() <= 0) {
                return false;
            }
            //generate real key
            String realKey = prefix.getPrefix() + key;
            //default expireSeconds = 0
            int expireSeconds = prefix.getExpireSeconds();
            if (expireSeconds <= 0) {
                //never expire
                jedis.set(realKey, value);
            } else {
                jedis.setex(realKey, expireSeconds, value);
            }
            return true;

        } finally {
            returnToPool(jedis);
        }
    }

    /**
     * cache object have prefix
     * The expiration time set in the KeyPrefix's constructor is invalid
     */
    public <T> Boolean set(KeyPrefix prefix, String key, T bean,Integer expire) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String value = beanToString(bean);
            if (value == null || value.length() <= 0) {
                return false;
            }
            //generate real key
            String realKey = prefix.getPrefix() + key;
            if (expire <= 0) {
                //never expire
                jedis.set(realKey, value);
            } else {
                jedis.setex(realKey, expire, value);
            }
            return true;

        } finally {
            returnToPool(jedis);
        }
    }

    /**
     * cache object have no prefix but have expire
     */
    public <T> Boolean set(String key, T bean ,Integer expire) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String value = beanToString(bean);
            if (value == null || value.length() <= 0) {
                return false;
            }
            //generate real key
            String realKey =  key;
            if (expire <= 0) {
                //never expire
                jedis.set(realKey, value);
            } else {
                jedis.setex(realKey, expire, value);
            }
            return true;

        } finally {
            returnToPool(jedis);
        }
    }

    /**
     * whether key exists or not
     */
    public <T> Boolean exists(KeyPrefix prefix, String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String realKey = prefix.getPrefix() + key;
            return jedis.exists(realKey);
        } finally {
            returnToPool(jedis);
        }
    }

    /**
     * increment
     */
    public <T> Long incr(KeyPrefix prefix, String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String realKey = prefix.getPrefix() + key;
            return jedis.incr(realKey);
        } finally {
            returnToPool(jedis);
        }
    }

    /**
     * decrease
     */
    public <T> Long decr(KeyPrefix prefix, String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String realKey = prefix.getPrefix() + key;
            return jedis.decr(realKey);
        } finally {
            returnToPool(jedis);
        }
    }

    private <T> String beanToString(T bean) {
        if (bean == null) {
            return null;
        }
        Class<?> clazz = bean.getClass();
        if (clazz == int.class || clazz == Integer.class || clazz == Long.class) {
            return "" + bean;
        } else if (clazz == String.class) {
            return (String) bean;
        } else {
            return JSON.toJSONString(bean);
        }
    }

    private <T> T stringToBean(String str, Class<T> clazz) {
        if (str == null || clazz == null || str.length() <= 0) {
            return null;
        }
        if (clazz == int.class || clazz == Integer.class) {
            return (T) Integer.valueOf(str);
        } else if (clazz == String.class) {
            return (T) str;
        } else if (clazz == long.class || clazz == Long.class) {
            return (T) Long.valueOf(str);
        } else {
            return JSON.toJavaObject(JSON.parseObject(str), clazz);
        }
    }

    /**
     * close jedis,  it's actually getting jedis back into the pool
     */
    private void returnToPool(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }
}
