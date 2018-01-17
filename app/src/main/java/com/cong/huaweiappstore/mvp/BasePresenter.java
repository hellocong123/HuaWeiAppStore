package com.cong.huaweiappstore.mvp;

/**
 * Created by Administrator on 2018/1/16.
 */

public interface BasePresenter<T extends BaseView> {
    void attachView(T view);
    void detachView();
}
