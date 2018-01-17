package com.cong.huaweiappstore.fragment;

import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.cong.huaweiappstore.view.LoadingPage;

import static android.content.ContentValues.TAG;


/**
 * Created by Administrator on 2018/1/4
 */

public class AppManagerFragment extends BaseFragment {


    @Override
    protected void load() {

        new Thread(new Runnable() {
            @Override
            public void run() {

                SystemClock.sleep(2000);
                setState(LoadingPage.LoadResult.success);
                Log.i(TAG, "AppManagerFragment: -------");
            }
        }).start();
    }

    @Override
    protected View createSuccessView() {
        TextView tv = new TextView(getContext());
        tv.setText("App管理");
        return tv;
    }


}
