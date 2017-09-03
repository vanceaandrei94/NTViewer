package com.unbm.andrei.ntviewer.activities.map.coverage.config.mvp;

import com.unbm.andrei.ntviewer.application.network.models.NetworkProvider;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Andrei on 9/3/2017.
 */

public interface CoverageMapModel {
    Observable<List<NetworkProvider>> getProvidersCoverage();
}
