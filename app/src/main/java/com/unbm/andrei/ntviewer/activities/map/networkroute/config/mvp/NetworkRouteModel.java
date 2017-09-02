package com.unbm.andrei.ntviewer.activities.map.networkroute.config.mvp;

import com.unbm.andrei.ntviewer.application.network.NTVService;
import com.unbm.andrei.ntviewer.application.network.models.networkroute.NetworkRoute;
import com.unbm.andrei.ntviewer.application.network.models.networkroute.NodeInfo;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Andrei on 6/19/2017.
 */

public class NetworkRouteModel {

    private NTVService service;

    public NetworkRouteModel(NTVService service) {
        this.service = service;
    }


    public Observable<List<NetworkRoute>> getNetworkRoutes() {
        return service.getNetworkRoutes();
    }

    public Observable<NodeInfo> getNodeInfo(String id) {
        return service.getNodeInfo(id);
    }
}
