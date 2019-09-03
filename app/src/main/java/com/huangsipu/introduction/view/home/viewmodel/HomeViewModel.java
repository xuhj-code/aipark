package com.huangsipu.introduction.view.home.viewmodel;

import com.huangsipu.introduction.viewmodel.PagedViewModel;

/**
 * @author xhj
 * @date 2019-08-31 23:23
 */
public class HomeViewModel extends PagedViewModel {

    private int count;

    public String test() {
        return "btn is click " + count++;
    }

}
