package com.cong.huaweiappstore.di.component;

import android.content.Context;

import com.cong.huaweiappstore.di.module.ApplicationModule;
import com.cong.huaweiappstore.di.scope.ContextLife;
import com.cong.huaweiappstore.di.scope.PerApp;

import dagger.Component;

/**
 * <p>Description:
 *
 * @author xzhang
 */
@PerApp
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    @ContextLife("Application")
    Context getApplication() ;
}
