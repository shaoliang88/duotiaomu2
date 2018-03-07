package com.example.lenovo.wangshaoliang20180306.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.wangshaoliang20180306.R;
import com.example.lenovo.wangshaoliang20180306.Utils.MyBean;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2018/3/6.
 */

public class MyIndexAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private MyBean.TuijianBean list;
    private OnItemClickListener mOnItemClickListener;

    public MyIndexAdapter(Context context, MyBean.TuijianBean list) {
        this.context = context;
        this.list = list;
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_index, null);
     ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
ViewHolder viewHolder=(ViewHolder)holder;
        viewHolder.tv.setText(list.getList().get(position).getTitle());
        String images = list.getList().get(position).getImages();
        String[] split = images.split("\\|");
        String s = split[0];
        viewHolder.simpl.setImageURI(s);
        if( mOnItemClickListener!= null){
            viewHolder.itemView.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onClick(position);
                }
            });
            viewHolder. itemView.setOnLongClickListener( new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mOnItemClickListener.onLongClick(position);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.getList().size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.simpl)
        SimpleDraweeView simpl;
        @BindView(R.id.tv)
        TextView tv;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
    public interface OnItemClickListener{
        void onClick( int position);
        void onLongClick( int position);
    }
    public void setOnItemClickListener(MyIndexAdapter.OnItemClickListener onItemClickListener ){
        this. mOnItemClickListener=onItemClickListener;
    }
}
