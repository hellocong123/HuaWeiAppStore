package com.cong.huaweiappstore.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import com.cong.huaweiappstore.fragment.BaseFragment;

import java.util.List;

/**
 * Created by Administrator on 2018/1/4.
 */

public class FixPagerAdapter extends FragmentStatePagerAdapter {

    private List<BaseFragment> fragments;
    private String[] titles;

    public FixPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }



    @Override
    public BaseFragment getItem(int position) {

        return fragments.get(position);
    }



    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);

    }

    public void setTitles(String[] titles) {
        this.titles = titles;
    }

    public void setFragments(List<BaseFragment> fragments) {
        this.fragments = fragments;
    }
}
