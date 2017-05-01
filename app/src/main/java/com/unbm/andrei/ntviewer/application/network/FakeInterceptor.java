package com.unbm.andrei.ntviewer.application.network;

import com.unbm.andrei.ntviewer.test.Helper;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by Andrei on 4/30/2017.
 */

public class FakeInterceptor implements Interceptor {
    private static final String ALL_SITES = "allSites";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = null;
        String responseString;

        if (chain.request().url().toString().contains(ALL_SITES)) {
            responseString = Helper.SECOND_JSON;
            response = new Response.Builder()
                    .code(200)
                    .message(responseString)
                    .request(chain.request())
                    .protocol(Protocol.HTTP_1_1)
                    .body(ResponseBody.create(MediaType.parse("application/json"), responseString.getBytes()))
                    .addHeader("content-type", "application/json")
                    .build();
        }

        return response == null ? chain.proceed(chain.request()) : response;
    }
}
