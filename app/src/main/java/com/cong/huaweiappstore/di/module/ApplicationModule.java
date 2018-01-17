package com.cong.huaweiappstore.di.module;

import android.content.Context;

import com.cong.huaweiappstore.activity.StoreApplication;
import com.cong.huaweiappstore.di.scope.ContextLife;
import com.cong.huaweiappstore.di.scope.PerApp;

import dagger.Module;
import dagger.Provides;

/**
 * <p>Description:
 *
 * @author xzhang
 */

@Module
public class ApplicationModule {

    private StoreApplication mApplication ;

    public ApplicationModule(StoreApplication application){
        this.mApplication = application ;
    }

    @Provides
    @PerApp
    @ContextLife("Application")
    public Context provideApplicationContext(){
        return mApplication.getApplicationContext() ;
    }

}
