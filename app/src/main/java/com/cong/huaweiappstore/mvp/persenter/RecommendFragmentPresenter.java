package com.cong.huaweiappstore.mvp.persenter;

import com.cong.huaweiappstore.mvp.view.framgent.RecommendFragmentView;

/**
 * Created by Administrator on 2018/1/16
 */

public interface RecommendFragmentPresenter extends BasePresenter<RecommendFragmentView> {
    void getRecommendData();
}
