package com.cong.huaweiappstore.mvp.persenter;

import com.cong.huaweiappstore.mvp.view.framgent.BaseView;

/**
 * Created by Administrator on 2018/1/16
 */

public class BasePresenterImpl<T extends BaseView> implements BasePresenter<T> {

    protected T presenterView;

    @Override
    public void attachView(T view) {
        this.presenterView = view;
    }

    @Override
    public void detachView() {
        this.presenterView = null;
    }
}
