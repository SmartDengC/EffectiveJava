package org.hahadeng.util;

/**
 * 字符工具类
 *
 * @author 邓聪
 */
public class ImcStringUtil {
    /**
     * 判断字符串是否为空
     *
     * @param str
     * @return boolean
     */
    public static boolean isEmpty(Object str) {
        return (str == null || (String.valueOf(str)).trim().length() < 1);
    }

    /**
     * 判断字符串是否为非空
     *
     * @param str
     * @return boolean
     */
    public static boolean isNotEmpty(Object str) {
        return !isEmpty(str);
    }
}
