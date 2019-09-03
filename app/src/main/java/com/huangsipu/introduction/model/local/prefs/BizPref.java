package com.huangsipu.introduction.model.local.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.huangsipu.introduction.AppPark;

/**
 * @author xhj
 * @date 2019-09-02 11:10
 */
public class BizPref implements BizPrefHelper {

    private SharedPreferences mPreferences;
    private BizPref bizPref;

    private BizPref() {
        mPreferences = AppPark.getContext().getSharedPreferences(PrefsConstants.BIZ_SHARED_PREFERENCE, Context.MODE_PRIVATE);
    }

    public BizPref getInstance() {
        if (bizPref == null) {
            synchronized (BizPref.class) {
                if (bizPref == null) {
                    bizPref = new BizPref();
                }
            }
        }
        return bizPref;
    }

    @Override
    public void clearInfo() {
        remove(PrefsConstants.DEVICE_REGISTER);
    }

    @Override
    public void remove(String key) {
        mPreferences.edit().remove(key).commit();
    }

    @Override
    public void putString(String key, String value) {
        mPreferences.edit().putString(key, value).apply();
    }

    @Override
    public String getString(String key, String value) {
        return mPreferences.getString(key, value);
    }

    @Override
    public void putInt(String key, int value) {
        mPreferences.edit().putInt(key, value).apply();
    }

    @Override
    public int getInt(String key, int value) {
        return mPreferences.getInt(key, value);
    }

    @Override
    public void putBoolean(String key, boolean value) {
        mPreferences.edit().putBoolean(key, value).apply();
    }

    @Override
    public boolean getBoolean(String key, boolean value) {
        return mPreferences.getBoolean(key, value);
    }

    @Override
    public void putFloat(String key, float value) {
        mPreferences.edit().putFloat(key, value).apply();
    }

    @Override
    public float getFloat(String key, float value) {
        return mPreferences.getFloat(key, value);
    }

    @Override
    public void setDeviceLogin(boolean value) {
        putBoolean(PrefsConstants.DEVICE_LOGIN, value);
    }

    @Override
    public boolean getDeviceLogin() {
        return getBoolean(PrefsConstants.DEVICE_LOGIN, false);
    }

}
