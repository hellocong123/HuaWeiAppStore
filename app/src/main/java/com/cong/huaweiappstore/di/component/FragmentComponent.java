package com.cong.huaweiappstore.di.component;

import android.app.Activity;
import android.content.Context;

import com.cong.huaweiappstore.di.module.FragmentModule;
import com.cong.huaweiappstore.di.scope.ContextLife;
import com.cong.huaweiappstore.di.scope.PerFragment;
import com.cong.huaweiappstore.fragment.CategoryFragment;
import com.cong.huaweiappstore.mvp.view.framgent.RecommendFragment;
import com.cong.huaweiappstore.fragment.TopFragment;

import dagger.Component;

/**
 * 必须定义为接口，Dagger2框架将自动生成Component的实现类，
 * 对应的类名是Dagger×××××，这里对应的实现类是DaggerFragmentComponent
 */

@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = FragmentModule.class)
// 指明Component查找Module的位置
public interface FragmentComponent {

    @ContextLife("Activity")
    Context getActivityContext();

    @ContextLife("Application")
    Context getApplicationContext();

    Activity getActivity();

    // 注入到A(Container)的方法，方法名一般使用inject
    void inject(RecommendFragment fragment);

    void inject(CategoryFragment fragment);

    void inject(TopFragment fragment);

}
