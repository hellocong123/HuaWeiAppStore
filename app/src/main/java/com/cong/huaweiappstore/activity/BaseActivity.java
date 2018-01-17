package com.cong.huaweiappstore.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import com.cong.huaweiappstore.R;

import java.lang.reflect.Field;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/1/4.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private ViewGroup title_bar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //保持竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        AppActivityManager.getInstance().addActivity(this);

        //当系统版本为4.4或者4.4以上时可以使用沉浸式状态栏
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            //透明状态栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            //透明导航栏
////            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//        }

        initLayout();
        ButterKnife.bind(this);
        initView();

        initData();
    }

    /**
     * 布局ID
     */
    protected abstract void initLayout();

    /**
     * 初始化view
     */
    protected abstract void initView();

    /**
     * 初始化数据
     */
    protected void initData() {
    }


    /**
     * 设置沉浸式状态栏
     */

    protected void setStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            title_bar = findViewById(R.id.bar_layout);
            //    ViewGroup title_bar =     findViewById(R.id.bar_layout);
            final int statusHeight = getStatusBarHeight();
            title_bar.post(new Runnable() {
                @Override
                public void run() {
                    int titleHeight = title_bar.getHeight();
                    android.widget.RelativeLayout.LayoutParams params = (android.widget.RelativeLayout.LayoutParams) title_bar.getLayoutParams();
                    params.height = statusHeight + titleHeight;
                    title_bar.setLayoutParams(params);
                }
            });
        }
    }

    /**
     * 获取状态栏的高度
     *
     * @return
     */
    protected int getStatusBarHeight() {
        try {
            Class<?> c = Class.forName("com.android.internal.R$dimen");
            Object obj = c.newInstance();
            Field field = c.getField("status_bar_height");
            int x = Integer.parseInt(field.get(obj).toString());
            return getResources().getDimensionPixelSize(x);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);

        overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_left);
    }


}
