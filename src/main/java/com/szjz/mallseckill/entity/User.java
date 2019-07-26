package com.szjz.mallseckill.entity;

import com.szjz.mallseckill.context.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * author:szjz
 * date:2019/7/24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity implements Serializable {


    private static final long serialVersionUID = 6646799125543835518L;


    /** 别名 */
    private String nickname;

    /** 手机号 */
    private String phone;

    /** 密码 */
    private String password;

    /** 密码盐 */
    private String salt;

    /** 头像 */
    private String head;

    /** 注册时间 */
    private Date registerDate;

    /** 最后一次的登录时间 */
    private String lastLoginDate;

    /** 登录次数 */
    private Integer loginCount;


//    public User() {
//    }
//
//    public User(String nickname, String password, String phone, String salt, String head, Date registerDate, String lastLoginDate, Integer loginCount) {
//        this.nickname = nickname;
//        this.password = password;
//        this.phone = phone;
//        this.salt = salt;
//        this.head = head;
//        this.registerDate = registerDate;
//        this.lastLoginDate = lastLoginDate;
//        this.loginCount = loginCount;
//    }
}
