package com.noahedu.yxputils;

/**
 * Author: shaoqw
 * Date: 2020/9/8 15:55
 * Description: 字符串工具类
 */
public class YxpStringUtils {

    /**
     * @return is the charsequence empty
     */
    public static boolean isEmpty(CharSequence s ){

        if(s == null || s.length() == 0){

            return true;
        }

        return false;
    }


    /**
     * Return whether the string is null or white space.
     *
     * @param s The string.
     * @return {@code true}: yes<br> {@code false}: no
     */
    public static boolean isSpace(final String s) {
        if (s == null){

            return true;
        }
        for (int i = 0, len = s.length(); i < len; ++i) {
            if (!Character.isWhitespace(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
