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
    private static final String USERS = "users";
    private static final String TEST_USERNAME = "test";
    private static final String TEST_PASS = "pass";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = null;
        String responseString;
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        switch (chain.request().url().pathSegments().get(0).toString()) {
            case ALL_SITES:
                responseString = Helper.GET_ALL_SITES_JSON;
                response = new Response.Builder()
                        .code(200)
                        .message(responseString)
                        .request(chain.request())
                        .protocol(Protocol.HTTP_1_1)
                        .body(ResponseBody.create(MediaType.parse("application/json"), responseString.getBytes()))
                        .addHeader("content-type", "application/json")
                        .build();
                break;
            case USERS:
                String[] queryParams = chain.request().url().url().getQuery().split("&");
                String username = queryParams[0].split("=")[1];
                String password = queryParams[1].split("=")[1];
                if (TEST_USERNAME.equals(username) && TEST_PASS.equals(password)) {
                    responseString = Helper.LOGIN_SUCCEEDED_JSON;
                    response = new Response.Builder()
                            .code(200)
                            .message(responseString)
                            .request(chain.request())
                            .protocol(Protocol.HTTP_1_1)
                            .body(ResponseBody.create(MediaType.parse("application/json"), responseString.getBytes()))
                            .addHeader("content-type", "application/json")
                            .build();
                } else {
                    responseString = Helper.INVALID_CREDENTIALS;
                    response = new Response.Builder()
                            .code(401)
                            .message(responseString)
                            .request(chain.request())
                            .protocol(Protocol.HTTP_1_1)
                            .body(ResponseBody.create(MediaType.parse("application/json"), responseString.getBytes()))
                            .addHeader("content-type", "application/json")
                            .build();
                }
        }

        return response == null ? chain.proceed(chain.request()) : response;
    }
}