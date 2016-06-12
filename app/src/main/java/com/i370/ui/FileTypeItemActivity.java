package com.i370.ui;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.widget.RecyclerView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

public class FileTypeItemActivity extends BaseActivity {

    @ViewInject(R.id.list_rv)
    private RecyclerView list_rv;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_file_type_item);
    }

    @Override
    public void initView() {
        ViewUtils.inject(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initEvent() {

    }
}
