package com.unbm.andrei.ntviewer.activities.coveragemap.config.mvp;

import android.app.Activity;
import android.graphics.Color;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolygonOptions;
import com.unbm.andrei.ntviewer.application.network.NTVService;
import com.unbm.andrei.ntviewer.application.network.models.NetworkProviders;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by andrei.vancea on 5/8/2017.
 */

public class CoverageMapModel {

    public static final int DEFAULT_ALPHA = 50;

    private final Activity activity;

    private final NTVService service;

    public CoverageMapModel(Activity activity, NTVService service) {
        this.activity = activity;
        this.service = service;
    }

    public Observable<List<NetworkProviders>> getNetworkProviders() {
        return service.getProviders();
    }

    public PolygonOptions getCoverage() {
        return new PolygonOptions()
                .add(new LatLng(47.091631, 23.093262))
                .add(new LatLng(47.597829, 24.543457))
                .add(new LatLng(46.851739, 24.763184))
                .add(new LatLng(46.640951, 23.049316))
                .fillColor(Color.argb(DEFAULT_ALPHA, 0, 255, 0))
                .strokeWidth(0);
    }

}
