package com.example.zhangqi.onion.listener;

/**
 * Created by zhangqi on 2016/12/28.
 */

public interface OnItemClickListener<T> {

    /**
     * 条目点击事件
     * @param item
     * @param position
     * @param obj
     */
    void onItemClick(T item,int position,Object ...obj);

}
