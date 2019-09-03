package com.huangsipu.introduction.view.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.huangsipu.introduction.AppPark;
import com.huangsipu.introduction.BR;

/**
 * @author xhj
 * @date 2019-08-31 23:08
 */
public abstract class BaseActivity<T extends ViewDataBinding> extends AppCompatActivity implements Presenter {

    public T mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, getLayoutId());
        mBinding.setVariable(BR.presenter, this);
        mBinding.executePendingBindings();
        mBinding.setLifecycleOwner(this);
        initView();
    }

    @Override
    public void loadData(boolean isRefresh) {

    }

    public abstract void initView();

    public abstract int getLayoutId();

    @Override
    public void onClick(View view) {

    }

    public void showToast(String str) {
        Toast.makeText(AppPark.getContext(), str, Toast.LENGTH_SHORT).show();
    }

}
