package com.unbm.andrei.ntviewer.service;

import com.unbm.andrei.ntviewer.service.api.INetworkServiceProvider;
import com.unbm.andrei.ntviewer.service.factory.ServiceFactory;

/**
 * Created by Andrei on 4/16/2017.
 */

public class NetworkApi {

    private static NetworkApi instance;
    private INetworkServiceProvider networkServiceProvider;

    private NetworkApi() {
        networkServiceProvider = ServiceFactory.createRetrofitService(INetworkServiceProvider.class, INetworkServiceProvider.BASE_URI);
    }

    public static NetworkApi getInstance() {
        if (instance == null) {
            instance = new NetworkApi();
        }
        return instance;
    }

    public INetworkServiceProvider getNetworkService() {
        return networkServiceProvider;
    }
}
