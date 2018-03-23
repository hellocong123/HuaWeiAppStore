package com.cong.huaweiappstore.mvp.persenter;

import com.cong.huaweiappstore.mvp.view.framgent.BaseView;

/**
 * Created by Administrator on 2018/1/16.
 */

public interface BasePresenter<T extends BaseView> {
    void attachView(T view);
    void detachView();
}
