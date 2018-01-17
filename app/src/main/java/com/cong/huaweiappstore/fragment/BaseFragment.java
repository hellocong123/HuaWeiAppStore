package com.cong.huaweiappstore.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cong.huaweiappstore.view.LoadingPage;

/**
 * Created by Administrator on 2018/1/4
 */

public abstract class BaseFragment extends Fragment {


    public LoadingPage loadingPage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (loadingPage == null) {
            loadingPage = new LoadingPage(getContext()) {
                @Override
                protected View createSuccessView() {
                    return BaseFragment.this.createSuccessView();
                }

                @Override
                protected void load() {
                    BaseFragment.this.load();
                }
            };
        }


        return loadingPage;
    }


    public void show() {
        if (loadingPage!=null){

            loadingPage.show();
        }
    }

    protected void setState(LoadingPage.LoadResult result) {
        if (loadingPage!=null){

            loadingPage.setState(result);
        }
    }

    protected abstract void load();

    protected abstract View createSuccessView();


}
