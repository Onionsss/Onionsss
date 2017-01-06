package com.example.zhangqi.onion.mvp.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.zhangqi.onion.R;

import butterknife.ButterKnife;

/**
 * Created by zhangqi on 2016/9/28.
 */

public abstract class SimpleBaseActivity extends RxBaseActivity{


    protected ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        attachPre();
        
        setContentView(getLayoutId());
        ButterKnife.bind(this);

        mProgressDialog = new ProgressDialog(this,
                R.style.AppTheme_Dark_Dialog);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage("未知操作");
        mProgressDialog.setCancelable(false);

        initView();
        
        initData();
    }

    @Override
    protected void onStart() {
        super.onStart();
        initListener();

        initDataOnStart();
    }

    protected abstract void attachPre();

    protected abstract int getLayoutId();

    protected void initView() {}

    protected void initData() {}

    protected void initDataOnStart() {}

    protected void initListener() {}

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
