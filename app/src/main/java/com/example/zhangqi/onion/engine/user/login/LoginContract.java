package com.example.zhangqi.onion.engine.user.login;

import com.example.zhangqi.onion.mvp.presenter.BasePresenter;
import com.example.zhangqi.onion.mvp.view.BaseView;

/**
 * Created by zhangqi on 2017/1/6.
 */

public interface LoginContract {

    interface View extends BaseView<Presenter>{}

    interface Presenter extends BasePresenter{}
}
