package com.szjz.mallseckill.utils;

import org.apache.commons.text.RandomStringGenerator;

public class RandomUtil {

    /**
     * 随机数字
     */
    private static RandomStringGenerator generatorNumeric = new RandomStringGenerator.Builder()//
            .withinRange(new char[]{'0', '9'}).build();
    /**
     * 随机字母(大小写)
     */
    private static RandomStringGenerator generatorAlphabetic = new RandomStringGenerator.Builder()//
            .withinRange(new char[]{'A', 'Z'}, new char[]{'a', 'z'}).build();
    /**
     * 随机字母(大小写)数字
     */
    private static RandomStringGenerator generatorAlphanumeric = new RandomStringGenerator.Builder()//
            .withinRange(new char[]{'A', 'Z'}, new char[]{'a', 'z'}, new char[]{'0', '9'}).build();

    public static void main(String[] args) {
        System.out.println("数字\t" + randomNumeric(20));
        System.out.println("字母\t" + randomAlphabetic(20));
        System.out.println("字母数字\t" + randomAlphanumeric(20));
        System.out.println("uuid\t" + getUUID());
    }

    /**
     * 32位 字母(大小写)+数字
     *
     * @return
     */
    public static synchronized String getUUID() {
        return generatorAlphanumeric.generate(32);
    }

    /**
     * 数字
     *
     * @param length
     * @return
     */
    public static String randomNumeric(int length) {
        return generatorNumeric.generate(length);
    }

    /**
     * 字母(大小写)
     *
     * @param length
     * @return
     */
    public static String randomAlphabetic(int length) {
        return generatorAlphabetic.generate(length);
    }

    /**
     * 字母(大小写)+数字
     *
     * @param length
     * @return
     */
    public static String randomAlphanumeric(int length) {
        return generatorAlphanumeric.generate(length);
    }

}
