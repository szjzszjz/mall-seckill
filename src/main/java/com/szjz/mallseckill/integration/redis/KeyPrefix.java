package com.szjz.mallseckill.integration.redis;

/**
 * author:szjz
 * date:2019/7/23
 */
public interface KeyPrefix {

    int getExpireSeconds();

    String getPrefix();
}
