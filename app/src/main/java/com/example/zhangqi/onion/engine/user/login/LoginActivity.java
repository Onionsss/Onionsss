package com.example.zhangqi.onion.engine.user.login;

import com.example.zhangqi.onion.mvp.activity.SimpleBaseActivity;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * Created by zhangqi on 2016/12/29.
 */

public class LoginActivity extends SimpleBaseActivity implements LoginContract.View{

    private LoginContract.Presenter mPresenter;

    @Override
    protected void attachPre() {
        new LoginPresenter(this,this,mCompositeSubscription);
    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }
}
