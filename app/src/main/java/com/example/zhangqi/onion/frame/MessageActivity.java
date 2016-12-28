package com.example.zhangqi.onion.frame;

import android.widget.TextView;

import com.example.zhangqi.onion.utils.ToastUtil;


/**
 * Created by zhangqi on 2016/10/12.
 */

public abstract class MessageActivity extends ConfigBaseActivity{

    protected void showMessage(String msg){
        ToastUtil.showShort(this,msg);
    }

    protected void showMessage(int strId){
        ToastUtil.showShort(this,getString(strId));
    }

    protected void showMessageLong(String msg){
        ToastUtil.showLong(this,msg);
    }

    protected void showMessageLong(int strId){
        ToastUtil.showLong(this,getString(strId));
    }

    public String getText(TextView tv){
        return tv.getText().toString().trim();
    }

}
