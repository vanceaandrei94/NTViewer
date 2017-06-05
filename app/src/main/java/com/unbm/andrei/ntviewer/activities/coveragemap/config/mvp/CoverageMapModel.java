package com.unbm.andrei.ntviewer.activities.coveragemap.config.mvp;

import android.app.Activity;
import android.graphics.Color;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolygonOptions;
import com.unbm.andrei.ntviewer.application.network.NTVService;
import com.unbm.andrei.ntviewer.application.network.models.NetworkProvider;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by andrei.vancea on 5/8/2017.
 */

public class CoverageMapModel {

    private final Activity activity;

    private final NTVService service;

    public CoverageMapModel(Activity activity, NTVService service) {
        this.activity = activity;
        this.service = service;
    }

    public Observable<List<NetworkProvider>> getProvidersCoverage() {
        return service.getProviders();
    }
}
