package com.example.zhangqi.onion.global;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.example.zhangqi.onion.constant.Constant;
import com.example.zhangqi.onion.logger.Logger;
import com.example.zhangqi.onion.utils.SpUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangqi on 2016/9/26.
 */

public class AppCenter extends Application {

    public static Context sContext;
    public static SpUtil mSpUtil;

    private static List<Activity> mList = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        /**
         * 初始化 sp 与 context
         */
        sContext = this;
        mSpUtil = new SpUtil(this, Constant.SP_LOCAL);

        /**
         * Logger
         */
        Logger.init(Constant.LOG_TAG,true);
    }

    public static void addActivity(Activity activity){
        mList.add(activity);
    }

    public static void removeActivity(Activity activity){
        mList.remove(activity);
    }

    public static void removeAll(){
        List<Activity> mList = AppCenter.mList;
        for (Activity activity : mList) {
            AppCenter.mList.remove(activity);
        }
    }

    public static void closeApp(){
        for (Activity activity : mList) {
            activity.finish();
        }
    }
}
