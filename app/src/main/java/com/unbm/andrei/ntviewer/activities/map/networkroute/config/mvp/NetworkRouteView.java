package com.unbm.andrei.ntviewer.activities.map.networkroute.config.mvp;

import com.unbm.andrei.ntviewer.application.network.models.networkroute.NetworkRoute;
import com.unbm.andrei.ntviewer.application.network.models.networkroute.NodeInfo;

import java.util.List;

/**
 * Created by Andrei on 6/19/2017.
 */

public interface NetworkRouteView {

    void drawNetworkRoutes(List<NetworkRoute> routes);

    void showLoading(boolean show);

    void showNodeInfoPopup(NodeInfo nodeInfo);
}
