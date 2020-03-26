package com.hxoim.common.utils;

public class StringUilt {

    public static boolean isStrOrnull(String str) {
        return str == null || str.length() == 0 ? false : true;
    }

    /**
     * @description:判断字符串是否为空或null
     * @author:杨波
     * @date:2019-06-12 * @param str
     * @return:boolean
     **/
    public static boolean stringIsNullOrEmpty(String str) {
        return (str == null || str.isEmpty()) ? true : false;
    }

    /**
     * @description:首字母转大写
     * @author:杨波
     * @date:2019-06-12 * @param s
     * @return:java.lang.String
     **/
    public static String toUpperCaseFirstOne(String s) {
        if (Character.isUpperCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }
}
