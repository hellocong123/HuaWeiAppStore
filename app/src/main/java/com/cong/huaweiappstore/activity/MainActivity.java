package com.cong.huaweiappstore.activity;


import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.cong.huaweiappstore.R;
import com.cong.huaweiappstore.adapter.FixPagerAdapter;
import com.cong.huaweiappstore.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {


    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    private String[] titles = {"推荐", "分类", "排行", "管理", "我的"};


    @Override
    protected void initLayout() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {


        List<BaseFragment> fragments = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            BaseFragment fragment = FragmentFactory.createFragment(i);
            fragments.add(fragment);
        }


        FixPagerAdapter fixPagerAdapter = new FixPagerAdapter(getSupportFragmentManager());


        fixPagerAdapter.setTitles(titles);
        fixPagerAdapter.setFragments(fragments);

        viewPager.setAdapter(fixPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);




        viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {

                BaseFragment fragment = FragmentFactory.createFragment(position);
                fragment.show();
                Log.i("TAG", "onPageSelected: " + position);
            }
        });

    }
}
