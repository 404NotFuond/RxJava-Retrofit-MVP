package com.taopao.rxjavaretrofitcutmvp.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.taopao.rxjavaretrofitcutmvp.R;
import com.taopao.rxjavaretrofitcutmvp.ui.base.BaseActivity;
import com.taopao.rxjavaretrofitcutmvp.ui.base.BasePresenter;
import com.taopao.rxjavaretrofitcutmvp.ui.base.BaseView;
import com.taopao.rxjavaretrofitcutmvp.widget.FriendRefreshView;

/**
 * ━━━━━━神兽出没━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃  神兽保佑
 * 　　　　┃　　　┃  代码无bug
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　     ┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━感觉萌萌哒━━━━━━
 *
 * @Author: 淘跑
 * @Data: 2018/1/30 08:46
 * @Use: 仿微信朋友圈下拉刷新
 */

public class FrActivity extends BaseActivity implements FriendRefreshView.OnRefreshListener {
    private ListView lv;
    private FriendRefreshView frv;
    private String citys[]=new String[]{
            "北京",
            "上海",
            "广州",
            "成都",
            "安徽"
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fr);
        initView();

    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public BaseView createView() {
        return null;
    }

    private void initView() {
        lv = (ListView) findViewById(R.id.lv);
        frv = (FriendRefreshView) findViewById(R.id.frv);


        ArrayAdapter<String> dataAdpater=new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,citys);
        frv.setAdapter(dataAdpater);
        lv.setAdapter(dataAdpater);

        frv.setOnRefreshListener(this);
    }

    @Override
    public void onRefresh() {
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                frv.stopRefresh();
            }
        }.start();
    }
}
