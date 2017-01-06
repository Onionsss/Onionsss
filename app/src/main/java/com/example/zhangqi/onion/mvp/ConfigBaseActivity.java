package com.example.zhangqi.onion.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.jinhuhang.youmi.global.AppCenter;
import com.jinhuhang.youmi.logger.Logger;
import com.umeng.analytics.MobclickAgent;

/**
 * Created by zhangqi on 2016/11/8.
 */

public abstract class ConfigBaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Logger.i("进入"+this.getClass().getName());
        AppCenter.addActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.i("退出"+this.getClass().getName());
        AppCenter.removeActivity(this);
    }
}
