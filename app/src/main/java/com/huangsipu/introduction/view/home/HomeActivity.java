package com.huangsipu.introduction.view.home;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.view.View;

import com.huangsipu.introduction.R;
import com.huangsipu.introduction.databinding.ActivityHomeBinding;
import com.huangsipu.introduction.view.base.BaseActivity;
import com.huangsipu.introduction.view.home.viewmodel.HomeViewModel;

/**
 * @author xhj
 */
public class HomeActivity extends BaseActivity<ActivityHomeBinding> {

    private HomeViewModel homeViewModel = new HomeViewModel();

    @Override
    public void initView() {
        mBinding.setVm(homeViewModel);
        mBinding.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.btn:
                String str = homeViewModel.test();
                mBinding.btn.setText(str);
                showToast(str);
                break;
            default:
                break;
        }
    }

    public BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = item -> {
        int i = item.getItemId();
        if (i == R.id.navigation_recommend) {
            // TODO: 2019-09-03 添加页面切换代码
            showToast(getString(R.string.title_recommend));
            return true;
        } else if (i == R.id.navigation_introduce) {
            // TODO: 2019-09-03 添加页面切换代码
            showToast(getString(R.string.title_introduce));
            return true;
        } else if (i == R.id.navigation_play) {
            // TODO: 2019-09-03 添加页面切换代码
            showToast(getString(R.string.title_play));
            return true;
        } else if (i == R.id.navigation_find) {
            // TODO: 2019-09-03 添加页面切换代码
            showToast(getString(R.string.title_find));
            return true;
        } else if (i == R.id.navigation_service) {
            // TODO: 2019-09-03 添加页面切换代码
            showToast(getString(R.string.title_service));
            return true;
        }
        return false;
    };
}
