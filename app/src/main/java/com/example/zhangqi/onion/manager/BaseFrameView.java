package com.example.zhangqi.onion.manager;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.zhangqi.onion.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zhangqi on 2016/12/30.
 */

public class BaseFrameView extends FrameLayout {

    @Bind(R.id.loading)
    View mLoadingView;
    @Bind(R.id.error_reconnect)
    TextView mErrorReconnect;
    @Bind(R.id.error)
    LinearLayout mErrorView;
    @Bind(R.id.fl_status)
    FrameLayout mFlStatus;

    private View mSuccessView;

    //加载状态
    public static final int STATUS_LOADING = 100;
    //成功状态
    public static final int STATUS_SUCCESS = 101;
    //失败状态
    public static final int STATUS_ERROR = 102;

    public static final int STATUS_NODATA = 103;

    public BaseFrameView(@NonNull Context context) {
        this(context, null);
    }

    public BaseFrameView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseFrameView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initSetting();
    }

    public void addSuccessView(View view) {
        mSuccessView = view;
        mFlStatus.addView(mSuccessView);
        mSuccessView.setVisibility(GONE);
    }

    private void initSetting() {
        View.inflate(getContext(), R.layout.status, this);
        ButterKnife.bind(this);
    }

    public void updateView(int currentStatus) {
        mSuccessView.setVisibility(GONE);
        mErrorView.setVisibility(GONE);
        mLoadingView.setVisibility(GONE);
        switch (currentStatus) {
            case STATUS_ERROR:
                mErrorView.setVisibility(VISIBLE);
                break;
            case STATUS_LOADING:
                mLoadingView.setVisibility(VISIBLE);
                break;
            case STATUS_SUCCESS:
                mSuccessView.setVisibility(VISIBLE);
                break;
        }
    }

}
