package com.noahedu.yxputils;

import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.Lifecycle;
import android.support.annotation.NonNull;

/**
 * Author: shaoqw
 * Date: 2020/9/8 15:33
 * Description: 优学派工具类
 */
public class YxpUtils {

    private static Application mApp;
    private static boolean isDebug;

    public static void init(Application app){

        mApp = app;
    }

    public static void setDebug(boolean isDebug){

        YxpUtils.isDebug = isDebug;
    }


    public static Application getApp(){

        if(mApp != null){

            return mApp;
        }else{

            throw new NullPointerException("you should init first");
        }
    }

    public static boolean isDebug(){

        return isDebug;
    }


    ///////////////////////////////////////////////////////////////////////////
    // interface
    ///////////////////////////////////////////////////////////////////////////

    public abstract static class Task<Result> extends YxpThreadUtils.SimpleTask<Result> {

        private Consumer<Result> mConsumer;

        public Task(final Consumer<Result> consumer) {
            mConsumer = consumer;
        }

        @Override
        public void onSuccess(Result result) {
            if (mConsumer != null) {
                mConsumer.accept(result);
            }
        }
    }

    public interface OnAppStatusChangedListener {
        void onForeground(Activity activity);

        void onBackground(Activity activity);
    }

    public static class ActivityLifecycleCallbacks {

        public void onActivityCreated(@NonNull Activity activity) {/**/}

        public void onActivityStarted(@NonNull Activity activity) {/**/}

        public void onActivityResumed(@NonNull Activity activity) {/**/}

        public void onActivityPaused(@NonNull Activity activity) {/**/}

        public void onActivityStopped(@NonNull Activity activity) {/**/}

        public void onActivityDestroyed(@NonNull Activity activity) {/**/}

        public void onLifecycleChanged(@NonNull Activity activity, Lifecycle.Event event) {/**/}
    }

    public interface Consumer<T> {
        void accept(T t);
    }

    public interface Supplier<T> {
        T get();
    }

    public interface Func1<Ret, Par> {
        Ret call(Par param);
    }

}
