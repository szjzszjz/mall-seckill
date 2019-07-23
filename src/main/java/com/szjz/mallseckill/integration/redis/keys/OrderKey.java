package com.szjz.mallseckill.integration.redis.keys;

import com.szjz.mallseckill.integration.redis.BasePrefix;

/**
 * author:szjz
 * date:2019/7/23
 * 订单缓存key
 */
public class OrderKey extends BasePrefix {

    public OrderKey(String prefix) {
        super(prefix);
    }

    public OrderKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

}
