package com.unbm.andrei.ntviewer.activities.map.derangements.dagger;

import com.unbm.andrei.ntviewer.activities.map.derangements.DerangementMapActivity;
import com.unbm.andrei.ntviewer.activities.map.derangements.mvp.DerangementMapModel;
import com.unbm.andrei.ntviewer.activities.map.derangements.mvp.DerangementMapPresenter;
import com.unbm.andrei.ntviewer.application.network.NTVService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by andrei.vancea on 5/8/2017.
 */

@Module
public class DerangementMapModule {

    private final DerangementMapActivity activity;

    public DerangementMapModule(DerangementMapActivity activity) {
        this.activity = activity;
    }

    @Provides
    @DerangementMapScope
    public DerangementMapModel provideModel(NTVService service) {
        return new DerangementMapModel(activity, service);
    }

    @Provides
    @DerangementMapScope
    public DerangementMapPresenter providePresenter(DerangementMapModel model) {
        return new DerangementMapPresenter(activity, model);
    }

}
