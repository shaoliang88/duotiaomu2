package com.example.lenovo.wangshaoliang20180306.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.lenovo.wangshaoliang20180306.R;
import com.example.lenovo.wangshaoliang20180306.ShopActivity;
import com.example.lenovo.wangshaoliang20180306.Utils.MyBean;
import com.youth.banner.Banner;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2018/3/6.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private MyBean bean;

    public MyAdapter(Context context, MyBean bean) {
        this.context = context;
        this.bean = bean;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View v = View.inflate(context, R.layout.itembanner, null);
            BannerViewHolder holder = new BannerViewHolder(v);
            return holder;
        } else if (viewType == 1) {
            View v = View.inflate(context, R.layout.item_two, null);
            TwoViewHolder holder = new TwoViewHolder(v);
            return holder;
        } else if (viewType == 2) {
            View v = View.inflate(context, R.layout.item_three, null);
            RecyclerView.ViewHolder holder = new ThreeViewHolder(v);
            return holder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof BannerViewHolder) {
            BannerViewHolder viewholder = (BannerViewHolder) holder;
            List<String> bannerList = new ArrayList<>();

            for (int i = 0; i < bean.getData().size(); i++) {
                bannerList.add(bean.getData().get(i).getIcon());
            }
            viewholder.itemBanner.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Glide.with(context).load(path).into(imageView);
                }
            });
            viewholder.itemBanner.setImages(bannerList);
            viewholder.itemBanner.setDelayTime(3000);
            viewholder.itemBanner.setBannerAnimation(Transformer.DepthPage).isAutoPlay(true);
            viewholder.itemBanner.start();

        }else if (holder instanceof TwoViewHolder) {
            TwoViewHolder viewholder2 = (TwoViewHolder) holder;
            viewholder2.recyclerTwo.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL));
            MyGridAdapter adapter = new MyGridAdapter(context, bean.getMiaosha());
            viewholder2.recyclerTwo.setAdapter(adapter);

        } else if (holder instanceof ThreeViewHolder) {
            ThreeViewHolder viewholder3 = (ThreeViewHolder) holder;
            MyIndexAdapter adapter=new MyIndexAdapter(context,bean.getTuijian());
            viewholder3.recyclerThree.setAdapter(adapter);
            viewholder3.recyclerThree.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
            adapter.setOnItemClickListener(new MyIndexAdapter.OnItemClickListener() {
                @Override
                public void onClick(int position) {
                    Intent intent=new Intent(context, ShopActivity.class);
                    context.startActivity(intent);
                }

                @Override
                public void onLongClick(int position) {

                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (position == 1) {
            return 1;
        }
        else if (position == 2) {
            return 2;
        }
        return 3;
    }
    @Override
    public int getItemCount() {
        return 3;
    }

    static class BannerViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_banner)
        Banner itemBanner;

        BannerViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class TwoViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.recycler_two)
        RecyclerView recyclerTwo;

        TwoViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class ThreeViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.recycler_three)
        RecyclerView recyclerThree;

        ThreeViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
