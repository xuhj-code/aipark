package com.huangsipu.introduction;

import android.app.Application;
import android.content.Context;

/**
 * @author xhj
 * @date 2019-08-31 23:01
 */
public class AppPark extends Application {
    private static AppPark appPark;

    public static AppPark getInstance() {
        return appPark;
    }

    public static Context getContext() {
        return appPark.getApplicationContext();
    }

    private static String token = "dGVzdDp0ZXN0";

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        AppPark.token = token;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        appPark = this;
    }

    /**
     * 杀进程
     */
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Runtime.getRuntime().gc();
    }
    
}
