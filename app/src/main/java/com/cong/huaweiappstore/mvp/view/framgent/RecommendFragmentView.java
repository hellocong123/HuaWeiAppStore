package com.cong.huaweiappstore.mvp.view.framgent;

import com.cong.huaweiappstore.http.Recommend;

/**
 * Created by Administrator on 2018/1/16.
 */

public interface RecommendFragmentView extends BaseView {

    void onRecommendDataSuccess(Recommend value);

    void onRecommendDataError();

}
