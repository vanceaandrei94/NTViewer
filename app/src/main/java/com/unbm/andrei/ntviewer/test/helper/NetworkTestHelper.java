package com.unbm.andrei.ntviewer.test.helper;

import com.unbm.andrei.ntviewer.model.NetworkNode;
import com.unbm.andrei.ntviewer.model.NetworkSite;
import com.unbm.andrei.ntviewer.model.node.SubscriberNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrei on 4/9/2017.
 */

public class NetworkTestHelper {

    public static NetworkSite getTestNetworkSite(double offset) {
        NetworkSite networkSite = new NetworkSite();
        List<NetworkNode> nodes = new ArrayList<>();
        nodes.add(new NetworkNode(47.663753 + offset, 23.572497 + offset));
        nodes.add(new SubscriberNode(47.659301 + offset, 23.573527 + offset, "1.2.3.4"));
        nodes.add(new NetworkNode(47.653693 + offset, 23.565803 + offset));
        networkSite.setNetworkNodes(nodes);
        return networkSite;
    }

    public static NetworkSite getTestNetworkSite() {
        return getTestNetworkSite(0);
    }

    public static List<NetworkSite> getTestNetworSites() {
        List<NetworkSite> networkSites = new ArrayList<>();
        networkSites.add(getTestNetworkSite());
        networkSites.add(getTestNetworkSite(0.000500));
        networkSites.add(getTestNetworkSite(0.000200));
        return networkSites;
    }
}
