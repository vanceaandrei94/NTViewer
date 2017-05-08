package com.unbm.andrei.ntviewer.activities.sitesmap.config.dagger;

import com.unbm.andrei.ntviewer.activities.sitesmap.SitesMapActivity;
import com.unbm.andrei.ntviewer.activities.sitesmap.config.mvp.SitesMapModel;
import com.unbm.andrei.ntviewer.activities.sitesmap.config.mvp.SitesMapPresenter;
import com.unbm.andrei.ntviewer.activities.sitesmap.config.mvp.SitesMapView;
import com.unbm.andrei.ntviewer.application.network.NTVService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by andrei.vancea on 5/8/2017.
 */

@Module
public class SitesMapModule {

    private final SitesMapActivity activity;

    public SitesMapModule(SitesMapActivity activity) {
        this.activity = activity;
    }

    @Provides
    @SitesMapScope
    public SitesMapModel provideModel(NTVService service) {
        return new SitesMapModel(activity, service);
    }

    @Provides
    @SitesMapScope
    public SitesMapPresenter providePresenter(SitesMapView view, SitesMapModel model) {
        return new SitesMapPresenter(view, model);
    }

    @Provides
    @SitesMapScope
    public SitesMapView provideView() {
        return new SitesMapView(activity);
    }
}
