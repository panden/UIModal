package com.i370.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by siwei.zhao on 2016/6/2.
 */
public abstract class BaseFragment extends Fragment{

    protected View mBaseView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBaseView=inflater.inflate(setCreateViewRes(), container, false);
        initView(mBaseView);
        initData();
        initEvent();
        return mBaseView;
    }

    /**设置Fragment的布局*/
    protected abstract int setCreateViewRes();

    /**初始化控件*/
    protected abstract void initView(View baseView);

    //初始化数据
    protected abstract void initData();

    //初始化事件
    protected abstract void initEvent();
}
