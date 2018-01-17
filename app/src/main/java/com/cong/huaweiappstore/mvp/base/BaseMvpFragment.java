package com.cong.huaweiappstore.mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.cong.huaweiappstore.activity.StoreApplication;
import com.cong.huaweiappstore.di.component.DaggerFragmentComponent;
import com.cong.huaweiappstore.di.component.FragmentComponent;
import com.cong.huaweiappstore.di.module.FragmentModule;
import com.cong.huaweiappstore.fragment.BaseFragment;
import com.cong.huaweiappstore.mvp.BasePresenter;
import com.cong.huaweiappstore.mvp.BaseView;

/**
 * Created by Administrator on 2018/1/16
 */

public abstract class BaseMvpFragment<T extends BasePresenter> extends BaseFragment implements BaseView {

    public FragmentComponent fragmentComponent;

    private T presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFragmentComponent();
        presenter = initInjector();
        presenter.attachView(this);
    }


    private void initFragmentComponent() {

        fragmentComponent = DaggerFragmentComponent.builder()
                .applicationComponent(((StoreApplication) getActivity().getApplication()).getApplicationComponent())
                .fragmentModule(new FragmentModule(this))
                .build();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
        }
    }

    protected abstract T initInjector();
}
