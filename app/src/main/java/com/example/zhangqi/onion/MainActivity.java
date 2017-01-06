package com.example.zhangqi.onion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.zhangqi.onion.api.RetrofitUtils;
import com.example.zhangqi.onion.manager.TransformUtils;
import com.example.zhangqi.onion.utils.ToastUtil;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RetrofitUtils.getInstance().build()
                .main()
                .compose(TransformUtils.defaultSchedulers())
                .subscribe(wrapper -> {
                    if(wrapper.code == 200)
                    ToastUtil.showShort(this,wrapper.data.getName()+":"+wrapper.data.getAge()+wrapper.date);
                });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
