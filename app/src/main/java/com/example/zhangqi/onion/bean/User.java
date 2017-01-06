package com.example.zhangqi.onion.bean;

import android.databinding.BaseObservable;

/**
 * Created by zhangqi on 2016/12/29.
 */

public class User extends BaseObservable {

    private String pwd;
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
