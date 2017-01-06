package com.example.zhangqi.onion.mvp.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.zhangqi.onion.R;
import com.example.zhangqi.onion.mvp.presenter.BasePresenter;

import butterknife.ButterKnife;

/**
 * Created by zhangqi on 2016/9/28.
 */

public abstract class BaseActivity<P extends BasePresenter> extends RxBaseActivity{

    protected P mPresenter;
    protected ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        attachPre();


        setContentView(getLayoutId());
        ButterKnife.bind(this);

        /**
         * 5.0以下 状态栏着色
         */
//        if(Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT){
//            UtilsCollection.setColor(this, Color.parseColor(Constant.TOOLBAR_COLOR),0);
//        }

        mProgressDialog = new ProgressDialog(this,
                R.style.AppTheme_Dark_Dialog);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage("未知操作");
        mProgressDialog.setCancelable(false);
        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        initData();
        initListener();
    }

    protected void initView() {}

    protected abstract void attachPre();

    protected abstract int getLayoutId();

    protected void initData() {}

    protected void initListener() {}

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
