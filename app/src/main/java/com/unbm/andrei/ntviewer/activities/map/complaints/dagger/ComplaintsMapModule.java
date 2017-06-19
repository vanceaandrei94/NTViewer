package com.unbm.andrei.ntviewer.activities.map.complaints.dagger;

import com.unbm.andrei.ntviewer.activities.map.complaints.ComplaintsMapActivity;
import com.unbm.andrei.ntviewer.activities.map.complaints.mvp.ComplaintsMapModel;
import com.unbm.andrei.ntviewer.activities.map.complaints.mvp.ComplaintsMapPresenter;
import com.unbm.andrei.ntviewer.application.network.NTVService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by andrei.vancea on 5/8/2017.
 */

@Module
public class ComplaintsMapModule {

    private final ComplaintsMapActivity activity;

    public ComplaintsMapModule(ComplaintsMapActivity activity) {
        this.activity = activity;
    }

    @Provides
    @ComplaintsMapScope
    public ComplaintsMapModel provideModel(NTVService service) {
        return new ComplaintsMapModel(activity, service);
    }

    @Provides
    @ComplaintsMapScope
    public ComplaintsMapPresenter providePresenter(ComplaintsMapModel model) {
        return new ComplaintsMapPresenter(activity, model);
    }

}
