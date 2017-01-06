package com.example.zhangqi.onion.api;


import com.example.zhangqi.onion.bean.HttpWrapper;
import com.example.zhangqi.onion.bean.User;

import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by zhangqi on 2016/9/12.
 */
public interface Api {

    @POST("main")
    Observable<HttpWrapper<User>> main();

}

