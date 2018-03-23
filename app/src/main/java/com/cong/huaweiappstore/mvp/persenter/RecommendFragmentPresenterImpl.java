package com.cong.huaweiappstore.mvp.persenter;

import android.os.SystemClock;
import android.util.Log;

import com.cong.huaweiappstore.http.ApiService;
import com.cong.huaweiappstore.http.Recommend;
import com.cong.huaweiappstore.http.RetrofitClient;
import com.cong.huaweiappstore.mvp.view.framgent.RecommendFragmentView;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

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

        Observable<Recommend> recommendData = RetrofitClient.getInstance().provideApiService().getRecommendData();

        recommendData.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<Recommend>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Recommend value) {
                        presenterView.onRecommendDataSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        presenterView.onRecommendDataError();
                    }

                    @Override
                    public void onComplete() {

                    }
                });


//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                SystemClock.sleep(2000);
//                presenterView.onRecommendDataError();
//                Log.i(TAG, "run: 推荐");
//            }
//        }).start();

    }
}
