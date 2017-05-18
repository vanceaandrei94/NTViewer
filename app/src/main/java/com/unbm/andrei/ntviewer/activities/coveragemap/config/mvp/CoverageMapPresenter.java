package com.unbm.andrei.ntviewer.activities.coveragemap.config.mvp;

import android.graphics.Color;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.PolygonOptions;
import com.unbm.andrei.ntviewer.activities.common.mvp.BasePresenter;

/**
 * Created by andrei.vancea on 5/8/2017.
 */

public class CoverageMapPresenter implements BasePresenter {

    private CoverageMapView view;
    private CoverageMapModel model;

    public CoverageMapPresenter(CoverageMapView view, CoverageMapModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {

    }

    public void addSiteOverlay() {
        PolygonOptions coverage = model.getCoverage();
        view.buildOverlay(coverage);
    }
}
