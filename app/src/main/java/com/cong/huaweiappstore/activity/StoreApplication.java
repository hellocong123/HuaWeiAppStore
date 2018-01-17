package com.cong.huaweiappstore.activity;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import com.cong.huaweiappstore.di.component.ApplicationComponent;
import com.cong.huaweiappstore.di.component.DaggerApplicationComponent;
import com.cong.huaweiappstore.di.module.ApplicationModule;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public class StoreApplication extends Application {

    private static int mMainThreadId;
    private static Handler mHandler;

    public static Context context;
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mHandler = new Handler();

        context = getApplicationContext();

        initApplicationComponent();
    }

    private void initApplicationComponent() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }


    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    /**
     * 返回主线程的pid
     *
     * @return
     */
    public static int getMainThreadId() {
        return mMainThreadId;
    }

    /**
     * 返回Handler
     *
     * @return
     */
    public static Handler getHandler() {
        return mHandler;
    }
}
