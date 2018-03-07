package com.example.lenovo.wangshaoliang20180306.Utils;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by lenovo on 2018/3/6.
 */

public interface ServiceAPI {
    @GET(UtilsAPI.TAGS_URL)
    Flowable<MyBean> ben();
    //http://120.27.23.105/product/getCarts
    @GET(UtilsAPI.SHOP_URL)
    Flowable<ShopCar> getNews(@QueryMap Map<String, String> map);
}
