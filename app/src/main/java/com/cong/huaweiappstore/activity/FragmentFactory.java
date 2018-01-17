package com.cong.huaweiappstore.activity;

import com.cong.huaweiappstore.fragment.AppManagerFragment;
import com.cong.huaweiappstore.fragment.BaseFragment;
import com.cong.huaweiappstore.fragment.CategoryFragment;
import com.cong.huaweiappstore.fragment.MyFragment;
import com.cong.huaweiappstore.mvp.view.RecommendFragment;
import com.cong.huaweiappstore.fragment.TopFragment;

import java.util.HashMap;

/**
 * Created by Administrator on 2018/1/4.
 */

public class FragmentFactory {

    //推荐
    public static final int TAB_RECOMMEND = 0;
    //分类
    public static final int TAB_CATEGORY = 1;
    //排行
    public static final int TAB_TOP = 2;
    //管理
    public static final int TAB_APPMANAGER = 3;
    //我的
    public static final int TAB_MY = 4;

    private static HashMap<Integer, BaseFragment> fragment = new HashMap<>();

    public static BaseFragment createFragment(int index) {

        BaseFragment baseFragment = fragment.get(index);

        if (baseFragment == null) {

            switch (index) {
                case TAB_RECOMMEND:
                    baseFragment = new RecommendFragment();
                    break;

                case TAB_CATEGORY:
                    baseFragment = new CategoryFragment();
                    break;

                case TAB_TOP:
                    baseFragment = new TopFragment();
                    break;

                case TAB_APPMANAGER:
                    baseFragment = new AppManagerFragment();
                    break;

                case TAB_MY:
                    baseFragment = new MyFragment();
                    break;
            }

            // 把创建的Fragment 存起来
            fragment.put(index, baseFragment);
        }

        return baseFragment;
    }
}
