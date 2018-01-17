package com.cong.huaweiappstore.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.PermissionChecker;
import android.widget.Button;
import android.widget.ImageView;

import com.cong.huaweiappstore.R;
import com.cong.huaweiappstore.utils.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/1/4.
 */

public class WelcomeActivity extends BaseActivity {

    @BindView(R.id.iv_welcome)
    ImageView ivWelcome;
    @BindView(R.id.bt_enter_app)
    Button btEnterApp;

    private SharedPreferences sp;


    @Override
    protected void initLayout() {
        setContentView(R.layout.activity_welcome);
    }

    @Override
    protected void initView() {
        sp = getSharedPreferences("appStore", Context.MODE_PRIVATE);

        boolean isFirst = sp.getBoolean("isFirst", true);
        if (!isFirst) {
            goHome();
        }

    }

    @OnClick(R.id.bt_enter_app)
    public void enterApp() {
        goHome();
    }


    public void goHome() {
        sp.edit().putBoolean("isFirst", false).commit();

        startActivity(new Intent(this, MainActivity.class));
        finish();

        applyPermission();
    }


    public void applyPermission() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PermissionChecker.PERMISSION_GRANTED) {
                startActivity(new Intent(this, MainActivity.class));
//                startActivity(new Intent(this,TestActivity.class));
                finish();
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 0);
            }
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);


        if (grantResults[0] == PermissionChecker.PERMISSION_GRANTED) {
            ToastUtils.showToast("授权SD卡成功");

        } else {
            ToastUtils.showToast("没有授权SD卡，可能会影响应用的使用");
        }
        startActivity(new Intent(this, MainActivity.class));
//        startActivity(new Intent(this,TestActivity.class));
        finish();
    }
}
