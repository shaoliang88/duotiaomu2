package com.example.lenovo.wangshaoliang20180306.model;

import com.example.lenovo.wangshaoliang20180306.Utils.MyBean;
import com.example.lenovo.wangshaoliang20180306.Utils.ServiceAPI;
import com.example.lenovo.wangshaoliang20180306.Utils.UtilsAPI;
import com.example.lenovo.wangshaoliang20180306.Utils.getFlish;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lenovo on 2018/3/6.
 */

public class getModelImpl implements getModel {
    @Override
    public void getData(final getFlish finish) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(UtilsAPI.HOST_URL)
                .build();
        ServiceAPI serviceAPI = retrofit.create(ServiceAPI.class);
        Flowable<MyBean> bean = serviceAPI.ben();
        bean.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MyBean>() {
                    @Override
                    public void accept(MyBean bean) throws Exception {
finish.onfinish(bean);
                    }
                });
    }
}