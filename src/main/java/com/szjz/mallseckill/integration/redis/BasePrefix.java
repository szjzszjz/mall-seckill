package com.szjz.mallseckill.integration.redis;

/**
 * author:szjz
 * date:2019/7/23
 */
public abstract class BasePrefix implements KeyPrefix {

    /**
     * expire seconds
     */
    private int expireSeconds ;

    /**
     * prefix
     */
    private String prefix;

    /**
     * 0:never expires
     */
    public BasePrefix(String prefix) {
        this(0, prefix);
    }


    public BasePrefix(int expireSeconds, String prefix) {
        this.expireSeconds = expireSeconds;
        this.prefix = prefix;
    }

    /** default 0 express never expires */
    @Override
    public int expireSeconds() {
        return expireSeconds;
    }

    @Override
    public String getPrefix() {
        String simpleName = getClass().getSimpleName();
        return simpleName + ":" + prefix;
    }
}
