package com.cong.huaweiappstore.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;

import com.cong.huaweiappstore.R;
import com.cong.huaweiappstore.utils.UIUtils;

/**
 * Created by Administrator on 2018/1/9
 */

public abstract class LoadingPage extends FrameLayout {

    private final static int STATE_UNKOWN = 0;//默认状态
    private final static int STATE_LOADING = 1;//加载中状态
    private final static int STATE_ERROR = 2;//错误状态
    private final static int STATE_SUCCESS = 3;//成功状态
    private final static int STATE_EMPTY = 4;//空状态

    //默认状态
    private  int state = STATE_UNKOWN;

    private View loadingView;
    private View successView;
    private View emptyView;
    private View errorView;
    private FrameLayout.LayoutParams params;

    public LoadingPage(@NonNull Context context) {
        super(context);
        init();

    }


    //将布局都添加到帧布局中
    private void init() {



        params = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT);

        if (loadingView == null) {
            loadingView = UIUtils.inflate(R.layout.loading_page);
            this.addView(loadingView, params);
        }

        if (errorView == null) {
            errorView = UIUtils.inflate(R.layout.loading_error_page);
            this.addView(errorView, params);
            errorView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    show();
                }
            });
        }

        if (emptyView == null) {
            emptyView = UIUtils.inflate(R.layout.loading_page_empty);
            this.addView(emptyView, params);
        }

        showPager();

    }

    //根据不同的状态显示不同的页面
    private void showPager() {

        if (loadingView != null) {
            loadingView.setVisibility(state == STATE_UNKOWN || state == STATE_LOADING ? View.VISIBLE : View.GONE);
        }

        if (errorView != null) {
            errorView.setVisibility(state == STATE_ERROR ? View.VISIBLE : View.GONE);
        }

        if (emptyView != null) {
            emptyView.setVisibility(state == STATE_EMPTY ? View.VISIBLE : View.GONE);
        }

        if (state == STATE_SUCCESS && successView == null) {
            successView = createSuccessView();
            this.addView(successView, params);
        }


    }




    //请求网络，修改状态
    public void show() {

        // 第一次进来肯定要 转圈的 所以就算是 error和empty 也要让状态是 unload
        if (state == STATE_UNKOWN || state == STATE_ERROR || state == STATE_EMPTY) {
            //修改为加载中状态
            state = STATE_LOADING;
            //联网加载,因为网络会有延迟，所以没有执行完这里就先执行下面的showPager方法显示加载中的界面
            load();

        }

        //这里主要是显示加载网络的数据之前，先根据上面修改的状态显示加载中的界面
        showPager();

    }

    //请求网络，修改状态
    protected abstract void load();

    protected abstract View createSuccessView();

    //设置状态
    public void setState(LoadResult result) {

        state = result.getValue();

        //把加载页面的逻辑放在主线程中操作
        UIUtils.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                showPager();
            }
        });


    }

    //请求结果的枚举
    public enum LoadResult {

        error(STATE_ERROR),
        success(STATE_SUCCESS),
        empty(STATE_EMPTY);

        int value;

        LoadResult(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

}
