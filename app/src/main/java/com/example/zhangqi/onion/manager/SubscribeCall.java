package com.example.zhangqi.onion.manager;

import com.example.zhangqi.onion.bean.HttpWrapper;
import com.example.zhangqi.onion.global.AppCenter;
import com.example.zhangqi.onion.utils.ToastUtil;
import com.example.zhangqi.onion.utils.UtilsCollection;

import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;

/**
 * 统一处理error  complete页面
 * 并提供回调
 * Created by zhangqi on 2016/9/23.
 * 简洁版
 */

public class SubscribeCall<T extends HttpWrapper> extends Subscriber<T> {

    /**
     * rxjava 回调
     */
    private Action1<? super T> mOnNext;
    private Action1<Throwable> mOnError;
    private Action0 mOnComplete;
    private Action0 mOnStart;

    public static final int mSuccessCode = 200;
    public static final int mErrorCode = 201;
    public static final int mTokenOut = 202;

    public SubscribeCall(Action0 mOnStart){
        this.mOnStart = mOnStart;
    }

    public SubscribeCall(Action0 mOnStart,Action1<? super T> mOnNext){
        this(mOnStart);
        this.mOnNext = mOnNext;
    }

    public SubscribeCall(Action0 mOnStart,Action1<? super T> mOnNext,Action1<Throwable> mOnError){
        this(mOnStart,mOnNext);
        this.mOnError = mOnError;
    }

    public SubscribeCall(Action0 mOnStart,Action1<? super T> mOnNext,Action1<Throwable> mOnError,Action0 mOnComplete){
        this(mOnStart,mOnNext,mOnError);
        this.mOnComplete = mOnComplete;
    }

    @Override
    public void onStart() {
        if (mOnStart != null)
            mOnStart.call();
    }

    @Override
    public void onCompleted() {
        if (mOnComplete != null)
            mOnComplete.call();
    }

    @Override
    public void onError(Throwable e) {
        UtilsCollection.error(e);
            if (mOnError != null)
                mOnError.call(e);
    }

    @Override
    public void onNext(T o) {
        if(o.code == mSuccessCode){
            if (mOnNext != null)
                mOnNext.call(o);
        }else if(o.code == mErrorCode){
            ToastUtil.showShort(AppCenter.sContext,o.info);
        }
    }

     interface SimpleSubscribe<T>{
        void onStart();

        void onNext(T data);

        void onError(Throwable t);

        void onCompleted();
    }

    public static class SimpleSubscribeImpl<T> implements SimpleSubscribe<T>{

        @Override
        public void onStart() {

        }

        @Override
        public void onNext(T data) {

        }

        @Override
        public void onError(Throwable t) {

        }

        @Override
        public void onCompleted() {

        }
    }

}
