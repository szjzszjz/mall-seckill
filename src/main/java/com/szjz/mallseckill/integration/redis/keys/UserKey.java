package com.szjz.mallseckill.integration.redis.keys;

import com.szjz.mallseckill.integration.redis.BasePrefix;

/**
 * author:szjz
 * date:2019/7/23
 * 用户缓存key
 */
public class UserKey extends BasePrefix {

    public UserKey(String prefix) {
        super(prefix);
    }

    public UserKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }
}
