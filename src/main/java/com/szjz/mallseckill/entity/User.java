package com.szjz.mallseckill.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * author:szjz
 * date:2019/7/24
 */
@Data
public class User implements Serializable {


    private static final long serialVersionUID = 6646799125543835518L;
    /** id */
    private Long id;

    /** name */
    private String name;

    public User() {
    }

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
