package com.unbm.andrei.ntviewer.activities.sitesmap.config.mvp;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.unbm.andrei.ntviewer.activities.common.mvp.BasePresenter;

/**
 * Created by andrei.vancea on 5/8/2017.
 */

public class SitesMapPresenter implements BasePresenter {

    private SitesMapView view;
    private SitesMapModel model;

    public SitesMapPresenter(SitesMapView view, SitesMapModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {

    }

    private void addSiteOverlay() {
        //making a site overlay
        LatLngBounds bounds = LatLngBounds.builder()
                .include(new LatLng(23, 24))
                .include(new LatLng(24, 25))
                .include(new LatLng(25, 26))
                .include(new LatLng(12, 14))
                .build();
        view.buildOverlay(bounds);
    }
}
