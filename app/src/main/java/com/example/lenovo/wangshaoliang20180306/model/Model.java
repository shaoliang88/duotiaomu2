package com.example.lenovo.wangshaoliang20180306.model;

import com.example.lenovo.wangshaoliang20180306.Utils.RetrofitUtils;
import com.example.lenovo.wangshaoliang20180306.Utils.ShopCar;
import com.example.lenovo.wangshaoliang20180306.presenter.NewsPresenter;

import java.util.Map;

import io.reactivex.Flowable;

public class Model implements IModel {
    private NewsPresenter presenter;

    public Model(NewsPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getData(Map<String, String> map) {
        Flowable<ShopCar> flowable = RetrofitUtils.getInstance().getApiService().getNews(map);
        presenter.get(flowable);
    }
}