package com.example.park.model.remote;

import com.example.park.helper.network.NetProvider;
import com.example.park.helper.network.RequestHandler;

import java.util.List;

import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

/**
 * @author xhj
 * @date 2019-09-01 18:15
 */
public class BaseNetProvider implements NetProvider {

    @Override
    public List<Interceptor> configInterceptors() {
        return null;
    }

    @Override
    public void configHttps(OkHttpClient.Builder builder) {

    }

    @Override
    public CookieJar configCookie() {
        return null;
    }

    @Override
    public RequestHandler configHandler() {
        return null;
    }

    @Override
    public long configConnectTimeoutSecs() {
        return 0;
    }

    @Override
    public long configReadTimeoutSecs() {
        return 0;
    }

    @Override
    public long configWriteTimeoutSecs() {
        return 0;
    }

    @Override
    public boolean configLogEnable() {
        return false;
    }
}
