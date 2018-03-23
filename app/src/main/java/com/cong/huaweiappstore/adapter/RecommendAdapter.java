package com.cong.huaweiappstore.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cong.huaweiappstore.R;

/**
 * @author Cong
 * @date 2018/2/5
 * @description
 */

public class RecommendAdapter extends RecyclerView.Adapter {
    private Context context;
    private final LayoutInflater inflater;

    public RecommendAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(inflater.inflate(R.layout.test, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ((ViewHolder) holder).tv.setText("我是推荐页-----------");
    }

    @Override
    public int getItemCount() {
        return 99;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv;

        public ViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
        }
    }
}
