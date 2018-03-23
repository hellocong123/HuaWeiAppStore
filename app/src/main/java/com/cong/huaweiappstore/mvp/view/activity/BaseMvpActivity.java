package com.cong.huaweiappstore.mvp.view.activity;

import android.widget.Toast;

import com.cong.huaweiappstore.activity.BaseActivity;
import com.cong.huaweiappstore.mvp.view.framgent.BaseView;

/**
 * Created by Administrator on 2018/1/16
 */

public abstract class BaseMvpActivity extends BaseActivity implements BaseView {

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}
