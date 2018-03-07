package com.example.lenovo.wangshaoliang20180306.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.wangshaoliang20180306.R;
import com.example.lenovo.wangshaoliang20180306.Utils.MyBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2018/3/6.
 */

public class MyGridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private MyBean.MiaoshaBean list;

    public MyGridAdapter(Context context, MyBean.MiaoshaBean list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_grid, null);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder=(ViewHolder)holder;
        viewHolder.tv.setText(list.getList().get(position).getTitle());
        String images = list.getList().get(position).getImages();
        String[] split = images.split("\\|");
        String s = split[0];
        viewHolder.simpl.setImageURI(s);

    }

    @Override
    public int getItemCount() {
        return list.getList().size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.simpl_grid)
        SimpleDraweeView simpl;
        @BindView(R.id.tv)
        TextView tv;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
