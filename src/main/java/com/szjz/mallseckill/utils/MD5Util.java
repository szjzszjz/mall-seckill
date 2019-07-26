package com.szjz.mallseckill.utils;


import org.apache.commons.codec.digest.DigestUtils;

/**
 * author:szjz
 * date:2019/7/25
 * md5 加密工具
 */
public class MD5Util {

    public static final String SALT = "1a2b3c4d";

    public static String md5(String src) {
        return DigestUtils.md5Hex(src);
    }

    /**
     * 第一次对用户输入的密码进行加盐加密处理
     */
    public static String inputPassToFormPass(String inputPass) {
        String string = "" + SALT.charAt(0) + SALT.charAt(2) + inputPass + SALT.charAt(5) + SALT.charAt(4);
        return md5(string);
    }

    /**
     * 对第一次加密的密码进行第二次加盐加密处理
     */
    public static String formPassToDBPass(String formPass) {
        String string = "" + SALT.charAt(0) + SALT.charAt(2) + formPass + SALT.charAt(5) + SALT.charAt(4);
        return md5(string);
    }

    /**
     * 获取最终的加密密码
     */
    public static String inputPassToDBPass(String inputPass) {
        String formPass = inputPassToFormPass(inputPass);
        String dbPass = formPassToDBPass(formPass);
        return dbPass;
    }

    public static void main(String[] args) {
        System.out.println(inputPassToDBPass("123"));
    }
}

