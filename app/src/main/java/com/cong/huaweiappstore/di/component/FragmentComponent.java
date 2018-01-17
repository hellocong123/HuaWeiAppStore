package com.cong.huaweiappstore.di.component;

import android.app.Activity;
import android.content.Context;

import com.cong.huaweiappstore.di.module.FragmentModule;
import com.cong.huaweiappstore.di.scope.ContextLife;
import com.cong.huaweiappstore.di.scope.PerFragment;
import com.cong.huaweiappstore.fragment.CategoryFragment;
import com.cong.huaweiappstore.mvp.view.RecommendFragment;
import com.cong.huaweiappstore.fragment.TopFragment;

import dagger.Component;

/**
 * <p>Description:
 *
 * @author xzhang
 */

@PerFragment
@Component(dependencies = ApplicationComponent.class,modules = FragmentModule.class)
public interface FragmentComponent {

    @ContextLife("Activity")
    Context getActivityContext();

    @ContextLife("Application")
    Context getApplicationContext();

    Activity getActivity() ;

    void inject(RecommendFragment fragment) ;
    void inject(CategoryFragment fragment) ;
    void inject(TopFragment fragment) ;

}
