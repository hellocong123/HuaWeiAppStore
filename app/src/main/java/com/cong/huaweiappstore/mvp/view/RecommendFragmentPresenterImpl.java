package com.cong.huaweiappstore.mvp.view;

import android.os.SystemClock;
import android.util.Log;

import com.cong.huaweiappstore.mvp.BasePresenterImpl;
import com.cong.huaweiappstore.mvp.persenter.RecommendFragmentPresenter;

import javax.inject.Inject;

import static android.content.ContentValues.TAG;

/**
 * Created by Administrator on 2018/1/16
 */

public class RecommendFragmentPresenterImpl extends BasePresenterImpl<RecommendFragmentView> implements RecommendFragmentPresenter {

    @Inject
    public RecommendFragmentPresenterImpl() {
    }

    @Override
    public void getRecommendData() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(2000);
                presenterView.onRecommendDataError();
                Log.i(TAG, "run: 推荐");
            }
        }).start();

    }
}
