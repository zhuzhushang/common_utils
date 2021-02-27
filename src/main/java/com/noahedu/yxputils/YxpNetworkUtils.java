package com.noahedu.yxputils;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


/**
 * Author: shaoqw
 * Date: 2020/11/23 19:50
 * Description: 网络相关工具类
 */
public class YxpNetworkUtils {


    /**
     * Return whether network is connected.
     * <p>Must hold {@code <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />}</p>
     *
     * @return {@code true}: connected<br>{@code false}: disconnected
     */
    public static boolean isConnected() {
        NetworkInfo info = getActiveNetworkInfo();
        return info != null && info.isConnected();
    }

    private static NetworkInfo getActiveNetworkInfo() {
        ConnectivityManager cm =
                (ConnectivityManager) YxpUtils.getApp().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm == null) {

            return null;
        }
        return cm.getActiveNetworkInfo();
    }

    /**
     * Open the settings of wireless.
     */
    public static void openWirelessSettings() {
        YxpUtils.getApp().startActivity(
                new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS)
                        .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        );
    }




}
