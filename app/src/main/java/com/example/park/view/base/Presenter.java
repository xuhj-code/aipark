package com.example.park.view.base;

import android.view.View;

/**
 * @author xhj
 * @date 2019-08-31 23:08
 */
public interface Presenter extends View.OnClickListener {


    @Override
    void onClick(View view);

    void loadData(boolean isRefresh);
}
