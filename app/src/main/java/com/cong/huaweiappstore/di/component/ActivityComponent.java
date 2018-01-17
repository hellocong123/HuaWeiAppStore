package com.cong.huaweiappstore.di.component;

import android.app.Activity;
import android.content.Context;

import com.cong.huaweiappstore.di.module.ActivityModule;
import com.cong.huaweiappstore.di.scope.ContextLife;
import com.cong.huaweiappstore.di.scope.PerActivity;

import dagger.Component;

/**
 * <p>Description:
 *
 * @author xzhang
 */
@PerActivity
@Component(modules = ActivityModule.class,dependencies = ApplicationComponent.class)
public interface ActivityComponent {
    @ContextLife("Activity")
    Context getActivityContext();

    @ContextLife("Application")
    Context getApplicationContext();

    Activity getActivity();


}
