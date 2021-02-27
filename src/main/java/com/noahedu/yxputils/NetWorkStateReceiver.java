package com.noahedu.yxputils;

/**
 * Author: shaoqw
 * Date: 2021/1/2 10:42
 * Description:
 */


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


/**
 * Created by Carson_Ho on 16/10/31.
 */
public class NetWorkStateReceiver extends BroadcastReceiver {

    private OnNetWorkChangeListener mOnNetWorkChangeListener;

    public NetWorkStateReceiver(OnNetWorkChangeListener mOnNetWorkChangeListener) {

        this.mOnNetWorkChangeListener = mOnNetWorkChangeListener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        System.out.println("网络状态发生变化");


        if (mOnNetWorkChangeListener != null) {

            mOnNetWorkChangeListener.onNetWorkChange(YxpNetworkUtils.isConnected());
        }
    }

    public interface OnNetWorkChangeListener {

        public void onNetWorkChange(boolean isConnected);
    }

}


