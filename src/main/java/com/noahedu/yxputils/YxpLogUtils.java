package com.noahedu.yxputils;

import android.util.Log;

import java.util.Locale;

/**
 * Author: shaoqw
 * Date: 2020/12/28 17:38
 * Description: log工具类
 */
public class YxpLogUtils {

    public static String customTagPrefix = "yxp_log";

    private YxpLogUtils() {
    }

    private static String generateTag() {
        StackTraceElement caller = new Throwable().getStackTrace()[2];
        String tag = "%s.%s(L:%d)";
        String callerClazzName = caller.getClassName();
        callerClazzName = callerClazzName.substring(callerClazzName.lastIndexOf(".") + 1);
        tag = String.format(Locale.getDefault(), tag, callerClazzName, caller.getMethodName(), caller.getLineNumber());
        tag = YxpStringUtils.isEmpty(customTagPrefix) ? tag : customTagPrefix + ":" + tag;
        return tag;
    }

    public static void d(String content) {
        if (!YxpUtils.isDebug() || YxpStringUtils.isEmpty(content)) return;
        String tag = generateTag();

        Log.d(tag, content);
    }

    public static void d(String content, Throwable tr) {
        if (!YxpUtils.isDebug() || YxpStringUtils.isEmpty(content)) return;
        String tag = generateTag();

        Log.d(tag, content, tr);
    }

    public static void e(String content) {
        if (!YxpUtils.isDebug() || YxpStringUtils.isEmpty(content)) return;
        String tag = generateTag();

        Log.e(tag, content);
    }

    public static void e(String content, Throwable tr) {
        if (!YxpUtils.isDebug() || YxpStringUtils.isEmpty(content)) return;
        String tag = generateTag();

        Log.e(tag, content, tr);
    }

    public static void i(String content) {
        if (!YxpUtils.isDebug() || YxpStringUtils.isEmpty(content)) return;
        String tag = generateTag();

        Log.i(tag, content);
    }

    public static void i(String content, Throwable tr) {
        if (!YxpUtils.isDebug() || YxpStringUtils.isEmpty(content)) return;
        String tag = generateTag();

        Log.i(tag, content, tr);
    }

    public static void v(String content) {
        if (!YxpUtils.isDebug() || YxpStringUtils.isEmpty(content)) return;
        String tag = generateTag();

        Log.v(tag, content);
    }

    public static void v(String content, Throwable tr) {
        if (!YxpUtils.isDebug() || YxpStringUtils.isEmpty(content)) return;
        String tag = generateTag();

        Log.v(tag, content, tr);
    }

    public static void w(String content) {
        if (!YxpUtils.isDebug() || YxpStringUtils.isEmpty(content)) return;
        String tag = generateTag();

        Log.w(tag, content);
    }

    public static void w(String content, Throwable tr) {
        if (!YxpUtils.isDebug() || YxpStringUtils.isEmpty(content)) return;
        String tag = generateTag();

        Log.w(tag, content, tr);
    }

    public static void w(Throwable tr) {
        if (!YxpUtils.isDebug() ) return;
        String tag = generateTag();

        Log.w(tag, tr);
    }

    public static void wtf(String content) {
        if (!YxpUtils.isDebug() || YxpStringUtils.isEmpty(content)) return;
        String tag = generateTag();

        Log.wtf(tag, content);
    }

    public static void wtf(String content, Throwable tr) {
        if (!YxpUtils.isDebug() || YxpStringUtils.isEmpty(content)) return;
        String tag = generateTag();

        Log.wtf(tag, content, tr);
    }

    public static void wtf(Throwable tr) {
        if (!YxpUtils.isDebug() ) return;
        String tag = generateTag();

        Log.wtf(tag, tr);
    }

    public static void d(String tag, String content) {
        if (!YxpUtils.isDebug() || YxpStringUtils.isEmpty(content)) return;

        Log.d(tag, content);
    }

    public static void e(String tag, String content) {
        if (!YxpUtils.isDebug() || YxpStringUtils.isEmpty(content)) return;

        Log.e(tag, content);
    }

    public static void i(String tag, String content) {
        if (!YxpUtils.isDebug() || YxpStringUtils.isEmpty(content)) return;

        Log.i(tag, content);
    }

    public static void v(String tag, String content) {
        if (!YxpUtils.isDebug() || YxpStringUtils.isEmpty(content)) return;

        Log.v(tag, content);
    }


    public static void w(String tag, String content) {
        if (!YxpUtils.isDebug() || YxpStringUtils.isEmpty(content)) return;

        Log.w(tag, content);
    }


    public static void wtf(String tag, String content) {
        if (!YxpUtils.isDebug() || YxpStringUtils.isEmpty(content)) return;

        Log.wtf(tag, content);
    }

}
