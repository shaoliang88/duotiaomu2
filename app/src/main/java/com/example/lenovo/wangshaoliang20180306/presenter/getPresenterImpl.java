package com.example.lenovo.wangshaoliang20180306.presenter;

import com.example.lenovo.wangshaoliang20180306.Utils.MyBean;
import com.example.lenovo.wangshaoliang20180306.Utils.getFlish;
import com.example.lenovo.wangshaoliang20180306.model.getModel;
import com.example.lenovo.wangshaoliang20180306.model.getModelImpl;
import com.example.lenovo.wangshaoliang20180306.view.getView;

/**
 * Created by lenovo on 2018/3/6.
 */

public class getPresenterImpl implements getPresenter,getFlish {
    private final getModel model;
    getView view;

    public getPresenterImpl(getView view) {
        this.view = view;
        model=new getModelImpl();
    }

    @Override
    public void onfinish(MyBean bean) {
view.ShowData(bean);
    }

    @Override
    public void guanlian() {
   model.getData(this);
    }
}
