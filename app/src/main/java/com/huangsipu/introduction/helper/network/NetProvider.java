package com.huangsipu.introduction.helper.network;

import java.util.List;

import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

/**
 * @author xhj
 * @date 2019-08-31 23:16
 */
public interface NetProvider {

    List<Interceptor> configInterceptors();

    void configHttps(OkHttpClient.Builder builder);

    CookieJar configCookie();

    RequestHandler configHandler();

    long configConnectTimeoutSecs();

    long configReadTimeoutSecs();

    long configWriteTimeoutSecs();

    boolean configLogEnable();
}
