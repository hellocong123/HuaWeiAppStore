package com.cong.huaweiappstore.mvp.view.framgent;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cong.huaweiappstore.R;
import com.cong.huaweiappstore.adapter.RecommendAdapter;
import com.cong.huaweiappstore.http.Recommend;
import com.cong.huaweiappstore.mvp.base.BaseMvpFragment;
import com.cong.huaweiappstore.mvp.persenter.RecommendFragmentPresenterImpl;
import com.cong.huaweiappstore.view.LoadingPage;
import com.zhxu.recyclerview.adapter.CommonAdapter;
import com.zhxu.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/1/4
 */

public class RecommendFragment extends BaseMvpFragment<RecommendFragmentPresenterImpl> implements RecommendFragmentView {

    @Inject
    public RecommendFragmentPresenterImpl recommendFragmentPresenter;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    Unbinder unbinder;
    private TextView tv;
    private Recommend recommend;
    private Recommend2Adapter adapter;
    private List<String> list;

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

        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_recommend, null);
        unbinder = ButterKnife.bind(this, view);

        adapter = new Recommend2Adapter(getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter.addDataAll(list);

        return view;
    }


    @Override
    protected RecommendFragmentPresenterImpl initInjector() {
        //完成依赖注入
        fragmentComponent.inject(this);
        //返回注入的Presenter
        return recommendFragmentPresenter;
    }

    @Override
    public void onRecommendDataSuccess(Recommend value) {
        setState(LoadingPage.LoadResult.success);
        this.recommend = value;

        list = new ArrayList<>();
        for (int i = 0; i < 99; i++) {
            list.add("我是条目-------"+i);
        }



    }

    @Override
    public void onRecommendDataError() {
        setState(LoadingPage.LoadResult.error);
    }

    @Override
    public void showToast(String msg) {

    }


    public class Recommend2Adapter extends CommonAdapter<String> {

        public Recommend2Adapter(Context context) {
            super(context, R.layout.test);
        }

        @Override
        protected void convert(ViewHolder holder, String s, int position) {

            holder.setText(R.id.tv, s);
        }
    }
}
