package com.noahedu.yxputils;

import android.view.Gravity;
import android.widget.Toast;

/**
 * Author: shaoqw
 * Date: 2020/9/8 19:08
 * Description: toast utils class
 */
public class YxpToastUtils {

    public static Toast mToast;

    public static void showShort(String msg){

        show(msg,Toast.LENGTH_SHORT);
    }

    public static void showLong(String msg){

        show(msg,Toast.LENGTH_LONG);
    }

    public static void show(String msg,int duration){


        if(mToast != null){

            mToast.cancel();
        }
        mToast = Toast.makeText(YxpUtils.getApp(),msg,duration);
        mToast.show();
    }

    public static void showCustom(String msg,int xoffset,int yoffset){

        mToast = Toast.makeText(YxpUtils.getApp(),msg,Toast.LENGTH_LONG);
        mToast.setGravity(Gravity.BOTTOM|Gravity.LEFT,xoffset,yoffset);
        mToast.show();
    }

    public static void ShowCenterShort(String msg){

        mToast = Toast.makeText(YxpUtils.getApp(),msg,Toast.LENGTH_SHORT);
        mToast.setGravity(Gravity.CENTER,0,0);
        mToast.show();
    }

    public static void ShowCenter(String msg){

        mToast = Toast.makeText(YxpUtils.getApp(),msg,Toast.LENGTH_LONG);
        mToast.setGravity(Gravity.CENTER,0,0);
        mToast.show();
    }


}
