package com.unbm.andrei.ntviewer.activities.siteinfo.config.dagger;

import com.unbm.andrei.ntviewer.activities.siteinfo.SiteInfoActivity;
import com.unbm.andrei.ntviewer.activities.siteinfo.config.mvp.SiteModel;
import com.unbm.andrei.ntviewer.activities.siteinfo.config.mvp.SitePresenter;
import com.unbm.andrei.ntviewer.activities.siteinfo.config.mvp.SiteView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Andrei on 5/1/2017.
 */

@Module
public class SiteModule {

    private final SiteInfoActivity activity;

    public SiteModule(SiteInfoActivity activity) {
        this.activity = activity;
    }

    @Provides
    @SiteScope
    public SiteView provideView() {
        return new SiteView(activity);
    }

    @Provides
    @SiteScope
    public SiteModel provideModel() {
        return new SiteModel(activity);
    }

    @Provides
    @SiteScope
    public SitePresenter providePresenter(SiteView view, SiteModel model) {
        return new SitePresenter(view, model);
    }
}
