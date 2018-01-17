package com.cong.huaweiappstore.mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.cong.huaweiappstore.activity.BaseActivity;
import com.cong.huaweiappstore.activity.StoreApplication;
import com.cong.huaweiappstore.di.component.ActivityComponent;
import com.cong.huaweiappstore.di.component.DaggerActivityComponent;
import com.cong.huaweiappstore.di.module.ActivityModule;
import com.cong.huaweiappstore.mvp.BasePresenter;
import com.cong.huaweiappstore.mvp.BaseView;

/**
 * Created by Administrator on 2018/1/16.
 */

public abstract class BaseMvpActivity<T extends BasePresenter> extends BaseActivity implements BaseView{

    private ActivityComponent activityComponent;
    protected T presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = initInjector() ;
        initActivityComponent();
    }



    protected  void initActivityComponent(){

        activityComponent = DaggerActivityComponent.builder()
                .applicationComponent(((StoreApplication) getApplication()).getApplicationComponent())
                .activityModule(new ActivityModule(this))
                .build();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (presenter!=null){
            presenter.detachView();
        }
    }

    protected abstract T initInjector();
}
