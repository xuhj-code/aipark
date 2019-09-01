package com.example.park.helper.network;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author xhj
 * @date 2019-08-31 23:56
 */
public interface RequestHandler {

    Request onBeforeRequest(Request request, Interceptor.Chain chain);

    Response onAfterRequest(Request request, Response response, Interceptor.Chain chain);
}
