package com.noahedu.yxputils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Author: shaoqw
 * Date: 2021/1/1 9:52
 * Description:
 */
public class YxpThreadPoolUtils {

    private Future mFuture;
    private ExecutorService mExecutorService;

    public YxpThreadPoolUtils(int size){

        mExecutorService = Executors.newFixedThreadPool(1);
    }

    public void startSumit(Runnable runnable){

        if(mFuture == null || (mFuture != null && mFuture.isDone())){

            if(mExecutorService != null){

                mFuture = mExecutorService.submit(runnable);
            }
        }
    }

    public void startExecute(Runnable runnable){

        if(mExecutorService != null){

            mExecutorService.execute(runnable);
        }

    }

    public void cancelSubmit(){

        if(mFuture != null){

            mFuture.cancel(true);
        }
    }

}
