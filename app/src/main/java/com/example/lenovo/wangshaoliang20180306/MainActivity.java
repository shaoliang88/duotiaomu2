package com.example.lenovo.wangshaoliang20180306;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.lenovo.wangshaoliang20180306.Adapter.MyAdapter;
import com.example.lenovo.wangshaoliang20180306.Utils.MyBean;
import com.example.lenovo.wangshaoliang20180306.presenter.getPresenter;
import com.example.lenovo.wangshaoliang20180306.presenter.getPresenterImpl;
import com.example.lenovo.wangshaoliang20180306.view.getView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements getView {

    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.shijian)
    TextView shijian;
    private int recLen = 0;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            recLen++;
            shijian.setText("" + recLen);
            handler.postDelayed(this, 1000);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
       handler.postDelayed(runnable, 1000);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        getPresenter p = new getPresenterImpl(this);
        p.guanlian();

    }

    @Override
    public void ShowData(MyBean bean) {
        recycler.setAdapter(new MyAdapter(this, bean));

    }
}
