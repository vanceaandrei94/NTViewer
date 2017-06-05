package com.unbm.andrei.ntviewer.activities.coveragemap.config.mvp;

import com.unbm.andrei.ntviewer.application.network.models.NetworkProvider;

import java.util.List;

/**
 * Created by Andrei on 6/3/2017.
 */

public interface ICoverageMapView {

    void drawCoverage(List<NetworkProvider> providers);
}
