package com.example.zhangqi.onion.mvp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.jinhuhang.youmi.utils.ToastUtil;

/**
 * Created by zhangqi on 2016/10/13.
 */

public class MessageFragment extends Fragment {

    public Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    protected void showMessage(String msg){
        ToastUtil.showShort(mContext,msg);
    }

    protected void showMessageLong(String msg){
        ToastUtil.showShort(mContext,msg);
    }

    protected void showMessage(int strId){
        ToastUtil.showShort(mContext,getString(strId));
    }

    public String getText(TextView tv){
        return tv.getText().toString().trim() == ""?null:tv.getText().toString().trim();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
