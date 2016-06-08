package com.i370.ui;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;

import com.i370.ui.app.MyActivityManager;

/**
 * Created by siwei.zhao on 2016/6/8.
 */
public abstract class BaseActivity extends FragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        MyActivityManager.getManager().addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyActivityManager.getManager().moveActivity(this);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        initView();
        initData();
        initEvent();
    }

    /**初始化控件,初始化顺序为：initView、initData、initEvent*/
    public abstract void initView();

    /**初始化s数据,初始化顺序为：initView、initData、initEvent*/
    public abstract void initData();

    /**初始化事件,初始化顺序为：initView、initData、initEvent*/
    public abstract void initEvent();

}
