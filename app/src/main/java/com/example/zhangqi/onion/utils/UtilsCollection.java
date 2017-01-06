package com.example.zhangqi.onion.utils;

import android.widget.Toast;

import com.example.zhangqi.onion.global.AppCenter;
import com.example.zhangqi.onion.logger.Logger;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import retrofit2.adapter.rxjava.HttpException;

/**
 * Created by zhangqi on 2016/12/30.
 */

public class UtilsCollection {
    /**
     * 集中处理 网络请求的错误
     * @param error
     */
    public static void error(Throwable error){
//        MobclickAgent.reportError(AppCenter.sContext,error);
        Logger.i(error.toString());
        if(error instanceof SocketTimeoutException){
            Toast.makeText(AppCenter.sContext,"访问服务器超时( ⊙ _ ⊙ )", Toast.LENGTH_SHORT).show();
        }else if(error instanceof NullPointerException){
            Toast.makeText(AppCenter.sContext,"一点小故障/(ㄒoㄒ)/~~", Toast.LENGTH_SHORT).show();
        }else if(error instanceof UnknownHostException){
            Toast.makeText(AppCenter.sContext,"服务器挂了/(ㄒoㄒ)/~~", Toast.LENGTH_SHORT).show();
        }else if(error instanceof IllegalArgumentException){
            Toast.makeText(AppCenter.sContext,"未知的错误", Toast.LENGTH_SHORT).show();
        }else if(error instanceof HttpException){
            Toast.makeText(AppCenter.sContext,"服务器挂了/(ㄒoㄒ)/~~", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(AppCenter.sContext,"网络错误,请检查网络", Toast.LENGTH_SHORT).show();
        }

    }
}
