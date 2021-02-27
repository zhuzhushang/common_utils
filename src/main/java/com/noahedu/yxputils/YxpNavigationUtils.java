package com.noahedu.yxputils;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings;
import android.view.View;
import android.view.ViewTreeObserver;

/**
 * Author: shaoqw
 * Date: 2020/11/24 9:35
 * Description: 导航栏工具
 */
public class YxpNavigationUtils {

    /**
     * 手势导航
     */
    public static int NAV_STYLE_GESTURE = 1;
    /**
     * 三键导航
     */
    public static int NAV_STYLE_THREE_KEYBROAD = 2;
    /**
     * 导航方式的contentprovider
     */
    public static String NAV_CONTENT_PROVIDER_KEY = "noah_navi_mode_value";



    /**
     * @return 得到导航栏方式
     *
     * 0：获取错误
     * 1：手势导航
     * 2：三键导航
     */
    public static int getNavigationStyle(Context context){

        int mode = 0;
        try {
            mode = Settings.System.getInt(context.getApplicationContext().getContentResolver(),NAV_CONTENT_PROVIDER_KEY,NAV_STYLE_THREE_KEYBROAD);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mode;
    }

    /**
     * 设置Navigation显示和隐藏回调
     */
    public static void addNavigationBarListener(Activity activity, final OnNavigationBarListener l) {

        if (activity == null || l == null) {
            return;
        }

        final View decorView = activity.getWindow().getDecorView();
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            int visibility = -1;

            @Override
            public void onGlobalLayout() {

                int visibilityNow = decorView.getSystemUiVisibility();
                if (visibility != visibilityNow) {
                    visibility = visibilityNow;
                    if ((visibility & View.SYSTEM_UI_FLAG_HIDE_NAVIGATION) > 0) {
                        l.onNavigationBarShow(false);
                    } else {
                        l.onNavigationBarShow(true);
                    }
                }
            }
        });
    }

    public interface OnNavigationBarListener {
        void onNavigationBarShow(boolean show);
    }
}
