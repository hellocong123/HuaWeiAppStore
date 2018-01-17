package com.cong.huaweiappstore.mvp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.cong.huaweiappstore.mvp.base.BaseMvpFragment;
import com.cong.huaweiappstore.view.LoadingPage;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/1/4
 */

public class RecommendFragment extends BaseMvpFragment<RecommendFragmentPresenterImpl> implements RecommendFragmentView {

    @Inject
    public RecommendFragmentPresenterImpl recommendFragmentPresenter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        loadingPage.show();
    }

    @Override
    protected void load() {
        recommendFragmentPresenter.getRecommendData();
    }

    @Override
    protected View createSuccessView() {
        TextView tv = new TextView(getContext());
        tv.setText("推荐界面");
        return tv;
    }


    @Override
    protected RecommendFragmentPresenterImpl initInjector() {
        //完成依赖注入
        fragmentComponent.inject(this);
        //返回注入的Presenter
        return recommendFragmentPresenter;
    }

    @Override
    public void onRecommendDataSuccess() {
        setState(LoadingPage.LoadResult.success);
    }

    @Override
    public void onRecommendDataError() {
        setState(LoadingPage.LoadResult.error);
    }

    @Override
    public void showToast(String msg) {

    }
}
