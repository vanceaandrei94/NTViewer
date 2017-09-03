package com.unbm.andrei.ntviewer.activities.map.networkroute.config.mvp;

import com.unbm.andrei.ntviewer.application.network.models.networkroute.NetworkRoute;
import com.unbm.andrei.ntviewer.application.network.models.networkroute.NodeInfo;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Andrei on 9/3/2017.
 */

public interface NetworkRouteModel {
    Observable<List<NetworkRoute>> getNetworkRoutes();

    Observable<NodeInfo> getNodeInfo(String id);
}
