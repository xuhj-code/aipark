package com.example.park.helper.network;

import android.support.annotation.Nullable;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * @author xhj
 * @date 2019-09-01 10:48
 */
public class NetInterceptor implements Interceptor {
    private final RequestHandler handler;

    public NetInterceptor(@Nullable RequestHandler handler) {
        this.handler = handler;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        return null;
    }
}
