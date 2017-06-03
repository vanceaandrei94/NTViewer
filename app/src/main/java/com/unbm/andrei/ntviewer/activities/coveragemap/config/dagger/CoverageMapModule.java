package com.unbm.andrei.ntviewer.activities.coveragemap.config.dagger;

import com.unbm.andrei.ntviewer.activities.coveragemap.CoverageMapActivity;
import com.unbm.andrei.ntviewer.activities.coveragemap.config.mvp.CoverageMapModel;
import com.unbm.andrei.ntviewer.activities.coveragemap.config.mvp.CoverageMapPresenter;
import com.unbm.andrei.ntviewer.activities.coveragemap.config.mvp.ICoverageMapView;
import com.unbm.andrei.ntviewer.application.network.NTVService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by andrei.vancea on 5/8/2017.
 */

@Module
public class CoverageMapModule {

    private final CoverageMapActivity activity;

    public CoverageMapModule(CoverageMapActivity activity) {
        this.activity = activity;
    }

    @Provides
    @CoverageMapScope
    public CoverageMapModel provideModel(NTVService service) {
        return new CoverageMapModel(activity, service);
    }

    @Provides
    @CoverageMapScope
    public CoverageMapPresenter providePresenter(CoverageMapModel model) {
        return new CoverageMapPresenter(activity, model);
    }

}
