package com.huangsipu.introduction.view.home;

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
}
