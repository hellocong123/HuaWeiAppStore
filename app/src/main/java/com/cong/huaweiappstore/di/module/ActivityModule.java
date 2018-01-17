package com.cong.huaweiappstore.di.module;

import android.app.Activity;
import android.content.Context;

import com.cong.huaweiappstore.di.scope.ContextLife;
import com.cong.huaweiappstore.di.scope.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * <p>Description:
 *
 * @author xzhang
 */

@Module
public class ActivityModule {

    private Activity mActivity ;

    public ActivityModule(Activity activity){
        this.mActivity = activity ;
    }

    @Provides
    @PerActivity
    @ContextLife("Activity")
    public Context provideActivityContext(){
        return mActivity ;
    }

    @Provides
    @PerActivity
    public Activity provideActivity(){
        return mActivity ;
    }
}
