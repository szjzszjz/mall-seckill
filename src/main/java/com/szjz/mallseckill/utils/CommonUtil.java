package com.szjz.mallseckill.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 * 公共工具类<br>
 * 2014年12月2日
 */
public class CommonUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonUtil.class);

    /**
     * 获取UTF8字符长度，英文字符为1，中文及其他为3
     *
     * @param value
     * @return
     */
    public static int getUtf8Length(String value) {
        if (StringUtils.isBlank(value)) {
            return 0;
        }
        return value.getBytes().length;
    }

    /**
     * 将异常堆栈转换为字符串
     *
     * @param aThrowable 异常 允许为空
     * @return aThrowable 为null, 则返回 ""
     */
    public static String getStackTrace(Throwable aThrowable) {
        return getStackTrace(aThrowable, -1);
    }

    /**
     * 将异常堆栈转换为字符串
     *
     * @param aThrowable 异常 允许为空
     * @param length     -1则返回全部
     * @return aThrowable 为null, 则返回 ""
     */
    public static String getStackTrace(Throwable aThrowable, int length) {
        if (aThrowable == null) {
            return "";
        }

        String result = "";
        final Writer writer = new StringWriter();
        final PrintWriter printWriter = new PrintWriter(writer);
        try {
            aThrowable.printStackTrace(printWriter);
            result = writer.toString();
        } catch (Exception e) {
            LOGGER.error("get stack trace error", e);
        } finally {
            printWriter.close();
        }

        if (length > 0 && result.length() > length) {
            result = result.substring(0, length);
        }
        return result;
    }

    public static Integer getInteger(String value) {
        if (StringUtils.isNotBlank(value)) {
            return new Integer(value);
        }
        return null;
    }

    public static Double getDouble(String value) {
        if (StringUtils.isNotBlank(value)) {
            return new Double(value);
        }
        return null;
    }

    /**
     * 将num前置补0至length的长度<br>
     *
     * @param number 序号
     * @param length 总长度
     * @return
     */
    public static String appendZero(Long number, int length) {
        String pattern = "%0" + length + "d";
        return String.format(pattern, number);
    }
}
