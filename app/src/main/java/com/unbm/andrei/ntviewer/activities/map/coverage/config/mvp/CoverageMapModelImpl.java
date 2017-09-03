package com.unbm.andrei.ntviewer.activities.map.coverage.config.mvp;

import android.app.Activity;

import com.unbm.andrei.ntviewer.application.network.NTVService;
import com.unbm.andrei.ntviewer.application.network.models.NetworkProvider;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by andrei.vancea on 5/8/2017.
 */

public class CoverageMapModelImpl implements CoverageMapModel {

    private final Activity activity;

    private final NTVService service;

    public CoverageMapModelImpl(Activity activity, NTVService service) {
        this.activity = activity;
        this.service = service;
    }

    public Observable<List<NetworkProvider>> getProvidersCoverage() {
        return service.getProviders();
    }
}
