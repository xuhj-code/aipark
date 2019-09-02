package com.example.park.model.local.prefs;

import lombok.NonNull;

/**
 * @author xhj
 * @date 2019-09-02 11:05
 */
public interface BizPrefHelper {

    /**
     * 清除数据
     */
    void clearInfo();

    /**
     * @param key
     */
    void remove(String key);

    /**
     * @param key
     * @param value
     */
    void putString(String key, String value);

    /**
     * @param key
     * @param value
     * @return
     */
    String getString(String key, String value);

    /**
     * @param key
     * @param value
     */
    void putInt(String key, int value);

    /**
     * @param key
     * @param value
     * @return
     */
    int getInt(String key, int value);

    /**
     * @param key
     * @param value
     */
    void putBoolean(String key, boolean value);

    /**
     * @param key
     * @param value
     * @return
     */
    boolean getBoolean(String key, boolean value);

    /**
     * @param key
     * @param value
     */
    void putFloat(String key, float value);

    /**
     *
     * @param key
     * @param value
     * @return
     */
    float getFloat(String key, float value);

    /**
     * @param value
     */
    void setDeviceLogin(boolean value);

    /**
     * @return
     */
    boolean getDeviceLogin();
}
