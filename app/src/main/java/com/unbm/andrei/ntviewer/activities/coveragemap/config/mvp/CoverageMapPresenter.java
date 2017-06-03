package com.unbm.andrei.ntviewer.activities.coveragemap.config.mvp;

import com.google.android.gms.maps.model.PolygonOptions;
import com.unbm.andrei.ntviewer.activities.common.mvp.BasePresenter;
import com.unbm.andrei.ntviewer.application.network.models.NetworkProvider;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by andrei.vancea on 5/8/2017.
 */

public class CoverageMapPresenter implements BasePresenter {

    private final ICoverageMapView view;
    private CoverageMapModel model;

    public CoverageMapPresenter(ICoverageMapView view, CoverageMapModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {

    }
}
