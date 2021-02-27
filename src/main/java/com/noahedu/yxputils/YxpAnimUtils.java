package com.noahedu.yxputils;


import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;

/**
 * Author: shaoqw
 * Date: 2020/12/25 14:21
 * Description: 仅用于播放帧动画
 */
public class YxpAnimUtils {

    private View mView;
    private int mDrawableIds[];
    private Handler mHander;
    private Handler.Callback mCallback;
    private long delayTime;
    private int mCurrentIndex;
    private boolean isStop = true;
    private final int MSG_UPDATE = 100;
    private final int MSG_PAUSE = 101;
    private final int MSG_STOP = 102;


    public YxpAnimUtils(final View mView, final int[] mDrawableIds, final long delayTime) {
        this.mView = mView;
        this.mDrawableIds = mDrawableIds;
        this.delayTime = delayTime;
        mCallback = new Handler.Callback() {
            @Override
            public boolean handleMessage(@NonNull Message msg) {

                int what = msg.what;
                if(what == MSG_UPDATE){

                    if(mView != null && mDrawableIds != null && !isStop){

                        mCurrentIndex++;
                        if(mCurrentIndex == mDrawableIds.length){

                            mCurrentIndex = 0;
                        }
                        mView.setBackgroundResource(mDrawableIds[mCurrentIndex]);
                        mHander.removeMessages(MSG_UPDATE);
                        mHander.sendEmptyMessageDelayed(MSG_UPDATE, delayTime);
                    }
                }

                return true;
            }
        };
        mHander = new Handler(mCallback);
    }

    public void startAnim(){

        if(mHander != null && isStop){

            isStop = false;
            mHander.removeMessages(MSG_UPDATE);
            mHander.sendEmptyMessage(MSG_UPDATE);
        }
    }

    public void stopAnim(){

        if(mHander != null){

            isStop = true;
            mCurrentIndex = 0;
            mHander.removeMessages(MSG_UPDATE);
        }
    }

    public void pauseAnim(){

        if(mHander != null){

            isStop = true;
            mHander.removeMessages(MSG_UPDATE);
        }

    }
}
