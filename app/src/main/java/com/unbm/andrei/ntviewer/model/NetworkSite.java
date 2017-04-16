package com.unbm.andrei.ntviewer.model;

import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by andrei.vancea on 2/27/2017.
 */
@Getter
@Setter
public class NetworkSite {

    List<NetworkNode> networkNodes;

    public NetworkSite(List<NetworkNode> networkNodes) {
        this.networkNodes = networkNodes;
    }

    public NetworkSite() {
        networkNodes = new ArrayList<>();
    }

    public void addNode(NetworkNode node) {
        networkNodes.add(node);
    }

    public void removeNode(NetworkNode node) {
        networkNodes.remove(node);
    }

    public NetworkNode getNetworkNodeByMapObject(Circle circle) {
        for (NetworkNode node : networkNodes) {
            LatLng circleLoc = circle.getCenter();
            if (circleLoc.latitude == node.getLat() && circleLoc.longitude == node.getLon()) {
                return node;
            }
        }
        return null;

    }
}
