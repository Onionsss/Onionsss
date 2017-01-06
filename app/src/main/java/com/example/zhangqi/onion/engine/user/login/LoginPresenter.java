package com.example.zhangqi.onion.engine.user.login;

import android.content.Context;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by zhangqi on 2017/1/6.
 */

public class LoginPresenter implements LoginContract.Presenter{

    private CompositeSubscription mCompositeSubscription;
    private LoginContract.View mView;
    private Context mContext;

    public LoginPresenter(Context context, LoginContract.View view, CompositeSubscription compositeSubscription){
        mContext = context;
        mView = view;
        mCompositeSubscription = compositeSubscription;
        mView.setPresenter(this);
    }


}
