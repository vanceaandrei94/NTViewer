package com.unbm.andrei.ntviewer.views;

import com.unbm.andrei.ntviewer.model.NetworkSite;

import java.util.List;

/**
 * Created by Andrei on 4/16/2017.
 */

public interface MainView {

    void loadAllNetworkSites(List<NetworkSite> sites);

}
